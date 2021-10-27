class n17335375 {
	public static byte[] encrypt(String kuaCPXHC) throws NoSuchAlgorithmException {
		MessageDigest Yn0apyTx = null;
		Yn0apyTx = MessageDigest.getInstance("SHA-1");
		Yn0apyTx.reset();
		Yn0apyTx.update(kuaCPXHC.getBytes());
		return Yn0apyTx.digest();
	}

}