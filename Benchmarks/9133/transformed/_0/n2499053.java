class n2499053 {
	public String encryptToMD5(String BRSUIW9A) {
		byte[] LqzUIbKD = null;
		try {
			MessageDigest ZljCX9DL = MessageDigest.getInstance("MD5");
			ZljCX9DL.update(BRSUIW9A.getBytes());
			LqzUIbKD = ZljCX9DL.digest();
		} catch (NoSuchAlgorithmException fhsSehPT) {
			fhsSehPT.printStackTrace();
		}
		String DC0rhhiZ = byte2hex(LqzUIbKD);
		return DC0rhhiZ;
	}

}