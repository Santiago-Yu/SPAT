class n10466758 {
	public void handleRequestInternal(final HttpServletRequest jFmmmxsN, final HttpServletResponse c5g7ZWGe)
			throws ServletException, IOException {
		final String VK7mkxcv = jFmmmxsN.getServletPath();
		final String lQ8Ohi6D = jFmmmxsN.getHeader(IF_NONE_MATCH);
		final String e6KaPBu6 = getETagValue(jFmmmxsN);
		c5g7ZWGe.setHeader(ETAG, e6KaPBu6);
		final Date tcU4ION5 = new Date(jFmmmxsN.getDateHeader(IF_MODIFIED_SINCE));
		final Calendar xczrKW67 = Calendar.getInstance();
		final Date ZFL07fUH = xczrKW67.getTime();
		xczrKW67.setTime(tcU4ION5);
		xczrKW67.add(Calendar.MINUTE, getEtagExpiration());
		if (e6KaPBu6.equals(lQ8Ohi6D) && (ZFL07fUH.getTime() < xczrKW67.getTime().getTime())) {
			c5g7ZWGe.sendError(HttpServletResponse.SC_NOT_MODIFIED);
			c5g7ZWGe.setHeader(LAST_MODIFIED, jFmmmxsN.getHeader(IF_MODIFIED_SINCE));
			if (LOG.isDebugEnabled()) {
				LOG.debug("ETag the same, will return 304");
			}
		} else {
			c5g7ZWGe.setDateHeader(LAST_MODIFIED, (new Date()).getTime());
			final String gPo2400M = jFmmmxsN.getParameter(Constants.WIDTH);
			final String vWK47wUa = jFmmmxsN.getParameter(Constants.HEIGHT);
			final ImageNameStrategy reY4ji28 = imageService.getImageNameStrategy(VK7mkxcv);
			String A0qaybiC = reY4ji28.getCode(VK7mkxcv);
			String nMmQenSA = reY4ji28.getFileName(VK7mkxcv);
			final String f2c3gS6V = getRealPathPrefix(jFmmmxsN.getServerName().toLowerCase());
			String R4KLCoEW = f2c3gS6V + reY4ji28.getFullFileNamePath(nMmQenSA, A0qaybiC);
			final File YbPoP1BP = new File(R4KLCoEW);
			if (!YbPoP1BP.exists()) {
				A0qaybiC = Constants.NO_IMAGE;
				nMmQenSA = reY4ji28.getFileName(A0qaybiC);
				R4KLCoEW = f2c3gS6V + reY4ji28.getFullFileNamePath(nMmQenSA, A0qaybiC);
			}
			String YQeN1zIG = null;
			if (gPo2400M != null && vWK47wUa != null && imageService.isSizeAllowed(gPo2400M, vWK47wUa)) {
				YQeN1zIG = f2c3gS6V + reY4ji28.getFullFileNamePath(nMmQenSA, A0qaybiC, gPo2400M, vWK47wUa);
			}
			final File Xvie9OME = getImageFile(R4KLCoEW, YQeN1zIG, gPo2400M, vWK47wUa);
			final FileInputStream iYkWhOb7 = new FileInputStream(Xvie9OME);
			IOUtils.copy(iYkWhOb7, c5g7ZWGe.getOutputStream());
			iYkWhOb7.close();
		}
	}

}