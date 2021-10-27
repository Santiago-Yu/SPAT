class n21181029 {
	public void run() {
		isRunning = true;
		try {
			URL rmf5cD4q = new URL("http://dcg.ethz.ch/projects/sinalgo/version");
			URLConnection oOQI9gOe = rmf5cD4q.openConnection();
			oOQI9gOe.setDoOutput(true);
			oOQI9gOe.setDoInput(true);
			oOQI9gOe.connect();
			PrintStream CVTToVvu = new PrintStream(oOQI9gOe.getOutputStream());
			CVTToVvu.println("GET index.html HTTP/1.1");
			CVTToVvu.flush();
			BufferedReader LAxVao8X = new BufferedReader(new InputStreamReader(oOQI9gOe.getInputStream()));
			String Q1kWF7FH = LAxVao8X.readLine();
			if (Q1kWF7FH != null) {
				if (Q1kWF7FH.equals(Configuration.versionString)) {
					if (displayIfOK) {
						Main.info("You are using the most recent version of Sinalgo.");
					}
				} else {
					String d2Jef9LQ = "\n" + "+----------------------------------------------------------------------\n"
							+ "| You are currently running Sinalgo " + Configuration.versionString + ".\n"
							+ "| A more recent version of Sinalgo is available (" + Q1kWF7FH + ")\n"
							+ "+---------------------------------------------------------------------\n"
							+ "| To download the latest version, please visit\n"
							+ "| http://sourceforge.net/projects/sinalgo/\n"
							+ "+---------------------------------------------------------------------\n"
							+ "| You may turn off these version checks through the 'Settings' dialog.\n"
							+ "| Note:   Sinalgo automatically tests for updates at most once\n"
							+ "|         every 24 hours.\n"
							+ "+---------------------------------------------------------------------\n";
					Main.warning(d2Jef9LQ);
				}
			}
		} catch (Exception Iw7E05cc) {
			String Mwm9LlN6 = "\n" + ">----------------------------------------------------------------------\n"
					+ "> Unable to test for updates of Sinalgo. The installed version\n" + "> is "
					+ Configuration.versionString + "\n"
					+ ">---------------------------------------------------------------------\n"
					+ "> To check for more recent versions, please visit\n"
					+ "> http://sourceforge.net/projects/sinalgo/\n"
					+ ">---------------------------------------------------------------------\n"
					+ "> You may turn off these version checks through the 'Settings' dialog.\n"
					+ "| Note:   Sinalgo automatically tests for updates at most once\n" + "|         every 24 hours.\n"
					+ ">---------------------------------------------------------------------\n";
			Main.warning(Mwm9LlN6);
		} finally {
			isRunning = false;
			AppConfig.getAppConfig().timeStampOfLastUpdateCheck = System.currentTimeMillis();
		}
	}

}