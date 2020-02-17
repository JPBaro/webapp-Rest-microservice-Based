package com.jpb.displaycontrol.repository;


import org.springframework.data.jpa.repository.JpaRepository;



import org.springframework.stereotype.Repository;

import com.jpb.displaycontrol.model.Item;

@Repository // defines BooksRepository as DAO 
public interface ItemRepository extends JpaRepository<Item, String>{
	
	
}
