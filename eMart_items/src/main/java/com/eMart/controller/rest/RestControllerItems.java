package com.eMart.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eMart.persistence.service.BaseService;
import com.eMart.controller.rest.Result;
import com.eMart.persistence.entity.Items;
import com.eMart.persistence.model.ItemModel;
import com.eMart.persistence.service.ItemsService;

@RestController
@RequestMapping("/item")
public class RestControllerItems {
	
	@Autowired
	private ItemsService itemsService;
	
	private BaseService getService() {
		return itemsService;
	}
	
	@RequestMapping(value = "/getall/", method = RequestMethod.GET)
	public List<Object> getall() {
		return getService().findAll();
	}
	
	@RequestMapping(value = "/getby/{id}", method = RequestMethod.GET)
	public Object getby(@PathVariable long id) {
		return getService().findBy(id);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public Items save (@RequestBody Items o) {
		return (Items) getService().save(o);
	}
	

	@RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
	public Result del(@PathVariable long id) {
		Object u = getService().findBy(id);		
		return getService().delete(u);
	}
	
	@RequestMapping(value = "/getmodel/", method = RequestMethod.GET)
	public List<ItemModel> getmodel() {
		return itemsService.getModel();
	}
	
	@RequestMapping(value = "/getmodelby/{id}", method = RequestMethod.GET)
	public Object getModelBy(@PathVariable long id) {
		return itemsService.getModelBy(id);
	}

}
