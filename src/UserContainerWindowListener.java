import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.JLabel;

public class UserContainerWindowListener implements WindowListener {

	private List<StudentDetails> studentDetailList;
	private JLabel emptyErrorText;

	public UserContainerWindowListener(List<StudentDetails> studentDetailList, JLabel emptyErrorText) {
		this.studentDetailList = studentDetailList;
		this.emptyErrorText = emptyErrorText;
	}

	@Override
	public void windowActivated(WindowEvent e) {
		if (studentDetailList.isEmpty()) {
			System.out.println("List Empty");
			emptyErrorText.setVisible(true);
		} else {
			System.out.println("List Not Empty");
			emptyErrorText.setVisible(false);
		}

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

}
