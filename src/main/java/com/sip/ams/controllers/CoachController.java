package com.sip.ams.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sip.ams.entities.Coach;
import com.sip.ams.repositories.CoachRepository;
import java.util.*;

@Controller
@RequestMapping("/coach")
public class CoachController {

	
	CoachRepository  coachRepository;
	
	@Autowired  // injection de dépendence
	public CoachController(CoachRepository  coachRepository)
	{
		this.coachRepository = coachRepository;
	}
	
	@RequestMapping("/list")
	//@ResponseBody
	public String listCoach(Model model)
	{
		List<Coach> lc = (List<Coach>) coachRepository.findAll();
		//System.out.println(lc.isEmpty());
		//System.out.println(lc.size());
		
		model.addAttribute("coaches", lc);
		return "coach/list";
	}
	
	@GetMapping("/add")
	public String formCoach()  // ça sera la méthode de création d'un form pour l'ajout d'un coach
	{
		return "coach/add";
	}
	
	// ça sera la méthode d'ajout d'un coach dans la table coach
	@PostMapping("/add")
	//@ResponseBody
	public String saveCoach(@RequestParam("nom")String nom,
			@RequestParam("email")String email,
			@RequestParam("age")int age
			)  
	
	{
		// un comment pour afficher les paramètres reçu
		//System.out.println("nom = "+nom +" email : "+email +" age = "+age);
		Coach c = new Coach();
		c.setNom(nom);
		c.setEmail(email);
		c.setAge(age);
		coachRepository.save(c);
		
		return "redirect:list";
	}
	
	// méthode delete coach
	
	@RequestMapping("delete/{id}")
	//@ResponseBody
	public String deleteCoach(@PathVariable("id")int idC)
	{
		coachRepository.deleteById(idC); //suppression du coach par son id
		return "redirect:../list";
		
	}
	
	// méthode form update coach : Get
	@GetMapping("update/{id}")
	public String formUpdateCoach(@PathVariable("id")int idC, Model model)
	{
		// récupération du coach a partir de son id
		
		Optional<Coach> coach= coachRepository.findById(idC);
		model.addAttribute("coach",coach);
		//System.out.println(coach);
		return "coach/update";
		
	}
	
	// méthode update and save coach : Post
		@PostMapping("update")
		public String saveUpdatedCoach(Coach coach)
		{
			coachRepository.save(coach);
			
			return "redirect:list";
			
		}
}
