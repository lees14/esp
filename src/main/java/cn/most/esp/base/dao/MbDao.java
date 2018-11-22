package cn.most.esp.base.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import cn.most.esp.base.entity.MbInfo;

public interface MbDao {

	@Select("select * from ${table}")
	List<MbInfo> getMb(@Param("table") String table);
}
