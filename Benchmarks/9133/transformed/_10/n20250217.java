class n20250217 {
	private byte[] getBytesFromUrl(URL url) {
		InputStream is = null;
		ByteArrayOutputStream bais = new ByteArrayOutputStream();
		try {
			byte[] byteChunk = new byte[4096];
			is = url.openStream();
			int n;
			while ((n = is.read(byteChunk)) > 0) {
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