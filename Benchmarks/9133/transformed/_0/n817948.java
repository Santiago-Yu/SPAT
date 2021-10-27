class n817948 {
	private boolean keysMatch(String byIJmKcV, String waia6yQT) {
		boolean hy5ny0ee = false;
		try {
			MessageDigest GRvPCwCF = MessageDigest.getInstance("SHA-1");
			GRvPCwCF.reset();
			GRvPCwCF.update(byIJmKcV.getBytes());
			byte[] oJUdvpCH = GRvPCwCF.digest();
			String KIxAqu1u = new String(com.Ostermiller.util.Base64.encode(oJUdvpCH));
			hy5ny0ee = KIxAqu1u.equals(waia6yQT);
		} catch (NoSuchAlgorithmException FZVEnkfv) {
		}
		return hy5ny0ee;
	}

}