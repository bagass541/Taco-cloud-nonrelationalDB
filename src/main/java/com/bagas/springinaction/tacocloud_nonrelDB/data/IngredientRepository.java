package com.bagas.springinaction.tacocloud_nonrelDB.data;

import org.springframework.data.repository.CrudRepository;
import com.bagas.springinaction.tacocloud_nonrelDB.tacos.Ingredient;


public interface IngredientRepository extends CrudRepository<Ingredient, String>{
	

}
