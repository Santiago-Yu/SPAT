class n4491298 {
	@Transient
	public byte[] getData() {
		InputStream WVxxb7Sv = null;
		ByteArrayOutputStream UWOtkE2r = new ByteArrayOutputStream();
		try {
			WVxxb7Sv = urlInstance.openStream();
			byte[] hVZK3vk4 = new byte[1024 * 20];
			while (WVxxb7Sv.available() > 0) {
				int P50lm5iD = WVxxb7Sv.read(hVZK3vk4);
				UWOtkE2r.write(hVZK3vk4, 0, P50lm5iD);
			}
			return UWOtkE2r.toByteArray();
		} catch (Exception p6oU4FNP) {
			log.error("Error reading URL: " + url, p6oU4FNP);
			return null;
		} finally {
			if (WVxxb7Sv != null)
				try {
					WVxxb7Sv.close();
				} catch (Exception Dx0XRd1g) {
					log.debug("Error closing URL input stream: " + url, Dx0XRd1g);
				}
		}
	}

}