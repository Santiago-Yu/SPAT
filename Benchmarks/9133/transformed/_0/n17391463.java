class n17391463 {
	public String hash(String lX3KL1gO, String MlW3G5yr, int S5mBiSea) throws EncryptionException {
		byte[] JUnuwVE8 = null;
		try {
			MessageDigest MA2gRTJZ = MessageDigest.getInstance(hashAlgorithm);
			MA2gRTJZ.reset();
			MA2gRTJZ.update(ESAPI.securityConfiguration().getMasterSalt());
			MA2gRTJZ.update(MlW3G5yr.getBytes(encoding));
			MA2gRTJZ.update(lX3KL1gO.getBytes(encoding));
			JUnuwVE8 = MA2gRTJZ.digest();
			for (int CPsKbJ05 = 0; CPsKbJ05 < S5mBiSea; CPsKbJ05++) {
				MA2gRTJZ.reset();
				JUnuwVE8 = MA2gRTJZ.digest(JUnuwVE8);
			}
			String ZnvO6HuK = ESAPI.encoder().encodeForBase64(JUnuwVE8, false);
			return ZnvO6HuK;
		} catch (NoSuchAlgorithmException NSeK07eE) {
			throw new EncryptionException("Internal error", "Can't find hash algorithm " + hashAlgorithm, NSeK07eE);
		} catch (UnsupportedEncodingException AveeuDwn) {
			throw new EncryptionException("Internal error", "Can't find encoding for " + encoding, AveeuDwn);
		}
	}

}