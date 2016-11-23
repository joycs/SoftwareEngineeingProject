import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class DeleteEmployee extends CFrame implements ActionListener{	
	JLabel lblTitle,lblId;
	JTextField txtId;
	JButton bDelete;
	
	public static void main(String[] args){
		new DeleteEmployee(50,50,1180,668);
	}
	
	DeleteEmployee(int x, int y, int w, int h) {
		super(x, y, w, h);
		Font titleFont = new Font("Arial", Font.BOLD, 20);
		//----------Top Panel----------------------------
		JPanel pTop = new JPanel();
		pTop.setLayout(null);
		createGui(pTop,0,0,1280,80,this); //add pTop
		pTop.setBackground(new Color(127,179,213));		
		lblTitle = new JLabel("Delete Employee");	
		lblTitle.setFont(titleFont);
		createGui(lblTitle,10,15,500,50,pTop); //add title label
		//----------Left Panel---------------------------
		JPanel pLeft = new JPanel();
		pLeft.setLayout(null);
		createGui(pLeft,20,81,150,688,this);//add pLeft
		lblId = new JLabel("Employee ID:");//initiate labels
		createGui(lblId,0,-10,300,50,pLeft);//add labels
		//----------Center Panel---------------------------
		JPanel pCenter = new JPanel();
		pCenter.setLayout(null);
		createGui(pCenter,170,81,979,688,this);//add pCenter
		txtId = new JTextField();//initiate textfields and such
		bDelete = new JButton("Delete Employee");//initiate button
		createGui(txtId,0,0,200,25,pCenter);//add textfields and such
		createGui(bDelete,25,30,140,25,pCenter);
		bDelete.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		DbConnect dc = new DbConnect();
		try{
		int id = Integer.parseInt(txtId.getText().trim());
		dc.dbConn("DELETE FROM Employee WHERE EmployeeID='" + id + "'","delete");
		}catch(NumberFormatException nf){
			System.out.println("The id does not exist");
		}
	}
}
