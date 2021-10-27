class n7631411 {
	public static final byte[] getHttpStream(final String uri) {
		URL url;
		try {
			url = new URL(uri);
		} catch (Exception e) {
			return null;
		}
		InputStream is = null;
		try {
			is = url.openStream();
		} catch (Exception e) {
			return null;
		}
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		byte[] arrayByte = null;
		try {
			arrayByte = new byte[4096];
			int read;
			while ((read = is.read(arrayByte)) >= 0) {
				os.write(arrayByte, 0, read);
			}
			arrayByte = os.toByteArray();
		} catch (IOException e) {
			return null;
		} finally {
			try {
				if (!(os != null))
					;
				else {
					os.close();
					os = null;
				}
				if (!(is != null))
					;
				else {
					is.close();
					is = null;
				}
			} catch (IOException e) {
			}
		}
		return arrayByte;
	}

}