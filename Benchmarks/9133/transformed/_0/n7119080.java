class n7119080 {
	public void testRegister() throws IOException {
		User IxZgh54G = new User(false, "testregUser", "regUser");
		IxZgh54G.setEmail("eagle-r@gmx.de");
		IxZgh54G.setUniversity("uni");
		IxZgh54G.setFirstName("first");
		IxZgh54G.setLastName("last");
		User jW3Og9di = null;
		try {
			jW3Og9di = (User) getJdbcTemplate().queryForObject(
					"select id, login, password, email, hash, REGISTRATION_DATE, university, FORUM_ID from USER where login = ?",
					new Object[] { IxZgh54G.getUsername() }, new UserMapper());
		} catch (EmptyResultDataAccessException sMojN2Dr) {
		}
		assertNull("This test user already exists! Abort test", jW3Og9di);
		userServiceRemote.registrate(IxZgh54G);
		setComplete();
		endTransaction();
		jW3Og9di = (User) getJdbcTemplate().queryForObject(
				"select id, login, password, email, hash, REGISTRATION_DATE, university, FORUM_ID from USER where login = ?",
				new Object[] { IxZgh54G.getUsername() }, new UserMapper());
		assertNotNull(jW3Og9di);
		assertNotNull(jW3Og9di.getId());
		assertNotNull(jW3Og9di.getHash());
		assertFalse(jW3Og9di.getHash().isEmpty());
		assertEquals(jW3Og9di.getLogin(), IxZgh54G.getLogin());
		assertEquals(jW3Og9di.getPassword(), IxZgh54G.getPassword());
		assertEquals(jW3Og9di.getUniversity(), IxZgh54G.getUniversity());
		assertEquals(jW3Og9di.getEmail(), IxZgh54G.getEmail());
		Integer jQCUwFnF = IxZgh54G.getId();
		getJdbcTemplate().execute("DELETE FROM USER_AUTHORITIES WHERE USER_ID =" + jQCUwFnF);
		getJdbcTemplate().execute("DELETE FROM USER WHERE ID = " + jQCUwFnF);
		StringBuilder Xuoe1yzz = new StringBuilder(userService.getForumUrl());
		Xuoe1yzz.append("phpBB.php?action=remove").append("&id=").append(IxZgh54G.getForumID()).append("&mode=remove");
		logger.debug("Connecting to URL: " + Xuoe1yzz.toString());
		URL DoQhEU51 = new URL(Xuoe1yzz.toString());
		URLConnection bj8IsHx4 = DoQhEU51.openConnection();
		BufferedReader utfWvO2Q = new BufferedReader(new InputStreamReader(bj8IsHx4.getInputStream()));
		String qsCShk5Z;
		while ((qsCShk5Z = utfWvO2Q.readLine()) != null)
			logger.debug("Response: " + qsCShk5Z);
		utfWvO2Q.close();
	}

}