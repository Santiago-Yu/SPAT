class n11865906 {
	@Test
	public void testIdentification() {
		try {
			String cTSSGxLT = "muchu";
			String lyVxvYa3 = "123";
			MessageDigest Be23uyhT = MessageDigest.getInstance("MD5");
			Be23uyhT.update(lyVxvYa3.getBytes());
			LogService MQMvT1S0 = EasyMock.createMock(LogService.class);
			DbService hc2sQfvx = EasyMock.createMock(DbService.class);
			userServ.setDbServ(hc2sQfvx);
			userServ.setLogger(MQMvT1S0);
			MQMvT1S0.info(DbUserServiceImpl.class, ">>>identification " + cTSSGxLT + "<<<");
			IFeelerUser Hn4hXACp = new FeelerUserImpl();
			Hn4hXACp.setUsername(cTSSGxLT);
			Hn4hXACp.setPassword(new String(Be23uyhT.digest()));
			EasyMock.expect(hc2sQfvx.queryFeelerUser(cTSSGxLT)).andReturn(Hn4hXACp);
			EasyMock.replay(MQMvT1S0, hc2sQfvx);
			Assert.assertTrue(userServ.identification(cTSSGxLT, lyVxvYa3));
			EasyMock.verify(MQMvT1S0, hc2sQfvx);
		} catch (NoSuchAlgorithmException zB7unkCX) {
			zB7unkCX.printStackTrace();
		}
	}

}