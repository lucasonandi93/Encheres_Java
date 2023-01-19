package fr.eni.enchere.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import fr.eni.enchere.bll.ArticleManager;
import fr.eni.enchere.bll.AuctionManager;
import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Auction;
import fr.eni.enchere.bo.User;
import fr.eni.enchere.exceptions.BusinessException;

/**
 * Servlet implementation class ServletConnexionPage
 */
@WebServlet("/ServletDetailsAuctionPage")
public class ServletDetailsAuctionPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @throws ServletException
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletDetailsAuctionPage() throws ServletException {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArticleManager articleManager = new ArticleManager();
		AuctionManager auctionManager = new AuctionManager();

		HttpSession session = request.getSession();

		try {
			Article articleOngoing = articleManager.selectById(Integer.parseInt(request.getParameter("articleID")));
			request.setAttribute("articleOngoing", articleOngoing);

			List<Auction> auctions = auctionManager
					.selectByNoArticle(Integer.parseInt(request.getParameter("articleID")));
			if (!auctions.isEmpty()) {
				Auction auctionOngoing = null;
				for (Auction auction : auctions) {
					if (auctionOngoing == null)
						auctionOngoing = auction;
					else if (auction.getAuctionAmount() > auctionOngoing.getAuctionAmount()) {
						auctionOngoing = auction;
					}
				}
				request.setAttribute("pseudoBestAuction", auctionOngoing.getUser().getPseudo());
			} else {
				request.setAttribute("pseudoBestAuction", articleOngoing.getUser().getPseudo());
			}

			boolean isStartDate = (articleOngoing.getAuctionStartDate().equals(LocalDate.now()));
			boolean isEndDate = (articleOngoing.getAuctionEndDate().equals(LocalDate.now()));
			boolean isAfterStartDate = (articleOngoing.getAuctionStartDate().isBefore(LocalDate.now()));
			boolean isBeforeEndDate = (articleOngoing.getAuctionEndDate().isAfter(LocalDate.now()));
			boolean isAfterEndDate = (articleOngoing.getAuctionEndDate().isBefore(LocalDate.now()));
			boolean canMakeProposal = ((isStartDate || isAfterStartDate) && (isBeforeEndDate || isEndDate));
			boolean isUserConnectedArticle = false;
			if (((User) session.getAttribute("user")) != null) {
				isUserConnectedArticle = articleOngoing.getUser().getNoUser() == ((User) session.getAttribute("user")).getNoUser();
			}
			request.setAttribute("canMakeProposal", canMakeProposal);
			request.setAttribute("isAfterEndDate", isAfterEndDate);
			request.setAttribute("isUserConnectedArticle", isUserConnectedArticle);
		} catch (NumberFormatException | BusinessException e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/detailsAuctionPage.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
