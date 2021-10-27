class n11865905 {
	@Test
	public void testRegister() {
		try {
			String JS93igMd = "muchu";
			String zmWG65u2 = "123";
			MessageDigest xK6XO7it = MessageDigest.getInstance("MD5");
			xK6XO7it.update(zmWG65u2.getBytes());
			String iUd4ucsy = new String(xK6XO7it.digest());
			LogService DcjkAdSa = EasyMock.createMock(LogService.class);
			DbService izpnJv19 = EasyMock.createMock(DbService.class);
			userServ.setDbServ(izpnJv19);
			userServ.setLogger(DcjkAdSa);
			IFeelerUser zizIVhc8 = new FeelerUserImpl();
			zizIVhc8.setUsername(JS93igMd);
			zizIVhc8.setPassword(iUd4ucsy);
			DcjkAdSa.info(DbUserServiceImpl.class, ">>>rigister " + JS93igMd + "<<<");
			EasyMock.expect(izpnJv19.queryFeelerUser(JS93igMd)).andReturn(null);
			izpnJv19.addFeelerUser(JS93igMd, iUd4ucsy);
			DcjkAdSa.info(DbUserServiceImpl.class, ">>>identification " + JS93igMd + "<<<");
			EasyMock.expect(izpnJv19.queryFeelerUser(JS93igMd)).andReturn(zizIVhc8);
			EasyMock.replay(izpnJv19, DcjkAdSa);
			Assert.assertTrue(userServ.register(JS93igMd, zmWG65u2));
			EasyMock.verify(izpnJv19, DcjkAdSa);
		} catch (NoSuchAlgorithmException mBdIc1eI) {
			mBdIc1eI.printStackTrace();
		}
	}

}