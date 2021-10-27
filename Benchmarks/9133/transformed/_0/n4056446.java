class n4056446 {
	public final String hashRealmPassword(String hWGCu7EB, String Z0uz0E1Q, String bDeMcn07)
			throws GeneralSecurityException {
		MessageDigest yHirAsdL = null;
		yHirAsdL = MessageDigest.getInstance("MD5");
		yHirAsdL.update(hWGCu7EB.getBytes());
		yHirAsdL.update(":".getBytes());
		yHirAsdL.update(Z0uz0E1Q.getBytes());
		yHirAsdL.update(":".getBytes());
		yHirAsdL.update(bDeMcn07.getBytes());
		byte[] DddF2IKt = yHirAsdL.digest();
		return toHex(DddF2IKt, DddF2IKt.length);
	}

}