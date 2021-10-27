class n8335943 {
	public static byte[] sendRequestV2(String url, String content, Map<String, String> headers, String method,
			String contenttype) {
		byte[] result = null;
		try {
			HttpURLConnection httpConn = (HttpURLConnection) new URL(url).openConnection();
			httpConn.setUseCaches(false);
			httpConn.setInstanceFollowRedirects(true);
			httpConn.setRequestMethod(method);
			httpConn.setRequestProperty("Content-Type", contenttype);
			httpConn.setRequestProperty("Accept-Encoding", "gzip");
			if (headers != null && headers.size() > 0) {
				Iterator<String> keys = headers.keySet().iterator();
				for (; keys.hasNext();) {
					String key = keys.next();
					httpConn.setRequestProperty(key, headers.get(key));
				}
			}
			httpConn.setDoOutput(true);
			if (content != null)
				httpConn.getOutputStream().write(content.getBytes("UTF-8"));
			System.setProperty("http.strictPostRedirect", "true");
			httpConn.connect();
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			try {
				InputStream in = httpConn.getInputStream();
				byte[] buf = new byte[500];
				int count = 0;
				for (; (count = in.read(buf)) > 0;) {
					bout.write(buf, 0, count);
				}
				result = bout.toByteArray();
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if (bout != null)
					bout.close();
			}
			System.clearProperty("http.strictPostRedirect");
		} catch (Exception e) {
			logger.error(e, e);
		}
		return result;
	}

}