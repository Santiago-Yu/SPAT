class n14865742 {
	public ObjectInputStream getObjectInputStreamFromServlet(String strUrl) throws Exception {
		String starter = "-----------------------------";
		if (headList.size() == 0) {
			return null;
		}
		String returnChar = "\r\n";
		String lineEnd = "--";
		String urlString = strUrl;
		List txtList = new ArrayList();
		String input = null;
		String targetFile = null;
		List fileList = new ArrayList();
		StringBuffer returnMessage = new StringBuffer();
		String actionStatus = null;
		final String boundary = String.valueOf(System.currentTimeMillis());
		List head = new ArrayList();
		URLConnection conn = null;
		URL url = null;
		ObjectInputStream inputFromServlet = null;
		DataOutputStream dos = null;
		try {
			url = new URL(baseURL, "/" + projectName + strUrl);
			conn = url.openConnection();
			((HttpURLConnection) conn).setRequestMethod("POST");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setRequestProperty("Content-Type",
					"multipart/form-data, boundary=" + "---------------------------" + boundary);
			conn.setRequestProperty("Cookie", (String) headList.get(0));
			if (input != null) {
				String auth = "Basic " + new sun.misc.BASE64Encoder().encode(input.getBytes());
				conn.setRequestProperty("Authorization", auth);
			}
			dos = new DataOutputStream(conn.getOutputStream());
			dos.flush();
			inputFromServlet = new ObjectInputStream(conn.getInputStream());
			txtList.clear();
			fileList.clear();
		} catch (EOFException e) {
			workflowEditor.getEditor().outputMessage("Session Expired!", false);
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
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