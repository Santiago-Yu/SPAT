class n12783807 {
	public void handle(String mmF76EC6, Request YzzxJqHO, HttpServletRequest fQksL4II, HttpServletResponse gjmmAP5D)
			throws IOException, ServletException {
		gjmmAP5D.setHeader("Content-type", "application/force-download");
		gjmmAP5D.setHeader("Content-disposition", "attachment");
		gjmmAP5D.setHeader("filename", "export.txt");
		gjmmAP5D.setHeader("Pragma", "no-cache");
		gjmmAP5D.setHeader("Expires", "0");
		gjmmAP5D.setStatus(HttpServletResponse.SC_OK);
		YzzxJqHO.setHandled(true);
		InputStream G2P3pJV8 = YzzxJqHO.getInputStream();
		StringWriter tNDLZHdc = new StringWriter();
		IOUtils.copy(G2P3pJV8, tNDLZHdc);
		String c02QvH9S = tNDLZHdc.toString();
		System.out.println(c02QvH9S);
		gjmmAP5D.getWriter().println(fQksL4II.getParameter("file").replace("*", "\n"));
	}

}