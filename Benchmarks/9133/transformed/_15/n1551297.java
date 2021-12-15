class n1551297 {
	public InputStream getDaoConfig(String connectionType) throws IOException {
		URL url = null;
		if (SQL.ORACLE.equals(connectionType)) {
			url = com.apelon.dts.db.admin.config.MigrateConfig.class.getResource("oracle.xml");
		} else if (SQL.SQL2K.equals(connectionType)) {
			url = com.apelon.dts.db.admin.config.MigrateConfig.class.getResource("sql2k.xml");
		}
		return url.openStream();
	}

}