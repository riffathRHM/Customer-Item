package com.springBootAcadamy.lombok.repositary;

import com.springBootAcadamy.lombok.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


@Repository
@EnableJpaRepositories
public interface ItemRepo extends JpaRepository<Item,Integer> {
}
