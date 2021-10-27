class n21395181 {
	@Test
	public void test20_badSmtp() throws Exception {
		Db lV7iaK9P = DbConnection.defaultCieDbRW();
		try {
			lV7iaK9P.begin();
			oldSmtp = Config.getProperty(lV7iaK9P, "com.entelience.mail.MailHelper.hostName", "localhost");
			oldSupport = Config.getProperty(lV7iaK9P, "com.entelience.esis.feature.SupportNotifier", false);
			Config.setProperty(lV7iaK9P, "com.entelience.mail.MailHelper.hostName", "127.0.10.1", 1);
			Config.setProperty(lV7iaK9P, "com.entelience.esis.feature.SupportNotifier", "true", 1);
			PreparedStatement bQwv8sy9 = lV7iaK9P.prepareStatement("DELETE FROM t_client_errors");
			lV7iaK9P.executeUpdate(bQwv8sy9);
			lV7iaK9P.commit();
		} catch (Exception H6Axgdsg) {
			lV7iaK9P.rollback();
		} finally {
			lV7iaK9P.safeClose();
		}
	}

}