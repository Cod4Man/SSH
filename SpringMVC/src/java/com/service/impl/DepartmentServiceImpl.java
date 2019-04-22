package com.service.impl;

import java.util.List;

import com.service.DepartmentService;
import org.springframework.transaction.annotation.Transactional;

import com.dao.DepartmentDao;
import com.entity.Department;
import com.entity.PageBean;
/**
 * ���Ź����ҵ���ʵ����
 * @author hope
 */

@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	// ע��serviceDao
    private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	/**
	 * ��ҳ��ѯ���ŵķ���
	 */
	public PageBean<Department> findByPage(Integer currPage) {
        PageBean<Department> pageBean = new PageBean<Department>();
        // ��װ��ǰҳ��
        pageBean.setCurrPage(currPage);
        // ��װÿҳ��¼��
        int pageSize = 3;
        pageBean.setPageSize(pageSize);
        // ��װ�ܼ�¼��
        int totalCount = departmentDao.findCount();
        pageBean.setTotalCount(totalCount);
        // ��װҳ��
        int totalPage;
        if(totalCount%pageSize == 0){
        	totalPage = totalCount/pageSize;
        }else{
        	totalPage = totalCount/pageSize+1; 
        }
        pageBean.setTotalPage(totalPage);
        // ��װ��ǰҳ��¼
        int begin= (currPage - 1)*pageSize;
        List<Department> list = departmentDao.findByPage(begin, pageSize);
        pageBean.setList(list);
		return pageBean;
	}

	@Override
	/**
	 * ��Ӳ��ŵ�ҵ���ʵ��
	 */
	public void save(Department department) {
		// TODO Auto-generated method stub
		departmentDao.save(department);
	}

	@Override
	/**
	 * ����id��ѯ���ŵ�ҵ���ʵ��
	 */
	public Department findById(Integer did) {
		// TODO Auto-generated method stub
		return departmentDao.findById(did);
	}
	
	@Override
	/**
	 * ���²��ŵ�ҵ���ʵ��
	 */
	public void update(Department department) {
		// TODO Auto-generated method stub
		departmentDao.update(department);
	}

	@Override
	/**
	 * ɾ�����ŵ�ҵ���ʵ��
	 */
	public void delete(Department department) {
		// TODO Auto-generated method stub
		departmentDao.delete(department);
	}

	@Override
	/**
	 * ҵ����ѯ���в���
	 */
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return departmentDao.findAll();
	}
	

}
