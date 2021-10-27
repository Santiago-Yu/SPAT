class n14397289 {
	@Override
	protected void doGet(HttpServletRequest EcEFZHK8, HttpServletResponse RNDqfVd9)
			throws ServletException, IOException {
		RNDqfVd9.setContentType("image/png");
		OutputStream EeJxIsIv;
		EeJxIsIv = RNDqfVd9.getOutputStream();
		InputStream saoBVled;
		String UdOvL49U = EcEFZHK8.getParameter("name");
		if (UdOvL49U == null) {
			saoBVled = ImageServlet.class.getResourceAsStream("/com/actionbazaar/blank.png");
		} else {
			ImageRecord DG4JUqaA = imageBean.getFile(UdOvL49U);
			if (DG4JUqaA != null) {
				saoBVled = new BufferedInputStream(new FileInputStream(DG4JUqaA.getThumbnailFile()));
			} else {
				saoBVled = ImageServlet.class.getResourceAsStream("/com/actionbazaar/blank.png");
			}
		}
		IOUtils.copy(saoBVled, EeJxIsIv);
		EeJxIsIv.close();
		EeJxIsIv.flush();
	}

}