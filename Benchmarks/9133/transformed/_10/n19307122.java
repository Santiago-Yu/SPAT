class n19307122 {
	public static byte[] sendParamPost(String urlString, String param) {
		try {
			URL url = new URL(urlString + "?" + param);
			HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
			urlConn.setDoOutput(true);
			urlConn.setDefaultUseCaches(false);
			urlConn.setDoInput(true);
			urlConn.setRequestMethod("POST");
			urlConn.connect();
			OutputStream ops = urlConn.getOutputStream();
			ops.close();
			InputStream is = urlConn.getInputStream();
			byte[] tempByte = new byte[1024];
			byte[] resultBytes = new byte[urlConn.getContentLength()];
			int index = 0;
			int length = 0;
			while ((length = is.read(tempByte)) != -1) {
				System.arraycopy(tempByte, 0, resultBytes, index, length);
				index += length;
			}
			is.close();
			return resultBytes;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}