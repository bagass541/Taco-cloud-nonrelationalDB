package com.bagas.springinaction.tacocloud_nonrelDB.data;

import org.springframework.data.repository.CrudRepository;

import com.bagas.springinaction.tacocloud_nonrelDB.tacos.TacoOrder;


public interface OrderRepository extends CrudRepository<TacoOrder, String>{


}
