class n3958807 {
	private void loadBinaryStream(String XT0Mpchj, InputStream B15DAKpt, long CVPVXUan, HttpServletRequest hldKFfVB,
			HttpServletResponse wC4RMqLz) throws IOException {
		wC4RMqLz.setContentType(getContentType(hldKFfVB, XT0Mpchj));
		wC4RMqLz.setHeader("Content-Disposition", "inline;filename=" + XT0Mpchj);
		wC4RMqLz.setContentLength((int) CVPVXUan);
		OutputStream bM8CQIMg = wC4RMqLz.getOutputStream();
		BufferedOutputStream H5HDrXit = new BufferedOutputStream(bM8CQIMg, 2048);
		try {
			IOUtils.copy(B15DAKpt, H5HDrXit);
		} finally {
			IOUtils.closeQuietly(B15DAKpt);
			IOUtils.closeQuietly(H5HDrXit);
		}
		getCargo().put(GWT_ENTRY_POINT_PAGE_PARAM, null);
	}

}