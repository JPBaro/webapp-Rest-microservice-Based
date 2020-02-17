package com.jpb.displaycontrol.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpb.displaycontrol.exception.ItemNotFoundException;
import com.jpb.displaycontrol.model.Item;
import com.jpb.displaycontrol.repository.ItemRepository;


@Service
public class ItemService {
		
	@Autowired  //autowire whith interface at repository at  com.jpb.displaycontrol.repositiry.ItemRepository
	ItemRepository repoItem;
	
	public List<Item> getItemInStock(){
	
		List<Item> itemList = repoItem.findAll();		
		if (itemList.size()>0) {
			return itemList;  // if >single item is present JP
			
		}else {
			return new ArrayList<Item>();  // if empty, creates ArrayList JP
			}
		}
	
	public Item getManufacturer_id(String manufacturer_id) throws ItemNotFoundException {

		Optional<Item> item = repoItem.findById(manufacturer_id);

		if (item.isPresent()) {
			return item.get();
		} else {
			throw new ItemNotFoundException("Lo siento miarma, No ITEM in stock with that ", manufacturer_id);
		}
	}
	
	
	public Item createOrUpdateItem(Item entity) throws ItemNotFoundException {

		if (entity.getManufacturer_id() != null) {

			Optional<Item> item = repoItem.findById(entity.getManufacturer_id());

			if (item.isPresent()) {
				Item newEntity = item.get();

				// REpensar, para adicionar a stock , asi como actualizar unidades y rechazar overwriting
				 				
				newEntity.setNickname(entity.getNickname());
				newEntity.setDescription(entity.getDescription());
				newEntity.setManufacturer_id(entity.getManufacturer_id());
				newEntity.setPrice(entity.getPrice());
				newEntity.setUnits(entity.getUnits());
				newEntity = repoItem.save(newEntity);

				return newEntity;

			} else {
				entity = repoItem.save(entity);

				return entity;
			}
		}

		
		else {
					
			entity = repoItem.save(entity);
			return entity;
		}

	}

  
	    public void deleteItemById(String manufacturer_id) throws ItemNotFoundException
	    {
	        Optional<Item> item = repoItem.findById(manufacturer_id);
	         
	        if(item.isPresent())
	        {
	            repoItem.deleteById(manufacturer_id);
	        } else {
	            throw new ItemNotFoundException("There is no item with the given manufacturer_id: ",manufacturer_id);
	        }
	    }
	
	
	
	
	
	}
	
	
	
	


