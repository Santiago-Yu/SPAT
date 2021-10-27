class n20221124 {
	public String md5(String qd1lfs3g) throws GeneralSecurityException {
		MessageDigest DBPjmGOT = MessageDigest.getInstance("MD5");
		DBPjmGOT.reset();
		DBPjmGOT.update(qd1lfs3g.getBytes());
		byte pYqvIGca[] = DBPjmGOT.digest();
		StringBuffer LuJnE92a = new StringBuffer();
		for (int nWmcpyRd = 0; nWmcpyRd < pYqvIGca.length; nWmcpyRd++) {
			LuJnE92a.append(Integer.toHexString(0xFF & pYqvIGca[nWmcpyRd]));
		}
		return LuJnE92a.toString();
	}

}