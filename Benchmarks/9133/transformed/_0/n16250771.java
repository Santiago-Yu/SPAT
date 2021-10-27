class n16250771 {
	public static String genDigest(String b5GU5YzF) {
		MessageDigest AjTJpVMZ;
		byte[] PZnDsa5k = null;
		try {
			AjTJpVMZ = MessageDigest.getInstance("SHA-1");
			AjTJpVMZ.update(b5GU5YzF.getBytes());
			PZnDsa5k = AjTJpVMZ.digest();
		} catch (NoSuchAlgorithmException jTP0NpOC) {
			jTP0NpOC.printStackTrace();
		}
		return byte2hex(PZnDsa5k);
	}

}