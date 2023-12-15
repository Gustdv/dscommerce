package com.luisgustav.dscommerce.repositories;

import com.luisgustav.dscommerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {



}
