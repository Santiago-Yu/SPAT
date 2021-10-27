class n23535752 {
	public String getCipherString(String XUUlCREk) throws CadenaNoCifradaException {
		String SLomQGYA = null;
		MessageDigest vskhJ66Q;
		try {
			vskhJ66Q = MessageDigest.getInstance("SHA-1");
			byte[] cMv6zg4Z = new byte[40];
			vskhJ66Q.update(XUUlCREk.getBytes(encoding), 0, XUUlCREk.length());
			cMv6zg4Z = vskhJ66Q.digest();
			SLomQGYA = convertToHex(cMv6zg4Z);
		} catch (Exception EJp4hcwf) {
			throw new CadenaNoCifradaException(EJp4hcwf);
		}
		return SLomQGYA;
	}

}