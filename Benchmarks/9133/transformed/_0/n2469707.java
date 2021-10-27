class n2469707 {
	@Override
	protected void doGet(HttpServletRequest xcMv3sig, HttpServletResponse HW4qYqKD)
			throws ServletException, IOException {
		HW4qYqKD.addHeader("Cache-Control", "max-age=" + Constants.HTTP_CACHE_SECONDS);
		String zvbS8wLx = xcMv3sig.getRequestURI()
				.substring(xcMv3sig.getRequestURI().indexOf(Constants.SERVLET_FULL_PREFIX)
						+ Constants.SERVLET_FULL_PREFIX.length() + 1);
		boolean yrd21Ox3 = ClientUtils.toBoolean(xcMv3sig.getParameter(Constants.URL_PARAM_NOT_SCALE));
		ServletOutputStream YnyAv5qM = HW4qYqKD.getOutputStream();
		if (zvbS8wLx != null && !"".equals(zvbS8wLx)) {
			try {
				String M8iXpxLu = fedoraAccess.getMimeTypeForStream(zvbS8wLx, FedoraUtils.IMG_FULL_STREAM);
				if (M8iXpxLu == null) {
					M8iXpxLu = "image/jpeg";
				}
				ImageMimeType eLktpcYX = ImageMimeType.loadFromMimeType(M8iXpxLu);
				if (eLktpcYX == ImageMimeType.JPEG || eLktpcYX == ImageMimeType.PNG) {
					StringBuffer kYLDAgxm = new StringBuffer();
					kYLDAgxm.append(config.getFedoraHost()).append("/objects/").append(zvbS8wLx)
							.append("/datastreams/IMG_FULL/content");
					InputStream rWb3lpES = RESTHelper.get(kYLDAgxm.toString(), config.getFedoraLogin(),
							config.getFedoraPassword(), false);
					if (rWb3lpES == null) {
						return;
					}
					try {
						IOUtils.copyStreams(rWb3lpES, YnyAv5qM);
					} catch (IOException iwydpkvc) {
						HW4qYqKD.setStatus(HttpURLConnection.HTTP_NOT_FOUND);
						LOGGER.error("Unable to open full image.", iwydpkvc);
					} finally {
						YnyAv5qM.flush();
						if (rWb3lpES != null) {
							try {
								rWb3lpES.close();
							} catch (IOException mWSJxuDR) {
								HW4qYqKD.setStatus(HttpURLConnection.HTTP_NOT_FOUND);
								LOGGER.error("Unable to close stream.", mWSJxuDR);
							} finally {
								rWb3lpES = null;
							}
						}
					}
				} else {
					Image Doqcd9QY = KrameriusImageSupport.readImage(zvbS8wLx, FedoraUtils.IMG_FULL_STREAM,
							this.fedoraAccess, 0, eLktpcYX);
					BufferedImage ZiXKLHyc = null;
					if (!yrd21Ox3) {
						ZiXKLHyc = KrameriusImageSupport.getSmallerImage(Doqcd9QY, 1250, 1000);
					} else {
						ZiXKLHyc = KrameriusImageSupport.getSmallerImage(Doqcd9QY, 2500, 2000);
					}
					KrameriusImageSupport.writeImageToStream(ZiXKLHyc, "JPG", YnyAv5qM);
					HW4qYqKD.setContentType(ImageMimeType.JPEG.getValue());
					HW4qYqKD.setStatus(HttpURLConnection.HTTP_OK);
				}
			} catch (IOException nfsogygP) {
				HW4qYqKD.setStatus(HttpURLConnection.HTTP_NOT_FOUND);
				LOGGER.error("Unable to open full image.", nfsogygP);
			} catch (XPathExpressionException FdInJULY) {
				HW4qYqKD.setStatus(HttpURLConnection.HTTP_NOT_FOUND);
				LOGGER.error("Unable to create XPath expression.", FdInJULY);
			} finally {
				YnyAv5qM.flush();
			}
		}
	}

}