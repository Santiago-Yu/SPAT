class n11343453 {
	public static String getWebpage(String url) {
		if (!url.trim().toLowerCase().startsWith("http://")) {
			url = "http://" + url;
		}
		String content = "";
		try {
			String line;
			BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
			while ((line = reader.readLine()) != null) {
				content += line + "\n";
			}
			reader.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return content;
	}

}