package com.tieppo.entidades;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Informes {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idInforme;
	private Integer informeTecnicoN;
	private String area;
	private String tecnicoNombre;
	private String nAntena;
	private String locacion;
	private String tareas;
	private String descripcionTareas;
	private String recomendacion;
	private Integer nEquipo;
	private String equipo;
	private Boolean alta;
	private Date horaLlegada;
	private Date horaSalida;
	private Date fechaCreacion;
	private Date fechaEdit;
	private String empresa;
	
	public Informes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Informes(Integer idInforme, Integer informeTecnicoN, String area, String tecnicoNombre, String nAntena,
			String locacion, String tareas, String descripcionTareas, String recomendacion, Integer nEquipo,
			String equipo, Boolean alta, Date horaLlegada,
			Date horaSalida, Date fechaCreacion, Date fechaEdit, String empresa) {
		super();
		this.idInforme = idInforme;
		this.informeTecnicoN = informeTecnicoN;
		this.area = area;
		this.tecnicoNombre = tecnicoNombre;
		this.nAntena = nAntena;
		this.locacion = locacion;
		this.tareas = tareas;
		this.descripcionTareas = descripcionTareas;
		this.recomendacion = recomendacion;
		this.nEquipo = nEquipo;
		this.equipo = equipo;
		this.alta = alta;
		this.horaLlegada = horaLlegada;
		this.horaSalida = horaSalida;
		this.fechaCreacion = fechaCreacion;
		this.fechaEdit = fechaEdit;
		this.empresa = empresa;
	}

	public Integer getIdInforme() {
		return idInforme;
	}

	public void setIdInforme(Integer idInforme) {
		this.idInforme = idInforme;
	}

	public Integer getInformeTecnicoN() {
		return informeTecnicoN;
	}

	public void setInformeTecnicoN(Integer informeTecnicoN) {
		this.informeTecnicoN = informeTecnicoN;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getTecnicoNombre() {
		return tecnicoNombre;
	}

	public void setTecnicoNombre(String tecnicoNombre) {
		this.tecnicoNombre = tecnicoNombre;
	}

	public String getnAntena() {
		return nAntena;
	}

	public void setnAntena(String nAntena) {
		this.nAntena = nAntena;
	}

	public String getLocacion() {
		return locacion;
	}

	public void setLocacion(String locacion) {
		this.locacion = locacion;
	}

	public String getTareas() {
		return tareas;
	}

	public void setTareas(String tareas) {
		this.tareas = tareas;
	}

	public String getDescripcionTareas() {
		return descripcionTareas;
	}

	public void setDescripcionTareas(String descripcionTareas) {
		this.descripcionTareas = descripcionTareas;
	}

	public String getRecomendacion() {
		return recomendacion;
	}

	public void setRecomendacion(String recomendacion) {
		this.recomendacion = recomendacion;
	}

	public Integer getnEquipo() {
		return nEquipo;
	}

	public void setnEquipo(Integer nEquipo) {
		this.nEquipo = nEquipo;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	

	public Boolean getAlta() {
		return alta;
	}

	public void setAlta(Boolean alta) {
		this.alta = alta;
	}

	public Date getHoraLlegada() {
		return horaLlegada;
	}

	public void setHoraLlegada(Date horaLlegada) {
		this.horaLlegada = horaLlegada;
	}

	public Date getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(Date horaSalida) {
		this.horaSalida = horaSalida;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaEdit() {
		return fechaEdit;
	}

	public void setFechaEdit(Date fechaEdit) {
		this.fechaEdit = fechaEdit;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
}
