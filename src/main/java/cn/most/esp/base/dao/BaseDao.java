package cn.most.esp.base.dao;

import java.util.List;

public interface BaseDao<T> {
	
	/**
	 *  增
	 * @param t
	 * @return
	 */
	int insert(T t);
	
	/**
	 *  删 
	 * @param id
	 * @return
	 */
	int deleteById(int id);
	
	/**
	 * 改
	 * @param T
	 * @return
	 */
	int updateById(T t);
	
	/**
	 * 根据ID查找
	 * @param id
	 * @return
	 */
	T getOneById(int id);
	
	/**
	 * 根据类属性查找
	 * @param t
	 * @return
	 */
	List<T> getList(T t);
	
	/**
	 * 查找所有
	 * @return
	 */
	List<T> getAll();
}
