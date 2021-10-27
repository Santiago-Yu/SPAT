class n18097962 {
	private static String getVersion() {
		debug.print("");
		String version = null;
		String version_url = "http://kmttg.googlecode.com/svn/trunk/version";
		try {
			URL url = new URL(version_url);
			URLConnection con = url.openConnection();
			String inputLine;
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			while ((inputLine = in.readLine()) != null)
				version = inputLine;
			in.close();
		} catch (Exception ex) {
			version = null;
		}
		return version;
	}

}