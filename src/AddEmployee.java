import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class AddEmployee extends CFrame implements ActionListener{
	JLabel lblTitle,lblId,lblFname,lblLname,lblDepartment,lblGender,lblNationality,lblEmail,lblPhone,lblAddress,lblDesignation;
	JTextField txtId,txtFname,txtLname,txtNationality,txtEmail,txtPhone,txtAddress;
	JComboBox<String> cbxDepartment,cbxDesignation;
	JRadioButton radMale,radFemale;
	ButtonGroup radGroup;
	JButton bAdd;
	String[] departments = {"Code Developing Department","Science","Arts and Languages","Social Sciences"};
	String[] designations = {"CEO","Manager","Supervisor","Assistant","Staff"};
	int id,pn;
	String fn,ln,dp,gd,nt,em,ad,ds;
	
	public static void main(String[] args){
		new AddEmployee(50,50,1180,668);
	}
	
	AddEmployee(int x, int y, int w, int h){
		super(x, y, w, h);
		Font titleFont = new Font("Arial", Font.BOLD, 20);
		//----------Top Panel----------------------------
		JPanel pTop = new JPanel();
		pTop.setLayout(null);
		createGui(pTop,0,0,1280,80,this); //add pTop
		pTop.setBackground(new Color(127,179,213));		
		lblTitle = new JLabel("Add Employee");	
		lblTitle.setFont(titleFont);
		createGui(lblTitle,10,15,500,50,pTop); //add title label
		//----------Left Panel---------------------------
		JPanel pLeft = new JPanel();
		pLeft.setLayout(null);
		createGui(pLeft,20,81,150,688,this);//add pLeft
		lblId = new JLabel("Employee ID:");//initiate labels
		lblFname = new JLabel("First Name:");
		lblLname = new JLabel("Last Name:");
		lblDepartment = new JLabel("Department:");
		lblGender = new JLabel("Gender:");
		lblNationality = new JLabel("Nationality:");
		lblEmail = new JLabel("Email:");
		lblPhone = new JLabel("Phone Number:");
		lblAddress = new JLabel("Address:");
		lblDesignation = new JLabel("Designation:");
		createGui(lblId,0,-10,300,50,pLeft);//add labels
		createGui(lblFname,0,20,300,50,pLeft);
		createGui(lblLname,0,50,300,50,pLeft);
		createGui(lblDepartment,0,80,300,50,pLeft);
		createGui(lblGender,0,110,300,50,pLeft);
		createGui(lblNationality,0,140,300,50,pLeft);
		createGui(lblEmail,0,170,300,50,pLeft);
		createGui(lblPhone,0,200,300,50,pLeft);
		createGui(lblAddress,0,230,300,50,pLeft);
		createGui(lblDesignation,0,260,300,50,pLeft);
		//----------Center Panel---------------------------
		JPanel pCenter = new JPanel();
		pCenter.setLayout(null);
		createGui(pCenter,170,81,979,688,this);//add pCenter
		txtId = new JTextField();//initiate textfields and such
		txtFname = new JTextField();
		txtLname = new JTextField();
		cbxDepartment = new JComboBox<String>(departments);
		radMale = new JRadioButton("Male");
		radMale.setSelected(true);
		radFemale = new JRadioButton("Female");
		radGroup = new ButtonGroup();
		radGroup.add(radMale);
		radGroup.add(radFemale);
		txtNationality = new JTextField();
		txtEmail = new JTextField();
		txtPhone = new JTextField();
		txtAddress = new JTextField();
		cbxDesignation = new JComboBox<String>(designations);
		bAdd = new JButton("Add Employee");//initiate button
		createGui(txtId,0,0,200,25,pCenter);//add textfields and such
		createGui(txtFname,0,30,200,25,pCenter);
		createGui(txtLname,0,60,200,25,pCenter);
		createGui(cbxDepartment,0,90,200,25,pCenter);
		createGui(radMale,0,120,60,25,pCenter);
		createGui(radFemale,80,120,70,25,pCenter);
		createGui(txtNationality,0,150,200,25,pCenter);
		createGui(txtEmail,0,180,200,25,pCenter);
		createGui(txtPhone,0,210,200,25,pCenter);
		createGui(txtAddress,0,240,200,25,pCenter);
		createGui(cbxDesignation,0,270,200,25,pCenter);
		createGui(bAdd,40,300,120,25,pCenter);
		bAdd.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		try{
		id = Integer.parseInt(txtId.getText());		
		fn = txtFname.getText();
		ln = txtLname.getText();
		dp = cbxDepartment.getSelectedItem().toString();
		if(radMale.isSelected())
			gd = radMale.getText();
		else gd = radFemale.getText();
		nt = txtNationality.getText();
		em = txtEmail.getText();
		pn = Integer.parseInt(txtPhone.getText());
		ad = txtAddress.getText();
		ds = cbxDesignation.getSelectedItem().toString();
		DbConnect dc = new DbConnect();	
		dc.dbConn("INSERT INTO Employee VALUES ('"+id+"','"+fn+"','"+ ln+"','"+ gd+"','"+ nt+"','"+ ad+"','"+ pn+"','"+ em+"','"+ dp+"','"+ ds+"')","insert");
		}catch(NumberFormatException nf){
			System.out.println("Make sure you've entered id and phone number correctly");
		}
	}
}