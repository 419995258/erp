package com.lucene.erp.dao;

import java.util.List;

import com.lucene.erp.domain.Inventory;

//该接口主要定义有关库存盘点的相关方法
public interface InventoryDao {
	// 声明添加盘点信息的方法
	public abstract boolean insertInventory(Inventory inventory);

	// 声明根据盘点编号检索盘点信息的方法
	public abstract Inventory selectInventoryByID(String inventoryID);

	// 声明根据盘点人检索盘点信息的方法
	public abstract List<Inventory> selectInventorysByPeople(String inventoryPeople);

	// 声明计算库存差异的方法
	public abstract int calculateDiff(int productNum, int inventoryNum);
}
