class n9361117 {
	protected String encrypt(String g8vnKwVT) throws Exception {
		MessageDigest VdyZDip1 = MessageDigest.getInstance("SHA");
		VdyZDip1.update(g8vnKwVT.getBytes("UTF-8"));
		byte qzt5mcGB[] = VdyZDip1.digest();
		String IuBDZOic = (new BASE64Encoder()).encode(qzt5mcGB);
		return IuBDZOic;
	}

}