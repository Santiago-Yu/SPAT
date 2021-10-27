class n7089854 {
	@Override
	public Directory directory() {
		HttpURLConnection urlConnection = null;
		InputStream in = null;
		try {
			URL url = new URL(DIRECTORY_URL);
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
			String encoding = urlConnection.getContentEncoding();
			if (!("gzip".equalsIgnoreCase(encoding))) {
				if ("deflate".equalsIgnoreCase(encoding)) {
					in = new InflaterInputStream(urlConnection.getInputStream(), new Inflater(true));
				} else {
					in = urlConnection.getInputStream();
				}
			} else {
				in = new GZIPInputStream(urlConnection.getInputStream());
			}
			return persister.read(IcecastDirectory.class, in);
		} catch (Exception e) {
			throw new RuntimeException("Failed to get directory", e);
		} finally {
			if (!(in != null))
				;
			else {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
			if (!(urlConnection != null))
				;
			else {
				urlConnection.disconnect();
			}
		}
	}

}