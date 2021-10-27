class n20250217 {
	private byte[] getBytesFromUrl(URL url) {
		ByteArrayOutputStream bais = new ByteArrayOutputStream();
		InputStream is = null;
		try {
			is = url.openStream();
			byte[] byteChunk = new byte[4096];
			int n;
			for (; (n = is.read(byteChunk)) > 0;) {
				bais.write(byteChunk, 0, n);
			}
		} catch (IOException e) {
			System.err.printf("Failed while reading bytes from %s: %s", url.toExternalForm(), e.getMessage());
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
				}
			}
		}
		return bais.toByteArray();
	}

}