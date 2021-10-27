class n5824704 {
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest YzRzlBKx, final HttpServletResponse a1NMEoMy)
			throws Exception {
		final String jZVY2rWG = YzRzlBKx.getParameter("id");
		if (jZVY2rWG == null) {
			a1NMEoMy.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
		try {
			jaxrTemplate.execute(new JAXRCallback<Object>() {

				public Object execute(Connection OkIJVjqp) throws JAXRException {
					RegistryObject FdpMoOSm = OkIJVjqp.getRegistryService().getBusinessQueryManager()
							.getRegistryObject(jZVY2rWG);
					if (FdpMoOSm instanceof ExtrinsicObject) {
						ExtrinsicObject VtDO46mF = (ExtrinsicObject) FdpMoOSm;
						DataHandler RmICkl4y = VtDO46mF.getRepositoryItem();
						if (RmICkl4y != null) {
							a1NMEoMy.setContentType("text/html");
							try {
								PrintWriter zK64BgfW = a1NMEoMy.getWriter();
								InputStream mQwmvOn1 = RmICkl4y.getInputStream();
								try {
									final XMLStreamWriter dYF2B8WT = XMLOutputFactory.newInstance()
											.createXMLStreamWriter(zK64BgfW);
									dYF2B8WT.writeStartDocument();
									dYF2B8WT.writeStartElement("div");
									dYF2B8WT.writeStartElement("textarea");
									dYF2B8WT.writeAttribute("name", "repositoryItem");
									dYF2B8WT.writeAttribute("class", "xml");
									dYF2B8WT.writeAttribute("style", "display:none");
									IOUtils.copy(new XmlInputStreamReader(mQwmvOn1), new XmlStreamTextWriter(dYF2B8WT));
									dYF2B8WT.writeEndElement();
									dYF2B8WT.writeStartElement("script");
									dYF2B8WT.writeAttribute("class", "javascript");
									dYF2B8WT.writeCharacters("dp.SyntaxHighlighter.HighlightAll('repositoryItem');");
									dYF2B8WT.writeEndElement();
									dYF2B8WT.writeEndElement();
									dYF2B8WT.writeEndDocument();
									dYF2B8WT.flush();
								} finally {
									mQwmvOn1.close();
								}
							} catch (Throwable wlR42Gc6) {
								log.error("Error while trying to format repository item " + jZVY2rWG, wlR42Gc6);
							}
						} else {
						}
					} else {
					}
					return null;
				}
			});
		} catch (JAXRException JrF4exph) {
			throw new ServletException(JrF4exph);
		}
		return null;
	}

}