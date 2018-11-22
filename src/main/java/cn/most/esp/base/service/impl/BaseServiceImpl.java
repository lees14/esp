package cn.most.esp.base.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.most.esp.base.dao.BaseDao;
import cn.most.esp.base.entity.BaseEntity;
import cn.most.esp.base.service.BaseService;

public abstract class BaseServiceImpl<D extends BaseDao<T>, T extends BaseEntity> implements BaseService<T> {

	private Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);

	@Autowired
	public D dao;

	@Override
	public int insert(T t) {
		try {
			return dao.insert(t);
		}catch (Exception e) {
			logger.debug(e.getMessage());
			return 0;
		}
	}

	@Override
	public int deleteById(int id) {
		try {
			return dao.deleteById(id);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			return 0;
		}
	}

	@Override
	public int updateById(T t) {
		try {
			return dao.updateById(t);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			return 0;
		}
	}

	@Override
	public T getOneById(int id) {
		try {
			return dao.getOneById(id);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			return null;
		}
	}

	@Override
	public List<T> getList(T t) {
		try {
			return dao.getList(t);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			return null;
		}
	}

	@Override
	public List<T> getAll() {
		try {
			return dao.getAll();
		} catch (Exception e) {
			logger.debug(e.getMessage());
			return null;
		}
	}

}
