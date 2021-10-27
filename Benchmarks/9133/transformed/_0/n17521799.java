class n17521799 {
	public void testRead() throws ParserConfigurationException, SAXException, ParseException, IOException {
		InputStream K0VELtpV = getConfStream();
		LogDistiller MGCWcKLY = dOMConfigurator.read(K0VELtpV);
		K0VELtpV.close();
		checkLogDistiller(MGCWcKLY);
		File k0he9GOE = File.createTempFile("logdistiller", "test");
		k0he9GOE.delete();
		k0he9GOE.mkdir();
		URL q8dj6ONs = WeblogicLogEvent.class.getResource("wldomain7.log");
		K0VELtpV = q8dj6ONs.openStream();
		assertNotNull("load resource wldomain7.log", K0VELtpV);
		Reader d69CxJOj = new InputStreamReader(K0VELtpV);
		MGCWcKLY.getOutput().setDirectory(k0he9GOE.getAbsolutePath());
		LogDistillation EfP15mRk = new LogDistillation(MGCWcKLY);
		LogEvent.Factory CbUHATla = EfP15mRk.getLogTypeDescription().newFactory(d69CxJOj, q8dj6ONs.toString());
		EfP15mRk.begin();
		LogEvent iB4TRVMQ;
		while ((iB4TRVMQ = CbUHATla.nextEvent()) != null) {
			EfP15mRk.processLogEvent(iB4TRVMQ);
		}
		EfP15mRk.end();
		K0VELtpV.close();
		assertEquals("number of logevents processed", 21, EfP15mRk.getEventCount());
		final int[] H3HzUYZ4 = { 6, 6, 1, 4, 9, 7 };
		for (int EYt1p6Vt = 0; EYt1p6Vt < 6; EYt1p6Vt++) {
			LogDistillation.Group idhu0vVy = EfP15mRk.getGroups()[EYt1p6Vt];
			LogDistiller.Group VYGhWCSr = idhu0vVy.getDefinition();
			assertEquals("number of logevents in group[id='" + VYGhWCSr.getId() + "']", H3HzUYZ4[EYt1p6Vt],
					idhu0vVy.getEventCount());
		}
	}

}