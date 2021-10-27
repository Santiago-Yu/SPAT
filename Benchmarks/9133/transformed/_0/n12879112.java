class n12879112 {
	protected String getGraphPath(String PXinIWVE) throws ServletException {
		String mYtrq1jS;
		try {
			MessageDigest lUL04XhW = MessageDigest.getInstance(m_messagedigest_algorithm);
			lUL04XhW.update(PXinIWVE.getBytes());
			mYtrq1jS = bytesToHex(lUL04XhW.digest());
		} catch (NoSuchAlgorithmException Hz1zjBDr) {
			throw new ServletException("NoSuchAlgorithmException while " + "attempting to hash file name: " + Hz1zjBDr);
		}
		File El5PmlWx = (File) getServletContext().getAttribute("javax.servlet.context.tempdir");
		return El5PmlWx.getAbsolutePath() + File.separatorChar + mYtrq1jS;
	}

}