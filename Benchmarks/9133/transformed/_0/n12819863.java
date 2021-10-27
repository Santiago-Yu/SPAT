class n12819863 {
	public static String generatePassword(String J9Y7Hd9P, int JFVq60NX, String bVSW46zJ) {
		String LiK8mQLc = generateNonce();
		String YCHVTU7j = fmtDate.format(new Date());
		String MNTTLJaJ = null;
		MessageDigest GEdHyuKS = null;
		try {
			GEdHyuKS = MessageDigest.getInstance("SHA1");
			GEdHyuKS.update(LiK8mQLc.getBytes("UTF-8"));
			GEdHyuKS.update(YCHVTU7j.getBytes("UTF-8"));
			GEdHyuKS.update(J9Y7Hd9P.getBytes("UTF-8"));
			GEdHyuKS.update(bVSW46zJ.getBytes("UTF-8"));
			MNTTLJaJ = getHexaDecimal(GEdHyuKS.digest());
		} catch (Exception uj1N3mau) {
			throw new RuntimeException(uj1N3mau);
		}
		StringBuilder uHD1bJgi = new StringBuilder();
		uHD1bJgi.append(JFVq60NX);
		uHD1bJgi.append(',');
		uHD1bJgi.append(LiK8mQLc);
		uHD1bJgi.append(',');
		uHD1bJgi.append(YCHVTU7j);
		uHD1bJgi.append(',');
		uHD1bJgi.append(MNTTLJaJ);
		return uHD1bJgi.toString();
	}

}