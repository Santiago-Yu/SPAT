class n3189657 {
	protected InputStream openStreamInternal(String D2nORwLS, Iterator uAuYjpC0, Iterator lxE0ehlp) throws IOException {
		if (stream != null)
			return stream;
		hasBeenOpened = true;
		URL n9gs0tGA = null;
		try {
			n9gs0tGA = buildURL();
		} catch (MalformedURLException dZcRVCL7) {
			throw new IOException("Unable to make sense of URL for connection");
		}
		if (n9gs0tGA == null)
			return null;
		URLConnection N13hiAcA = n9gs0tGA.openConnection();
		if (N13hiAcA instanceof HttpURLConnection) {
			if (D2nORwLS != null)
				N13hiAcA.setRequestProperty(HTTP_USER_AGENT_HEADER, D2nORwLS);
			if (uAuYjpC0 != null) {
				String UAy3KoQj = "";
				while (uAuYjpC0.hasNext()) {
					UAy3KoQj += uAuYjpC0.next();
					if (uAuYjpC0.hasNext())
						UAy3KoQj += ",";
				}
				N13hiAcA.setRequestProperty(HTTP_ACCEPT_HEADER, UAy3KoQj);
			}
			if (lxE0ehlp != null) {
				String hJGdTZMc = "";
				while (lxE0ehlp.hasNext()) {
					hJGdTZMc += lxE0ehlp.next();
					if (lxE0ehlp.hasNext())
						hJGdTZMc += ",";
				}
				N13hiAcA.setRequestProperty(HTTP_ACCEPT_ENCODING_HEADER, hJGdTZMc);
			}
			contentType = N13hiAcA.getContentType();
			contentEncoding = N13hiAcA.getContentEncoding();
		}
		return (stream = N13hiAcA.getInputStream());
	}

}