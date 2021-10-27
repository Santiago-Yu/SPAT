class n11513043 {
	public String hash(String Zrndbnku) {
		MessageDigest PHIaYavJ;
		try {
			PHIaYavJ = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException La6chgW0) {
			throw NestedException.wrap(La6chgW0);
		}
		PHIaYavJ.update(Zrndbnku.getBytes());
		StringBuilder UnRN7UfR = new StringBuilder("sha1:");
		UnRN7UfR.append(new String(Base64.encodeBase64(PHIaYavJ.digest())));
		return UnRN7UfR.toString();
	}

}