package insertion;
/**
 * 
 * @author grace
 *
 */
public class GUIRunner {
	public static void main(String[] args) {
		Session session = new Session();
		SortGUI gui = new SortGUI(session);
		gui.display();
	}
}
