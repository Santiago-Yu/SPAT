class n1551297 {
	public InputStream getDaoConfig(String connectionType) throws IOException {
		URL url = null;
		if (connectionType.equals(SQL.ORACLE)) {
			url = com.apelon.dts.db.admin.config.MigrateConfig.class.getResource("oracle.xml");
		} else
			url = (connectionType.equals(SQL.SQL2K))
					? com.apelon.dts.db.admin.config.MigrateConfig.class.getResource("sql2k.xml")
					: url;
		return url.openStream();
	}

}