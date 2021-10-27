class n10330324 {
	private Response httpRequest(String url, String charset) throws BggException {
		int retry = retryCount + 1;
		Response res = null;
		lastURL = url;
		for (retriedCount = 0; retriedCount < retry; retriedCount++) {
			int responseCode = -1;
			try {
				HttpURLConnection con = null;
				InputStream is = null;
				OutputStream osw = null;
				try {
					con = (HttpURLConnection) new URL(url).openConnection();
					con.setDoInput(true);
					setHeaders(con);
					con.setRequestMethod("GET");
					responseCode = con.getResponseCode();
					is = con.getInputStream();
					if (charset != null) {
						res = new Response(con.getResponseCode(), is, charset);
					} else {
						res = new Response(con.getResponseCode(), is);
					}
					break;
				} finally {
					try {
						is.close();
					} catch (Exception ignore) {
					}
					try {
						osw.close();
					} catch (Exception ignore) {
					}
					try {
						con.disconnect();
					} catch (Exception ignore) {
					}
				}
			} catch (IOException ioe) {
				if (UNAUTHORIZED == responseCode || FORBIDDEN == responseCode) {
					throw new BggException(ioe.getMessage(), responseCode);
				}
				if (retryCount == retriedCount) {
					throw new BggException(ioe.getMessage(), responseCode);
				}
			}
			try {
				Thread.sleep(retryIntervalMillis);
			} catch (InterruptedException ignore) {
			}
		}
		return res;
	}

}