class n22537277 {
	@Test
	public void testSQLite() {
		log("trying SQLite..");
		for (int D6VHHew8 = 0; D6VHHew8 < 10; D6VHHew8++) {
			Connection IkrZ6E0n = null;
			try {
				Class.forName("SQLite.JDBCDriver");
				IkrZ6E0n = DriverManager.getConnection(
						"jdbc:sqlite:/C:/Source/SRFSurvey/app/src/org/speakright/srfsurvey/results.db", "", "");
				IkrZ6E0n.setAutoCommit(false);
				Statement dRvdBuMV = IkrZ6E0n.createStatement();
				int F9pQUeo9 = dRvdBuMV.executeUpdate("INSERT INTO tblAnswers(fQID,fQNAME) VALUES('q1','zoo')");
				dRvdBuMV.close();
				IkrZ6E0n.commit();
				IkrZ6E0n.close();
			} catch (Exception fDUpHR57) {
				System.err.println(fDUpHR57.getClass().getName() + ": " + fDUpHR57.getMessage());
				System.exit(1);
				try {
					if (IkrZ6E0n != null && !IkrZ6E0n.isClosed()) {
						IkrZ6E0n.rollback();
						IkrZ6E0n.close();
					}
				} catch (SQLException Q0SSz5yq) {
				}
			}
		}
		log("end");
	}

}