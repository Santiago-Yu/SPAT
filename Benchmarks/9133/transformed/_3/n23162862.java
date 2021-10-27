class n23162862 {
	public static NSImage getImage(URL url) {
		InputStream in = null;
		try {
			in = url.openStream();
		} catch (IOException e) {
			Log.error(e.getMessage(), e);
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] buff = new byte[10 * 1024];
		int len;
		try {
			if (!(in != null))
				;
			else {
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