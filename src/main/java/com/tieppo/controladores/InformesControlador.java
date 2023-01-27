package com.tieppo.controladores;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.tieppo.entidades.Informes;
import com.tieppo.repositorios.InformesRepositorio;
import com.tieppo.servicios.InformesServicios;

import errorServicio.ErrorServicio;

@Controller
@RequestMapping("/informes")
public class InformesControlador {
	Boolean	altas=true;
	
	@Autowired
	InformesServicios informesServicio;
	
	@Autowired
	InformesRepositorio informesRepositorio;
	
	
	@GetMapping("/lista")
	public ModelAndView lista(ModelMap model) {
		ModelAndView mav = new ModelAndView("Informes/listaInformes");
		model.put("altas",altas);
		return mav;
	}
	@GetMapping("/agregar")
	public ModelAndView agregar(ModelMap model) {
		ModelAndView mav = new ModelAndView("Informes/agregarInforme");
		return mav;
	}
	
	@PostMapping("/crearInforme")
	public RedirectView crearInformeMetodoPost(Model modelo,@RequestParam Integer informeTecnicoN,
			 @RequestParam(required=false) String area, @RequestParam(required=false) String nombreTecnico,
			 @RequestParam(required=false) String locacion,  @RequestParam(required=false) String nAntena,  @RequestParam String tareas,
			 @RequestParam(required=false) Integer nEquipo, @RequestParam String equipo ,@RequestParam(required=false) String horaLlegada,
			 @RequestParam(required=false) String horaSalida,@RequestParam String empresa, @RequestParam(required=false) String recomendacion,
			 @RequestParam String descripcion)
			
					 throws ErrorServicio, ParseException {
		RedirectView rv = new RedirectView();
		try {
			Date dia = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String fechaTexto = formatter.format(dia);
			String horaLlegadaA = fechaTexto +" - " +horaLlegada ;
			String horaSalidaA = fechaTexto +" - " +horaSalida ;
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
			Date fechaEntrada = formato.parse(horaLlegadaA);
			Date fechaSalida = formato.parse(horaSalidaA);
			
			informesServicio.crearInformes(informeTecnicoN,area,nombreTecnico,locacion,nAntena,tareas,nEquipo,equipo,fechaEntrada,fechaSalida,empresa,recomendacion,descripcion);
		} catch (ErrorServicio e) {
			modelo.addAttribute("error", e.getMessage());
			
			rv.setUrl("redirect:/informes/lista");
			return rv;
		}
		rv.setUrl("/informes/lista");
		return rv;
	}
	
	@ModelAttribute
	public void addAttributes(Model modelo) {
		List<Informes> listaInformes = informesRepositorio.findAll();
		modelo.addAttribute("informes", listaInformes);
	}
	
	@GetMapping("/imprimir/{id}")
	public ModelAndView imprimir(@PathVariable String id,ModelMap model) {
		ModelAndView mav = new ModelAndView("informes/imprimirInforme");
		int idNumber = Integer.parseInt(id);
		Informes informes = informesServicio.buscarPorId(idNumber);
		model.addAttribute("informe",informes);
		return mav;
	}
	
	@GetMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable String id,ModelMap model) {
		ModelAndView mav = new ModelAndView("informes/editarInforme");
		int idNumber = Integer.parseInt(id);
		Informes informes = informesServicio.buscarPorId(idNumber);
		model.addAttribute("informe",informes);
		System.out.println( informes.getDescripcionTareas());
		return mav;
	}
	
	@PostMapping("/editar/informes")
	public RedirectView editarVacunaMetodoPost(Model modelo,@RequestParam(required=false) Integer informeTecnicoN,
			 @RequestParam(required=false) String area, @RequestParam(required=false) String nombreTecnico,
			 @RequestParam(required=false) String locacion,  @RequestParam(required=false) String nAntena,  @RequestParam(required=false) String tareas,
			 @RequestParam(required=false) Integer nEquipo, @RequestParam(required=false) String equipo ,@RequestParam(required=false) String horaLlegada,
			 @RequestParam(required=false) String horaSalida,@RequestParam(required=false) String empresa, @RequestParam(required=false) String recomendacion,
			 @RequestParam(required=false) String descripcion,
			 @RequestParam(required=false) String id) 
			throws ErrorServicio, ParseException {
			
		RedirectView rv = new RedirectView();
		try {
			System.out.println(descripcion + " id");
			System.out.println(id + " area");
			Date dia = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String fechaTexto = formatter.format(dia);
			String horaLlegadaA = fechaTexto +" - " +horaLlegada ;
			String horaSalidaA = fechaTexto +" - " +horaSalida ;
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
			Date fechaEntrada = formato.parse(horaLlegadaA);
			Date fechaSalida = formato.parse(horaSalidaA);
			informesServicio.editarInforme(informeTecnicoN,area,nombreTecnico,locacion,nAntena,tareas,nEquipo,equipo,fechaEntrada,fechaSalida,empresa,recomendacion,descripcion,id);
		} catch (ErrorServicio e) {
			modelo.addAttribute("error", e.getMessage());
			rv.setUrl("redirect:/informes/lista");
			return rv;
		}
		rv.setUrl("/informes/lista");
		return rv;
	}
}
