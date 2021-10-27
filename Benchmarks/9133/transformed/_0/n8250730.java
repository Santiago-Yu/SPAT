class n8250730 {
	@Override
	protected void doPost(HttpServletRequest fHnT5EhK, HttpServletResponse upa6VbMG)
			throws ServletException, IOException {
		String vHXvXclF = fHnT5EhK.getParameterValues(Constants.PARAM_UUID)[0];
		String NESLy4dU = null;
		if (fHnT5EhK.getRequestURI().contains(Constants.SERVLET_DOWNLOAD_FOXML_PREFIX)) {
			upa6VbMG.addHeader("Content-Disposition",
					"attachment; ContentType = \"text/xml\"; filename=\"" + vHXvXclF + "_local_version.foxml\"");
		} else {
			NESLy4dU = fHnT5EhK.getParameterValues(Constants.PARAM_DATASTREAM)[0];
			upa6VbMG.addHeader("Content-Disposition", "attachment; ContentType = \"text/xml\"; filename=\"" + vHXvXclF
					+ "_local_version_" + NESLy4dU + ".xml\"");
		}
		String UV9xbgZY = URLDecoder.decode(fHnT5EhK.getParameterValues(Constants.PARAM_CONTENT)[0], "UTF-8");
		InputStream no97II8h = new ByteArrayInputStream(UV9xbgZY.getBytes("UTF-8"));
		ServletOutputStream mVlFJtzr = upa6VbMG.getOutputStream();
		IOUtils.copyStreams(no97II8h, mVlFJtzr);
		mVlFJtzr.flush();
	}

}