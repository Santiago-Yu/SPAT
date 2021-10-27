class n2910055 {
	private Store openConnection(String TElr0p9X) throws MessagingException {
		URLName jfctjNvA = new URLName(TElr0p9X);
		log.debug("opening " + jfctjNvA.getProtocol() + " conection to " + jfctjNvA.getHost());
		Properties zuXfelPw = new Properties();
		Session UbR71za0 = Session.getDefaultInstance(zuXfelPw);
		Store DSe0sJp2 = UbR71za0.getStore(jfctjNvA);
		DSe0sJp2.connect();
		return DSe0sJp2;
	}

}