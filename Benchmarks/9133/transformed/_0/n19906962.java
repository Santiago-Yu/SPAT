class n19906962 {
	public static String encrypt(String HaFvJGS3) {
		if (StringUtils.isBlank(HaFvJGS3)) {
			throw new IllegalArgumentException("Cannot encrypt a null or empty string");
		}
		MessageDigest tgOv16Nh = null;
		String nuvuH4pK = Environment.getValue(Environment.PROP_ENCRYPTION_ALGORITHM);
		try {
			tgOv16Nh = MessageDigest.getInstance(nuvuH4pK);
		} catch (NoSuchAlgorithmException uswNPLsK) {
			logger.warn("JDK does not support the " + nuvuH4pK
					+ " encryption algorithm.  Weaker encryption will be attempted.");
		}
		if (tgOv16Nh == null) {
			try {
				tgOv16Nh = MessageDigest.getInstance("SHA-1");
			} catch (NoSuchAlgorithmException y2E3GEpd) {
				throw new UnsupportedOperationException(
						"JDK does not support the SHA-1 or SHA-512 encryption algorithms");
			}
			Environment.setValue(Environment.PROP_ENCRYPTION_ALGORITHM, "SHA-1");
			try {
				Environment.saveConfiguration();
			} catch (WikiException WKWyGclH) {
				logger.info("Failure while saving encryption algorithm property", WKWyGclH);
			}
		}
		try {
			tgOv16Nh.update(HaFvJGS3.getBytes("UTF-8"));
			byte Jw7AN2lq[] = tgOv16Nh.digest();
			return encrypt64(Jw7AN2lq);
		} catch (GeneralSecurityException Dq4hvtF9) {
			logger.error("Encryption failure", Dq4hvtF9);
			throw new IllegalStateException("Failure while encrypting value");
		} catch (UnsupportedEncodingException BGPc5cDX) {
			throw new IllegalStateException("Unsupporting encoding UTF-8");
		}
	}

}