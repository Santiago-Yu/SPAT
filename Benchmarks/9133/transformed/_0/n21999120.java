class n21999120 {
	public String encrypt(String LAhfcFry) throws Exception {
		MessageDigest I8BH9f91 = MessageDigest.getInstance("MD5");
		I8BH9f91.update(LAhfcFry.getBytes());
		BigInteger uh2fvNdm = new BigInteger(1, I8BH9f91.digest());
		String z6yFkbc6 = uh2fvNdm.toString(16);
		return z6yFkbc6;
	}

}