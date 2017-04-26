package com.lucene.erp.service.impl;

import java.util.List;
import java.util.Map;

import com.lucene.erp.dao.ExportDao;
import com.lucene.erp.dao.impl.ExportDaoImpl;
import com.lucene.erp.domain.Export;
import com.lucene.erp.service.ExportService;

public class ExportServiceImpl implements ExportService {
	ExportDao exportDao = new ExportDaoImpl();
	
	
	@Override
	public Export findExportByCode(String barCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Export> findAllExports() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addExport(Export export) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getCount(Map<String, Object> searchItem) {
		return exportDao.getCountForSearch(searchItem);
	}

	@Override
	public List<Export> getPagingList(int start, int number,
			Map<String, Object> searchItem) {
		// TODO Auto-generated method stub
		return exportDao.getPagingList(start, number, searchItem);
	}

}
