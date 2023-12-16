package com.luisgustav.dscommerce.repositories;


import com.luisgustav.dscommerce.entities.OrderItem;
import com.luisgustav.dscommerce.entities.OrderItemPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk> {



}
