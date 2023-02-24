package com.example.produits.restcontrollers;

import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.example.produits.entitys.Produit;
import com.example.produits.entitys.Slider;
import com.example.produits.repository.SliderRepository;
import com.example.produits.service.SliderService;

@RestController
@RequestMapping("/slider")
@CrossOrigin (origins = "*")
public class SliderRestController {

	@Autowired
	SliderRepository sliderRepository;
	
	@Autowired
	SliderService sliderService;
	
	@Autowired  ServletContext context;
	
	
	public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/webapp/img";
	
	
	
	@GetMapping(path="/imageSlider/{id}")
	public byte[] getPhoto(@PathVariable("id")Long id) throws Exception{
		Slider slider = sliderRepository.findById(id).get();
		
		return Files.readAllBytes(Paths.get(context.getRealPath("/img/")+slider.getSphoto()));
	}
	
	
	
	
	
	@RequestMapping(path="all",method=RequestMethod.GET)
	public List<Slider> getAllSlider()
	{
		return sliderService.getAllSliders();
	}
	
	@RequestMapping(value="getSlider/{id}",method=RequestMethod.GET)
	public Slider getSliderById(@PathVariable("id") Long id)
	{
		return sliderRepository.findById(id).get();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String saveSlider(Slider s,@RequestParam("img") MultipartFile file) {
		
		
		String filename=s.getId() + file.getOriginalFilename();
		Path fileNameAndPath =Paths.get(uploadDirectory,filename);
		try {
			Files.write(fileNameAndPath, file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		s.setSphoto(filename);
		sliderRepository.save(s);
		return "Save Data Successfully ! ";
	}
	
	@RequestMapping(value = "updateinfo/{id}",method = RequestMethod.PUT)
	@ResponseBody
	public String updateinfo(Slider s,@PathVariable("id") Long id) {
		
		Slider getSlider= sliderRepository.findById(id).get();
		if (getSlider.getSphoto()!=null)
		{
			getSlider.setSphoto(getSlider.getSphoto());
			getSlider.setTitre(s.getTitre());
			getSlider.setDescription(s.getDescription());
			getSlider.setUrl(s.getUrl());
			sliderRepository.save(getSlider);
			
		}
		
		return "Save Data Successfully ! ";
	}
	
	
	@RequestMapping(value = "updateimage/{id}",method = RequestMethod.PUT)
	@ResponseBody
	public String updateimage(Slider s,@RequestParam("img") MultipartFile file,@PathVariable("id") Long id) {
		
		Slider getSlider= sliderRepository.findById(id).get();
		
		getSlider.setTitre(getSlider.getTitre());
		getSlider.setDescription(getSlider.getDescription());
		getSlider.setUrl(getSlider.getUrl());
			String filename=s.getId() + file.getOriginalFilename();
			Path fileNameAndPath =Paths.get(uploadDirectory,filename);
			try {
				Files.write(fileNameAndPath, file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			getSlider.setSphoto(filename);
			
			sliderRepository.save(getSlider);
			
		
		
		return "Save Data Successfully ! ";
	}
	
	
	
	
	
	
}
