class n19682242 {
	private boolean getRemoteFiles() throws Exception {
		boolean resp = false;
		int respCode = 0;
		URL url = new URL(storageUrlString);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		RequestUtils requestUtils = new RequestUtils();
		requestUtils.preRequestAddParameter("senderObj", "FileGetter");
		requestUtils.preRequestAddParameter("wfiType", "zen");
		requestUtils.preRequestAddParameter("portalID", this.portalID);
		requestUtils.preRequestAddParameter("userID", this.userID);
		addRenameFileParameters(requestUtils);
		requestUtils.createPostRequest();
		httpURLConnection.setRequestProperty("Content-Type",
				"multipart/form-data; boundary=" + requestUtils.getBoundary());
		httpURLConnection.setRequestMethod("POST");
		httpURLConnection.setDoOutput(true);
		httpURLConnection.setDoInput(true);
		try {
			httpURLConnection.connect();
			OutputStream out = httpURLConnection.getOutputStream();
			byte[] preBytes = requestUtils.getPreRequestStringBytes();
			out.write(preBytes);
			out.flush();
			byte[] postBytes = requestUtils.getPostRequestStringBytes();
			out.write(postBytes);
			out.flush();
			out.close();
			respCode = httpURLConnection.getResponseCode();
			if (respCode == HttpURLConnection.HTTP_OK) {
				resp = true;
				InputStream in = httpURLConnection.getInputStream();
				ZipUtils.getInstance().getFilesFromStream(in, getFilesDir);
				in.close();
			}
			if (500 == respCode) {
				resp = false;
			}
			if (560 == respCode) {
				resp = false;
				throw new Exception("Server Side Remote Exeption !!! respCode = (" + respCode + ")");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Cannot connect to: " + storageUrlString, e);
		}
		return resp;
	}

}