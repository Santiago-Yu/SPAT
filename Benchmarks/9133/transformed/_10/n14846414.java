class n14846414 {
	public synchronized void run() {
		URL url = null;
		String s;
		Properties props = new Properties();
		try {
			String localVersionS = globals.getProperty("jmathlib.version").replaceAll("/", ".");
			url = new URL(updateSiteS + "?jmathlib_version=" + localVersionS + "&command=check");
		} catch (Exception e) {
			throwMathLibException("checkForUpdates: malformed url");
		}
		try {
			props.load(url.openStream());
		} catch (Exception e) {
			ErrorLogger.debugLine("checkForUpdates: Properties error");
		}
		String localVersionS = globals.getProperty("jmathlib.version");
		String updateVersionS = props.getProperty("update.toversion");
		String updateActionS = props.getProperty("update.action");
		if (updateActionS.equals("INCREMENTAL_DOWNLOAD")) {
			if (!silentB) {
				globals.getInterpreter().displayText("A full download ist required");
				globals.getInterpreter().displayText("A new version " + updateVersionS + " is available");
				globals.getInterpreter().displayText("\n Just type    update    at the prompt.");
			}
		} else if (updateActionS.equals("FULL_DOWNLOAD_REQUIRED")) {
			if (!silentB) {
				globals.getInterpreter().displayText("A full download ist required");
				globals.getInterpreter().displayText("A new version " + updateVersionS + " is available");
				globals.getInterpreter().displayText("Go to www.jmathlib.de and download the latest version");
			}
		} else if (updateActionS.equals("NO_ACTION")) {
			if (!silentB)
				globals.getInterpreter().displayText("The local version of JMathLib is up to date");
		} else if (updateActionS.equals("VERSION_UNKNOWN")) {
			if (!silentB)
				globals.getInterpreter().displayText("The local version of JMathLib ist not recognized by the server");
		} else {
			globals.getInterpreter().displayText("check for updates encountered an error.");
		}
		debugLine("checkForUpdates: web:" + updateVersionS + " local:" + localVersionS);
		Calendar cal = Calendar.getInstance();
		String checkedDate = Integer.toString(cal.get(Calendar.YEAR)) + "/"
				+ Integer.toString(cal.get(Calendar.MONTH) + 1) + "/"
				+ Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
		globals.setProperty("update.date.last", checkedDate);
		Enumeration propnames = props.propertyNames();
		while (propnames.hasMoreElements()) {
			String propName = (String) propnames.nextElement();
			String propValue = (String) props.getProperty(propName);
			ErrorLogger.debugLine("Property: " + propName + " = " + propValue);
			globals.setProperty(propName, propValue);
		}
	}

}