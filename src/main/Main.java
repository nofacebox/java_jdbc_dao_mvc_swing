package main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


import kk.EmployeeTerminatorDialog;
import kk.EmployeeTerminatorModel;
import model.User;
import view.layout.MainJFrame;

public class Main {
	
	public static void main(String[] args) throws SQLException {
		//textMode();
//		MainJFrame.createAndShowGUI();
//		github token :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
		List<String> list= new ArrayList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		
		Vector<String> vec= new Vector<String>(list); 
		EmployeeTerminatorDialog vv=new  EmployeeTerminatorDialog(); 
		EmployeeTerminatorModel model=new EmployeeTerminatorModel();
		vv.initialize(model);
		model.initialize(vec, vv);
		
	}		

	@SuppressWarnings("unused")
	private static void textMode() throws SQLException{
		System.out.println("Apagando todos os usuários do Banco de Dados");
		System.out.println(User.deleteAll() + " usuários deletados");
		
		System.out.println("Criando Usuários");
		User user = new User("Diego", "marczal");
		user.save();
		
		User user_a = new User("Diego", "marczal_a");
		user_a.save();
		
		User user_b = new User("Diego", "marczal_b");
		user_b.save();
		
		System.out.println("====================================");
		System.out.println("Listar Usuários Criados");
		
		for (User u : User.all()) {
			System.out.println(u);
		}
	}
}
