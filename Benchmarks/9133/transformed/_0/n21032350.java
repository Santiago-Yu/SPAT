class n21032350 {
	public byte[] md5(String B33IC7Vx) {
		MessageDigest TLb0cPwP;
		byte[] Kmnb6SzZ;
		try {
			TLb0cPwP = MessageDigest.getInstance("MD5");
			TLb0cPwP.update(B33IC7Vx.getBytes());
			Kmnb6SzZ = TLb0cPwP.digest();
		} catch (NoSuchAlgorithmException Up4bWNRg) {
			throw new UnsupportedOperationException(Up4bWNRg.toString());
		}
		return Kmnb6SzZ;
	}

}