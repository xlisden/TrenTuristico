package com.example.demo.Service;
import com.example.demo.Entity.TipoLugar;
import java.util.List;

public interface TipoLugarService {
	public abstract List<TipoLugar> findAllTipoLugar();
	public abstract TipoLugar addTipoLugar(TipoLugar tipoLugar);
	public abstract TipoLugar updateTipoLugar(TipoLugar tipoLugar);
	public abstract TipoLugar getTipoLugar(int id)throws Exception;
	public abstract void deleteTipoLugar(int id);
	
}
