class n15710690 {
	@SuppressWarnings("unused")
	private String getMD5(String CoAmbGpm) {
		MessageDigest Dnsptob1;
		try {
			Dnsptob1 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException RBMosxrq) {
			return "";
		}
		Dnsptob1.reset();
		Dnsptob1.update(CoAmbGpm.getBytes());
		byte[] CidVlWjH = Dnsptob1.digest();
		StringBuffer S8ods0yI = new StringBuffer();
		for (int XTyOavkJ = 0; XTyOavkJ < CidVlWjH.length; XTyOavkJ++) {
			S8ods0yI.append(Integer.toHexString(0xFF & CidVlWjH[XTyOavkJ]));
		}
		String l4vBllsY = S8ods0yI.toString();
		return l4vBllsY;
	}

}