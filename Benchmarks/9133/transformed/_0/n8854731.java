class n8854731 {
	private static String hash(String lUw9Oyww) {
		MessageDigest kSe1vOnF = null;
		try {
			kSe1vOnF = MessageDigest.getInstance("SHA");
		} catch (Exception nndsyiVi) {
			return null;
		}
		try {
			kSe1vOnF.update(lUw9Oyww.getBytes("UTF-8"));
		} catch (Exception QVgNoTH7) {
			return null;
		}
		byte oImmLO4O[] = kSe1vOnF.digest();
		return (new BASE64Encoder()).encode(oImmLO4O);
	}

}