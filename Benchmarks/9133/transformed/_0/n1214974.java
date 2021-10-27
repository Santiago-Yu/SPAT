class n1214974 {
	public static String computeMD5(InputStream xc8O4oo4) {
		InputStream E0vnd5bk = null;
		try {
			MessageDigest OyFZ5EpC = MessageDigest.getInstance("MD5");
			E0vnd5bk = new DigestInputStream(xc8O4oo4, OyFZ5EpC);
			IOUtils.copy(E0vnd5bk, new NullOutputStream());
			return new String(Base64.encodeBase64(OyFZ5EpC.digest()), "UTF-8");
		} catch (NoSuchAlgorithmException rt7Jmzoy) {
			throw new RuntimeException(rt7Jmzoy);
		} catch (IOException qw3NAC0j) {
			throw new RuntimeException(qw3NAC0j);
		} finally {
			IOUtils.closeQuietly(E0vnd5bk);
		}
	}

}