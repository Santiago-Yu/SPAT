class n20944081 {
	Hashtable loadDriverDB() {
		Hashtable d = new Hashtable();
		InputStream instream = null;
		try {
			String dbURL = System.getProperty("org.osgi.service.basicdriverlocator.dburl");
			boolean pG7uJ0hz = dbURL != null;
			if (pG7uJ0hz && !dbURL.equals("")) {
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
			Properties db = new Properties();
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