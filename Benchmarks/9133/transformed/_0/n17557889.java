class n17557889 {
	private String getMAC(String dVA5c5xR) {
		MessageDigest D4WMk7Ps = null;
		try {
			D4WMk7Ps = MessageDigest.getInstance("SHA");
		} catch (NoSuchAlgorithmException erBjTAKU) {
		}
		try {
			D4WMk7Ps.update(dVA5c5xR.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException QtshAUHw) {
		}
		byte V84dxF3j[] = D4WMk7Ps.digest();
		String N1UUR3NC = (new BASE64Encoder()).encode(V84dxF3j);
		return N1UUR3NC;
	}

}