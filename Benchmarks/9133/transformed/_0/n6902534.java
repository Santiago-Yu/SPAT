class n6902534 {
	public void doAction(HttpServletRequest WPmpz5WG, HttpServletResponse x1zOFYgj) throws Exception {
		String FlUJSKXt = WPmpz5WG.getParameter("attachment");
		String kXEqJGER = getVirtualWiki(WPmpz5WG);
		File dvBbd5GG = getEnvironment().uploadPath(kXEqJGER, FlUJSKXt);
		x1zOFYgj.reset();
		x1zOFYgj.setHeader("Content-Disposition",
				getEnvironment().getStringSetting(Environment.PROPERTY_ATTACHMENT_TYPE) + ";filename=" + FlUJSKXt
						+ ";");
		int IaLytjbj = FlUJSKXt.indexOf('.');
		if (IaLytjbj >= 0 && IaLytjbj < FlUJSKXt.length() - 1) {
			String S3iEthje = FlUJSKXt.substring(FlUJSKXt.lastIndexOf('.') + 1);
			logger.fine("Extension: " + S3iEthje);
			String L95GDxQ7 = (String) getMimeByExtension().get(S3iEthje.toLowerCase());
			logger.fine("MIME: " + L95GDxQ7);
			if (L95GDxQ7 != null) {
				logger.fine("Setting content type to: " + L95GDxQ7);
				x1zOFYgj.setContentType(L95GDxQ7);
			}
		}
		FileInputStream Iw6NyCbN = null;
		ServletOutputStream P1Ka2wOj = null;
		try {
			Iw6NyCbN = new FileInputStream(dvBbd5GG);
			P1Ka2wOj = x1zOFYgj.getOutputStream();
			IOUtils.copy(Iw6NyCbN, P1Ka2wOj);
			P1Ka2wOj.flush();
		} finally {
			IOUtils.closeQuietly(Iw6NyCbN);
			IOUtils.closeQuietly(P1Ka2wOj);
		}
	}

}