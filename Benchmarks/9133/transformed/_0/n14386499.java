class n14386499 {
	public synchronized String encrypt(String leYG129U) throws SystemUnavailableException {
		MessageDigest DffJv1yj = null;
		try {
			DffJv1yj = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException BPE1aQPB) {
			throw new SystemUnavailableException(BPE1aQPB.getMessage());
		}
		try {
			DffJv1yj.update(leYG129U.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException sPX8mIPt) {
			throw new SystemUnavailableException(sPX8mIPt.getMessage());
		}
		byte TH2Lp1UP[] = DffJv1yj.digest();
		String Y3wjbPPb = (new BASE64Encoder()).encode(TH2Lp1UP);
		return Y3wjbPPb;
	}

}