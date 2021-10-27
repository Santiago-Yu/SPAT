class n8230744 {
	protected void performInsertTest() throws Exception {
		Connection OeDCR6X6 = connect();
		EntityDescriptor aXdSVVKC = repository.getEntityDescriptor(User.class);
		User O6froAEo = new User();
		Date qW4o5non = new Date();
		OeDCR6X6.setAutoCommit(false);
		O6froAEo.setUsername("rednose");
		O6froAEo.setUCreated("dbUtilTest");
		O6froAEo.setUModified("dbUtilTest");
		O6froAEo.setDtCreated(qW4o5non);
		O6froAEo.setDtModified(qW4o5non);
		String yepHKqI9 = dbUtil.genInsert(aXdSVVKC, O6froAEo);
		Statement LrbvAMTC = OeDCR6X6.createStatement();
		long sIsiAtXv = 0;
		System.err.println("Insert: " + yepHKqI9);
		int oDn0jm3J = LrbvAMTC.executeUpdate(yepHKqI9,
				dbUtil.supportsGeneratedKeyQuery() ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS);
		if (oDn0jm3J > 0) {
			if (dbUtil.supportsGeneratedKeyQuery()) {
				ResultSet UXJ2r1mY = LrbvAMTC.getGeneratedKeys();
				if (UXJ2r1mY.next())
					sIsiAtXv = UXJ2r1mY.getLong(1);
			} else {
				sIsiAtXv = queryId(aXdSVVKC, qW4o5non, "dbUtilTest", OeDCR6X6, dbUtil);
			}
			if (sIsiAtXv > 0)
				O6froAEo.setId(sIsiAtXv);
			else
				oDn0jm3J = 0;
		}
		OeDCR6X6.rollback();
		assertTrue("oups, insert failed?", sIsiAtXv != 0);
		System.err.println("successfully created user with id #" + sIsiAtXv + " temporarily");
	}

}