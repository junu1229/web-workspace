package pattern.model;

import java.sql.SQLException;

public class NoteBookDAO {
	private static NoteBookDAO noteBookDAO = new NoteBookDAO();
	private NoteBookDAO() {}
	public static NoteBookDAO getInstance() {
		return noteBookDAO;
	}
	
	public NoteBook findNoteBook(String model) throws SQLException {
		
		NoteBook noteBook = new NoteBook(model, 1000);
		return noteBook;
	}
}
