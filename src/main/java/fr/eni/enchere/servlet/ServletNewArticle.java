package fr.eni.enchere.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import fr.eni.enchere.bll.ArticleManager;
import fr.eni.enchere.bll.CategoryManager;
import fr.eni.enchere.bll.UserManager;
import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Category;
import fr.eni.enchere.bo.User;
import fr.eni.enchere.bo.Withdrawal;
import fr.eni.enchere.exceptions.BusinessException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

/**
 * Servlet implementation class ServletNewArticle
 */
@WebServlet("/ServletNewArticle")
@MultipartConfig
public class ServletNewArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int TAILLE_TAMPON = 10240;
	private static final String CHEMIN_FICHIER = "/Images/";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletNewArticle() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public void init() throws ServletException {
		File uploFile = new File(getServletContext().getRealPath("/Images"));
		if ( !uploFile.exists()) uploFile.mkdir();
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CategoryManager categoryManager = new CategoryManager();
		List<Category> categoryList = null;
		ArticleManager articleManager = new ArticleManager();

		try {

			categoryList = categoryManager.selectAll();
			request.setAttribute("categoryList", categoryList);
			if (request.getParameter("articleID") != null) {
				Article articleOngoing = articleManager.selectById(Integer.parseInt(request.getParameter("articleID")));
				request.setAttribute("articleOngoing", articleOngoing);
			}
			request.getRequestDispatcher("/WEB-INF/jsp/newArticlePage.jsp").forward(request, response);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CategoryManager categoryManager = new CategoryManager();
		UserManager userManager = new UserManager();
		ArticleManager articleManager = new ArticleManager();
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Article articleOngoing = new Article();
		HttpSession session = request.getSession();

		try {
			articleOngoing.setNameArticle(request.getParameter("articleName"));
			articleOngoing.setDescription(request.getParameter("articleDescription"));
			articleOngoing.setCategory(categoryManager.selectByName(request.getParameter("articleCategorie")));
			
			articleOngoing.setOriginalPrice(Integer.parseInt(request.getParameter("articleOriginalPrice")));
			articleOngoing.setSellingPrice(Integer.parseInt(request.getParameter("articleOriginalPrice")));
			Date startDate = formatter.parse(request.getParameter("articleStartDate"));
			articleOngoing.setAuctionStartDate(startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
			Date endtDate = formatter.parse(request.getParameter("articleEndDate"));
			articleOngoing.setAuctionEndDate(endtDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
			Withdrawal withdrawalOngoing = new Withdrawal();
			
			withdrawalOngoing.setStreet(request.getParameter("withdrawalStreet"));
			withdrawalOngoing.setCp(request.getParameter("withdrawalCp"));
			withdrawalOngoing.setCity(request.getParameter("withdrawalCity"));
			
			articleOngoing.setWithdrawal(withdrawalOngoing);
			articleOngoing.setUser(userManager.selectById(((User)session.getAttribute("user")).getNoUser()));
			// UPLOAD IMAGE
			String path = uploadImage(request);
			articleOngoing.setImageName(path);
			
			
			if (request.getParameter("articleID") == null) {
				articleManager.addData(articleOngoing);
			} else {
				articleOngoing.setNoArticle(Integer.valueOf(request.getParameter("articleID")));
				articleManager.updateData(articleOngoing);
			}				
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath()+"/ServletListOfAuctionsPage");
	}
	
	private String uploadImage(HttpServletRequest req) throws IOException, ServletException {
		Part part = req.getPart("photoArticle");
		String nomFichier = getNomFichier(part);
		if (nomFichier != null && !nomFichier.isEmpty()) {
			String nomChamp = part.getName();
			nomFichier = nomFichier.substring(nomFichier.lastIndexOf('/') + 1)
					.substring(nomFichier.lastIndexOf('\\') + 1);
			ecrireFichier(part, nomFichier, req.getServletContext().getRealPath(CHEMIN_FICHIER));
			req.setAttribute(nomChamp, nomFichier);
		}
		return CHEMIN_FICHIER+nomFichier;
	}

	private void ecrireFichier(Part part, String nomFichier, String chemin) throws IOException {
		BufferedInputStream entree = null;
		BufferedOutputStream sortie = null;
		
		System.out.println(chemin);
		
		try {
			entree = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON);
			sortie = new BufferedOutputStream(new FileOutputStream(new File(chemin + nomFichier)), TAILLE_TAMPON);
			byte[] tampon = new byte[TAILLE_TAMPON];
			int longueur;
			while ((longueur = entree.read(tampon)) > 0) {
				sortie.write(tampon, 0, longueur);
			}
		} finally {
			try {
				sortie.close();
			} catch (IOException ignore) {
			}
			try {
				entree.close();
			} catch (IOException ignore) {
			}
		}
		
	}

	private String getNomFichier(Part part) {
		for ( String contentDisposition : part.getHeader( "content-disposition" ).split(";")) {
			if ( contentDisposition.trim().startsWith("filename")) {
				return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace("\"", "");
			}
		}
		return null;
	}

}
