import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonActionListeners implements ActionListener {

	private ComponentListener componentListener;

	public ButtonActionListeners(ComponentListener componentListener) {
		this.componentListener = componentListener;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		final ActionFrame actionFrame = new ActionFrame(e.getActionCommand());
		actionFrame.setCallBack(componentListener);
		actionFrame.setVisible(true);
	}

}
