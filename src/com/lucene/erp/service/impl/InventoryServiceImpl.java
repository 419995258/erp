package com.lucene.erp.service.impl;

import java.util.List;

import com.lucene.erp.domain.Inventory;
import com.lucene.erp.service.InventoryService;

public class InventoryServiceImpl implements InventoryService {

	@Override
	public boolean addInventory(Inventory inventory) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Inventory findInventoryByID(String inventoryID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Inventory> findInventorysByPeople(String inventoryPeople) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int calculateDiff(int productNum, int inventoryNum) {
		// TODO Auto-generated method stub
		return 0;
	}

}
