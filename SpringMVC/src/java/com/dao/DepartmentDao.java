package com.dao;

import com.entity.Department;

import java.util.List;

/**
 * ���Ź����Dao��ӿ�
 * @author hope
 */
public interface DepartmentDao {

	int findCount();

	List<Department> findByPage(int begin, int pageSize);

	void save(Department department);

	void update(Department department);

	Department findById(Integer did);

	void delete(Department department);

	List<Department> findAll();

}
