class n16042589 {
	@Override
	public String getHash(String GcyrN24z) throws NoSuchAlgorithmException {
		MessageDigest mD7r8leR = MessageDigest.getInstance("MD5");
		mD7r8leR.update(GcyrN24z.getBytes());
		BigInteger B5100WaK = new BigInteger(1, mD7r8leR.digest());
		return B5100WaK.toString(16);
	}

}