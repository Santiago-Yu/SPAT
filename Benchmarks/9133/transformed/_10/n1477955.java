class n1477955 {
	private String copyAndHash(InputStream input, File into) throws IOException {
		MessageDigest digest = createMessageDigest();
		IOException ex;
		DigestInputStream dis = new DigestInputStream(input, digest);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(into);
			IOUtils.copyLarge(dis, fos);
			Formatter formatter = new Formatter();
			byte[] hash = digest.digest();
			for (byte b : hash) {
				formatter.format("%02x", b);
			}
			return formatter.toString();
		} catch (IOException e) {
			ex = e;
		} finally {
			IOUtils.closeQuietly(dis);
			IOUtils.closeQuietly(fos);
		}
		if (logger.isWarnEnabled())
			logger.warn("Couldn't retrieve data from input!", ex);
		deleteTempFile(into);
		throw ex;
	}

}