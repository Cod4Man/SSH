package com.service.impl;

import java.util.List;

import com.service.EmployeeService;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Department;
import com.entity.Employee;
import com.entity.PageBean;
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    private com.dao.EmployeeDao employeeDao;
   
	public void setEmployeeDao(com.dao.EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	/**
	 * ҵ����¼����
	 */
	public Employee login(Employee employee) {
		// TODO Auto-generated method stub
		Employee eEmployee = employeeDao.findByUsernameAndPassword(employee);
		return eEmployee;
	}

	@Override
	/**
	 * ҵ����ѯָ��ҳ�淽��
	 */
	public PageBean<Employee> findByPage(Integer currPage) {
		// TODO Auto-generated method stub
		  PageBean<Employee> pageBean = new PageBean<Employee>();
	        // ��װ��ǰҳ��
	        pageBean.setCurrPage(currPage);
	        // ��װÿҳ��¼��
	        int pageSize = 3;
	        pageBean.setPageSize(pageSize);
	        // ��װ�ܼ�¼��
	        int totalCount = employeeDao.findCount();
	        pageBean.setTotalCount(totalCount);
	        // ��װҳ��
	        int totalPage;
	        if(totalCount%pageSize==0){
	        	totalPage = totalCount/pageSize;
	        }else{
	        	totalPage = totalCount/pageSize + 1; 
	        }
	        pageBean.setTotalPage(totalPage);
	        // ��װ��ǰҳ��¼
	        int begin= (currPage - 1)*pageSize;
	        List<Employee> list = employeeDao.findByPage(begin, pageSize);
	        pageBean.setList(list);
			return pageBean;
	}

	@Override
	/**
	 * ҵ������Ա���ķ���
	 */
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.save(employee);
		
	}

	@Override
	/**
	 * ҵ������id��ѯԱ���ķ���
	 */
	public Employee findById(Integer eid) {
		// TODO Auto-generated method stub
		return employeeDao.findById(eid);
	}
	
	@Override
	/**
	 * �༭Ա����ҵ���ʵ�ַ���
	 */
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.update(employee);		
	}

	@Override
	/**
	 * ҵ���Ա��ɾ��
	 */
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.delete(employee);
	}
}
