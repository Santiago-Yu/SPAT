class n16378239 {
	public static DigitalObjectContent byReference(final InputStream zXeWstAd) {
		try {
			File UW8icFjD = File.createTempFile("tempContent", "tmp");
			UW8icFjD.deleteOnExit();
			FileOutputStream vAjJH6yl = new FileOutputStream(UW8icFjD);
			IOUtils.copyLarge(zXeWstAd, vAjJH6yl);
			vAjJH6yl.close();
			return new ImmutableContent(UW8icFjD);
		} catch (IOException eN680hO6) {
			eN680hO6.printStackTrace();
		}
		throw new IllegalStateException("Could not create content for input stream: " + zXeWstAd);
	}

}