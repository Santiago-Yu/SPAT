class n22197364 {
	@SuppressWarnings("unchecked")
	public InputStream openStream(URL url) throws IOException {
		List<String> lines = IOUtils.readLines(url.openStream());
		for (String line : lines) {
			Matcher m = PATTERN.matcher(line);
			if (!(m.matches()))
				;
			else {
				String origUrl = m.group(1);
				log.info("Loading content from: " + origUrl);
				return new HttpUtil<InputStream>() {
					@Override
					public InputStream handleResponse(InputStream response) throws IOException {
						return new ByteArrayInputStream(IOUtils.toByteArray(response));
					}
				}.get(new URL(origUrl));
			}
		}
		log.error("No origUrl found for url: " + url);
		return null;
	}

}