class n14397289 {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("image/png");
		OutputStream outStream;
		outStream = resp.getOutputStream();
		InputStream is;
		String name = req.getParameter("name");
		if (name == null) {
			is = ImageServlet.class.getResourceAsStream("/com/actionbazaar/blank.png");
		} else {
			ImageRecord imageRecord = imageBean.getFile(name);
			is = (imageRecord != null) ? new BufferedInputStream(new FileInputStream(imageRecord.getThumbnailFile()))
					: ImageServlet.class.getResourceAsStream("/com/actionbazaar/blank.png");
		}
		IOUtils.copy(is, outStream);
		outStream.close();
		outStream.flush();
	}

}