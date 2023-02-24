package com.example.produits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.produits.entitys.Slider;
import com.example.produits.repository.SliderRepository;
@Transactional
@Service
public class SliderServiceImp implements SliderService{

	
	@Autowired
	SliderRepository sliderRepository;
	
	
	@Override
	public List<Slider> getAllSliders() {
		// TODO Auto-generated method stub
		return sliderRepository.findAll();
	}

}
