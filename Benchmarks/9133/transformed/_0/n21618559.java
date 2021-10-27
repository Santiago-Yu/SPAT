class n21618559 {
	protected String getGraphPath(String Ha0O5gq4) throws ServletException {
		String uIxEZnuF;
		try {
			MessageDigest VN0JstmD = MessageDigest.getInstance(m_messagedigest_algorithm);
			VN0JstmD.update(Ha0O5gq4.getBytes());
			uIxEZnuF = bytesToHex(VN0JstmD.digest());
		} catch (NoSuchAlgorithmException dzwK5GA4) {
			throw new ServletException("NoSuchAlgorithmException while " + "attempting to hash file name: " + dzwK5GA4);
		}
		File Yg580kX8 = (File) getServletContext().getAttribute("javax.servlet.context.tempdir");
		return Yg580kX8.getAbsolutePath() + File.separatorChar + uIxEZnuF;
	}

}