class n15577716 {
	public void setUp() throws Exception {
		logger.finer("******************** set up ********************");
		Properties props;
		if (XMLDBTestSuite.propertiesFileName == null) {
			String defaultPropsFileLocation = "test/xmldb/XMLDBTestSuite.properties";
			URL url = this.getClass().getClassLoader().getResource(defaultPropsFileLocation);
			if (url == null) {
				throw new Exception("failed to find default props file at " + defaultPropsFileLocation);
			}
			props = loadProps(url.openConnection().getInputStream());
		} else {
			props = loadProps(XMLDBTestSuite.propertiesFileName);
		}
		String driver = props.getProperty("driverName");
		Database database = (Database) Class.forName(driver).newInstance();
		String collectionURI = props.getProperty("URI");
		collectionStorageHelper = new CollectionStorageHelper(collectionURI);
		rootCollectionName = collectionStorageHelper.getCollectionName();
		Collection root = database.getCollection(collectionURI, null, null);
		String childCollection = "child";
		CollectionManagementService service = (CollectionManagementService) root
				.getService(CollectionManagementService.SERVICE_NAME, "1.0");
		removeChildCollection(root, childCollection, service);
		col = service.createCollection(childCollection);
		assertNotNull("XMLDBTestCase.setUp() - Collection could not be created", col);
		logger.info("created child collection '" + col.getName() + "' parent is '" + col.getParentCollection().getName()
				+ "'");
		assertEquals("Root collection name should match childs parent name", rootCollectionName,
				col.getParentCollection().getName());
		document = createXMLFile(xmlFileName);
		assertNotNull("XMLDBTestCase.setUp() - failed to create XML file", document);
	}

}