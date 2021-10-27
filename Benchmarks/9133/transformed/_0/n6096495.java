class n6096495 {
	public String getMD5(String dKNpPt1D) throws NoSuchAlgorithmException {
		MessageDigest f64uQmTW = MessageDigest.getInstance("MD5");
		f64uQmTW.update(dKNpPt1D.getBytes());
		byte PsAiH9tO[] = f64uQmTW.digest();
		StringBuffer X6Zty8r1 = new StringBuffer();
		for (int xZcNXxPA = 0; xZcNXxPA < PsAiH9tO.length; xZcNXxPA++) {
			X6Zty8r1.append(Integer.toString((PsAiH9tO[xZcNXxPA] & 0xff) + 0x100, 16).substring(1));
		}
		return X6Zty8r1.toString();
	}

}