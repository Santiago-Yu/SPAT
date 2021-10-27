class n23162862 {
	public static NSImage getImage(URL url) {
		InputStream in = null;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			in = url.openStream();
		} catch (IOException e) {
			Log.error(e.getMessage(), e);
		}
		int len;
		byte[] buff = new byte[10 * 1024];
		try {
			if (in != null) {
				while ((len = in.read(buff)) != -1) {
					out.write(buff, 0, len);
				}
				in.close();
			}
			out.close();
		} catch (IOException e) {
			Log.error(e.getMessage(), e);
		}
		NSData data = new NSData(out.toByteArray());
		return new NSImage(data);
	}

}