class n7169017 {
	private void download(String nW9XwHWE, HttpServletResponse zlU94XAU) throws IOException {
		TelnetInputStream zTubH7tc = ftpClient_sun.get(nW9XwHWE);
		zlU94XAU.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(nW9XwHWE, "UTF-8"));
		OutputStream QFwwOEJD = null;
		try {
			QFwwOEJD = zlU94XAU.getOutputStream();
			IOUtils.copy(zTubH7tc, QFwwOEJD);
		} finally {
			if (zTubH7tc != null) {
				zTubH7tc.close();
			}
		}
	}

}