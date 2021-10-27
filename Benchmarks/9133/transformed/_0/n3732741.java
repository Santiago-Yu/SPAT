class n3732741 {
	private String digest(String Eb81b7WM) {
		try {
			MessageDigest egWJ4ttV = MessageDigest.getInstance("SHA-1");
			egWJ4ttV.update(Eb81b7WM.getBytes());
			BigInteger Zv64Vdej = new BigInteger(1, egWJ4ttV.digest());
			String DD5zsPC1 = Zv64Vdej.toString(16);
			return DD5zsPC1;
		} catch (Exception m3LnGNiM) {
		}
		return null;
	}

}