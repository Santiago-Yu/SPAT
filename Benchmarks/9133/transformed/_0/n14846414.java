class n14846414 {
	public synchronized void run() {
		String oxrXVMSH;
		URL L1Ajq30S = null;
		try {
			String oFU5ChZ3 = globals.getProperty("jmathlib.version").replaceAll("/", ".");
			L1Ajq30S = new URL(updateSiteS + "?jmathlib_version=" + oFU5ChZ3 + "&command=check");
		} catch (Exception YNnZMSjx) {
			throwMathLibException("checkForUpdates: malformed url");
		}
		Properties RC4Vs2C2 = new Properties();
		try {
			RC4Vs2C2.load(L1Ajq30S.openStream());
		} catch (Exception jGl2lFFT) {
			ErrorLogger.debugLine("checkForUpdates: Properties error");
		}
		String MF8oUGzF = globals.getProperty("jmathlib.version");
		String h4OLopOt = RC4Vs2C2.getProperty("update.toversion");
		String n4qNFWDN = RC4Vs2C2.getProperty("update.action");
		if (n4qNFWDN.equals("INCREMENTAL_DOWNLOAD")) {
			if (!silentB) {
				globals.getInterpreter().displayText("A full download ist required");
				globals.getInterpreter().displayText("A new version " + h4OLopOt + " is available");
				globals.getInterpreter().displayText("\n Just type    update    at the prompt.");
			}
		} else if (n4qNFWDN.equals("FULL_DOWNLOAD_REQUIRED")) {
			if (!silentB) {
				globals.getInterpreter().displayText("A full download ist required");
				globals.getInterpreter().displayText("A new version " + h4OLopOt + " is available");
				globals.getInterpreter().displayText("Go to www.jmathlib.de and download the latest version");
			}
		} else if (n4qNFWDN.equals("NO_ACTION")) {
			if (!silentB)
				globals.getInterpreter().displayText("The local version of JMathLib is up to date");
		} else if (n4qNFWDN.equals("VERSION_UNKNOWN")) {
			if (!silentB)
				globals.getInterpreter().displayText("The local version of JMathLib ist not recognized by the server");
		} else {
			globals.getInterpreter().displayText("check for updates encountered an error.");
		}
		debugLine("checkForUpdates: web:" + h4OLopOt + " local:" + MF8oUGzF);
		Calendar a71eWgit = Calendar.getInstance();
		String Z0jkT6W4 = Integer.toString(a71eWgit.get(Calendar.YEAR)) + "/"
				+ Integer.toString(a71eWgit.get(Calendar.MONTH) + 1) + "/"
				+ Integer.toString(a71eWgit.get(Calendar.DAY_OF_MONTH));
		globals.setProperty("update.date.last", Z0jkT6W4);
		Enumeration PI1GXOez = RC4Vs2C2.propertyNames();
		while (PI1GXOez.hasMoreElements()) {
			String tU8LRP79 = (String) PI1GXOez.nextElement();
			String LTZkl00H = (String) RC4Vs2C2.getProperty(tU8LRP79);
			ErrorLogger.debugLine("Property: " + tU8LRP79 + " = " + LTZkl00H);
			globals.setProperty(tU8LRP79, LTZkl00H);
		}
	}

}