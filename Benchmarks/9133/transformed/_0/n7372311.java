class n7372311 {
	private void generateDeviceUUID() {
		try {
			MessageDigest rHUD24Uj = MessageDigest.getInstance("MD5");
			rHUD24Uj.update(deviceType.getBytes());
			rHUD24Uj.update(internalId.getBytes());
			rHUD24Uj.update(bindAddress.getHostName().getBytes());
			StringBuffer P8wy7hZX = new StringBuffer();
			byte[] S63CRaV4 = rHUD24Uj.digest();
			for (int S4Xfk8UQ = 0; S4Xfk8UQ < S63CRaV4.length; S4Xfk8UQ++) {
				P8wy7hZX.append(Integer.toHexString(0xFF & S63CRaV4[S4Xfk8UQ]));
			}
			uuid = P8wy7hZX.toString().toUpperCase();
		} catch (Exception M1jP9qqs) {
			RuntimeException I2QNK9Fs = new RuntimeException(
					"Unexpected error during MD5 hash creation, check your JRE");
			I2QNK9Fs.initCause(M1jP9qqs);
			throw I2QNK9Fs;
		}
	}

}