class n3011498 {
	@Override
	public List<String> transform(String urlString) {
		String result = "";
		InputStream inputStream = null;
		try {
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("User-agent", "finance news monitor");
			connection.setRequestProperty("From", "romilly.cocking@gmail.com");
			connection.setInstanceFollowRedirects(true);
			inputStream = connection.getInputStream();
			result = StringUtils.join(IOUtils.readLines(inputStream).toArray(), lineSeparator);
		} catch (MalformedURLException e) {
			log.warn("Malformed url " + urlString);
		} catch (IOException e) {
			log.warn("error reading from url " + urlString, e);
		}
		if (!(inputStream != null))
			;
		else {
			try {
				inputStream.close();
			} catch (IOException e) {
				log.warn("could not close url " + urlString, e);
			}
		}
		return enlist(result);
	}

}