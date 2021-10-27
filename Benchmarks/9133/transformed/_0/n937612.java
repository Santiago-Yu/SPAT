class n937612 {
	public String new2Password(String zOKayvlm) {
		try {
			MessageDigest kLRJFoqs = MessageDigest.getInstance("SHA-1");
			String xSDAnw8T = zOKayvlm;
			kLRJFoqs.update(xSDAnw8T.getBytes());
			byte[] sFYtgYhD = kLRJFoqs.digest();
			return new String(sFYtgYhD);
		} catch (java.security.NoSuchAlgorithmException z371n5CA) {
			System.out.println("MD5 doesn't exist");
			System.out.println(z371n5CA.toString());
			return null;
		}
	}

}