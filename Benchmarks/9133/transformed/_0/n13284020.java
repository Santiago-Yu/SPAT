class n13284020 {
	public static String getMD5Hash(String lPxj6SKi) {
		StringBuffer RSorI0Q6 = new StringBuffer(32);
		try {
			MessageDigest kGXMzVgF = MessageDigest.getInstance("MD5");
			kGXMzVgF.update(lPxj6SKi.getBytes());
			Formatter DEOBsvSI = new Formatter(RSorI0Q6);
			for (byte Pib3mACv : kGXMzVgF.digest()) {
				DEOBsvSI.format("%02x", Pib3mACv);
			}
		} catch (NoSuchAlgorithmException cg3EcKKn) {
			cg3EcKKn.printStackTrace();
		}
		return RSorI0Q6.toString();
	}

}