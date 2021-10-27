class n21395184 {
	@Test
	public void test30_passwordAging() throws Exception {
		Db iRQVzwzO = DbConnection.defaultCieDbRW();
		try {
			iRQVzwzO.begin();
			Config.setProperty(iRQVzwzO, "com.entelience.esis.security.passwordAge", "5", 1);
			PreparedStatement KSKcj6gf = iRQVzwzO
					.prepareStatement("UPDATE e_people SET last_passwd_change = '2006-07-01' WHERE user_name = ?");
			KSKcj6gf.setString(1, "esis");
			iRQVzwzO.executeUpdate(KSKcj6gf);
			iRQVzwzO.commit();
			p_logout();
			t30login1();
			assertTrue(isPasswordExpired());
			PeopleInfoLine km6nUHFt = getCurrentPeople();
			assertNotNull(km6nUHFt.getPasswordExpirationDate());
			assertTrue(km6nUHFt.getPasswordExpirationDate().before(DateHelper.now()));
			t30chgpasswd();
			assertFalse(isPasswordExpired());
			km6nUHFt = getCurrentPeople();
			assertNotNull(km6nUHFt.getPasswordExpirationDate());
			assertTrue(km6nUHFt.getPasswordExpirationDate().after(DateHelper.now()));
			p_logout();
			t30login2();
			assertFalse(isPasswordExpired());
			t30chgpasswd2();
			iRQVzwzO.begin();
			Config.setProperty(iRQVzwzO, "com.entelience.esis.security.passwordAge", "0", 1);
			iRQVzwzO.commit();
		} catch (Exception PwXgsHIw) {
			PwXgsHIw.printStackTrace();
			iRQVzwzO.rollback();
		} finally {
			iRQVzwzO.safeClose();
		}
	}

}