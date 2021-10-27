class n22537277 {
	@Test
	public void testSQLite() {
		log("trying SQLite..");
		int UCXiY = 0;
		while (UCXiY < 10) {
			Connection c = null;
			try {
				Class.forName("SQLite.JDBCDriver");
				c = DriverManager.getConnection(
						"jdbc:sqlite:/C:/Source/SRFSurvey/app/src/org/speakright/srfsurvey/results.db", "", "");
				c.setAutoCommit(false);
				Statement st = c.createStatement();
				int rc = st.executeUpdate("INSERT INTO tblAnswers(fQID,fQNAME) VALUES('q1','zoo')");
				st.close();
				c.commit();
				c.close();
			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
				System.exit(1);
				try {
					if (c != null && !c.isClosed()) {
						c.rollback();
						c.close();
					}
				} catch (SQLException sql) {
				}
			}
			UCXiY++;
		}
		log("end");
	}

}