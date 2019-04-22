package com.action;

import java.util.ArrayList;
import java.util.List;

import com.entity.Department;
import com.entity.Employee;
import com.entity.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.DepartmentService;
import com.service.EmployeeService;

/**
 * Ա������web��
 * ����ģ������
 * @author hope
 *
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	// ģ������ʹ�õĶ����Զ�ע��employee������ 
    private Employee employee = new Employee();
    // struts2����spring,ע��ҵ���
    private EmployeeService employeeService;
    private DepartmentService departmentService;
    
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@Override
	public Employee getModel(){
		return employee;
	}
	/**
	 * Ա����½
	 * @return
	 */
	public String login(){
		System.out.println("action.login����ִ��");
		// ����ҵ��㷽��
		Employee existEmployee = employeeService.login(employee);
		if(existEmployee==null){
			// ��½ʧ��
			this.addActionError("�û������������");
			System.out.println("action����ʧ��");
			return "INPUT";
		}else{
			// ��¼�ɹ�
			System.out.println("Action���ҳɹ�");
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return "SUCCESS";
		}
	}
	
	// ��ǰҳ��
	private Integer currPage = 1;
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
	/**
	 * ��ҳ��ѯԱ��
	 * @return
	 */
	public String findAll(){
		PageBean<Employee> pageBean = employeeService.findByPage(currPage);
		// ʹ�õ���ģ���������Ѳ�����Ϣ����ֵջ�У��ɿ���ʹ��OGNL����ǻ�ȡ
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	/**
	 * ��ת�����Ա���ķ���
	 * @return
	 */
	public String goAddEmployee(){
		// ��ѯ���в���
		List<Department> list = departmentService.findAll();
		// �Ѳ�����Ϣ����ֵջ��
		ActionContext.getContext().getValueStack().set("list", list);
		return "goAddEmployee";
	}
	/**
	 * web�����Ա������
	 */
	public String save(){
		employeeService.save(employee);
		return "addSuccess";
	}
	
	/**
	 * ����id��ѯԱ��
	 * @return
	 */
	public String findById(){
		employee = employeeService.findById(employee.getEid());
		System.out.print("�������ţ�"+employee.getEname());
		// ��ѯ���в���
		List<Department> list = departmentService.findAll();
		// �Ѳ�����Ϣ����ֵջ��
		System.out.print("���в��ţ�"+list.size());
		ActionContext.getContext().getValueStack().set("list", list);	
		return "goEditEmployee";
	}
	
	/**
	 * web��༭Ա������
	 */
	public String edit(){
		employeeService.update(employee);
		return "editSuccess";
	}
	/**
	 * web��ʵ��ɾ���ķ���
	 */
	public String delete(){
		employee = employeeService.findById(employee.getEid());
		employeeService.delete(employee);
		return "deleteSuccess";
	}
}
