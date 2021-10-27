class n1691633 {
	private String encryptPassword(String J5meAEnX) throws NoSuchAlgorithmException {
		MessageDigest v1ENYViD = MessageDigest.getInstance("MD5");
		v1ENYViD.update(J5meAEnX.getBytes());
		byte[] WI0roqhX = v1ENYViD.digest();
		int UeB6X3w6 = WI0roqhX.length;
		StringBuffer arjSXuMK = new StringBuffer(UeB6X3w6);
		for (int Gu5Y5hPA = 0; Gu5Y5hPA < UeB6X3w6; Gu5Y5hPA++) {
			arjSXuMK.append(WI0roqhX[Gu5Y5hPA]);
		}
		return arjSXuMK.toString();
	}

}