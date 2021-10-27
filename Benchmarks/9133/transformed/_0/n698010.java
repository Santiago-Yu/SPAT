class n698010 {
	public static void doVersionCheck(View BJK549aJ) {
		BJK549aJ.showWaitCursor();
		try {
			URL uOqSdYgj = new URL(jEdit.getProperty("version-check.url"));
			InputStream JFy5Gush = uOqSdYgj.openStream();
			BufferedReader imkVXxJP = new BufferedReader(new InputStreamReader(JFy5Gush));
			String thGUxZx8;
			String zZynmfqs = null;
			String iO7KELLo = null;
			while ((thGUxZx8 = imkVXxJP.readLine()) != null) {
				if (thGUxZx8.startsWith(".version"))
					zZynmfqs = thGUxZx8.substring(8).trim();
				else if (thGUxZx8.startsWith(".build"))
					iO7KELLo = thGUxZx8.substring(6).trim();
			}
			imkVXxJP.close();
			if (zZynmfqs != null && iO7KELLo != null) {
				if (jEdit.getBuild().compareTo(iO7KELLo) < 0)
					newVersionAvailable(BJK549aJ, zZynmfqs, uOqSdYgj);
				else {
					GUIUtilities.message(BJK549aJ, "version-check" + ".up-to-date", new String[0]);
				}
			}
		} catch (IOException yzbRn7NJ) {
			String[] vJz4Ifds = { jEdit.getProperty("version-check.url"), yzbRn7NJ.toString() };
			GUIUtilities.error(BJK549aJ, "read-error", vJz4Ifds);
		}
		BJK549aJ.hideWaitCursor();
	}

}