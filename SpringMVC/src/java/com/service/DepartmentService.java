package com.service;

import java.util.List;

import com.entity.Department;
import com.entity.PageBean;
/**
 * ���Ź����ҵ���ӿ�ʵ����
 * @author hope
 */
public interface DepartmentService {

	PageBean<Department> findByPage(Integer currPage);

	void save(Department department);

	void update(Department department);

	Department findById(Integer did);

	void delete(Department department);

	List<Department> findAll();


}
