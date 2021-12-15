class n9501298 {
	public InputStream getDaoConfig(String connectionType) throws IOException {
		URL url = null;
		if (SQL.ORACLE.equals(connectionType)) {
			url = DBCreateConfig.class.getResource("oracle.xml");
		} else if (SQL.SQL2K.equals(connectionType)) {
			url = DBCreateConfig.class.getResource("sql2k.xml");
		}
		return url.openStream();
	}

}