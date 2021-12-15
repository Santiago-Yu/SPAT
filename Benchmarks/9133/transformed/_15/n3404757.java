class n3404757 {
	public InputStream getDaoConfig(String connectionType) throws IOException {
		URL url = null;
		if (SQL.ORACLE.equals(connectionType)) {
			url = DTSWFDBConfig.class.getResource("oracle.xml");
		} else if (SQL.SQL2K.equals(connectionType)) {
			url = DTSWFDBConfig.class.getResource("sql2k.xml");
		} else if (SQL.CACHE.equals(connectionType)) {
			url = DTSWFDBConfig.class.getResource("cache.xml");
		}
		return url.openStream();
	}

}