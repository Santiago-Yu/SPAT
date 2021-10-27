class n17147420 {
	public final String latestVersion() {
		String latestVersion = "";
		try {
			URL url = new URL(Constants.officialSite + ":80/LatestVersion");
			String str;
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((str = in.readLine()) != null) {
				latestVersion = str;
			}
			in.close();
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
		return latestVersion;
	}

}