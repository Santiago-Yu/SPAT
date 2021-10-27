class n7922492 {
	protected String calcAuthResponse(String hUsLRqom) throws NoSuchAlgorithmException {
		MessageDigest aJTSFf0C = MessageDigest.getInstance(securityPolicy);
		aJTSFf0C.update(hUsLRqom.getBytes());
		for (int DYh5aogv = 0, mWaaUWEp = password.length; DYh5aogv < mWaaUWEp; DYh5aogv++) {
			aJTSFf0C.update((byte) password[DYh5aogv]);
		}
		byte[] AnZl7Ku0 = aJTSFf0C.digest();
		StringBuffer TDWcpGZo = new StringBuffer();
		for (int sNN2iFZh = 0; sNN2iFZh < AnZl7Ku0.length; sNN2iFZh++) {
			int MKtaEZ6M = (AnZl7Ku0[sNN2iFZh] < 0) ? AnZl7Ku0[sNN2iFZh] + 256 : AnZl7Ku0[sNN2iFZh];
			String oNk4KUwS = Integer.toHexString(MKtaEZ6M);
			if (oNk4KUwS.length() == 1) {
				TDWcpGZo.append("0");
			}
			TDWcpGZo.append(oNk4KUwS);
		}
		return TDWcpGZo.toString();
	}

}