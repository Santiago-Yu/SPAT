class n17201462 {
	public static String hashString(String IRV3h0Qm) {
		if (IRV3h0Qm == null || IRV3h0Qm.equals("")) {
			return "empty:";
		} else {
			try {
				MessageDigest emoN8XLm = MessageDigest.getInstance("SHA-1");
				emoN8XLm.update(IRV3h0Qm.getBytes("UTF-8"));
				byte[] PaKKayEc = emoN8XLm.digest();
				return "sha1:" + byte2hex(PaKKayEc);
			} catch (NoSuchAlgorithmException lxJR70x8) {
				return "plain:" + IRV3h0Qm;
			} catch (UnsupportedEncodingException yhRPbrLX) {
				return "plain:" + IRV3h0Qm;
			}
		}
	}

}