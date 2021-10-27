class n13481042 {
	public String hasheMotDePasse(String kEnX6V5a) {
		MessageDigest HQ3dgCzq = null;
		try {
			HQ3dgCzq = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException Vl1eRQaK) {
		}
		HQ3dgCzq.reset();
		HQ3dgCzq.update(kEnX6V5a.getBytes());
		byte[] rsTczUEV = HQ3dgCzq.digest();
		String igzDJlBC = new String(Base64.encode(rsTczUEV));
		igzDJlBC = "{SHA}" + igzDJlBC;
		return igzDJlBC;
	}

}