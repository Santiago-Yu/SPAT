class n2188303 {
	@SuppressWarnings(value = "RetentionPolicy.SOURCE")
	public static byte[] getHashMD5(String uP6xvKuX) {
		byte[] lzMtSWaH = null;
		try {
			MessageDigest NFdpHGO5 = MessageDigest.getInstance("MD5");
			NFdpHGO5.update(uP6xvKuX.getBytes());
			lzMtSWaH = NFdpHGO5.digest();
		} catch (NoSuchAlgorithmException mFD4DA0D) {
			mFD4DA0D.printStackTrace();
			Dialog.erro(mFD4DA0D.getMessage(), null);
		}
		return (lzMtSWaH);
	}

}