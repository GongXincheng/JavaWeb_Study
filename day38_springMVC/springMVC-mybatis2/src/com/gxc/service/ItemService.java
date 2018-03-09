package com.gxc.service;

import java.util.List;
import com.gxc.pojo.Items;

public interface ItemService {

	/**
	 * 查询商品列表
	 */
	public List<Items> selectItemsList();

	/**
	 * 根据Id查询
	 * @param id
	 * @return
	 */
	public Items selectItemById(Integer id);

	/**
	 * 更新商品信息
	 * @param items
	 */
	public void updateItems(Items items);
}
