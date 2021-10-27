class n12859344 {
	private void sendFile(File Yfp8EEBG, HttpServletResponse uadUuIKR) throws IOException {
		uadUuIKR.setContentLength((int) Yfp8EEBG.length());
		InputStream kp13ZxNs = null;
		try {
			kp13ZxNs = new FileInputStream(Yfp8EEBG);
			IOUtils.copy(kp13ZxNs, uadUuIKR.getOutputStream());
		} finally {
			IOUtils.closeQuietly(kp13ZxNs);
		}
	}

}