package com.bagas.springinaction.tacocloud_nonrelDB.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.bagas.springinaction.tacocloud.data.IngredientRepository;
import com.bagas.springinaction.tacocloud.tacos.Ingredient;
import com.bagas.springinaction.tacocloud.tacos.Ingredient.Type;




@Component
public class IngredientByIdConverter implements Converter<String, Ingredient>{

	private IngredientRepository ingredientRepo;
	
	@Autowired
	public IngredientByIdConverter(IngredientRepository ingredientRepo)
	{
		this.ingredientRepo = ingredientRepo;
	}
	
	@Override
	public Ingredient convert(String id) {
		return ingredientRepo.findById(id).orElse(null);
	}

	
	

}
