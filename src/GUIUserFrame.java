import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GUIUserFrame extends JFrame {

	private ActionController actionController;
	private StudentDetails selectedStudentDetails;
	private int updatedIndex;

	public GUIUserFrame() {
		
		final JList<StudentDetails> studentList = new JList<>();
		final List<StudentDetails> studentDetailList = new ArrayList<>();
		actionController = new ActionController(studentDetailList);

		final JFrame jFrame = new JFrame("Queue Status");
		final JLabel empty_indicatorJLabel = new JLabel("Queue is empty!", SwingConstants.CENTER);
		final JLabel header = new JLabel("N  A  M  E", SwingConstants.CENTER);
		final JLabel indicator = new JLabel("Red text means paused users");
		indicator.setForeground(Color.RED);
		final JScrollPane tablePane = new JScrollPane(studentList);

		final JPanel panel1 = new JPanel();
		final JPanel panel2 = new JPanel();
		final JPanel panel3 = new JPanel();
		final JPanel panel4 = new JPanel();
		
		final JButton addEntry = new JButton("AddEntry");
		final JButton pauseEntry = new JButton("PauseEntry");
		final JButton unpauseEntry = new JButton("UnpauseEntry");
		final JButton removeEntry = new JButton("RemoveEntry");

		pauseEntry.setEnabled(false);
		pauseEntry.setFocusable(false);
		unpauseEntry.setEnabled(false);
		unpauseEntry.setFocusable(false);
		removeEntry.setEnabled(false);
		removeEntry.setFocusable(false);

		panel3.add(addEntry);
		panel3.add(pauseEntry);
		panel3.add(unpauseEntry);
		panel3.add(removeEntry);
		panel3.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel4.add(indicator);
		panel1.add(panel3);
		panel1.add(panel4);
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		panel1.setBorder(new EmptyBorder(10, 10, 10, 10));

		final UserContainerWindowListener userContainerWindowListener = new UserContainerWindowListener(
				studentDetailList, empty_indicatorJLabel);
		jFrame.addWindowListener(userContainerWindowListener);

		final ListSelectionListener listSelectionListener = new ListSelectionListener() {

			@Override
			public void valueChanged(final ListSelectionEvent e) {
				updatedIndex = studentList.getSelectedIndex();
				actionController.setUpdatedIndex(updatedIndex);
				removeEntry.setEnabled(false);
				pauseEntry.setEnabled(false);
				unpauseEntry.setEnabled(false);
				unpauseEntry.setFocusable(false);
				pauseEntry.setFocusable(false);
				if (studentDetailList.size() != updatedIndex) {
					selectedStudentDetails = studentDetailList.get(studentList.getSelectedIndex());
					removeEntry.setEnabled(true);
					removeEntry.setFocusable(true);
					if (selectedStudentDetails.isPaused()) {
						unpauseEntry.setEnabled(true);
						unpauseEntry.setFocusable(true);
					} else {
						pauseEntry.setEnabled(true);
						pauseEntry.setFocusable(true);
					}
				}
			}
		};
		
		studentList.addListSelectionListener(listSelectionListener);
		studentList.setCellRenderer(new PausedCellRenderer(actionController));
		studentList.setModel(actionController);
		studentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		studentList.setLayoutOrientation(JList.VERTICAL);

		final ActionListener actionListener = new ButtonActionListeners(actionController);
		addEntry.addActionListener(actionListener);
		removeEntry.addActionListener(actionListener);
		pauseEntry.addActionListener(actionListener);
		unpauseEntry.addActionListener(actionListener);

		actionController.setQueueListListenerCallBack(listSelectionListener);

		actionController.addEntry(new StudentDetails("Avinash", "s", "ss", false));
		actionController.addEntry(new StudentDetails("Sai Kiran", "s", "ss", true));
		actionController.addEntry(new StudentDetails("Moe", "s", "ss", false));
		actionController.addEntry(new StudentDetails("Mahesh", "s", "ss", false));
		actionController.addEntry(new StudentDetails("Swathi", "s", "ss", false));


		tablePane.setPreferredSize(new Dimension(350, 150));

		panel2.add(tablePane);

		final Font font = new Font(Font.SANS_SERIF, Font.BOLD, 20);
		header.setFont(font);
		header.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		tablePane.setViewportView(studentList);
		tablePane.setColumnHeaderView(header);

		jFrame.add(panel1);
		jFrame.add(panel2, BorderLayout.CENTER);
		jFrame.add(panel1, BorderLayout.NORTH);
		jFrame.add(empty_indicatorJLabel, BorderLayout.SOUTH);
		empty_indicatorJLabel.setBorder(new EmptyBorder(10, 5, 30, 5));

		jFrame.setSize(550, 350);
		jFrame.setVisible(true);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}