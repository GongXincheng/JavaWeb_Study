package com.gxc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gxc.pojo.Items;
import com.gxc.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value = "/item/itemList.action")
	public ModelAndView itemList(){
		
		List<Items> itemsList = itemService.selectItemsList();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("itemList", itemsList);
		mav.setViewName("itemList");
		return mav;
	}
	
	@RequestMapping(value = "/itemEdit.action")
	public ModelAndView toEditUI(Integer id){
		Items item = itemService.selectItemById(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("item", item);
		mav.setViewName("editItem");
		return mav;
	}
	
	@RequestMapping(value = "/updateitem.action")
	public ModelAndView updateItems(Items items){
	//public ModelAndView updateItems(QueryVo vo){
		this.itemService.updateItems(items);
		//this.itemService.updateItems(vo.getItem());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("success");
		return mav;
	}
	
}
