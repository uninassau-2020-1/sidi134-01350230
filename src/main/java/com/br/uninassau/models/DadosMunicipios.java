package com.br.uninassau.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dados")
public class DadosMunicipios {
	
	@Id
	private Integer id;
	private String nomeMunicipio;
	private Integer totalDomiciliosParticularesOcupados;	
	private Integer totalDomiciliosParticularesNaoOcupados;
	private Integer totalDomiciliosParticularesNaoOcupadosOcasional;
	private Integer totalDomiciliosParticularesNaoOcupadosVagos;
	@Column(name = "total_domicilios_particulares")
	private Integer totalDomiciliosParticulares;
	private Integer totalDomiciliosColetivos;
	private Integer totalDomiciliosColetivosComMorador;
	private Integer totalDomiciliosColetivosSemMorador;
	private double percentualDomiciliosParticularesOcupados;
	private double percentualDomiciliosParticularesDesocupados;
	
	public DadosMunicipios () {
		
	};	
	
	public DadosMunicipios(Integer id, String nomeMunicipio, Integer totalDomiciliosParticularesOcupados,
			Integer totalDomiciliosParticularesNaoOcupados, Integer totalDomiciliosParticularesNaoOcupadosOcasional,
			Integer totalDomiciliosParticularesNaoOcupadosVagos, Integer totalDomiciliosParticulares,
			Integer totalDomiciliosColetivos, Integer totalDomiciliosColetivosComMorador,
			Integer totalDomiciliosColetivosSemMorador, double percentualDomiciliosParticularesOcupados,
			double percentualDomiciliosParticularesDesocupados) {
		super();
		this.id = id;
		this.nomeMunicipio = nomeMunicipio;
		this.totalDomiciliosParticularesOcupados = totalDomiciliosParticularesOcupados;
		this.totalDomiciliosParticularesNaoOcupados = totalDomiciliosParticularesNaoOcupados;
		this.totalDomiciliosParticularesNaoOcupadosOcasional = totalDomiciliosParticularesNaoOcupadosOcasional;
		this.totalDomiciliosParticularesNaoOcupadosVagos = totalDomiciliosParticularesNaoOcupadosVagos;
		this.totalDomiciliosParticulares = totalDomiciliosParticulares;
		this.totalDomiciliosColetivos = totalDomiciliosColetivos;
		this.totalDomiciliosColetivosComMorador = totalDomiciliosColetivosComMorador;
		this.totalDomiciliosColetivosSemMorador = totalDomiciliosColetivosSemMorador;
		this.percentualDomiciliosParticularesOcupados = percentualDomiciliosParticularesOcupados;
		this.percentualDomiciliosParticularesDesocupados = percentualDomiciliosParticularesDesocupados;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNomeMunicipio() {
		return nomeMunicipio;
	}
	public void setNomeMunicipio(String nomeMunicipio) {
		this.nomeMunicipio = nomeMunicipio;
	}
	public Integer getTotalDomiciliosParticularesOcupados() {
		return totalDomiciliosParticularesOcupados;
	}
	public void setTotalDomiciliosParticularesOcupados(Integer totalDomiciliosParticularesOcupados) {
		this.totalDomiciliosParticularesOcupados = totalDomiciliosParticularesOcupados;
	}
	public Integer getTotalDomiciliosParticularesNaoOcupados() {
		return totalDomiciliosParticularesNaoOcupados;
	}
	public void setTotalDomiciliosParticularesNaoOcupados(Integer totalDomiciliosParticularesNaoOcupados) {
		this.totalDomiciliosParticularesNaoOcupados = totalDomiciliosParticularesNaoOcupados;
	}
	public Integer getTotalDomiciliosParticularesNaoOcupadosOcasional() {
		return totalDomiciliosParticularesNaoOcupadosOcasional;
	}
	public void setTotalDomiciliosParticularesNaoOcupadosOcasional(Integer totalDomiciliosParticularesNaoOcupadosOcasional) {
		this.totalDomiciliosParticularesNaoOcupadosOcasional = totalDomiciliosParticularesNaoOcupadosOcasional;
	}
	public Integer getTotalDomiciliosParticularesNaoOcupadosVagos() {
		return totalDomiciliosParticularesNaoOcupadosVagos;
	}
	public void setTotalDomiciliosParticularesNaoOcupadosVagos(Integer totalDomiciliosParticularesNaoOcupadosVagos) {
		this.totalDomiciliosParticularesNaoOcupadosVagos = totalDomiciliosParticularesNaoOcupadosVagos;
	}
	public Integer getTotalDomiciliosParticulares() {
		return totalDomiciliosParticulares;
	}
	public void setTotalDomiciliosParticulares(Integer totalDomiciliosParticulares) {
		this.totalDomiciliosParticulares = totalDomiciliosParticulares;
	}
	public Integer getTotalDomiciliosColetivos() {
		return totalDomiciliosColetivos;
	}
	public void setTotalDomiciliosColetivos(Integer totalDomiciliosColetivos) {
		this.totalDomiciliosColetivos = totalDomiciliosColetivos;
	}
	public Integer getTotalDomiciliosColetivosComMorador() {
		return totalDomiciliosColetivosComMorador;
	}
	public void setTotalDomiciliosColetivosComMorador(Integer totalDomiciliosColetivosComMorador) {
		this.totalDomiciliosColetivosComMorador = totalDomiciliosColetivosComMorador;
	}
	public Integer getTotalDomiciliosColetivosSemMorador() {
		return totalDomiciliosColetivosSemMorador;
	}
	public void setTotalDomiciliosColetivosSemMorador(Integer totalDomiciliosColetivosSemMorador) {
		this.totalDomiciliosColetivosSemMorador = totalDomiciliosColetivosSemMorador;
	}

	public double getPercentualDomiciliosParticularesOcupados() {
		return percentualDomiciliosParticularesOcupados;
	}

	public void setPercentualDomiciliosParticularesOcupados(double percentualDomiciliosParticularesOcupados) {
		this.percentualDomiciliosParticularesOcupados = percentualDomiciliosParticularesOcupados;
	}

	public double getPercentualDomiciliosParticularesDesocupados() {
		return percentualDomiciliosParticularesDesocupados;
	}

	public void setPercentualDomiciliosParticularesDesocupados(double percentualDomiciliosParticularesDesocupados) {
		this.percentualDomiciliosParticularesDesocupados = percentualDomiciliosParticularesDesocupados;
	}

}