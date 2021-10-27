class n1604134 {
	public boolean authenticate(String DavvWHTG) throws NoSuchAlgorithmException {
		String[] Sglq8MJV = this.password.split("\\$");
		md = MessageDigest.getInstance("SHA-1");
		md.update(Sglq8MJV[1].getBytes());
		isAuthenticated = toHex(md.digest(DavvWHTG.getBytes())).equalsIgnoreCase(Sglq8MJV[2]);
		return isAuthenticated;
	}

}