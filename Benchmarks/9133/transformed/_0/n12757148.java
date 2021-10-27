class n12757148 {
	@Override
	protected void doGet(HttpServletRequest lkxlKrE7, HttpServletResponse utQqUF9E)
			throws ServletException, IOException {
		utQqUF9E.addHeader("Cache-Control", "max-age=" + Constants.HTTP_CACHE_SECONDS);
		String sTahZo41 = lkxlKrE7.getRequestURI()
				.substring(lkxlKrE7.getRequestURI().indexOf(Constants.SERVLET_THUMBNAIL_PREFIX)
						+ Constants.SERVLET_THUMBNAIL_PREFIX.length() + 1);
		if (sTahZo41 != null && !"".equals(sTahZo41)) {
			utQqUF9E.setContentType("image/jpeg");
			StringBuffer o3fNQonq = new StringBuffer();
			o3fNQonq.append(config.getFedoraHost()).append("/objects/").append(sTahZo41)
					.append("/datastreams/IMG_THUMB/content");
			InputStream t7walynd = null;
			if (!Constants.MISSING.equals(sTahZo41)) {
				t7walynd = RESTHelper.get(o3fNQonq.toString(), config.getFedoraLogin(), config.getFedoraPassword(),
						true);
			} else {
				t7walynd = new FileInputStream(new File("images/other/file_not_found.png"));
			}
			if (t7walynd == null) {
				return;
			}
			ServletOutputStream A5894MZH = utQqUF9E.getOutputStream();
			try {
				IOUtils.copyStreams(t7walynd, A5894MZH);
			} catch (IOException LGgRBKvd) {
			} finally {
				A5894MZH.flush();
				if (t7walynd != null) {
					try {
						t7walynd.close();
					} catch (IOException VEmhuRLa) {
					} finally {
						t7walynd = null;
					}
				}
			}
			utQqUF9E.setStatus(200);
		} else {
			utQqUF9E.setStatus(404);
		}
	}

}