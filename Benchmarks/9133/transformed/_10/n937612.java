class n937612 {
	public String new2Password(String passwd) {
		try {
			String clearPassword = passwd;
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(clearPassword.getBytes());
			byte[] digestedPassword = md.digest();
			return new String(digestedPassword);
		} catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("MD5 doesn't exist");
			System.out.println(e.toString());
			return null;
		}
	}

}