package view.layout;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import view.users.JTableList;


public class MainJFrame extends JFrame {

	public static final Dimension PREFERREDSIZE = new Dimension(500,300);
	
	private static final long serialVersionUID = 1L;
	
	public MainJFrame() {
		super("Lista de Usuários");
		
		JPanel jpBody = new JPanel();
		jpBody.setLayout(new BorderLayout());
		
		JScrollPane jspList = new JScrollPane();
		JTableList jTableList = new JTableList();
		jspList.setViewportView(jTableList);
		
		jpBody.add(new Options(jTableList), BorderLayout.SOUTH);
		jpBody.add(jspList, BorderLayout.CENTER);
		
		setJMenuBar(new MenuOver(jTableList));
//		JList myList;
//	   String interessen[]= {"aaaaaaa", "bbbbbbbb", "ccccccccc", "ddddddd"};
//
//	    myList = new JList<>(interessen);
//
//	    myList.addListSelectionListener(new ListSelectionListener() {
//
//
//	        @Override
//	        public void valueChanged(ListSelectionEvent e) {
//	            if(!e.getValueIsAdjusting())
//	            System.out.println(myList.getSelectedValue());
//
//	        }
//	    });
//	    jpBody.add(myList);
		this.setContentPane(jpBody);
		
	}
	
	public static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new MainJFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(PREFERREDSIZE);
        frame.setPreferredSize(PREFERREDSIZE);
 
        //Center the frame
        frame.setLocationRelativeTo(null);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
