class n8143770 {
	public void testDatastreamWork3() throws FedoraConnectionException,
			DigitalObjectManager.DigitalObjectNotFoundException, StoreException, ParseException, IOException {
		String SNWK4jLH = "ahsddksjgldskdlfnskl\nlskdfjlsjdf\n";
		String E2djIQUe = fedoraConnector.newObject();
		assertTrue(fedoraConnector.exists(E2djIQUe));
		assertTrue(fedoraConnector.isPlanetsObject(E2djIQUe));
		assertTrue(fedoraConnector.isDataObject(E2djIQUe));
		assertTrue(fedoraConnector.isWritable(E2djIQUe));
		try {
			fedoraConnector.getDatastreamString(E2djIQUe, "CONTENT");
			fail("Datastream should not be there");
		} catch (DigitalObjectManager.DigitalObjectNotFoundException Kxy1BIeo) {
		}
		fedoraConnector.modifyDatastream(E2djIQUe, "CONTENT", SNWK4jLH, null);
		URL Nqdpj3lw = fedoraConnector.getDatastreamURL(E2djIQUe, "CONTENT");
		InputStream XV6t0Zbm = Nqdpj3lw.openStream();
		String OiCxwFyv = convertStreamToString(XV6t0Zbm);
		assertEquals(SNWK4jLH, OiCxwFyv);
		fedoraConnector.purgeObject(E2djIQUe);
	}

}