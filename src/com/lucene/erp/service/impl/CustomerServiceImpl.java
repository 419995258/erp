package com.lucene.erp.service.impl;

import java.util.List;
import java.util.Map;

import com.lucene.erp.dao.CustomerDao;
import com.lucene.erp.dao.impl.CustomerDaoImpl;
import com.lucene.erp.domain.Customer;
import com.lucene.erp.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	@Override
	public int addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		/*String cid = customer.getCid();
		String name = customer.getName();
		String tel = customer.getTel();
		Date birthday = customer.getBirthday();
		String address = customer.getAddress();
		String email = customer.getEmail();
		double saleAmount = customer.getSaleAmount();
		String record = customer.getRecord();
		String note = customer.getNote();
		customer = new Customer(cid, name, tel, birthday, address, email, saleAmount, record, note);*/
		CustomerDao customerDao = new CustomerDaoImpl();
		int affectRows = customerDao.insertCustomer(customer);
		return affectRows;
	}

	@Override
	public List<Customer> findAllCustomer() {
		// TODO Auto-generated method stub
		CustomerDao customerDao = new CustomerDaoImpl();
		List<Customer> customerList = customerDao.selectAllCustomers();
		return customerList;
	}

	@Override
	public Customer findCustomerByCID(int cid) {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		CustomerDao customerDao = new CustomerDaoImpl();
		customer = customerDao.selectCustomerByCID(cid);
		return customer;
	}

	@Override
	public Customer findCustomerByTel(String tel) {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		CustomerDao customerDao = new CustomerDaoImpl();
		customer = customerDao.selectCustomerByTel(tel);
		return customer;
	}

	@Override
	public List<Customer> findCustomerByName(String name) {
		// TODO Auto-generated method stub
		CustomerDao customerDao = new CustomerDaoImpl();
		List<Customer> customerList = customerDao.selectCustomerByName(name);
		return customerList;
	}

	@Override
	public List<Customer> findCustomerByCidTelName(String cid, String tel,
			String name) {
		CustomerDao customerDao = new CustomerDaoImpl();
		List<Customer> customerList = customerDao.selectCustomerByCidTelCname(cid, tel, name);
		return customerList;
	}

	@Override
	public List<Customer> getPagingList(int start, int number, Map<String, Object> searchItem) {
		// TODO Auto-generated method stub
		CustomerDao customerDao = new CustomerDaoImpl();
		List<Customer> customerList = customerDao.getPagingList(start, number, searchItem);
		return customerList;
	}

	@Override
	public int getCount(Map<String, Object> searchItem) {
		// TODO Auto-generated method stub
		CustomerDao customerDao = new CustomerDaoImpl();
		
		return customerDao.getCountForSearch(searchItem);
	}

	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		CustomerDao customerDao = new CustomerDaoImpl();
		
		return customerDao.getCustomerById(id);
	}

	@Override
	public int updateCustomerById(Customer customer) {
		// TODO Auto-generated method stub
		CustomerDao customerDao = new CustomerDaoImpl();
		
		return customerDao.updateCustomerById(customer);
	}

	@Override
	public int updateCustomerServiceById(Customer customer) {
		// TODO Auto-generated method stub
		CustomerDao customerDao = new CustomerDaoImpl();
		
		return customerDao.updateCustomerServiceById(customer);
	}

}
