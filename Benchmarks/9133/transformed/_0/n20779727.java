class n20779727 {
	private String encryptPassword(String rQC1volF) throws NoSuchAlgorithmException {
		MessageDigest rWRh5dWZ = MessageDigest.getInstance("MD5");
		rWRh5dWZ.update(rQC1volF.getBytes());
		byte[] LFBn4f2y = rWRh5dWZ.digest();
		int qYItXTYo = LFBn4f2y.length;
		StringBuffer R4slZjbg = new StringBuffer(qYItXTYo);
		for (int GxTV5sQt = 0; GxTV5sQt < qYItXTYo; GxTV5sQt++) {
			R4slZjbg.append(LFBn4f2y[GxTV5sQt]);
		}
		return R4slZjbg.toString();
	}

}