class n19867423 {
	@Test
	public void testPersistor() throws Exception {
		PreparedStatement hq7CE8Pr;
		hq7CE8Pr = connection.prepareStatement("delete from privatadresse");
		hq7CE8Pr.executeUpdate();
		hq7CE8Pr.close();
		hq7CE8Pr = connection.prepareStatement("delete from adresse");
		hq7CE8Pr.executeUpdate();
		hq7CE8Pr.close();
		hq7CE8Pr = connection.prepareStatement("delete from person");
		hq7CE8Pr.executeUpdate();
		hq7CE8Pr.close();
		Persistor iam5GX1C;
		Adresse OyuQsdSv = new LieferAdresse();
		OyuQsdSv.setStrasse("Amalienstrasse 68");
		modificationTracker.addNewParticipant(OyuQsdSv);
		Person aBTa1Cdh = new Person();
		aBTa1Cdh.setName("markus");
		modificationTracker.addNewParticipant(aBTa1Cdh);
		aBTa1Cdh.getPrivatAdressen().add(OyuQsdSv);
		Person PcfKcmVM = new Person();
		PcfKcmVM.setName("martin");
		modificationTracker.addNewParticipant(PcfKcmVM);
		iam5GX1C = new Persistor(getSchemaMapping(), idGenerator, modificationTracker);
		iam5GX1C.persist();
		Adresse IJ96Gd9W = new LieferAdresse();
		modificationTracker.addNewParticipant(IJ96Gd9W);
		IJ96Gd9W.setStrasse("dr. boehringer gasse");
		aBTa1Cdh.getAdressen().add(IJ96Gd9W);
		IJ96Gd9W.setPerson(PcfKcmVM);
		aBTa1Cdh.setContactPerson(PcfKcmVM);
		iam5GX1C = new Persistor(getSchemaMapping(), idGenerator, modificationTracker);
		try {
			iam5GX1C.persist();
			connection.commit();
		} catch (Exception WJB8mgRl) {
			connection.rollback();
			throw WJB8mgRl;
		}
	}

}