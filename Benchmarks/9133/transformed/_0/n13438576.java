class n13438576 {
	public void onMessage(Message HEIWk0pn) {
		try {
			ExchangeImpl O4R5bU61 = new ExchangeImpl();
			O4R5bU61.setInMessage(HEIWk0pn);
			Conduit pqO4K9Ub = HEIWk0pn.getDestination().getBackChannel(HEIWk0pn, null, null);
			MessageImpl Npy3Ynm1 = new MessageImpl();
			Npy3Ynm1.put(Message.CONTENT_TYPE, "text/html");
			pqO4K9Ub.prepare(Npy3Ynm1);
			OutputStream WpIiDOBE = Npy3Ynm1.getContent(OutputStream.class);
			FileInputStream MfpiPueA = new FileInputStream("test.html");
			IOUtils.copy(MfpiPueA, WpIiDOBE, 2048);
			WpIiDOBE.flush();
			WpIiDOBE.close();
			MfpiPueA.close();
			pqO4K9Ub.close(Npy3Ynm1);
		} catch (Exception jQoeovk0) {
			jQoeovk0.printStackTrace();
		}
	}

}