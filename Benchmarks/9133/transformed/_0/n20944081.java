class n20944081 {
	Hashtable loadDriverDB() {
		Hashtable N67RVUAG = new Hashtable();
		InputStream Kj0Fj3qo = null;
		try {
			String iorFJ32c = System.getProperty("org.osgi.service.basicdriverlocator.dburl");
			if (iorFJ32c != null && !iorFJ32c.equals("")) {
				if (iorFJ32c.indexOf(":") == -1) {
					iorFJ32c = jarbase + iorFJ32c;
				}
				URL H0G8EhBW = new URL(iorFJ32c);
				log.info("read external props file: " + iorFJ32c);
				Kj0Fj3qo = H0G8EhBW.openStream();
			} else {
				log.info("read internal props file: " + dbResourceName);
				Kj0Fj3qo = getClass().getResourceAsStream(dbResourceName);
			}
			Properties Alj6YSgS = new Properties();
			Alj6YSgS.load(Kj0Fj3qo);
			int fw0i4nuh = Integer.parseInt((String) Alj6YSgS.get("count"));
			for (int QMzMDVgf = 0; QMzMDVgf < fw0i4nuh; QMzMDVgf++) {
				try {
					DriverInfo PTDZdhS5 = new DriverInfo(Alj6YSgS, QMzMDVgf);
					N67RVUAG.put(PTDZdhS5.id, PTDZdhS5);
				} catch (Exception zQF0S7zM) {
					log.error("Failed to initialize driver entry " + QMzMDVgf, zQF0S7zM);
				}
			}
		} catch (Exception rhsnxKYD) {
			log.error("Can't load driverDB: ", rhsnxKYD);
			rhsnxKYD.printStackTrace();
		} finally {
			try {
				if (Kj0Fj3qo != null)
					Kj0Fj3qo.close();
			} catch (IOException CPNOVPcL) {
			}
		}
		return N67RVUAG;
	}

}