class n4519500 {
	@Override
	protected void doGet(HttpServletRequest ATNK6NUH, HttpServletResponse aq1FzPxz)
			throws ServletException, IOException {
		String Jhin7ww9 = ATNK6NUH.getPathInfo();
		String GZOyeoPF = Jhin7ww9.substring(prefix.length());
		String EJhOTviv = GZOyeoPF.substring(pluginKey.length() + 1);
		String mw8WHCWF = CLASSPATH_PREFIX + EJhOTviv;
		InputStream tksqYZuN = cl.getResourceAsStream(mw8WHCWF);
		if (tksqYZuN != null) {
			try {
				OutputStream yDg2NCkg = aq1FzPxz.getOutputStream();
				IOUtils.copy(tksqYZuN, yDg2NCkg);
			} finally {
				tksqYZuN.close();
			}
		} else {
			aq1FzPxz.sendError(HttpServletResponse.SC_NOT_FOUND);
		}
	}

}