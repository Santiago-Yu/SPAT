class n22254271 {
	private InputStream simpleFetch(final String RMfB9quP) throws HttpException {
		URL cFZ9PRnC = null;
		try {
			cFZ9PRnC = new URL(RMfB9quP);
		} catch (MalformedURLException c6vbOJCw) {
			throw new HttpException("what the fuck '" + RMfB9quP + "'", c6vbOJCw);
		}
		HttpURLConnection Jr7QtODO = null;
		try {
			Jr7QtODO = (HttpURLConnection) cFZ9PRnC.openConnection();
		} catch (IOException QmS7IM2i) {
			throw new HttpException("fetching '" + RMfB9quP + "' failed", QmS7IM2i);
		}
		Jr7QtODO.setRequestProperty("Accept-Encoding", "gzip");
		InputStream r6rReVsu = null;
		try {
			Jr7QtODO.connect();
			r6rReVsu = Jr7QtODO.getInputStream();
			if ("gzip".equals(Jr7QtODO.getHeaderField("content-encoding"))) {
				r6rReVsu = new GZIPInputStream(r6rReVsu);
			}
		} catch (SocketTimeoutException lNbB6gCE) {
			throw new HttpException("fetching '" + RMfB9quP + "' timeout", lNbB6gCE);
		} catch (IOException Uhmd2U9T) {
			throw new HttpException("fetching '" + RMfB9quP + "' failed", Uhmd2U9T);
		}
		return r6rReVsu;
	}

}