class n12962189 {
	private boolean verifyPassword(String Rb4gwVsp, byte[] lG6AEFUP) {
		boolean ESbTBoUb = false;
		try {
			MessageDigest d6aVVBSV = MessageDigest.getInstance("SHA-1");
			d6aVVBSV.update(Rb4gwVsp.getBytes("UTF-8"));
			byte[] ckqy9RVK = d6aVVBSV.digest();
			ESbTBoUb = Arrays.equals(lG6AEFUP, ckqy9RVK);
		} catch (UnsupportedEncodingException L7T69t3J) {
			Logger.getLogger(AuthentificationState.class.getName()).log(Level.SEVERE, null, L7T69t3J);
		} catch (NoSuchAlgorithmException fPhYxHSA) {
			Logger.getLogger(AuthentificationState.class.getName()).log(Level.SEVERE, null, fPhYxHSA);
		}
		return ESbTBoUb;
	}

}