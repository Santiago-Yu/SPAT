class n8250731 {
	@Override
	protected void doGet(HttpServletRequest YvIBmgu9, HttpServletResponse ezlhRo2m)
			throws ServletException, IOException {
		String sPCrvpws = YvIBmgu9.getParameterValues(Constants.PARAM_UUID)[0];
		String z5VQ7wqs = null;
		if (YvIBmgu9.getRequestURI().contains(Constants.SERVLET_DOWNLOAD_FOXML_PREFIX)) {
			ezlhRo2m.addHeader("Content-Disposition",
					"attachment; ContentType = \"text/xml\"; filename=\"" + sPCrvpws + "_server_version.foxml\"");
		} else {
			z5VQ7wqs = YvIBmgu9.getParameterValues(Constants.PARAM_DATASTREAM)[0];
			ezlhRo2m.addHeader("Content-Disposition", "attachment; ContentType = \"text/xml\"; filename=\"" + sPCrvpws
					+ "_server_version_" + z5VQ7wqs + ".xml\"");
		}
		ServletOutputStream Btz1OpPV = ezlhRo2m.getOutputStream();
		if (sPCrvpws != null && !"".equals(sPCrvpws)) {
			try {
				StringBuffer N5qCiVXQ = new StringBuffer();
				if (YvIBmgu9.getRequestURI().contains(Constants.SERVLET_DOWNLOAD_FOXML_PREFIX)) {
					N5qCiVXQ.append(config.getFedoraHost()).append("/objects/").append(sPCrvpws).append("/objectXML");
				} else if (YvIBmgu9.getRequestURI().contains(Constants.SERVLET_DOWNLOAD_DATASTREAMS_PREFIX)) {
					N5qCiVXQ.append(config.getFedoraHost()).append("/objects/").append(sPCrvpws).append("/datastreams/")
							.append(z5VQ7wqs).append("/content");
				}
				InputStream zVXU8MXM = RESTHelper.get(N5qCiVXQ.toString(), config.getFedoraLogin(),
						config.getFedoraPassword(), false);
				if (zVXU8MXM == null) {
					return;
				}
				try {
					if (YvIBmgu9.getRequestURI().contains(Constants.SERVLET_DOWNLOAD_DATASTREAMS_PREFIX)) {
						Btz1OpPV.write(Constants.XML_HEADER_WITH_BACKSLASHES.getBytes());
					}
					IOUtils.copyStreams(zVXU8MXM, Btz1OpPV);
				} catch (IOException BtR4Uz6t) {
					ezlhRo2m.setStatus(HttpURLConnection.HTTP_NOT_FOUND);
					LOGGER.error("Problem with downloading foxml.", BtR4Uz6t);
				} finally {
					Btz1OpPV.flush();
					if (zVXU8MXM != null) {
						try {
							zVXU8MXM.close();
						} catch (IOException NtvN0ZPR) {
							ezlhRo2m.setStatus(HttpURLConnection.HTTP_NOT_FOUND);
							LOGGER.error("Problem with downloading foxml.", NtvN0ZPR);
						} finally {
							zVXU8MXM = null;
						}
					}
				}
			} catch (IOException KSyfPkQo) {
				ezlhRo2m.setStatus(HttpURLConnection.HTTP_NOT_FOUND);
				LOGGER.error("Problem with downloading foxml.", KSyfPkQo);
			} finally {
				Btz1OpPV.flush();
			}
		}
	}

}