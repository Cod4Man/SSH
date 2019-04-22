package com.dao.impl;

import java.util.List;

import com.dao.EmployeeDao;
import com.entity.Employee;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

/**
 * Ա��ʵ�ֵ�Dao��
 * @author hope
 *
 */
public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {

	@Override
	/**
	 * Dao�и����û����������ѯ
	 */
	public Employee findByUsernameAndPassword(Employee employee) {
		// TODO Auto-generated method stub
		String hql = "from Employee where username=? and password=?";
		List<Employee> employeeList = this.getHibernateTemplate().find(hql,employee.getUsername(),employee.getPassword());
		if(employeeList.size()>0){
			// �鵽���ݷ��ص�һ��
			System.out.println(employeeList.get(0).getEname()+"���ҳɹ�");
			return employeeList.get(0);
		}
		return null;
	}

	@Override
	/**
	 * Dao���ѯ��Ա�����ķ���
	 */
	public int findCount() {
		// TODO Auto-generated method stub
		String hql="select count(*) from Employee";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	/**
	 * Dao�в�ѯָ��ҳ�ķ���
	 */
	public List<Employee> findByPage(int begin, int pageSize) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		List<Employee> list = this.getHibernateTemplate().findByCriteria(criteria,begin,pageSize);
		return list;
	}

	@Override
	/**
	 * Dao �����Ա���ı��淽��
	 */
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(employee);
	}

	@Override
	/**
	 * Dao�и���id��ѯԱ��
	 */
	public Employee findById(Integer eid) {
		// TODO Auto-generated method stub
		Employee em =this.getHibernateTemplate().get(Employee.class, eid);
		System.out.println("�ض�Ա����"+em);
		return em;
	}
	@Override
	/**
	 * Dao��༭Ա��
	 */
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		System.out.println("name: "+employee.getEname());
		System.out.println("sex: "+employee.getSex());
		this.getHibernateTemplate().update(employee);
	}

	@Override
	/**
	 * Dao��ɾ������
	 */
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(employee);
	}
}
