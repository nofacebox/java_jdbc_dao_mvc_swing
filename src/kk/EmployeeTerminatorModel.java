package kk;

import java.util.Vector;

public class EmployeeTerminatorModel implements EmployeeTerminatorController {
	private EmployeeTerminatorView view;
	private Vector employees;
	private String selectedEmployee;
	public void initialize(Vector employees,EmployeeTerminatorView view) {
		this.employees = employees;
		this.view = view;
		view.setEmployeeList(employees);
		view.clearSelection();
		view.enableTerminate(false);
	}
	// EmployeeTerminatorController interface
	public void selectionChanged(String employee) {
		view.enableTerminate(employee != null);
		selectedEmployee = employee;
		}
	public void terminate() {
		if (selectedEmployee != null)
		employees.remove(selectedEmployee);
		view.setEmployeeList(employees);
		view.clearSelection();
		view.enableTerminate(false);
	}
}

