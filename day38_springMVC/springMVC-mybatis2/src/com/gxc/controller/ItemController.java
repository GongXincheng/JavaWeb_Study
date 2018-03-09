package com.gxc.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.gxc.pojo.Items;
import com.gxc.pojo.QueryVo;
import com.gxc.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value = "/item/itemList.action")
	public ModelAndView itemList(){
		//int i = 1/0;
		List<Items> itemsList = this.itemService.selectItemsList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("itemList", itemsList);
		mav.setViewName("/WEB-INF/jsp/itemList.jsp");
		return mav;
	}
	@RequestMapping(value = "/item/itemList2.action")
	public String itemList2(Model model){
		List<Items> itemsList = this.itemService.selectItemsList();
		model.addAttribute("itemList", itemsList);
		return "/WEB-INF/jsp/itemList.jsp";
	}
	
	@RequestMapping(value = "/itemEdit.action")
	public ModelAndView toEditUI(Integer id){
		Items item = this.itemService.selectItemById(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("item", item);
		mav.setViewName("/WEB-INF/jsp/editItem.jsp");
		return mav;
	}
	
	@RequestMapping(value = "/updateitem.action")
	public String updateItems(QueryVo vo, MultipartFile pictureFile) throws Exception{
		
		//为图片重命名
		String fileName = UUID.randomUUID().toString().replaceAll("-", "");
		//后缀名
		String afterName = FilenameUtils.getExtension(pictureFile.getOriginalFilename());
		//拼接文件名
		String name = fileName + "." + afterName;
		//保存图片到D:\\upload
		pictureFile.transferTo(new File("D:\\upload", name));
		
		//保存到数据库
		vo.getItem().setPic(name);
		this.itemService.updateItems(vo.getItem());

		return "redirect:/itemEdit.action?id="+vo.getItem().getId();
	}
	
	/**
	 * 删除多个Item
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/deletes.action")
	public ModelAndView deleteItems(Integer[] ids){
		for (Integer id : ids) {
			System.out.println(id);
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/jsp/success.jsp");
		return mav;
	}
	
	/**
	 * JSON数据交互
	 */
	@RequestMapping(value = "/json.action")
	public @ResponseBody 
	Items jsonTest(@RequestBody Items items){
		System.out.println(items);
		return items;
	}
	
	/**
	 * RestFul风格开发
	 */
	@RequestMapping(value = "/itemEdit/{id}.action")
	public ModelAndView toEdit(@PathVariable Integer id){
		Items item = this.itemService.selectItemById(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("item", item);
		mav.setViewName("/WEB-INF/jsp/editItem.jsp");
		return mav;
	}
	
}
