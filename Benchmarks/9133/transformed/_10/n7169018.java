class n7169018 {
	private void show(String fileName, HttpServletResponse response) throws IOException {
		OutputStream out = null;
		TelnetInputStream ftpIn = ftpClient_sun.get(fileName);
		try {
			out = response.getOutputStream();
			IOUtils.copy(ftpIn, out);
		} finally {
			if (ftpIn != null) {
				ftpIn.close();
			}
		}
	}

}