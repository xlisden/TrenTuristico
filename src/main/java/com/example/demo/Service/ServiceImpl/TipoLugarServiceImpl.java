package com.example.demo.Service.ServiceImpl;

import com.example.demo.Entity.TipoLugar;
import com.example.demo.Repository.TipoLugarRepository;
import com.example.demo.Service.TipoLugarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TipoLugarServiceImpl implements TipoLugarService {

	private final TipoLugarRepository tipoLugarRepository;

	@Override
	public List<TipoLugar> findAllTipoLugar() {
		return tipoLugarRepository.findAll();
	}

	@Override
	public TipoLugar addTipoLugar(TipoLugar tipoLugar) {
		return tipoLugarRepository.save(tipoLugar);
	}

	@Override
	public TipoLugar updateTipoLugar(TipoLugar tipoLugar) {
		return tipoLugarRepository.save(tipoLugar);
	}

	@Override
	public TipoLugar getTipoLugar(int id) throws Exception {
		Optional<TipoLugar> tipoLugar = tipoLugarRepository.findById(id);
		if (tipoLugar.isPresent()) {
			return tipoLugar.get();
		} else {
			throw new Exception("No se encontró el tipo de lugar con ID: " + id);
		}
	}

	@Override
	public void deleteTipoLugar(int id) {
		tipoLugarRepository.deleteById(id);
	}
}
