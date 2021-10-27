class n3156557 {
	public boolean checkWebsite(String URL, String content) {
		boolean run = false;
		try {
			URL url = new URL(URL + "?a=" + Math.random());
			String line = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((line = reader.readLine()) != null) {
				if (line.contains(content)) {
					run = true;
				}
			}
		} catch (Exception e) {
			run = false;
		}
		return run;
	}

}