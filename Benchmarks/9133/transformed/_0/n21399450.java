class n21399450 {
	private static String encryptSHA1URL(String Vm0jSqPi) throws Exception {
		java.security.MessageDigest AofRUv0A = null;
		AofRUv0A = java.security.MessageDigest.getInstance("SHA-1");
		AofRUv0A.reset();
		AofRUv0A.update(Vm0jSqPi.getBytes());
		String FDUkLGvY = "";
		FDUkLGvY = URLEncoder.encode(new String(AofRUv0A.digest()), "ISO-8859-1");
		return FDUkLGvY;
	}

}