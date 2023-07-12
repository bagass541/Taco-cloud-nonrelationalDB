package com.bagas.springinaction.tacocloud_nonrelDB.web;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bagas.springinaction.tacocloud_nonrelDB.data.IngredientRepository;
import com.bagas.springinaction.tacocloud_nonrelDB.tacos.Ingredient;
import com.bagas.springinaction.tacocloud_nonrelDB.tacos.Ingredient.Type;
import com.bagas.springinaction.tacocloud_nonrelDB.tacos.Taco;
import com.bagas.springinaction.tacocloud_nonrelDB.tacos.TacoOrder;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {
	
	private final IngredientRepository ingredientRepo;
	
	@Autowired
	public DesignTacoController(IngredientRepository ingredientRepo) {
		this.ingredientRepo = ingredientRepo;
	}

	@ModelAttribute
	public void addIngredientsToModel(Model model)
	{
		Iterable<Ingredient> ingredients = ingredientRepo.findAll();
		Type[] types = Ingredient.Type.values();
		for(Type type : types)
		{
			// Cast shouldn't be required
			model.addAttribute(type.toString().toLowerCase(), 
					filterbyType((List<Ingredient>) ingredients, type));
		}
	}
	
	@ModelAttribute(name = "tacoOrder")
	public TacoOrder order()
	{
		return new TacoOrder();
	}
	
	@ModelAttribute(name = "taco")
	public Taco taco()
	{
		return new Taco();
	}
	
	@GetMapping
	public String showDesignForm()
	{
		return "design";
	}
	
	@PostMapping
	public String processTaco(@Valid Taco taco, Errors errors, @ModelAttribute TacoOrder tacoOrder)
	{
		if(errors.hasErrors())
		{
			return "design";
		}
		tacoOrder.addTaco(taco);
		log.info("Processing taco: {}", taco);
		return "redirect:/orders/current";
	}
	

	private Iterable<Ingredient> filterbyType(List<Ingredient> ingredients, Type type) {
		return ingredients
				.stream()
				.filter(x -> x.getType().equals(type))
				.collect(Collectors.toList());
	}

}
