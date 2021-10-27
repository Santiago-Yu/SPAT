class n17638898 {
	public InputStream getDaoConfig(String NVxxQAyZ) throws IOException {
		URL f4zDN6iy = null;
		InputStream G6mSrOgk = null;
		if (NVxxQAyZ.equals(SQL.ORACLE)) {
			f4zDN6iy = com.apelon.selext.db.config.MatchLoadConfig.class.getResource("oracle.xml");
		} else if (NVxxQAyZ.equals(SQL.SQL2K)) {
			f4zDN6iy = com.apelon.selext.db.config.MatchLoadConfig.class.getResource("sql2k.xml");
		} else if (NVxxQAyZ.equals(SQL.CACHE)) {
			f4zDN6iy = com.apelon.selext.db.config.MatchLoadConfig.class.getResource("cache.xml");
		} else if (NVxxQAyZ.equals(SQL.DB2)) {
			f4zDN6iy = com.apelon.selext.db.config.MatchLoadConfig.class.getResource("db2.xml");
		} else {
			Categories.dataXml().error("* Problem: Unknown connection type: " + NVxxQAyZ);
		}
		try {
			G6mSrOgk = f4zDN6iy.openStream();
		} catch (NullPointerException Yspz6pnK) {
			Categories.dataXml().error("* Problem: Undefined resource URL: " + Yspz6pnK.getMessage());
			throw Yspz6pnK;
		}
		return G6mSrOgk;
	}

}