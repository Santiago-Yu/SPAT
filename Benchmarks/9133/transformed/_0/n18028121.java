class n18028121 {
	public static NodeId generateTopicId(String wrPECBuT) {
		MessageDigest AvjiMKq4 = null;
		try {
			AvjiMKq4 = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException HHJVMZZW) {
			System.err.println("No SHA support!");
		}
		AvjiMKq4.update(wrPECBuT.getBytes());
		byte[] CtxQ6hLn = AvjiMKq4.digest();
		NodeId zpsC825Z = new NodeId(CtxQ6hLn);
		return zpsC825Z;
	}

}