package com.br.uninassau.dto;

import java.util.List;

import com.br.uninassau.models.DadosMunicipios;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DadosMunicipiosDto {
	
	private Long somaTotalDomiciliosParticulares;
	private Long totalDomiciliosParticularesOcupados;
	private double percentualDomiciliosParticularesDesocupados;
	@JsonProperty(value = "dados_municipios")
	private List<DadosMunicipios> lista;
	
	public DadosMunicipiosDto() {
		
	}

	public DadosMunicipiosDto(Long somaTotalDomiciliosParticulares, Long totalDomiciliosParticularesOcupados,
			double percentualDomiciliosParticularesDesocupados, List<DadosMunicipios> lista) {
		this.somaTotalDomiciliosParticulares = somaTotalDomiciliosParticulares;
		this.totalDomiciliosParticularesOcupados = totalDomiciliosParticularesOcupados;
		this.percentualDomiciliosParticularesDesocupados = percentualDomiciliosParticularesDesocupados;
		this.lista = lista;
	}

	public Long getSomaTotalDomiciliosParticulares() {
		return somaTotalDomiciliosParticulares;
	}

	public void setSomaTotalDomiciliosParticulares(Long somaTotalDomiciliosParticulares) {
		this.somaTotalDomiciliosParticulares = somaTotalDomiciliosParticulares;
	}

	public Long getTotalDomiciliosParticularesOcupados() {
		return totalDomiciliosParticularesOcupados;
	}

	public void setTotalDomiciliosParticularesOcupados(Long totalDomiciliosParticularesOcupados) {
		this.totalDomiciliosParticularesOcupados = totalDomiciliosParticularesOcupados;
	}

	public double getPercentualDomiciliosParticularesDesocupados() {
		return percentualDomiciliosParticularesDesocupados;
	}

	public void setPercentualDomiciliosParticularesDesocupados(double percentualDomiciliosParticularesDesocupados) {
		this.percentualDomiciliosParticularesDesocupados = percentualDomiciliosParticularesDesocupados;
	}

	public List<DadosMunicipios> getLista() {
		return lista;
	}

	public void setLista(List<DadosMunicipios> lista) {
		this.lista = lista;
	}

}