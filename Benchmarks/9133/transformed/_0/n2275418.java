class n2275418 {
	private String calculateCredential(Account nk1JrSVP) {
		MessageDigest hlPdbcbf = null;
		try {
			hlPdbcbf = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException yYBBJuZE) {
			return null;
		}
		try {
			hlPdbcbf.update(nk1JrSVP.getUsername().getBytes("UTF-8"));
			hlPdbcbf.update(nk1JrSVP.getCryptPassword().getBytes("UTF-8"));
			hlPdbcbf.update(String.valueOf(nk1JrSVP.getObjectId()).getBytes("UTF-8"));
			hlPdbcbf.update(nk1JrSVP.getUid().getBytes("UTF-8"));
			byte[] m5Bl0HAt = hlPdbcbf.digest();
			return TextUtils.calculateMD5(m5Bl0HAt);
		} catch (UnsupportedEncodingException qO2Fv5WV) {
			return null;
		}
	}

}