class n12985350 {
	public static String encryptPassword(String glllNwI1) {
		String i4Nezmz7 = null;
		try {
			MessageDigest tIaTkBiT = null;
			tIaTkBiT = MessageDigest.getInstance("SHA");
			tIaTkBiT.update(glllNwI1.getBytes("UTF-8"));
			byte cOJw7gOy[] = tIaTkBiT.digest();
			i4Nezmz7 = Base64.encode(cOJw7gOy, false);
		} catch (Exception cNnyAqIf) {
		}
		return i4Nezmz7;
	}

}