package cn.sdhqtj.hjt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.sdhqtj.hjt.entity.Fendian;

@Service
public interface FendianService {

	public List<Fendian> fendianquery();

	public Fendian fendianget(Integer id);

	public Fendian selectByfdbh(String fdbh);

	public Fendian selectByfdmc(String fdmc);

	public void fendianadd(Fendian fendian);


	public void fendiandelete(int id);

	public void fendianUpdate(Fendian fendian);

}