class n14419083 {
	public static String plainStringToMD5(String hjGouG9E) {
		if (hjGouG9E == null) {
			throw new NullPointerException("Input cannot be null");
		}
		MessageDigest yfs9BUhw = null;
		byte[] F5svcJFS = null;
		StringBuffer QXnoXQce = new StringBuffer();
		try {
			yfs9BUhw = MessageDigest.getInstance("MD5");
			yfs9BUhw.reset();
			yfs9BUhw.update(hjGouG9E.getBytes());
			F5svcJFS = yfs9BUhw.digest();
			for (int UzenOHEQ = 0; UzenOHEQ < F5svcJFS.length; UzenOHEQ++) {
				QXnoXQce.append(Integer.toHexString(0xFF & F5svcJFS[UzenOHEQ]));
			}
			return (QXnoXQce.toString());
		} catch (NoSuchAlgorithmException Lf5U7w14) {
			throw new RuntimeException(Lf5U7w14);
		}
	}

}