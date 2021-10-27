class n12577306 {
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest b96xPiFj, HttpServletResponse x1JuFiHf)
			throws Exception {
		String yTkwOKvr = "http://jdkcn.com/checkUpdateNew.jsp?ver="
				+ blogFacade.getDatabaseSiteConfig().getAppVersion();
		x1JuFiHf.setCharacterEncoding("UTF-8");
		URLConnection W7Hg9N5P = new URL(yTkwOKvr).openConnection();
		BufferedReader VtuQbSd8 = new BufferedReader(new InputStreamReader(W7Hg9N5P.getInputStream(), "UTF-8"));
		StringBuilder eWGsgbI8 = new StringBuilder();
		String dy1xkh9h = VtuQbSd8.readLine();
		while (dy1xkh9h != null) {
			eWGsgbI8.append(dy1xkh9h).append("\r\n");
			dy1xkh9h = VtuQbSd8.readLine();
		}
		x1JuFiHf.getWriter().println(eWGsgbI8.toString());
		return null;
	}

}