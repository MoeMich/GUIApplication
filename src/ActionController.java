import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.event.ListSelectionListener;

public class ActionController extends AbstractListModel implements ComponentListener {

	private List<StudentDetails> studentDetailsList;
	private StudentDetails removalEntry, entryToBePaused, entryToBeUnPaused;
	private ListSelectionListener listSelectionListener;
	private int updatedIndex;

	public ActionController(List<StudentDetails> studentDetailsList) {
		this.studentDetailsList = studentDetailsList;
	}

	public void setUpdatedIndex(int index) {
		updatedIndex = index;
	}

	public void setQueueListListenerCallBack(final ListSelectionListener listSelectionListener) {
		this.listSelectionListener = listSelectionListener;
	}

	@Override
	public void addEntry(StudentDetails studentDetails) {
		studentDetailsList.add(studentDetails);
		fireContentsChanged(studentDetails, getSize(), getSize());
		listSelectionListener.valueChanged(null);
	}

	@Override
	public void removeEntry(String sessionPassword) {
		removalEntry = getElementAt(updatedIndex);
		studentDetailsList.remove(removalEntry);
		fireContentsChanged(removalEntry, getSize(), getSize());
		listSelectionListener.valueChanged(null);
	}

	@Override
	public void pauseEntry(String sessionPassword) {
		entryToBePaused = getElementAt(updatedIndex);
		if (!entryToBePaused.isPaused()) {
			entryToBePaused.setPaused(true);
		}
		fireContentsChanged(entryToBePaused, getSize(), getSize());
		listSelectionListener.valueChanged(null);
	}

	@Override
	public void unpauseEntry(String sessionPassword) {
		entryToBePaused = getElementAt(updatedIndex);
		System.out.println(entryToBePaused.getName());
		if (entryToBePaused.isPaused()) {
			entryToBePaused.setPaused(false);
		}
		fireContentsChanged(entryToBePaused, getSize(), getSize());
		listSelectionListener.valueChanged(null);
	}

	@Override
	public StudentDetails getElementAt(int index) {
		return studentDetailsList.get(index);
	}

	@Override
	public int getSize() {
		return studentDetailsList.size();
	}

}
