package com.lucene.erp.dao.impl;

import java.util.List;

import com.lucene.erp.dao.InventoryDao;
import com.lucene.erp.domain.Inventory;

public class InventoryDaoImpl implements InventoryDao {

	@Override
	public boolean insertInventory(Inventory inventory) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Inventory selectInventoryByID(String inventoryID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Inventory> selectInventorysByPeople(String inventoryPeople) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int calculateDiff(int productNum, int inventoryNum) {
		// TODO Auto-generated method stub
		return 0;
	}

}
