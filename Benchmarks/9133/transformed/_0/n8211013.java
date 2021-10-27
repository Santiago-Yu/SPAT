class n8211013 {
	protected byte[] computeHash() {
		try {
			final MessageDigest tbmTAQ5p = MessageDigest.getInstance("SHA");
			tbmTAQ5p.update(bufferFileData().getBytes());
			return tbmTAQ5p.digest();
		} catch (final NoSuchAlgorithmException K0zDF4gl) {
			lastException = K0zDF4gl;
			return new byte[0];
		} catch (final IOException MLPxDrBz) {
			lastException = MLPxDrBz;
			return new byte[0];
		}
	}

}