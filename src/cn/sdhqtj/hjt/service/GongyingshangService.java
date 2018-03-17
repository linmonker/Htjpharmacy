package cn.sdhqtj.hjt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.sdhqtj.hjt.entity.Gongyingshang;
import cn.sdhqtj.hjt.entity.GongyingshangWithBLOBs;

@Service
public interface GongyingshangService {

	public List<Gongyingshang> gongyingshangquery();

	public GongyingshangWithBLOBs selectBygysbhWithBLOBs(String gysbh);

	public void gongyingshangadd(GongyingshangWithBLOBs gysB);
	
	public void gongyingshangupdate(GongyingshangWithBLOBs gysB);

	public void gongyingshangdelete(Integer id);
	
}