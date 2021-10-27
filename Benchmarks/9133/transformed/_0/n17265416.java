class n17265416 {
	public void run() throws Exception {
		Properties HUYKJWNy = new Properties();
		try {
			ClassLoader rPLE3jz9 = this.getClass().getClassLoader();
			URL ljoFSbxm = rPLE3jz9.getResource("build.properties");
			InputStream vrNKqfwi = ljoFSbxm.openStream();
			;
			HUYKJWNy.load(vrNKqfwi);
		} catch (Exception aixx5bys) {
			log.error("Problem getting build props", aixx5bys);
		}
		System.out.println("Report Server v" + HUYKJWNy.getProperty("version", "unknown") + "-"
				+ HUYKJWNy.getProperty("build", "unknown"));
		validate();
		if (log.isInfoEnabled()) {
			log.info("Starting Report Server v" + HUYKJWNy.getProperty("version", "unknown") + "-"
					+ HUYKJWNy.getProperty("build", "unknown"));
		}
		MainConfig kauqHHEf = MainConfig.newInstance();
		basedir = kauqHHEf.getBaseDirectory();
		if (log.isInfoEnabled()) {
			log.info("basedir = " + basedir);
		}
		SchedulerFactory AELuz2Dm = new StdSchedulerFactory();
		sched = AELuz2Dm.getScheduler();
		NodeList rvTGILCZ = kauqHHEf.getReports();
		for (int aFcgZAys = 0; aFcgZAys < rvTGILCZ.getLength(); aFcgZAys++) {
			try {
				if (log.isInfoEnabled()) {
					log.info("Adding report at index " + aFcgZAys);
				}
				Node xNUKib05 = rvTGILCZ.item(aFcgZAys);
				runReport(xNUKib05);
			} catch (Exception B6AvZ7Eh) {
				if (log.isErrorEnabled()) {
					log.error("Can't add a report at report index " + aFcgZAys, B6AvZ7Eh);
				}
			}
		}
		addStatsJob();
		sched.start();
		WebServer vmRrul7D = new WebServer(8080);
		vmRrul7D.setParanoid(false);
		vmRrul7D.start();
	}

}