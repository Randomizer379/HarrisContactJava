import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class ContactManager {

	private JFrame ContactFrame;
	private JTextField et_address;
	private JTextField et_city;
	private JTextField et_postcode;
	private JTextField et_name;
	private JTextField et_id;
	private JTextField et_surname;
	private JTextField et_email;
	private JTextField et_phone;
	private JTable tbl_contacts;
	private JTextField et_type;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactManager window = new ContactManager();
					window.ContactFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ContactManager() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ContactFrame = new JFrame();
		ContactFrame.setResizable(false);
		ContactFrame.setTitle("Contacts");
		ContactFrame.setBounds(100, 100, 793, 424);
		ContactFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ContactFrame.getContentPane().setLayout(null);
		
		dbConn d = new dbConn();
		
		JButton btn_add = new JButton("Add");
		//Button to add new contacts to database and updates table
		btn_add.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				d.CreateContact(et_name.getText(), et_surname.getText(), 
						et_email.getText(), et_phone.getText(), 
						et_address.getText(), et_city.getText(), 
						et_postcode.getText(), et_type.toString());
				tbl_contacts.setModel(DbUtils.resultSetToTableModel(d.getAll()));
			}
		});
		btn_add.setBounds(678, 285, 89, 23);
		ContactFrame.getContentPane().add(btn_add);
		
		//Button to update existing records in database and updates table
		JButton btn_update = new JButton("Update");
		btn_update.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				 d.UpdateContact(et_name.getText(), 
						 et_surname.getText(), et_email.getText(), 
						 et_phone.getText(), et_address.getText(), 
						 et_city.getText(), et_postcode.getText(), 
						 et_type.getText(), et_id.getText());
				 tbl_contacts.setModel(DbUtils.resultSetToTableModel(d.getAll()));
			}
		});
		btn_update.setBounds(678, 319, 89, 23);
		ContactFrame.getContentPane().add(btn_update);
		
		//Deletes contact from database and updates table
		JButton btn_delete = new JButton("Delete");
		btn_delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				d.DeleteContact(et_id.getText());
				tbl_contacts.setModel(DbUtils.resultSetToTableModel(d.getAll()));
			}
		});
		btn_delete.setBounds(678, 353, 89, 23);
		ContactFrame.getContentPane().add(btn_delete);
		
		et_address = new JTextField();
		et_address.setToolTipText("");
		et_address.setBounds(10, 354, 337, 20);
		ContactFrame.getContentPane().add(et_address);
		et_address.setColumns(10);
		
		et_city = new JTextField();
		et_city.setBounds(357, 354, 102, 20);
		ContactFrame.getContentPane().add(et_city);
		et_city.setColumns(10);
		
		et_postcode = new JTextField();
		et_postcode.setBounds(469, 354, 86, 20);
		ContactFrame.getContentPane().add(et_postcode);
		et_postcode.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Address");
		lblNewLabel.setBounds(10, 336, 72, 14);
		ContactFrame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("City");
		lblNewLabel_1.setBounds(357, 336, 46, 14);
		ContactFrame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Postcode");
		lblNewLabel_2.setBounds(469, 336, 72, 14);
		ContactFrame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Type");
		lblNewLabel_3.setBounds(565, 336, 46, 14);
		ContactFrame.getContentPane().add(lblNewLabel_3);
		
		et_name = new JTextField();
		et_name.setBounds(10, 305, 102, 20);
		ContactFrame.getContentPane().add(et_name);
		et_name.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("ID");
		lblNewLabel_4.setBounds(10, 252, 46, 14);
		ContactFrame.getContentPane().add(lblNewLabel_4);
		
		et_id = new JTextField();
		et_id.setEditable(false);
		et_id.setBounds(32, 249, 61, 20);
		ContactFrame.getContentPane().add(et_id);
		et_id.setColumns(10);
		
		et_surname = new JTextField();
		et_surname.setBounds(122, 305, 102, 20);
		ContactFrame.getContentPane().add(et_surname);
		et_surname.setColumns(10);
		
		et_email = new JTextField();
		et_email.setBounds(234, 305, 264, 20);
		ContactFrame.getContentPane().add(et_email);
		et_email.setColumns(10);
		
		et_phone = new JTextField();
		et_phone.setBounds(508, 305, 143, 20);
		ContactFrame.getContentPane().add(et_phone);
		et_phone.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Name");
		lblNewLabel_5.setBounds(10, 280, 46, 14);
		ContactFrame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Surname");
		lblNewLabel_6.setBounds(122, 280, 86, 14);
		ContactFrame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Email Address");
		lblNewLabel_7.setBounds(234, 280, 89, 14);
		ContactFrame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Telephone Number");
		lblNewLabel_8.setBounds(508, 280, 132, 14);
		ContactFrame.getContentPane().add(lblNewLabel_8);
		
		JComboBox cb_filter = new JComboBox();
		cb_filter.setModel(new DefaultComboBoxModel(new String[] {"All", "Personal", "Business"}));
		cb_filter.setBounds(525, 248, 102, 22);
		ContactFrame.getContentPane().add(cb_filter);
		
		JScrollPane sp_contacts = new JScrollPane();
		sp_contacts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		sp_contacts.setBounds(10, 11, 757, 225);
		ContactFrame.getContentPane().add(sp_contacts);
		
		
		tbl_contacts = new JTable();
		tbl_contacts.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//Sets textFields to information within selected row
				et_id.setText(tbl_contacts.getValueAt(tbl_contacts.getSelectedRow(), 0).toString());
				et_name.setText(tbl_contacts.getValueAt(tbl_contacts.getSelectedRow(), 1).toString());
				et_surname.setText(tbl_contacts.getValueAt(tbl_contacts.getSelectedRow(), 2).toString());
				et_email.setText(tbl_contacts.getValueAt(tbl_contacts.getSelectedRow(), 3).toString());
				et_phone.setText(tbl_contacts.getValueAt(tbl_contacts.getSelectedRow(), 4).toString());
				et_address.setText(tbl_contacts.getValueAt(tbl_contacts.getSelectedRow(), 5).toString());
				et_city.setText(tbl_contacts.getValueAt(tbl_contacts.getSelectedRow(), 6).toString());
				et_postcode.setText(tbl_contacts.getValueAt(tbl_contacts.getSelectedRow(), 7).toString());
				et_type.setText(tbl_contacts.getValueAt(tbl_contacts.getSelectedRow(), 8).toString());


			}
		});
		sp_contacts.setViewportView(tbl_contacts);
	
		//Updates table
		JButton btn_updateSP = new JButton("Refresh Table");
		btn_updateSP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				tbl_contacts.setModel(DbUtils.resultSetToTableModel(d.getAll()));
			}
		});
		btn_updateSP.setBounds(637, 248, 130, 23);
		ContactFrame.getContentPane().add(btn_updateSP);
		
		JLabel lblNewLabel_9 = new JLabel("Filter: ");
		lblNewLabel_9.setBounds(469, 252, 46, 14);
		ContactFrame.getContentPane().add(lblNewLabel_9);
		
		et_type = new JTextField();
		et_type.setBounds(565, 354, 103, 20);
		ContactFrame.getContentPane().add(et_type);
		et_type.setColumns(10);
	}
}
