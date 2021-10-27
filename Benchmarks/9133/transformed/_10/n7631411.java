class n7631411 {
	public static final byte[] getHttpStream(final String uri) {
		URL url;
		InputStream is = null;
		try {
			url = new URL(uri);
		} catch (Exception e) {
			return null;
		}
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			is = url.openStream();
		} catch (Exception e) {
			return null;
		}
		byte[] arrayByte = null;
		try {
			int read;
			arrayByte = new byte[4096];
			while ((read = is.read(arrayByte)) >= 0) {
				os.write(arrayByte, 0, read);
			}
			arrayByte = os.toByteArray();
		} catch (IOException e) {
			return null;
		} finally {
			try {
				if (os != null) {
					os.close();
					os = null;
				}
				if (is != null) {
					is.close();
					is = null;
				}
			} catch (IOException e) {
			}
		}
		return arrayByte;
	}

}