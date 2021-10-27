class n19392399 {
	public boolean setRecipeToTimetable(int bicAusT6, Timestamp e3zy0sQv, int Oe8YqzzP) {
		System.out.println("setRecipeToTimetable");
		PreparedStatement d1IqT9I8 = null;
		StringBuffer U3cEvabD = new StringBuffer("insert into timetable (recipe_id, time, meal) values (?,?,?)");
		try {
			conn = getConnection();
			d1IqT9I8 = conn.prepareStatement(U3cEvabD.toString());
			d1IqT9I8.setInt(1, bicAusT6);
			d1IqT9I8.setTimestamp(2, e3zy0sQv);
			d1IqT9I8.setInt(3, Oe8YqzzP);
			d1IqT9I8.executeUpdate();
			conn.commit();
		} catch (Exception uwNySmWR) {
			try {
				conn.rollback();
			} catch (Exception duhSlKhe) {
			}
			MainFrame.appendStatusText("Error when trying to execute sql: " + uwNySmWR.getMessage());
		} finally {
			try {
				if (d1IqT9I8 != null)
					d1IqT9I8.close();
				d1IqT9I8 = null;
			} catch (Exception scNq0wr8) {
				MainFrame.appendStatusText("Can't close database connection.");
			}
		}
		return true;
	}

}