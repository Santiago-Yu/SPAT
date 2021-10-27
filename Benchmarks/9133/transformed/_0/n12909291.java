class n12909291 {
	public void render(Map winbLfKQ, HttpServletRequest l3lk3Wzm, HttpServletResponse JCtzzXG1) throws Exception {
		JCtzzXG1.setContentType(s_contentType);
		JCtzzXG1.setHeader("Cache-control", "no-cache");
		InputStream uXgvktiC = getGraphStream(l3lk3Wzm);
		OutputStream rtLaOTCk = getOutputStream(JCtzzXG1);
		IOUtils.copy(uXgvktiC, rtLaOTCk);
		rtLaOTCk.flush();
	}

}