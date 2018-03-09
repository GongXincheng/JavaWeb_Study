package com.gxc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxc.dao.ItemsMapper;
import com.gxc.pojo.Items;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemsMapper itemsMapper;
	
	@Override
	public List<Items> selectItemsList() {
		List<Items> list = this.itemsMapper.selectByExampleWithBLOBs(null);
		return list;
	}

	@Override
	public Items selectItemById(Integer id) {
		return this.itemsMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateItems(Items items) {
		this.itemsMapper.updateByPrimaryKeyWithBLOBs(items);
	}

}
