class n1889366 {
	public String hash(String hPn8z2J2) {
		MessageDigest v2C2qQrq = null;
		try {
			v2C2qQrq = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException QSBkzhh8) {
			log.info("No sha-256 available");
			try {
				v2C2qQrq = MessageDigest.getInstance("SHA-1");
			} catch (NoSuchAlgorithmException RWhe2zgV) {
				log.fatal("sha-1 is not available", RWhe2zgV);
				throw new RuntimeException("Couldn't get a hash algorithm from Java");
			}
		}
		try {
			v2C2qQrq.reset();
			v2C2qQrq.update((salt + hPn8z2J2).getBytes("UTF-8"));
			byte FEBQT4W1[] = v2C2qQrq.digest();
			return new String(Base64.encodeBase64(FEBQT4W1, false));
		} catch (Throwable OqGytB9k) {
			throw new RuntimeException("Couldn't hash password");
		}
	}

}