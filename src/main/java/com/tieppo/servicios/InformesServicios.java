package com.tieppo.servicios;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.tieppo.entidades.Informes;
import com.tieppo.repositorios.InformesRepositorio;

import errorServicio.ErrorServicio;

@Service
public class InformesServicios {
	
	@Autowired
	private InformesRepositorio informesRepositorio;
	


	@Transactional
	public void crearInformes(Integer informeTecnicoN ,String area,String nombreTecnico,String locacion,String nAntena,String tareas,Integer nEquipo, String equipo,Date horaLlegada,Date horaSalida,String empresa,String recomendacion,String descripcion) throws ErrorServicio {
		try {
			Informes informe = new Informes();
			informe.setLocacion(locacion);
			informe.setnAntena(nAntena);
			informe.setTareas(tareas);
			informe.setnEquipo(nEquipo);
			informe.setEquipo(equipo);
			informe.setHoraLlegada(horaLlegada);
			informe.setHoraSalida(horaSalida);
			informe.setFechaEdit(new Date());
			informe.setFechaCreacion(new Date()); 
			informe.setAlta(true);
			informe.setInformeTecnicoN(informeTecnicoN);
			informe.setArea(area);
			informe.setTecnicoNombre(nombreTecnico);
			informe.setDescripcionTareas(descripcion);
			informe.setRecomendacion(recomendacion);
			informe.setEmpresa(empresa);
			informesRepositorio.save(informe);
		} catch (Exception e) {
			System.out.println(horaLlegada);
			throw new ErrorServicio("Todos los campos son obligatorios");
		}
	}
	public Informes buscarPorId(Integer id) {
		Informes informe = informesRepositorio.findById(id).get();
		return informe;
	}
	
	@Transactional
	public void editarInforme(Integer informeTecnicoN ,String area,String nombreTecnico,String locacion,String nAntena,String tareas,Integer nEquipo, String equipo,Date horaLlegada,Date horaSalida,String empresa,String recomendacion,String descripcion,String id) throws ErrorServicio {
		try {
			System.out.println(informeTecnicoN + " informes");
			System.out.println(id);
			int idNumber = Integer.parseInt(id);
			Informes informe = buscarPorId(idNumber);
			
			informe.setLocacion(locacion);
			informe.setnAntena(nAntena);
			informe.setTareas(tareas);
			informe.setnEquipo(nEquipo);
			informe.setEquipo(equipo);
			informe.setHoraLlegada(horaLlegada);
			informe.setHoraSalida(horaSalida);
			informe.setFechaEdit(new Date());
			informe.setAlta(true);
			informe.setInformeTecnicoN(informeTecnicoN);
			informe.setArea(area);
			informe.setTecnicoNombre(nombreTecnico);
			informe.setDescripcionTareas(descripcion);
			informe.setRecomendacion(recomendacion);
			informe.setEmpresa(empresa);
			informesRepositorio.save(informe);
		} catch (Exception e) {
			throw new ErrorServicio("Todos los campos son obligatorios");
		}
	}
	
}
