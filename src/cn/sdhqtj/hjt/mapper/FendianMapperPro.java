package cn.sdhqtj.hjt.mapper;

import java.util.List;

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
	 * 检查重复，分店编号和分店名称
	 */
	List<Fendian> checkrepeat(Fendian record);

	/**
	 * 更新分店信息，选择字段
	 */
	int updatefendian(Fendian record);
}