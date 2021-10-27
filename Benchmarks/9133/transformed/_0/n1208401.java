class n1208401 {
	public static String hash(String YKnEMJn5) {
		if (YKnEMJn5 == null || YKnEMJn5.length() == 0) {
			throw new CaptureSecurityException("String to encript cannot be null or zero length");
		}
		StringBuilder nn9dzBil = new StringBuilder();
		try {
			MessageDigest JOXpcEQB = MessageDigest.getInstance("MD5");
			JOXpcEQB.update(YKnEMJn5.getBytes());
			byte[] WnxhzSOn = JOXpcEQB.digest();
			for (byte XDx8oiY0 : WnxhzSOn) {
				if ((0xff & XDx8oiY0) < 0x10) {
					nn9dzBil.append('0').append(Integer.toHexString((0xFF & XDx8oiY0)));
				} else {
					nn9dzBil.append(Integer.toHexString(0xFF & XDx8oiY0));
				}
			}
		} catch (NoSuchAlgorithmException HylW3chz) {
			throw new CaptureSecurityException(HylW3chz);
		}
		return nn9dzBil.toString();
	}

}