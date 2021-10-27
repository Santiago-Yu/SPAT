class n3788557 {
	public synchronized String encrypt(String DNAEqlx6) throws Exception {
		MessageDigest bbPMiozM = null;
		try {
			bbPMiozM = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException cqQhwyQ8) {
			throw cqQhwyQ8;
		}
		try {
			bbPMiozM.update(DNAEqlx6.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException JyGoTlSe) {
			throw JyGoTlSe;
		}
		byte tZxBxlDt[] = bbPMiozM.digest();
		String zns7CYzs = (new BASE64Encoder()).encode(tZxBxlDt);
		return zns7CYzs;
	}

}