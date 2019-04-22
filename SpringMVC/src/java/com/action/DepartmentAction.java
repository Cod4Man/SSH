package com.action;

import com.entity.Department;
import com.entity.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.DepartmentService;

/**
 * ���Ź����action
 * ����ģ������ע��
 * @author hope
 */
public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {
	// ģ������
    private Department department = new Department();
    
    private DepartmentService departmentService;
	@Override
	// ģ������
	public Department getModel() {
		// TODO Auto-generated method stub
		return department;
	}
	// ע�벿�Ź���service
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	// ��ǰҳ��
	private Integer currPage = 1;
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	/**
	 * ��ҳ��ѯ����
	 * @return
	 */
	public String findAll(){
		PageBean<Department> pageBean = departmentService.findByPage(currPage);
		// ʹ�õ���ģ���������Ѳ�����Ϣ����ֵջ�У��ɿ���ʹ��OGNL����ǻ�ȡ
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	/**
	 * ��ת����Ӳ��ŵķ���
	 * @return
	 */
	public String goAddDepartment(){
		return "goAddDepartment";
	}
	/**
	 * ��Ӳ��ŵ�ִ�з���
	 */
	public String saveDepartment(){
		departmentService.save(department);
		return "addSuccess";
	}
	/**
	 * ����ID��ѯ���ŵķ���
	 */
	public String findById(){
		department = departmentService.findById(department.getDid());
		return "goEditDepartment";
	}
	/**
	 * �༭���ŵ�ִ�з���
	 */
	public String update(){
		departmentService.update(department);
		return "updateSuccess";
	}
	/**
	 * web�㲿��ɾ���ķ���
	 * @return
	 */
	public String delete(){
		department = departmentService.findById(department.getDid());
		departmentService.delete(department);
		return "deleteSuccess";
	}
}
