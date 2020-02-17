package com.jpb.displaycontrol.model;


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="items")
public class Item {
	
	/**
	 * Note: intento de dejar a Postgresql que seleccione el en numero de serie en lugar de hacerlo en el service JP
	 */
	
	@Id
	@Column(name = "manufacturer_id")
	private String manufacturer_id;
		
	//No implementado aun - JP 16/02/2020
    @SequenceGenerator(name="items_id_serial_seq",sequenceName="items_id_serial_seq",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="items_id_serial_seq")
    @Column(name = "id_serial", updatable=true)
    private Long idItemInStore;
		
	
	@Column(name = "nickname")
	private String nickname;
	
	@Column(name = "description")
	private String description;

	
	@Column(name = "price")
	private BigDecimal price;
	
	@Column(name = "units")
	private int units;
		
	
	public Long getIdItemInStore() {
		return idItemInStore;
	}

	public void setIdItemInStore(Long idItemInStore) {
		this.idItemInStore = idItemInStore;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getManufacturer_id() {
		return manufacturer_id;
	}

	public void setManufacturer_id(String manufacturer_id) {
		this.manufacturer_id = manufacturer_id;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
		
	}
}
	
	
	