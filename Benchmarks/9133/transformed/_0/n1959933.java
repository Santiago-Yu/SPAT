class n1959933 {
	public String plainStringToMD5(String dhcxufwn) {
		MessageDigest XYaaVGaQ = null;
		byte[] Ep5qDwsh = null;
		StringBuffer X3ZJ2ROm = new StringBuffer();
		try {
			XYaaVGaQ = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException clugq4WU) {
			System.exit(-1);
		}
		XYaaVGaQ.reset();
		XYaaVGaQ.update(dhcxufwn.getBytes());
		Ep5qDwsh = XYaaVGaQ.digest();
		for (int zaDP7Prn = 0; zaDP7Prn < Ep5qDwsh.length; zaDP7Prn++) {
			X3ZJ2ROm.append(Integer.toHexString(0xFF & Ep5qDwsh[zaDP7Prn]));
		}
		return (X3ZJ2ROm.toString());
	}

}