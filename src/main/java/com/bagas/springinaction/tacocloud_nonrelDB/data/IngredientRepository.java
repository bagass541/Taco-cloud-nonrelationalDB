package com.bagas.springinaction.tacocloud_nonrelDB.data;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import com.bagas.springinaction.tacocloud.tacos.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String>{
	

}
