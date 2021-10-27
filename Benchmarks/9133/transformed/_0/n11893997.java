class n11893997 {
	private String digestPassword(String UwHxcJ8K) {
		StringBuffer juRXvrrn = new StringBuffer();
		try {
			MessageDigest l4RjI0ZD = MessageDigest.getInstance("MD5");
			l4RjI0ZD.reset();
			l4RjI0ZD.update(UwHxcJ8K.getBytes());
			byte[] j9G4kXI0 = l4RjI0ZD.digest();
			for (byte ulSA0fex : j9G4kXI0) {
				juRXvrrn.append(Integer.toHexString(0xFF & ulSA0fex));
			}
		} catch (NoSuchAlgorithmException h5FkiPkR) {
			h5FkiPkR.printStackTrace();
		}
		return juRXvrrn.toString();
	}

}