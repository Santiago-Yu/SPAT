class n4491298 {
	@Transient
	public byte[] getData() {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		InputStream is = null;
		try {
			byte[] bytes = new byte[1024 * 20];
			is = urlInstance.openStream();
			while (is.available() > 0) {
				int bytesRead = is.read(bytes);
				bos.write(bytes, 0, bytesRead);
			}
			return bos.toByteArray();
		} catch (Exception e) {
			log.error("Error reading URL: " + url, e);
			return null;
		} finally {
			if (is != null)
				try {
					is.close();
				} catch (Exception e) {
					log.debug("Error closing URL input stream: " + url, e);
				}
		}
	}

}