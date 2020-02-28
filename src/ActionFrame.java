import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ActionFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField emailField;
	private JTextField sessionPasswordField;
	public ComponentListener componentListener;
	public String action;

	/**
	 * Create the frame.
	 */
	public ActionFrame(String action) {
		this.action = action;
		setBounds(30, 30, 350, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		if (action == "AddEntry") {
			nameField = new JTextField();
			nameField.setBounds(175, 45, 130, 26);
			contentPane.add(nameField);
			nameField.setColumns(10);

			JLabel name = new JLabel("Name");
			name.setBounds(30, 45, 130, 26);
			contentPane.add(name);

			JLabel email = new JLabel("Email");
			email.setBounds(30, 79, 130, 26);
			contentPane.add(email);

			emailField = new JTextField();
			emailField.setBounds(175, 79, 130, 26);
			contentPane.add(emailField);
			emailField.setColumns(10);
		}

		final JButton actionButton = new JButton(action);
		actionButton.setBounds(70, 200, 196, 29);
		contentPane.add(actionButton);

		final JLabel sessionPassword = new JLabel("Session Password");
		sessionPassword.setBounds(25, 100, 130, 46);
		contentPane.add(sessionPassword);

		sessionPasswordField = new JTextField();
		sessionPasswordField.setBounds(185, 110, 130, 26);
		contentPane.add(sessionPasswordField);
		sessionPasswordField.setColumns(10);
		actionButton.addActionListener(this);
	}

	public void setCallBack(ComponentListener componentListener) {
		this.componentListener = componentListener;
	}
	
	public void setErrorMessage() {
		JOptionPane.showMessageDialog(null,
		          "Error: Please enter all the details", "Error Message",
		          JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		switch (e.getActionCommand()) {
		case "AddEntry":
			String email = emailField.getText();
			String sname = nameField.getText();
			String sPassword = sessionPasswordField.getText();
			if(!email.isEmpty() && !sname.isEmpty() && !sPassword.isEmpty()) {
				componentListener.addEntry(new StudentDetails(sname, email, sPassword, false));
				dispose();
			}
			else {
				setErrorMessage();
			}
			break;

		case "RemoveEntry":
			sPassword = sessionPasswordField.getText();
			if(!sPassword.isEmpty()) {
				componentListener.removeEntry(sPassword);
				dispose();
			}
			else {
				setErrorMessage();
			}
			break;

		case "PauseEntry":
			sPassword = sessionPasswordField.getText();
			if(!sPassword.isEmpty()) {
				componentListener.pauseEntry(sPassword);
				dispose();
			}
			else {
				setErrorMessage();
			}
			break;

		case "UnpauseEntry":
			sPassword = sessionPasswordField.getText();
			if(!sPassword.isEmpty()) {
				componentListener.unpauseEntry(sPassword);
				dispose();
			}
			else {
				setErrorMessage();
			}
			break;

		default:
			break;
		}
	}

}
