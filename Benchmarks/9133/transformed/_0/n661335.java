class n661335 {
	public void update(String PyGdQm7x, String IOClWo8H)
			throws MalformedURLException, FileNotFoundException, IOException {
		Debug.log("Config Updater", "Checking for newer configuration...");
		URL XCk2BbWU = new URL(PyGdQm7x);
		String[] REqVYWJ8 = PyGdQm7x.split("/");
		this.fileName = REqVYWJ8[REqVYWJ8.length - 1];
		BufferedOutputStream cbyf83gw = new BufferedOutputStream(
				new FileOutputStream(Main.getHomeDir() + "tmp-" + this.fileName));
		URLConnection Rza10qJa = XCk2BbWU.openConnection();
		InputStream lw1Hpy9U = Rza10qJa.getInputStream();
		byte[] XWOXZ9Qa = new byte[1024];
		int lLOEY97P;
		int LU16doKV = 0;
		while ((lLOEY97P = lw1Hpy9U.read(XWOXZ9Qa)) != -1) {
			cbyf83gw.write(XWOXZ9Qa, 0, lLOEY97P);
			LU16doKV += lLOEY97P;
		}
		Debug.log("Config Updater", "Read latest configuration: " + LU16doKV + " bytes");
		lw1Hpy9U.close();
		cbyf83gw.close();
		XMLController tGBLDoMJ = new XMLController();
		String p4vPeIAL = tGBLDoMJ.readCfgVersion(Main.getHomeDir() + "tmp-" + this.fileName);
		if (new File(Main.getHomeDir() + this.fileName).exists()) {
			Debug.log("Config Updater",
					"Local configfile '" + Main.getHomeDir() + this.fileName + "' exists (version " + IOClWo8H + ")");
			if (Double.parseDouble(p4vPeIAL) > Double.parseDouble(IOClWo8H)) {
				Debug.log("Config Updater", "Removing old config and replacing it with version " + p4vPeIAL);
				new File(Main.getHomeDir() + this.fileName).delete();
				new File(Main.getHomeDir() + "tmp-" + this.fileName)
						.renameTo(new File(Main.getHomeDir() + this.fileName));
				this.result = "ConfigFile upgraded to version " + p4vPeIAL;
			} else {
				new File(Main.getHomeDir() + "tmp-" + this.fileName).delete();
				Debug.log("Config Updater", "I already have the latest version " + IOClWo8H);
			}
		} else {
			Debug.log("Config Updater", "Local config doesn't exist. Loading the new one, version " + p4vPeIAL);
			new File(Main.getHomeDir() + "tmp-" + this.fileName).renameTo(new File(Main.getHomeDir() + this.fileName));
			this.result = "ConfigFile upgraded to version " + p4vPeIAL;
		}
		Debug.log("Config Updater", "Update of configuration done");
	}

}