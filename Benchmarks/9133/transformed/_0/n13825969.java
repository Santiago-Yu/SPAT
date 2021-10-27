class n13825969 {
	@Override
	protected void doFetch(HttpServletRequest qwAU5gP8, HttpServletResponse ffzfnNrI)
			throws IOException, GadgetException {
		if (qwAU5gP8.getHeader("If-Modified-Since") != null) {
			ffzfnNrI.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
			return;
		}
		String boEiuCHj = qwAU5gP8.getHeader("Host");
		if (!lockedDomainService.isSafeForOpenProxy(boEiuCHj)) {
			String e8mCoIvd = "Embed request for url " + getParameter(qwAU5gP8, URL_PARAM, "")
					+ " made to wrong domain " + boEiuCHj;
			logger.info(e8mCoIvd);
			throw new GadgetException(GadgetException.Code.INVALID_PARAMETER, e8mCoIvd);
		}
		HttpRequest aXpGLdPV = buildHttpRequest(qwAU5gP8, URL_PARAM);
		HttpResponse pIpXCjwr = requestPipeline.execute(aXpGLdPV);
		if (pIpXCjwr.isError()) {
			HttpRequest pRqTIinJ = buildHttpRequest(qwAU5gP8, FALLBACK_URL_PARAM);
			if (pRqTIinJ != null) {
				pIpXCjwr = requestPipeline.execute(pRqTIinJ);
			}
		}
		if (contentRewriterRegistry != null) {
			try {
				pIpXCjwr = contentRewriterRegistry.rewriteHttpResponse(aXpGLdPV, pIpXCjwr);
			} catch (RewritingException Qd658cWI) {
				throw new GadgetException(GadgetException.Code.INTERNAL_SERVER_ERROR, Qd658cWI);
			}
		}
		for (Map.Entry<String, String> entry : pIpXCjwr.getHeaders().entries()) {
			String jWwogT8u = entry.getKey();
			if (!DISALLOWED_RESPONSE_HEADERS.contains(jWwogT8u.toLowerCase())) {
				ffzfnNrI.addHeader(jWwogT8u, entry.getValue());
			}
		}
		String gIAcHaAi = pIpXCjwr.getHeader("Content-Type");
		if (!StringUtils.isEmpty(aXpGLdPV.getRewriteMimeType())) {
			String bkcWGDXE = aXpGLdPV.getRewriteMimeType();
			if (bkcWGDXE.endsWith("/*") && !StringUtils.isEmpty(gIAcHaAi)) {
				bkcWGDXE = bkcWGDXE.substring(0, bkcWGDXE.length() - 2);
				if (!gIAcHaAi.toLowerCase().startsWith(bkcWGDXE.toLowerCase())) {
					ffzfnNrI.setContentType(bkcWGDXE);
					gIAcHaAi = bkcWGDXE;
				}
			} else {
				ffzfnNrI.setContentType(bkcWGDXE);
				gIAcHaAi = bkcWGDXE;
			}
		}
		setResponseHeaders(qwAU5gP8, ffzfnNrI, pIpXCjwr);
		if (pIpXCjwr.getHttpStatusCode() != HttpResponse.SC_OK) {
			ffzfnNrI.sendError(pIpXCjwr.getHttpStatusCode());
		}
		IOUtils.copy(pIpXCjwr.getResponse(), ffzfnNrI.getOutputStream());
	}

}