class n22879451 {
	@Override
	public void doFilter(HttpServletRequest FnMrzXFQ, HttpServletResponse LYDKyJU7, FilterChain RKBKVeIX)
			throws IOException {
		String UhGT3lK4 = FnMrzXFQ.getContextPath();
		String NMA1Z0Z2 = FnMrzXFQ.getRequestURI().replace(UhGT3lK4, "");
		NMA1Z0Z2 = NMA1Z0Z2.replaceAll(RESOURCES_PATH + "/", "");
		if ((StringUtils.isEmpty(NMA1Z0Z2)) || (NMA1Z0Z2.endsWith("/"))) {
			LYDKyJU7.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		this.getLogger().info("Getting resource: " + NMA1Z0Z2);
		URL WI1d566M = ClassLoaderUtils.getResource(NMA1Z0Z2);
		if (WI1d566M == null) {
			LYDKyJU7.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		InputStream Nq6Ng1ue = WI1d566M.openStream();
		OutputStream zjy8B7nz = LYDKyJU7.getOutputStream();
		URLConnection mqqpHZE7 = WI1d566M.openConnection();
		String D2Lbna5K = mqqpHZE7.getContentEncoding();
		int IGxug70v = mqqpHZE7.getContentLength();
		String gvTxto6D = mqqpHZE7.getContentType();
		if (D2Lbna5K != null) {
			LYDKyJU7.setCharacterEncoding(D2Lbna5K);
		}
		LYDKyJU7.setContentLength(IGxug70v);
		LYDKyJU7.setContentType(gvTxto6D);
		IOUtils.copy(Nq6Ng1ue, zjy8B7nz, true);
	}

}