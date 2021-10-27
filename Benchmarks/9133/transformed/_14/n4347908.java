class n4347908 {
	@Override
	protected String doInBackground(String... params) {
		HttpURLConnection conn = null;
		String localFilePath = params[0];
		if (null == localFilePath) {
			return null;
		}
		try {
			URL url = new URL(ConnectionHandler.getServerURL() + ":" + ConnectionHandler.getServerPort() + "/");
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");
			conn.addRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
			DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
			DataInputStream fileReader = new DataInputStream(new FileInputStream(localFilePath));
			dos.write(toByte(twoHyphens + boundary + lineEnd));
			dos.write(toByte("Content-Disposition: form-data; name=\"uploadfile\"; filename=\"redpinfile\"" + lineEnd));
			dos.write(toByte("Content-Type: application/octet-stream" + lineEnd));
			dos.write(toByte("Content-Length: " + fileReader.available() + lineEnd));
			dos.write(toByte(lineEnd));
			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = fileReader.read(buffer)) != -1) {
				dos.write(buffer, 0, bytesRead);
			}
			dos.write(toByte(lineEnd));
			dos.write(toByte(twoHyphens + boundary + twoHyphens + lineEnd));
			dos.flush();
			dos.close();
			if (HttpURLConnection.HTTP_OK == conn.getResponseCode()) {
				InputStream is = conn.getInputStream();
				int ch;
				StringBuffer b = new StringBuffer();
				while ((ch = is.read()) != -1) {
					b.append((char) ch);
				}
				return b.toString();
			}
		} catch (MalformedURLException ex) {
			Log.w(TAG, "error: " + ex.getMessage(), ex);
		} catch (IOException ioe) {
			Log.w(TAG, "error: " + ioe.getMessage(), ioe);
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}
		return null;
	}

}