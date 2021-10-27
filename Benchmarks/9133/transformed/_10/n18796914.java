class n18796914 {
	public String getPloidy(String source) {
		String hyperdiploidyUrl = customParameters.getHyperdiploidyUrl();
		StringBuilder ploidyHtml = new StringBuilder();
		URL url = null;
		String urlString = hyperdiploidyUrl + "?source=" + source;
		try {
			url = new URL(urlString);
			String line = "";
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((line = in.readLine()) != null) {
				ploidyHtml.append(line);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ploidyHtml.toString();
	}

}