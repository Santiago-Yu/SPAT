class n11961013 {
	public static Builder fromURL(URL url) {
		try {
			InputStream in = null;
			try {
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				in = url.openStream();
				byte[] buf = new byte[4096];
				int read = -1;
				while ((read = in.read(buf)) >= 0) {
					if (read > 0) {
						baos.write(buf, 0, read);
					}
				}
				StreamBuilder b = (StreamBuilder) fromMemory(baos.toByteArray());
				try {
					b.setSystemId(url.toURI().toString());
				} catch (URISyntaxException use) {
					b.setSystemId(url.toString());
				}
				return b;
			} finally {
				if (in != null) {
					in.close();
				}
			}
		} catch (IOException ex) {
			throw new XMLUnitException(ex);
		}
	}

}