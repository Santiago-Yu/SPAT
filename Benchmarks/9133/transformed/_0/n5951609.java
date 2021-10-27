class n5951609 {
	public void testCryptHash() {
		Log.v("Test", "[*] testCryptHash()");
		String guf5rYZv = "Hash me";
		byte SxHEDZPz[];
		MessageDigest pQ6JvpJX = null;
		try {
			pQ6JvpJX = java.security.MessageDigest.getInstance("MD5");
			pQ6JvpJX.update(guf5rYZv.getBytes());
			SxHEDZPz = pQ6JvpJX.digest();
			pQ6JvpJX.digest(guf5rYZv.getBytes());
			pQ6JvpJX = java.security.MessageDigest.getInstance("SHA1");
			pQ6JvpJX.update(guf5rYZv.getBytes());
			SxHEDZPz = pQ6JvpJX.digest();
			pQ6JvpJX = null;
			pQ6JvpJX = java.security.MessageDigest.getInstance("SHA1");
			pQ6JvpJX.update(imei.getBytes());
			SxHEDZPz = pQ6JvpJX.digest();
			hashedImei = this.toHex(SxHEDZPz);
		} catch (NoSuchAlgorithmException kBmVjek0) {
			kBmVjek0.printStackTrace();
		}
	}

}