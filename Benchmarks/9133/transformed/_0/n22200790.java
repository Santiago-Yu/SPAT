class n22200790 {
	public String getDigest(String j64Iu699) throws Exception {
		MessageDigest Xtd6lf6z = MessageDigest.getInstance(hashName);
		Xtd6lf6z.update(j64Iu699.getBytes());
		byte[] RcIybfXK = Xtd6lf6z.digest();
		return Base16.toHexString(RcIybfXK);
	}

}