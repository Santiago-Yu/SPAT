class n17164077 {
	public void readConfig(String UzD5xhnJ) throws Exception {
		try {
			URL bLQeras5 = new URL(UzD5xhnJ);
			InputStream GBi34uxr = bLQeras5.openStream();
			XmlDoc xJiqq9DK = new Parser().parse(new InputSource(GBi34uxr), true, true);
			Verifier IugsBk2I = new Verifier(InputOutput.create(SCHEMA), null);
			IugsBk2I.verify(xJiqq9DK.getDocument());
			this.config = xJiqq9DK.getDocument();
		} catch (Exception AUaBuHoX) {
			log("Can't read " + UzD5xhnJ + ": " + AUaBuHoX.toString());
			throw AUaBuHoX;
		}
		initParms();
		log("Got parameters: \n" + paramsInfo());
		initMessages();
		log("Got messages: \n" + messagesInfo());
		checkMessageId();
	}

}