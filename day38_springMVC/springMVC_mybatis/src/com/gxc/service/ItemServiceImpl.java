package com.gxc.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gxc.dao.ItemsMapper;
import com.gxc.pojo.Items;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemsMapper ItemsMapper;
	
	@Override
	public List<Items> selectItemsList() {
		List<Items> itemsList = ItemsMapper.selectByExampleWithBLOBs(null);
		return itemsList;
	}

	@Override
	public Items selectItemById(Integer id) {
		Items items = ItemsMapper.selectByPrimaryKey(id);
		return items;
	}

	@Override
	public void updateItems(Items items) {
		ItemsMapper.updateByPrimaryKeyWithBLOBs(items);		
	}
	

	
}
