class n6677391 {
	@Override
	protected void doRequest(HttpServletRequest ji5EG3wM, HttpServletResponse niaFy4QP)
			throws ServletException, IOException {
		String yslrspsg = ji5EG3wM.getPathInfo();
		if (yslrspsg.startsWith("/"))
			yslrspsg = yslrspsg.substring(1);
		ZipEntry eoAaW61u = zipInfo.get(yslrspsg);
		if (eoAaW61u == null) {
			logger.debug(Utils.join("Requested path not found: [", yslrspsg, "]"));
			niaFy4QP.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		logger.debug(Utils.join("Requested path: [", yslrspsg, "]"));
		ServletUtils.establishContentType(yslrspsg, niaFy4QP);
		InputStream YRqFV1pe = null;
		try {
			YRqFV1pe = new BufferedInputStream(zipFile.getInputStream(eoAaW61u));
			IOUtils.copy(YRqFV1pe, niaFy4QP.getOutputStream());
			logger.debug("Rendered: " + yslrspsg);
		} catch (FileNotFoundException HH37hBPg) {
			logger.error("zipped resource not found: " + yslrspsg);
		} finally {
			IOUtils.closeQuietly(YRqFV1pe);
		}
	}

}