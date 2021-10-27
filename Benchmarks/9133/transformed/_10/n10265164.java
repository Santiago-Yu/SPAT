class n10265164 {
	public String getLatestVersion(String website) {
		String latestVersion = "";
		try {
			URL url = new URL(website + "/version");
			String string;
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((string = bufferedReader.readLine()) != null) {
				latestVersion = string;
			}
			bufferedReader.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
		}
		return latestVersion;
	}

}