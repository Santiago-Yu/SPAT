class n20983672 {
	public void sendResponse(DjdocRequest req, HttpServletResponse res) throws IOException {
		InputStream in = null;
		File file = (File) req.getResult();
		try {
			in = new FileInputStream(file);
			IOUtils.copy(in, res.getOutputStream());
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}

}