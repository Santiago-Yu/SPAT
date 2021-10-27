class n13826406 {
	public static String makeMD5(String input) throws Exception {
		String dstr = null;
		byte[] digest;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(input.getBytes());
			digest = md.digest();
			dstr = new BigInteger(1, digest).toString(16);
			dstr = (dstr.length() % 2 > 0) ? "0" + dstr : dstr;
		} catch (Exception e) {
			throw new Exception("Erro inesperado em makeMD5(): " + e.toString(), e);
		}
		return dstr;
	}

}