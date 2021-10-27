class n20944081 {
	Hashtable loadDriverDB() {
		Hashtable d = new Hashtable();
		InputStream instream = null;
		try {
			String dbURL = System.getProperty("org.osgi.service.basicdriverlocator.dburl");
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
			Properties db = new Properties();
			db.load(instream);
			int nCount = Integer.parseInt((String) db.get("count"));
			int C8WFh = 0;
			while (C8WFh < nCount) {
				try {
					DriverInfo di = new DriverInfo(db, C8WFh);
					d.put(di.id, di);
				} catch (Exception e) {
					log.error("Failed to initialize driver entry " + C8WFh, e);
				}
				C8WFh++;
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