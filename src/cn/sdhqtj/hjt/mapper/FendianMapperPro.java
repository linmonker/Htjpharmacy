package cn.sdhqtj.hjt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.sdhqtj.hjt.entity.Fendian;

/**
 * 分店mapper补充
 */
public interface FendianMapperPro {

	/**
	 * 获取分店列表
	 */
	List<Fendian> fendianquery();

	/**
	 * 获取分店列表,从start位置开始20条记录
	 */
	List<Fendian> getlist(int start);

	/**
	 * 获取分店列表记录数
	 */
	int getcount();

	/**
	 * 模糊搜索分店：分店名称
	 */
	List<Fendian> searchfendian(@Param("fendian") Fendian record, @Param("start") int start);

	/**
	 * 获取分店列表搜索记录数
	 */
	int getsearchcount(@Param("fendian") Fendian record);

	/**
	 * 检查重复：分店编号，分店名称
	 */
	List<Fendian> checkrepeat(Fendian record);

	/**
	 * 更新分店信息，部分字段
	 */
	int updatefendian(Fendian record);
}