class n833655 {
	private void checkForLatestVersion() {
		log(Color.BLUE, "Checking for latest version.");
		try {
			double bGsmAVEH = 0.0;
			URL BPxQU86a = new URL("http://www.powerbot.org/vb/showthread.php?t=723144");
			URLConnection HoaBDTQ9 = BPxQU86a.openConnection();
			BufferedReader yvJyfdPy = new BufferedReader(new InputStreamReader(HoaBDTQ9.getInputStream()));
			String gz2axWVW;
			while ((gz2axWVW = yvJyfdPy.readLine()) != null) {
				if (gz2axWVW.contains("<pre class=\"bbcode_code\"style=\"height:48px;\"><i>Current version")) {
					for (String CYySuQUD : gz2axWVW.split(" ")) {
						try {
							bGsmAVEH = Double.parseDouble(CYySuQUD);
						} catch (NumberFormatException IPyGy742) {
						}
					}
				}
			}
			double MarlSvPH = getClass().getAnnotation(ScriptManifest.class).version();
			String ilHTzhFw = bGsmAVEH < MarlSvPH ? ", you should update to the latest version!"
					: ", you have the latest version of this script.";
			log(bGsmAVEH < MarlSvPH ? Color.RED : Color.BLUE, "Latest version available : " + bGsmAVEH + ilHTzhFw);
		} catch (IOException ZGVke3hg) {
			log(Color.RED, "Couldn't retreive latest version due to a connection issue!");
		} catch (NumberFormatException woqyhKJT) {
			log(Color.RED, "Couldn't reveice latest version; no version were available on PowerBot website!.");
		} catch (Exception hDrzwnNP) {
			log(Color.RED, "Couldn't retreive latest version due to an unknown reason!");
		}
	}

}