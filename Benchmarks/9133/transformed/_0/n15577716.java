class n15577716 {
	public void setUp() throws Exception {
		logger.finer("******************** set up ********************");
		Properties gFJrULze;
		if (XMLDBTestSuite.propertiesFileName == null) {
			String AbQbxGpz = "test/xmldb/XMLDBTestSuite.properties";
			URL L8R9GsY9 = this.getClass().getClassLoader().getResource(AbQbxGpz);
			if (L8R9GsY9 == null) {
				throw new Exception("failed to find default props file at " + AbQbxGpz);
			}
			gFJrULze = loadProps(L8R9GsY9.openConnection().getInputStream());
		} else {
			gFJrULze = loadProps(XMLDBTestSuite.propertiesFileName);
		}
		String uJWYiw4m = gFJrULze.getProperty("driverName");
		String i70opPG7 = gFJrULze.getProperty("URI");
		Database fOsauOXR = (Database) Class.forName(uJWYiw4m).newInstance();
		collectionStorageHelper = new CollectionStorageHelper(i70opPG7);
		rootCollectionName = collectionStorageHelper.getCollectionName();
		Collection CDqWn9rB = fOsauOXR.getCollection(i70opPG7, null, null);
		CollectionManagementService bOUAnsEm = (CollectionManagementService) CDqWn9rB
				.getService(CollectionManagementService.SERVICE_NAME, "1.0");
		String MBV2N3tM = "child";
		removeChildCollection(CDqWn9rB, MBV2N3tM, bOUAnsEm);
		col = bOUAnsEm.createCollection(MBV2N3tM);
		assertNotNull("XMLDBTestCase.setUp() - Collection could not be created", col);
		logger.info("created child collection '" + col.getName() + "' parent is '" + col.getParentCollection().getName()
				+ "'");
		assertEquals("Root collection name should match childs parent name", rootCollectionName,
				col.getParentCollection().getName());
		document = createXMLFile(xmlFileName);
		assertNotNull("XMLDBTestCase.setUp() - failed to create XML file", document);
	}

}