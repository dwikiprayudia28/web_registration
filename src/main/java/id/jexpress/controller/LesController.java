package id.jexpress.controller;

import id.jexpress.model.Les;
import id.jexpress.model.Master;
import id.jexpress.model.User;
import id.jexpress.service.LesService;
import id.jexpress.service.MasterService;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("les")
public class LesController {
	
	@Autowired
	private MasterService masterService;
	
	@Autowired
	private LesService lesService;
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public ModelAndView viewList() {
		System.out.println("list les");
		Authentication userlogin = SecurityContextHolder.getContext().getAuthentication();
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("listDataLes", lesService.getListLesByCreatedUser(userlogin.getName()));
		return new ModelAndView("lesListing", model);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView viewCreateLes(@ModelAttribute Les les) {
		System.out.println("les new");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("listKelas", masterService.getListMasterByType("kelas"));
		model.put("listJurusan", masterService.getListMasterByType("jurusan"));
		model.put("listJenisPertemuan", masterService.getListMasterByType("jenis_pertemuan"));
		model.put("listJadwal", masterService.getListMasterByType("jadwal"));
		return new ModelAndView("lesCreate", model);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView submitCreateLes(@ModelAttribute Les les,
			BindingResult errors) {
		System.out.println("submit les");
		try {
			lesService.insertLes(les);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/les/list");
	}
	
	@RequestMapping(value="/paid", method = RequestMethod.GET, params = "id")
	public ModelAndView submitPaid(@RequestParam("id") Integer id) {
		System.out.println("paid");
		try {
			Les les = new Les();
			les.setId(id);
			les.setStatus("paid");
			lesService.updatePaidLes(les);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/les/list");
	}
	
	@RequestMapping(value="/edit", method = RequestMethod.GET, params = "id")
	public ModelAndView viewEdit(@RequestParam("id") Integer id) {
		
		System.out.println("les edit");
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("les", lesService.getLesById(id));
		model.put("listKelas", masterService.getListMasterByType("kelas"));
		model.put("listJurusan", masterService.getListMasterByType("jurusan"));
		model.put("listJenisPertemuan", masterService.getListMasterByType("jenis_pertemuan"));
		model.put("listJadwal", masterService.getListMasterByType("jadwal"));
		return new ModelAndView("lesDetail", model);
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView submitEditLes(@ModelAttribute Les les,
			BindingResult errors) {
		System.out.println("submit edit les");
		try {
			lesService.updateLes(les);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/les/list");
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}

}
