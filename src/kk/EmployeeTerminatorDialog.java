package kk;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class EmployeeTerminatorDialog implements EmployeeTerminatorView {
	private JFrame frame;
	private JList listBox;
	private JButton terminateButton;
	private EmployeeTerminatorController controller;
	private Vector employees;
	public static final String
	EMPLOYEE_LIST_NAME = "Employee List";
	public static final String
	TERMINATE_BUTTON_NAME = "Terminate";
	public void initialize(EmployeeTerminatorController controller) {
		this.controller = controller;
		initializeEmployeeListBox();
		initializeTerminateButton();
		initializeContentPane();
	}
	private void initializeEmployeeListBox() {
		String interessen[]= {"aaaaaaa", "bbbbbbbb", "ccccccccc", "ddddddd"};
		listBox = new JList();
		listBox.setName(EMPLOYEE_LIST_NAME);
		listBox.addListSelectionListener(
			new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting())
				controller.selectionChanged(
				(String) listBox.getSelectedValue());
				}
				}
				);
	
	}
	private void initializeTerminateButton() {
		terminateButton = new JButton(TERMINATE_BUTTON_NAME);
		terminateButton.disable();
		terminateButton.setName(TERMINATE_BUTTON_NAME);
		terminateButton.addActionListener(
		new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		controller.terminate();
		}
		}
		);
		}
	private void initializeContentPane() {
		frame = new JFrame("Employee List");
		frame.getContentPane().setLayout(new FlowLayout());
		frame.getContentPane().add(listBox);
		frame.getContentPane().add(terminateButton);
		frame.getContentPane().setSize(600, 600);
		frame.pack();
        frame.setVisible(true);

	}
	public Container getContentPane() {
		return frame.getContentPane();
	}
	public JFrame getFrame() {
		return frame;
	}
	// functions for EmployeeTerminatorView interface
	public void enableTerminate(boolean enable) {
		terminateButton.setEnabled(enable);
	}
	public void setEmployeeList(Vector employees) {
		this.employees = employees;
		listBox.setListData(employees);
		frame.pack();
	}
	public void clearSelection() {
		listBox.clearSelection();
	}
}
