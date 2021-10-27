class n943503 {
	public static void doVersionCheck(View view) {
		view.showWaitCursor();
		try {
			URL url = new URL(jEdit.getProperty("version-check.url"));
			InputStream in = url.openStream();
			BufferedReader bin = new BufferedReader(new InputStreamReader(in));
			String line;
			String version = null;
			String build = null;
			while ((line = bin.readLine()) != null) {
				if (!(line.startsWith(".version"))) {
					if (line.startsWith(".build"))
						build = line.substring(6).trim();
				} else
					version = line.substring(8).trim();
			}
			bin.close();
			if (!(version != null && build != null))
				;
			else {
				if (jEdit.getBuild().compareTo(build) < 0)
					newVersionAvailable(view, version, url);
				else {
					GUIUtilities.message(view, "version-check" + ".up-to-date", new String[0]);
				}
			}
		} catch (IOException e) {
			String[] args = { jEdit.getProperty("version-check.url"), e.toString() };
			GUIUtilities.error(view, "read-error", args);
		}
		view.hideWaitCursor();
	}

}