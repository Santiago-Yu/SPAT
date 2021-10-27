class n1026391 {
	public ObjectInputStream getObjectInputStreamFromServlet(String strUrl) throws Exception {
		if (cookie == null) {
			return null;
		}
		String starter = "-----------------------------", returnChar = "\r\n";
		String lineEnd = "--", urlString = strUrl;
		String input = null;
		List txtList = new ArrayList();
		List fileList = new ArrayList();
		String targetFile = null, actionStatus = null;
		StringBuffer returnMessage = new StringBuffer();
		List head = new ArrayList();
		final String boundary = String.valueOf(System.currentTimeMillis());
		URL url = null;
		URLConnection conn = null;
		DataOutputStream dos = null;
		ObjectInputStream inputFromServlet = null;
		try {
			url = new URL(urlString);
			conn = url.openConnection();
			((HttpURLConnection) conn).setRequestMethod("POST");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setRequestProperty("Content-Type",
					"multipart/form-data, boundary=" + "---------------------------" + boundary);
			conn.setRequestProperty(HEADER_COOKIE, cookie);
			if (input != null) {
				String auth = "Basic " + new sun.misc.BASE64Encoder().encode(input.getBytes());
				conn.setRequestProperty("Authorization", auth);
			}
			dos = new DataOutputStream(conn.getOutputStream());
			dos.flush();
			inputFromServlet = new ObjectInputStream(conn.getInputStream());
			txtList.clear();
			fileList.clear();
		} catch (Exception e) {
			log.error(e, e);
			return null;
		} finally {
			try {
				dos.close();
			} catch (Exception e) {
			}
		}
		return inputFromServlet;
	}

}