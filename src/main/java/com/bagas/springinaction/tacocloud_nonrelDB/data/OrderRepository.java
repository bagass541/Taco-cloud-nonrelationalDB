package com.bagas.springinaction.tacocloud_nonrelDB.data;

import org.springframework.data.repository.CrudRepository;

import com.bagas.springinaction.tacocloud.tacos.TacoOrder;

public interface OrderRepository extends CrudRepository<TacoOrder, Long>{


}
