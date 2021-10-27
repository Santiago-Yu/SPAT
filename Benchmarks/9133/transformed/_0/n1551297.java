class n1551297 {
	public InputStream getDaoConfig(String LzINgw8d) throws IOException {
		URL L73JRWY9 = null;
		if (LzINgw8d.equals(SQL.ORACLE)) {
			L73JRWY9 = com.apelon.dts.db.admin.config.MigrateConfig.class.getResource("oracle.xml");
		} else if (LzINgw8d.equals(SQL.SQL2K)) {
			L73JRWY9 = com.apelon.dts.db.admin.config.MigrateConfig.class.getResource("sql2k.xml");
		}
		return L73JRWY9.openStream();
	}

}