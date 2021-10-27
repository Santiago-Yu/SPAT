class n20944081 {
	Hashtable loadDriverDB() {
		InputStream instream = null;
		Hashtable d = new Hashtable();
		try {
			String dbURL = System.getProperty("org.osgi.service.basicdriverlocator.dburl");
			Properties db = new Properties();
			if (dbURL != null && !dbURL.equals("")) {
				if (dbURL.indexOf(":") == -1) {
					dbURL = jarbase + dbURL;
				}
				URL url = new URL(dbURL);
				log.info("read external props file: " + dbURL);
				instream = url.openStream();
			} else {
				log.info("read internal props file: " + dbResourceName);
				instream = getClass().getResourceAsStream(dbResourceName);
			}
			db.load(instream);
			int nCount = Integer.parseInt((String) db.get("count"));
			for (int i = 0; i < nCount; i++) {
				try {
					DriverInfo di = new DriverInfo(db, i);
					d.put(di.id, di);
				} catch (Exception e) {
					log.error("Failed to initialize driver entry " + i, e);
				}
			}
		} catch (Exception e) {
			log.error("Can't load driverDB: ", e);
			e.printStackTrace();
		} finally {
			try {
				if (instream != null)
					instream.close();
			} catch (IOException e2) {
			}
		}
		return d;
	}

}