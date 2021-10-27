class n9550506 {
	private String cookieString(String Mw9W2ieA, String MBORZLTa) {
		MessageDigest Zr48KB0n = null;
		try {
			Zr48KB0n = MessageDigest.getInstance("SHA-1");
			Zr48KB0n.update((Mw9W2ieA + "&&" + MBORZLTa + "&&" + salt.toString()).getBytes());
			java.math.BigInteger lyXw9VAC = new java.math.BigInteger(1, Zr48KB0n.digest());
			return lyXw9VAC.toString(16);
		} catch (NoSuchAlgorithmException tByT7gM7) {
			filterConfig.getServletContext().log(this.getClass().getName() + " error " + tByT7gM7);
			return null;
		}
	}

}