class n21186037 {
	public Project createProject(int Rukj4Uap, String jzMnw8cU, String AEXGpJad) throws AdaptationException {
		Project L4vLtKTa = null;
		Connection rjAnrIba = null;
		Statement CqvoCYUc = null;
		ResultSet noNCEoqK = null;
		try {
			String xueM9SCf = "INSERT INTO Projects(testbedID, name, " + "description) VALUES (" + Rukj4Uap + ", '"
					+ jzMnw8cU + "', '" + AEXGpJad + "')";
			rjAnrIba = DriverManager.getConnection(CONN_STR);
			CqvoCYUc = rjAnrIba.createStatement();
			CqvoCYUc.executeUpdate(xueM9SCf);
			xueM9SCf = "SELECT * FROM Projects WHERE " + " testbedID   = " + Rukj4Uap + "  AND " + " name        = '"
					+ jzMnw8cU + "' AND " + " description = '" + AEXGpJad + "'";
			noNCEoqK = CqvoCYUc.executeQuery(xueM9SCf);
			if (!noNCEoqK.next()) {
				rjAnrIba.rollback();
				String EXZ98S6C = "Attempt to create project failed.";
				log.error(EXZ98S6C);
				throw new AdaptationException(EXZ98S6C);
			}
			L4vLtKTa = getProject(noNCEoqK);
			rjAnrIba.commit();
		} catch (SQLException aU5qHczs) {
			try {
				rjAnrIba.rollback();
			} catch (Exception WcrJgWOj) {
			}
			String RUjAtPOo = "SQLException in createProject";
			log.error(RUjAtPOo, aU5qHczs);
			throw new AdaptationException(RUjAtPOo, aU5qHczs);
		} finally {
			try {
				noNCEoqK.close();
			} catch (Exception rR97iLsg) {
			}
			try {
				CqvoCYUc.close();
			} catch (Exception c3RNtHHe) {
			}
			try {
				rjAnrIba.close();
			} catch (Exception rHzG3Bi8) {
			}
		}
		return L4vLtKTa;
	}

}