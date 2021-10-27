class n12469139 {
	public Program createNewProgram(int nd36vNQi, String zlqJucf9, String EGg4j6L8) throws AdaptationException {
		Program H4cLZ38l = null;
		Connection MotOOJ4T = null;
		Statement hAL5v9Yr = null;
		ResultSet JmiGTqkQ = null;
		try {
			MotOOJ4T = DriverManager.getConnection(CONN_STR);
			MotOOJ4T.setAutoCommit(false);
			hAL5v9Yr = MotOOJ4T.createStatement();
			String wjnIIyyQ = "INSERT INTO Programs(projectID, name, " + "description, sourcePath) VALUES ( " + nd36vNQi
					+ ", " + "'" + zlqJucf9 + "', " + "'" + EGg4j6L8 + "', " + "'" + "[unknown]" + "')";
			log.debug("SQL Query:\n" + wjnIIyyQ);
			hAL5v9Yr.executeUpdate(wjnIIyyQ);
			wjnIIyyQ = "SELECT * FROM Programs WHERE " + " projectID   =  " + nd36vNQi + "  AND " + " name        = '"
					+ zlqJucf9 + "' AND " + " description = '" + EGg4j6L8 + "'";
			JmiGTqkQ = hAL5v9Yr.executeQuery(wjnIIyyQ);
			if (!JmiGTqkQ.next()) {
				MotOOJ4T.rollback();
				String Fwm2TaWQ = "Attempt to create program failed";
				log.error(Fwm2TaWQ);
				throw new AdaptationException(Fwm2TaWQ);
			}
			H4cLZ38l = getProgram(JmiGTqkQ);
			MotOOJ4T.commit();
		} catch (SQLException kKValHX0) {
			try {
				MotOOJ4T.rollback();
			} catch (Exception yAecwbXe) {
			}
			String aCwHtRV6 = "SQLException in createNewProgram";
			log.error(aCwHtRV6, kKValHX0);
			throw new AdaptationException(aCwHtRV6, kKValHX0);
		} finally {
			try {
				JmiGTqkQ.close();
			} catch (Exception cUSPc2Ad) {
			}
			try {
				hAL5v9Yr.close();
			} catch (Exception dmnFluKE) {
			}
			try {
				MotOOJ4T.close();
			} catch (Exception waw1awIJ) {
			}
		}
		return H4cLZ38l;
	}

}