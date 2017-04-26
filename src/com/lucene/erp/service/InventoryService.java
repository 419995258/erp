package com.lucene.erp.service;

import java.util.List;

import com.lucene.erp.domain.Inventory;

public interface InventoryService {
	// 声明添加盘点信息的方法
	public abstract boolean addInventory(Inventory inventory);

	// 声明根据盘点编号检索盘点信息的方法
	public abstract Inventory findInventoryByID(String inventoryID);

	// 声明根据盘点人检索盘点信息的方法
	public abstract List<Inventory> findInventorysByPeople(String inventoryPeople);

	// 声明计算库存差异的方法
	public abstract int calculateDiff(int productNum, int inventoryNum);
}
