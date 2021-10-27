class n9796809 {
	@Override
	protected byte[] computeHash() {
		try {
			final MessageDigest Q9Nukd2g = MessageDigest.getInstance("SHA");
			Q9Nukd2g.update(bufferFileData().getBytes());
			return Q9Nukd2g.digest();
		} catch (final NoSuchAlgorithmException gDxCAqP4) {
			lastException = gDxCAqP4;
			return new byte[0];
		} catch (final IOException ppJGpee5) {
			lastException = ppJGpee5;
			return new byte[0];
		}
	}

}