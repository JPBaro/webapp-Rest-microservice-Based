package com.jpb.displaycontrol.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jpb.displaycontrol.exception.ItemNotFoundException;
import com.jpb.displaycontrol.model.Item;
import com.jpb.displaycontrol.service.ItemService;



@RestController   // IMPORTANTE:   @RestController = @Controller + @ResponseBody
@RequestMapping("/items")  
public class ItemsController {
	
	@Autowired
	ItemService itemService;
	
	@GetMapping
	public ResponseEntity<List<Item>> getItemInStock(@RequestHeader HttpHeaders httpHeaders) {
		// *replace by empty () when finish tests - JP
		//public ResponseEntity<List<Item>> getItemInStock() {
	

	       
		List<Item> list = itemService.getItemInStock();
		
		//Fancy printing for checking Workflow at Console. to be removed JP
		System.out.println("######################################");
		System.out.println("  @GetMapping  getItemInStock !");
		
		// Test for headers info - still pending authorization to implement logbook???  - JP
		httpHeaders.forEach((headerName, HeaderValue) -> {System.out.println("# Header Name:"+headerName + " ---> Header Value:"+HeaderValue);});
		System.out.println("######################################");
		//----------------------------------------------------------------
		
		return new ResponseEntity<List<Item>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{manufacturer_id}")  
	public ResponseEntity<Item> getManufacturer_id(@PathVariable("manufacturer_id") String manufacturer_id) throws ItemNotFoundException {
		
		Item entity = itemService.getManufacturer_id(manufacturer_id);
		return new ResponseEntity<Item>(entity, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping 
	public ResponseEntity<Item> createOrUpdateItem(@Valid @RequestBody Item item) throws ItemNotFoundException{		
		
		//Fancy printing for checking Workflow at Console. to be removed JP
		System.out.println("######################################");
		System.out.println("#  HIT   @PostMapping  ItemsController  ");
		System.out.println("#  ");
		System.out.println("#  >>>  Item to POST  " + item.getManufacturer_id() + "   <<<" );
		System.out.println("######################################");
		//----------------------------------------------------------------
		
		Item toUpdate = itemService.createOrUpdateItem(item);		
		
		
		return new ResponseEntity<Item>(toUpdate, new HttpHeaders(), HttpStatus.OK);		
	}
	
	@DeleteMapping("/{manufacturer_id}")
	public HttpStatus deleteItemById(@PathVariable("manufacturer_id") String manufacturer_id)
			throws ItemNotFoundException {
		// Fancy printing for checking Workflow at Console. to be removed JP
		System.out.println("######################################");
		System.out.println("#  HIT   @PostMapping  ItemsController  ");
		System.out.println("#  ");
		System.out.println("#  >>>  Item to POST  " + manufacturer_id + "   <<<");
		System.out.println("######################################");
		// ----------------------------------------------------------------
		itemService.deleteItemById(manufacturer_id);
		return HttpStatus.FORBIDDEN;
	}
		
}
