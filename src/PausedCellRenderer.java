import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

public class PausedCellRenderer extends DefaultListCellRenderer {

	private ActionController actionController;

	public PausedCellRenderer(final ActionController actionController) {
		this.actionController = actionController;
	}

	public Component getListCellRendererComponent(final JList list, final Object value, final int index,
			final boolean isSelected, final boolean cellHasFocus) {
		final JLabel cell = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

		cell.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));

		if (actionController.getElementAt(index).isPaused()) {
			cell.setForeground(Color.red);
		} else {
			cell.setForeground(Color.black);
		}

		if (index == 0) {
			cell.setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, Color.black));
		}
		if (isSelected) {
			cell.setBackground(new Color(220, 220, 220));
		}

		return cell;
	}
}
