package fr.eni.enchere.dal.jdbc;

import java.util.List;

import fr.eni.enchere.exceptions.BusinessException;


public interface DAO <T, U> {

	public List<T> selectAll() throws BusinessException;
	public T selectById(U id) throws BusinessException;
	public void insert(T data) throws BusinessException;
	public void update(T data) throws BusinessException;
	public void delete(U id) throws BusinessException;
	
}
