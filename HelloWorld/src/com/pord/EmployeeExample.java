package com.pord;

public class EmployeeExample {

	public static void main(String[] args) {
		Employee e1 = new Employee();
		e1.setSalary(-10000);
		System.out.println(e1.getSalary());
		
		e1.setEmployeeId(100);
		System.out.println(e1.getEmployeeId());

		e1.setEmployeeName("김사원");
		System.out.println(e1.getEmployeeName());
		
		e1.setDepartment("개발팀");
		System.out.println(e1.getdepartment());
		e1.setJod("월급계산");
		System.out.println(e1.getJob());
		
//		System.out.println(e1.getEmployeeName() + "의 부서는" + e1.getdepartment()
//		+ "\n직무는 " + e1.getJob() + "이고"
//		+ "\n급여는 " + e1.getSalary() + "입니다");
//		
		System.out.println(e1.getEmpInfo());
		
		Employee e2 = new Employee();
		e2.setEmployeeId(101);
		e2.setEmployeeName("권태현");
		e2.setDepartment("총무부");
		e2.setJod("비품구매");
		e2.setSalary(10000000);
		
		System.out.println(e2.getEmpInfo());
	}

}
