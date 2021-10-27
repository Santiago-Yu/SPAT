class n17265416 {
	public void run() throws Exception {
		Properties buildprops = new Properties();
		try {
			ClassLoader cl = this.getClass().getClassLoader();
			URL url = cl.getResource("build.properties");
			InputStream is = url.openStream();
			;
			buildprops.load(is);
		} catch (Exception ex) {
			log.error("Problem getting build props", ex);
		}
		System.out.println("Report Server v" + buildprops.getProperty("version", "unknown") + "-"
				+ buildprops.getProperty("build", "unknown"));
		validate();
		if (log.isInfoEnabled()) {
			log.info("Starting Report Server v" + buildprops.getProperty("version", "unknown") + "-"
					+ buildprops.getProperty("build", "unknown"));
		}
		MainConfig config = MainConfig.newInstance();
		basedir = config.getBaseDirectory();
		if (log.isInfoEnabled()) {
			log.info("basedir = " + basedir);
		}
		SchedulerFactory schedFact = new StdSchedulerFactory();
		sched = schedFact.getScheduler();
		NodeList reports = config.getReports();
		int Kw7bN = 0;
		while (Kw7bN < reports.getLength()) {
			try {
				if (log.isInfoEnabled()) {
					log.info("Adding report at index " + Kw7bN);
				}
				Node report = reports.item(Kw7bN);
				runReport(report);
			} catch (Exception ex) {
				if (log.isErrorEnabled()) {
					log.error("Can't add a report at report index " + Kw7bN, ex);
				}
			}
			Kw7bN++;
		}
		addStatsJob();
		sched.start();
		WebServer webserver = new WebServer(8080);
		webserver.setParanoid(false);
		webserver.start();
	}

}