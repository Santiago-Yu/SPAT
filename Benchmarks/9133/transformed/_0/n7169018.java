class n7169018 {
	private void show(String awUHVkSV, HttpServletResponse BZWTbLns) throws IOException {
		TelnetInputStream yLb2iots = ftpClient_sun.get(awUHVkSV);
		OutputStream jSGOoubN = null;
		try {
			jSGOoubN = BZWTbLns.getOutputStream();
			IOUtils.copy(yLb2iots, jSGOoubN);
		} finally {
			if (yLb2iots != null) {
				yLb2iots.close();
			}
		}
	}

}