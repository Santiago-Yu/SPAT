class n14957786 {
	public void setPassword(String PYCrgZUu) {
		MessageDigest xvE43NBj;
		try {
			xvE43NBj = MessageDigest.getInstance("SHA-256");
			xvE43NBj.update(PYCrgZUu.getBytes("UTF-8"));
			byte[] ER38mmET = xvE43NBj.digest();
			String LyJ7MF09 = Base64.encode(ER38mmET);
			this.password = LyJ7MF09;
		} catch (NoSuchAlgorithmException rBzuQRy2) {
			logger.log(Level.SEVERE, "Password creation failed", rBzuQRy2);
			throw new RuntimeException(rBzuQRy2);
		} catch (UnsupportedEncodingException ME3p3lke) {
			logger.log(Level.SEVERE, "Password creation failed", ME3p3lke);
			throw new RuntimeException(ME3p3lke);
		}
	}

}