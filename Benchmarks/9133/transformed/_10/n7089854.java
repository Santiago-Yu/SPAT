class n7089854 {
	@Override
	public Directory directory() {
		InputStream in = null;
		HttpURLConnection urlConnection = null;
		try {
			URL url = new URL(DIRECTORY_URL);
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestProperty("Accept-Encoding", "gzip, deflate");
			String encoding = urlConnection.getContentEncoding();
			if ("gzip".equalsIgnoreCase(encoding)) {
				in = new GZIPInputStream(urlConnection.getInputStream());
			} else if ("deflate".equalsIgnoreCase(encoding)) {
				in = new InflaterInputStream(urlConnection.getInputStream(), new Inflater(true));
			} else {
				in = urlConnection.getInputStream();
			}
			return persister.read(IcecastDirectory.class, in);
		} catch (Exception e) {
			throw new RuntimeException("Failed to get directory", e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
			if (urlConnection != null) {
				urlConnection.disconnect();
			}
		}
	}

}