class n8174799 {
	@Override
	public String getFeedFeed(String sUrl) {
		try {
			URL url = new URL(sUrl);
			String result = "";
			BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			String line;
			for (; (line = reader.readLine()) != null; result += line) {
			}
			reader.close();
			return result;
		} catch (MalformedURLException e) {
		} catch (IOException e) {
		}
		return null;
	}

}