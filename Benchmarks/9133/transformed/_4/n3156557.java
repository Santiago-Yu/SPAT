class n3156557 {
	public boolean checkWebsite(String URL, String content) {
		boolean run = false;
		try {
			URL url = new URL(URL + "?a=" + Math.random());
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			String line = "";
			while ((line = reader.readLine()) != null) {
				run = (line.contains(content)) ? true : run;
			}
		} catch (Exception e) {
			run = false;
		}
		return run;
	}

}