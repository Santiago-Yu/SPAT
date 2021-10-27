class n13555352 {
	@Test
	public void test00_reinitData() throws Exception {
		Logs.logMethodName();
		init();
		Db EjYDxovl = DbConnection.defaultCieDbRW();
		try {
			EjYDxovl.begin();
			PreparedStatement WE17hkBS = EjYDxovl.prepareStatement("TRUNCATE e_module;");
			WE17hkBS.executeUpdate();
			WE17hkBS = EjYDxovl.prepareStatement("TRUNCATE e_application_version;");
			WE17hkBS.executeUpdate();
			ModuleHelper.synchronizeDbWithModuleList(EjYDxovl);
			ModuleHelper.declareNewVersion(EjYDxovl);
			ModuleHelper.updateModuleVersions(EjYDxovl);
			esisId = com.entelience.directory.PeopleFactory.lookupUserName(EjYDxovl, "esis");
			assertNotNull(esisId);
			guestId = com.entelience.directory.PeopleFactory.lookupUserName(EjYDxovl, "guest");
			assertNotNull(guestId);
			extenId = com.entelience.directory.PeopleFactory.lookupUserName(EjYDxovl, "exten");
			assertNotNull(extenId);
			EjYDxovl.commit();
		} catch (Exception gkBDIW5E) {
			EjYDxovl.rollback();
			throw gkBDIW5E;
		}
	}

}