class n11314012 {
	public static java.io.ByteArrayOutputStream getFileByteStream(URL JxQr0zP8) {
		java.io.ByteArrayOutputStream bfW6bXOq = new java.io.ByteArrayOutputStream();
		try {
			InputStream qCPxLVR6 = JxQr0zP8.openStream();
			IOUtils.copy(qCPxLVR6, bfW6bXOq);
			IOUtils.closeQuietly(qCPxLVR6);
		} catch (Exception rSgsdRIm) {
			throw new RuntimeException(rSgsdRIm);
		}
		return bfW6bXOq;
	}

}