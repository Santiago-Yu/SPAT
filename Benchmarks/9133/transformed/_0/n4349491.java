class n4349491 {
	public void migrateTo(String JPU1fHHM) throws IOException {
		DigitalObject YGP1ZeEH = new DigitalObject.Builder(Content.byReference(
				new File(AllJavaSEServiceTestsuite.TEST_FILE_LOCATION + "PlanetsLogo.png").toURI().toURL())).build();
		System.out.println("Input: " + YGP1ZeEH);
		FormatRegistry mmij1gu1 = FormatRegistryFactory.getFormatRegistry();
		MigrateResult bLEgYHxo = dom.migrate(YGP1ZeEH, mmij1gu1.createExtensionUri("png"),
				mmij1gu1.createExtensionUri(JPU1fHHM), null);
		ServiceReport WP3sUdDT = bLEgYHxo.getReport();
		System.out.println("Got Report: " + WP3sUdDT);
		DigitalObject lQ28UYzt = bLEgYHxo.getDigitalObject();
		assertTrue("Resulting digital object is null.", lQ28UYzt != null);
		System.out.println("Output: " + lQ28UYzt);
		System.out.println("Output.content: " + lQ28UYzt.getContent());
		File cOYKc4B4 = new File("services/java-se/test/results/test." + JPU1fHHM);
		FileOutputStream hSC0rZB8 = new FileOutputStream(cOYKc4B4);
		IOUtils.copyLarge(lQ28UYzt.getContent().getInputStream(), hSC0rZB8);
		hSC0rZB8.close();
		System.out.println("Recieved service report: " + bLEgYHxo.getReport());
		System.out.println("Recieved service properties: ");
		ServiceProperties.printProperties(System.out, bLEgYHxo.getReport().getProperties());
	}

}