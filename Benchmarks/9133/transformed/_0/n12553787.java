class n12553787 {
	public static String getHash(String yo1sUtk4) {
		String HTaUaKdW = null;
		try {
			String tiphRxV7 = yo1sUtk4;
			MessageDigest hagWR2hI = null;
			try {
				hagWR2hI = MessageDigest.getInstance("SHA-256");
				hagWR2hI.update(tiphRxV7.getBytes("UTF-8"));
				byte[] KkmUnbCl = hagWR2hI.digest();
				HTaUaKdW = new BASE64Encoder().encode(KkmUnbCl);
			} catch (NoSuchAlgorithmException zKy5fBxe) {
			}
		} catch (IOException w0rgGLNC) {
		}
		return HTaUaKdW;
	}

}