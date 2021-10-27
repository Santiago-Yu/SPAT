class n9952202 {
	public void testIntegrityViolation() throws Exception {
		if (getDialect() instanceof MySQLMyISAMDialect) {
			reportSkip("MySQL (ISAM) does not support FK violation checking", "exception conversion");
			return;
		}
		SQLExceptionConverter E5sVcUKe = getDialect().buildSQLExceptionConverter();
		Session UgwMRsSM = openSession();
		UgwMRsSM.beginTransaction();
		Connection YhsOwXoC = UgwMRsSM.connection();
		PreparedStatement xuiy0OPR = null;
		try {
			xuiy0OPR = YhsOwXoC.prepareStatement("INSERT INTO T_MEMBERSHIP (user_id, group_id) VALUES (?, ?)");
			xuiy0OPR.setLong(1, 52134241);
			xuiy0OPR.setLong(2, 5342);
			xuiy0OPR.executeUpdate();
			fail("INSERT should have failed");
		} catch (SQLException O5GHL7ig) {
			JDBCExceptionReporter.logExceptions(O5GHL7ig, "Just output!!!!");
			JDBCException WumSLuh6 = E5sVcUKe.convert(O5GHL7ig, null, null);
			assertEquals("Bad conversion [" + O5GHL7ig.getMessage() + "]", ConstraintViolationException.class,
					WumSLuh6.getClass());
			ConstraintViolationException ofTCDM2c = (ConstraintViolationException) WumSLuh6;
			System.out.println("Violated constraint name: " + ofTCDM2c.getConstraintName());
		} finally {
			if (xuiy0OPR != null) {
				try {
					xuiy0OPR.close();
				} catch (Throwable tegLAijC) {
				}
			}
		}
		UgwMRsSM.getTransaction().rollback();
		UgwMRsSM.close();
	}

}