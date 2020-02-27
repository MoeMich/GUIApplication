import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		setBounds(100, 100, 450, 300);
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

		JButton actionButton = new JButton(action);
		actionButton.setBounds(144, 171, 196, 29);
		contentPane.add(actionButton);

		JLabel sessionPassword = new JLabel("Session Password");
		sessionPassword.setBounds(30, 109, 130, 46);
		contentPane.add(sessionPassword);

		sessionPasswordField = new JTextField();
		sessionPasswordField.setBounds(175, 119, 130, 26);
		contentPane.add(sessionPasswordField);
		sessionPasswordField.setColumns(10);
		actionButton.addActionListener(this);
	}

	public void setCallBack(ComponentListener componentListener) {
		this.componentListener = componentListener;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		switch (e.getActionCommand()) {
		case "AddEntry":
			String email = emailField.getText();
			String sname = nameField.getText();
			String sPassword = sessionPasswordField.getText();
			componentListener.addEntry(new StudentDetails(sname, email, sPassword, false));
			break;

		case "RemoveEntry":
			sPassword = sessionPasswordField.getText();
			componentListener.removeEntry(sPassword);
			break;

		case "PauseEntry":
			sPassword = sessionPasswordField.getText();
			componentListener.pauseEntry(sPassword);
			break;

		case "UnpauseEntry":
			System.out.println("Came to unpause switch");
			sPassword = sessionPasswordField.getText();
			componentListener.unpauseEntry(sPassword);
			break;

		default:
			break;
		}
		dispose();
	}

}
