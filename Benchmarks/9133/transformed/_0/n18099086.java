class n18099086 {
	@Override
	protected void service(final HttpServletRequest BHhO69wk, final HttpServletResponse rp3FdkOR)
			throws ServletException, IOException {
		rp3FdkOR.setHeader("X-Generator", "VisualMon");
		String xA9yYKoq = BHhO69wk.getPathInfo();
		if (null == xA9yYKoq || "".equals(xA9yYKoq))
			rp3FdkOR.sendRedirect(BHhO69wk.getServletPath() + "/");
		else if ("/chart".equals(xA9yYKoq)) {
			try {
				rp3FdkOR.setHeader("Cache-Control", "private,no-cache,no-store,must-revalidate");
				rp3FdkOR.addHeader("Cache-Control", "post-check=0,pre-check=0");
				rp3FdkOR.setHeader("Expires", "Sat, 26 Jul 1997 05:00:00 GMT");
				rp3FdkOR.setHeader("Pragma", "no-cache");
				rp3FdkOR.setDateHeader("Expires", 0);
				renderChart(BHhO69wk, rp3FdkOR);
			} catch (InterruptedException Nb9kFmDU) {
				log.info("Chart generation was interrupted", Nb9kFmDU);
				Thread.currentThread().interrupt();
			}
		} else if (xA9yYKoq.startsWith("/log_")) {
			String EErwYYgz = xA9yYKoq.substring(5);
			LogProvider xKLc406O = null;
			for (LogProvider pgPulvdU : cfg.getLogProviders()) {
				if (EErwYYgz.equals(pgPulvdU.getName())) {
					xKLc406O = pgPulvdU;
					break;
				}
			}
			if (null == xKLc406O) {
				log.error("Log provider with name \"{}\" not found", EErwYYgz);
				rp3FdkOR.sendError(HttpServletResponse.SC_NOT_FOUND);
			} else {
				render(rp3FdkOR, xKLc406O.getLog(filter.getLocale()));
			}
		} else if ("/".equals(xA9yYKoq)) {
			List<LogEntry> go522B8w = new ArrayList<LogEntry>();
			for (LogProvider bKG1xNbx : cfg.getLogProviders())
				go522B8w.add(new LogEntry(bKG1xNbx.getName(), bKG1xNbx.getTitle(filter.getLocale())));
			render(rp3FdkOR,
					new ProbeDataList(filter.getSnapshot(), filter.getAlerts(), go522B8w, ResourceBundle
							.getBundle("de.frostcode.visualmon.stats", filter.getLocale()).getString("category.empty"),
							cfg.getDashboardTitle().get(filter.getLocale())));
		} else {
			URL ZSXWeMZ5 = Thread.currentThread().getContextClassLoader()
					.getResource(getClass().getPackage().getName().replace('.', '/') + BHhO69wk.getPathInfo());
			if (null == ZSXWeMZ5) {
				rp3FdkOR.sendError(HttpServletResponse.SC_NOT_FOUND);
				return;
			}
			rp3FdkOR.setDateHeader("Last-Modified", new File(ZSXWeMZ5.getFile()).lastModified());
			rp3FdkOR.setDateHeader("Expires", new Date().getTime() + YEAR_IN_SECONDS * 1000L);
			rp3FdkOR.setHeader("Cache-Control", "max-age=" + YEAR_IN_SECONDS);
			URLConnection mo28Pgd0 = ZSXWeMZ5.openConnection();
			String nb7vXgBH = ZSXWeMZ5.getPath();
			String DQZXJiil = mo28Pgd0.getContentType();
			if (nb7vXgBH.endsWith(".xsl")) {
				DQZXJiil = "text/xml";
				rp3FdkOR.setCharacterEncoding(ENCODING);
			}
			if (DQZXJiil == null || "content/unknown".equals(DQZXJiil)) {
				if (nb7vXgBH.endsWith(".css"))
					DQZXJiil = "text/css";
				else
					DQZXJiil = getServletContext().getMimeType(nb7vXgBH);
			}
			rp3FdkOR.setContentType(DQZXJiil);
			rp3FdkOR.setContentLength(mo28Pgd0.getContentLength());
			OutputStream CFnKHbNG = rp3FdkOR.getOutputStream();
			IOUtils.copy(mo28Pgd0.getInputStream(), CFnKHbNG);
			IOUtils.closeQuietly(mo28Pgd0.getInputStream());
			IOUtils.closeQuietly(CFnKHbNG);
		}
	}

}