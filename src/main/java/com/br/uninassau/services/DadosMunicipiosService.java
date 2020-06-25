package com.br.uninassau.services;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.uninassau.dto.DadosMunicipiosDto;
import com.br.uninassau.models.DadosMunicipios;
import com.br.uninassau.repositories.DadosMunicipiosRepository;

@Service
public class DadosMunicipiosService {

	@Autowired
	private DadosMunicipiosRepository dadosMunicipiosRepository;

	public DadosMunicipiosDto findAll() {
		List<DadosMunicipios> retorno = dadosMunicipiosRepository.findAll();
		DadosMunicipiosDto dadosMunicipiosDto = new DadosMunicipiosDto();
		dadosMunicipiosDto.setLista(retorno);
		dadosMunicipiosDto.setSomaTotalDomiciliosParticulares(somaTotalDomiciliosParticulares(retorno));
		dadosMunicipiosDto.setTotalDomiciliosParticularesOcupados(totalDomiciliosParticularesOcupados(retorno));
		dadosMunicipiosDto.setTotalDomiciliosParticularesNaoOcupados(totalDomiciliosParticularesNaoOcupados(retorno));
		dadosMunicipiosDto
				.setPercentualDomiciliosParticularesOcupados(percentualDomiciliosParticularesOcupados(retorno));
		dadosMunicipiosDto
				.setPercentualDomiciliosParticularesDesocupados(percentualDomiciliosParticularesDesocupados(retorno));
		return dadosMunicipiosDto;
	}

	public DadosMunicipios findById(Integer id) {
		Optional<DadosMunicipios> objDadosMunicipios = dadosMunicipiosRepository.findById(id);
		objDadosMunicipios.get().setPercentualDomiciliosParticularesDesocupados(
				((double)objDadosMunicipios.get().getTotalDomiciliosParticularesNaoOcupados()
						/ ((double)objDadosMunicipios.get().getTotalDomiciliosParticularesOcupados()) * 100));
		objDadosMunicipios.get().setPercentualDomiciliosParticularesOcupados(
				((double)objDadosMunicipios.get().getTotalDomiciliosParticularesOcupados()
						/ ((double)objDadosMunicipios.get().getTotalDomiciliosParticulares()) * 100));
		return objDadosMunicipios.get();
//		return dadosMunicipiosRepository.findById(id).get();
	}

	private Long somaTotalDomiciliosParticulares(List<DadosMunicipios> lista) {

		Long soma = 0L;
		for (DadosMunicipios dadosMunicipios : lista) {
			soma += dadosMunicipios.getTotalDomiciliosParticulares();
		}
		return soma;
	}

	private Long totalDomiciliosParticularesOcupados(List<DadosMunicipios> lista) {

		Long soma = 0L;
		for (DadosMunicipios dadosMunicipios : lista) {
			soma += dadosMunicipios.getTotalDomiciliosParticularesOcupados();
		}
		return soma;
	}

	private Long totalDomiciliosParticularesNaoOcupados(List<DadosMunicipios> lista) {

		Long soma = 0L;
		for (DadosMunicipios dadosMunicipios : lista) {
			soma += dadosMunicipios.getTotalDomiciliosParticularesNaoOcupados();
		}
		return soma;
	}

	private double percentualDomiciliosParticularesDesocupados(List<DadosMunicipios> lista) {
		double percentual = ((double) totalDomiciliosParticularesNaoOcupados(lista)
				/ (double) totalDomiciliosParticularesOcupados(lista)) * 100;
		DecimalFormat df = new DecimalFormat("#0.00");
		String percentualString = df.format(percentual);
		return Double.parseDouble(percentualString.replace(",", "."));
	}

	private double percentualDomiciliosParticularesOcupados(List<DadosMunicipios> lista) {
		double percentual = ((double) totalDomiciliosParticularesOcupados(lista)
				/ (double) somaTotalDomiciliosParticulares(lista)) * 100;
		DecimalFormat df = new DecimalFormat("#0.00");
		String percentualString = df.format(percentual);
		return Double.parseDouble(percentualString.replace(",", "."));
	}

}
