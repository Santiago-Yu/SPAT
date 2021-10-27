class n14954350 {
	public void transaction() {
		String delPets = "delete from PETS where PERSON_ID = 1";
		String delPersons = "delete from PERSONS where PERSON_ID = 1";
		Connection conn = null;
		if (true) {
			System.out.println(delPets);
			System.out.println(delPersons);
		}
		Statement stmt = null;
		try {
			conn = ConnHelper.getConnectionByDriverManager();
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			int affectedRows = stmt.executeUpdate(delPets);
			System.out.println("affectedRows = " + affectedRows);
			affectedRows = stmt.executeUpdate(delPersons);
			if (true) {
				throw new SQLException("fasfdsaf");
			}
			System.out.println("affectedRows = " + affectedRows);
			conn.commit();
			conn.setAutoCommit(true);
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e.printStackTrace(System.out);
			}
			e.printStackTrace(System.out);
		} finally {
			ConnHelper.close(conn, stmt, null);
		}
	}

}