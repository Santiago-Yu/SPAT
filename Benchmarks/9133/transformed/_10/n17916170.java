class n17916170 {
	public String getWebPage(String url) {
		URL urlObj = null;
		String content = "";
		try {
			urlObj = new URL(url);
		} catch (MalformedURLException urlEx) {
			urlEx.printStackTrace();
			throw new Error("URL creation failed.");
		}
		try {
			String line;
			BufferedReader reader = new BufferedReader(new InputStreamReader(urlObj.openStream()));
			while ((line = reader.readLine()) != null) {
				content += line;
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new Error("Page retrieval failed.");
		}
		return content;
	}

}