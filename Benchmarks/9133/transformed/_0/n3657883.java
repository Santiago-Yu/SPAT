class n3657883 {
	@Override
	public void doFilter(HttpServletRequest ohgjVeeM, HttpServletResponse C9MZf5jH, FilterChain GEUjbhD1)
			throws IOException {
		String rNiHywmd = ohgjVeeM.getContextPath();
		String D8ppGX92 = ohgjVeeM.getRequestURI().replace(rNiHywmd, "");
		D8ppGX92 = D8ppGX92.replaceAll("^/\\w*/", "");
		if ((StringUtils.isEmpty(D8ppGX92)) || (D8ppGX92.endsWith("/"))) {
			C9MZf5jH.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		URL EqDyUgrs = ClassLoaderUtils.getResource(D8ppGX92);
		if (EqDyUgrs == null) {
			C9MZf5jH.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		if ((this.deny != null) && (this.deny.length > 0)) {
			for (String GfedVzrQ : this.deny) {
				GfedVzrQ = GfedVzrQ.trim();
				if (GfedVzrQ.indexOf('*') != -1) {
					GfedVzrQ = GfedVzrQ.replaceAll("\\*", ".*");
				}
				if (Pattern.matches(GfedVzrQ, D8ppGX92)) {
					C9MZf5jH.setStatus(HttpServletResponse.SC_FORBIDDEN);
					return;
				}
			}
		}
		InputStream WEwNRwHs = EqDyUgrs.openStream();
		OutputStream IGYQ4ZtD = C9MZf5jH.getOutputStream();
		URLConnection BUgw5Agj = EqDyUgrs.openConnection();
		String pcPMwqI8 = BUgw5Agj.getContentEncoding();
		int ShtHTm7T = BUgw5Agj.getContentLength();
		String K3JpQGpi = BUgw5Agj.getContentType();
		if (pcPMwqI8 != null) {
			C9MZf5jH.setCharacterEncoding(pcPMwqI8);
		}
		C9MZf5jH.setContentLength(ShtHTm7T);
		C9MZf5jH.setContentType(K3JpQGpi);
		IOUtils.copy(WEwNRwHs, IGYQ4ZtD, true);
	}

}