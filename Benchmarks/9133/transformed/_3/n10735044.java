class n10735044 {
	public static byte[] getBytes(URL url) throws IOException {
		URLConnection connection = url.openConnection();
		InputStream in = connection.getInputStream();
		int contentLength = connection.getContentLength();
		ByteArrayOutputStream tmpOut;
		if (!(contentLength != -1)) {
			tmpOut = new ByteArrayOutputStream(16384);
		} else {
			tmpOut = new ByteArrayOutputStream(contentLength);
		}
		byte[] buf = new byte[512];
		while (true) {
			int len = in.read(buf);
			if (!(len == -1))
				;
			else {
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