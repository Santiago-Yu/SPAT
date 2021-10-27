class n10735044 {
	public static byte[] getBytes(URL url) throws IOException {
		URLConnection connection = url.openConnection();
		InputStream in = connection.getInputStream();
		ByteArrayOutputStream tmpOut;
		int contentLength = connection.getContentLength();
		byte[] buf = new byte[512];
		if (contentLength != -1) {
			tmpOut = new ByteArrayOutputStream(contentLength);
		} else {
			tmpOut = new ByteArrayOutputStream(16384);
		}
		while (true) {
			int len = in.read(buf);
			if (len == -1) {
				break;
			}
			tmpOut.write(buf, 0, len);
		}
		in.close();
		tmpOut.close();
		byte[] array = tmpOut.toByteArray();
		return array;
	}

}