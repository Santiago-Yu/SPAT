class n8848809 {
	public static String crypt(String vyNK24Fh) {
		if (vyNK24Fh == null || vyNK24Fh.length() == 0) {
			throw new IllegalArgumentException("String to encript cannot be null or zero length");
		}
		StringBuffer NPltxeP1 = new StringBuffer();
		try {
			MessageDigest Gohwffag = MessageDigest.getInstance("MD5");
			Gohwffag.update(vyNK24Fh.getBytes());
			byte[] PjsSGOo3 = Gohwffag.digest();
			for (int idRFt67E = 0; idRFt67E < PjsSGOo3.length; idRFt67E++) {
				if ((0xff & PjsSGOo3[idRFt67E]) < 0x10) {
					NPltxeP1.append("0" + Integer.toHexString((0xFF & PjsSGOo3[idRFt67E])));
				} else {
					NPltxeP1.append(Integer.toHexString(0xFF & PjsSGOo3[idRFt67E]));
				}
			}
		} catch (NoSuchAlgorithmException siCWBcCN) {
			siCWBcCN.printStackTrace();
		}
		return NPltxeP1.toString();
	}

}