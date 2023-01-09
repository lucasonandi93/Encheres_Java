package fr.eni.enchere.dal.jdbc;

import java.util.List;


public interface DAO <T, U> {

	public List<T> selectAll() throws DALException;
	public T selectById(U id) throws DALException;
	public void insert(T data) throws DALException;
	public void update(T data) throws DALException;
	public void delete(U id) throws DALException;
	
}
