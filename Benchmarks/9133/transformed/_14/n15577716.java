class n15577716 {
	public void setUp() throws Exception {
		logger.finer("******************** set up ********************");
		Properties props;
		if (null == XMLDBTestSuite.propertiesFileName) {
			String defaultPropsFileLocation = "test/xmldb/XMLDBTestSuite.properties";
			URL url = this.getClass().getClassLoader().getResource(defaultPropsFileLocation);
			if (null == url) {
				throw new Exception("failed to find default props file at " + defaultPropsFileLocation);
			}
			props = loadProps(url.openConnection().getInputStream());
		} else {
			props = loadProps(XMLDBTestSuite.propertiesFileName);
		}
		String driver = props.getProperty("driverName");
		String collectionURI = props.getProperty("URI");
		Database database = (Database) Class.forName(driver).newInstance();
		collectionStorageHelper = new CollectionStorageHelper(collectionURI);
		rootCollectionName = collectionStorageHelper.getCollectionName();
		Collection root = database.getCollection(collectionURI, null, null);
		CollectionManagementService service = (CollectionManagementService) root
				.getService(CollectionManagementService.SERVICE_NAME, "1.0");
		String childCollection = "child";
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