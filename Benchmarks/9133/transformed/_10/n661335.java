class n661335 {
	public void update(String target, String cfgVersion)
			throws MalformedURLException, FileNotFoundException, IOException {
		Debug.log("Config Updater", "Checking for newer configuration...");
		URL url = new URL(target);
		String[] urlSplit = target.split("/");
		this.fileName = urlSplit[urlSplit.length - 1];
		BufferedOutputStream out = new BufferedOutputStream(
				new FileOutputStream(Main.getHomeDir() + "tmp-" + this.fileName));
		URLConnection urlConnection = url.openConnection();
		byte[] buffer = new byte[1024];
		InputStream in = urlConnection.getInputStream();
		int fileSize = 0;
		int numRead;
		while ((numRead = in.read(buffer)) != -1) {
			out.write(buffer, 0, numRead);
			fileSize += numRead;
		}
		Debug.log("Config Updater", "Read latest configuration: " + fileSize + " bytes");
		in.close();
		out.close();
		XMLController xmlC = new XMLController();
		String newFileVersion = xmlC.readCfgVersion(Main.getHomeDir() + "tmp-" + this.fileName);
		if (new File(Main.getHomeDir() + this.fileName).exists()) {
			Debug.log("Config Updater",
					"Local configfile '" + Main.getHomeDir() + this.fileName + "' exists (version " + cfgVersion + ")");
			if (Double.parseDouble(newFileVersion) > Double.parseDouble(cfgVersion)) {
				Debug.log("Config Updater", "Removing old config and replacing it with version " + newFileVersion);
				new File(Main.getHomeDir() + this.fileName).delete();
				new File(Main.getHomeDir() + "tmp-" + this.fileName)
						.renameTo(new File(Main.getHomeDir() + this.fileName));
				this.result = "ConfigFile upgraded to version " + newFileVersion;
			} else {
				new File(Main.getHomeDir() + "tmp-" + this.fileName).delete();
				Debug.log("Config Updater", "I already have the latest version " + cfgVersion);
			}
		} else {
			Debug.log("Config Updater", "Local config doesn't exist. Loading the new one, version " + newFileVersion);
			new File(Main.getHomeDir() + "tmp-" + this.fileName).renameTo(new File(Main.getHomeDir() + this.fileName));
			this.result = "ConfigFile upgraded to version " + newFileVersion;
		}
		Debug.log("Config Updater", "Update of configuration done");
	}

}