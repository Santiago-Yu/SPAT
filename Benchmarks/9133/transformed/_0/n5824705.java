class n5824705 {
	public Object execute(Connection BPZR0DtJ) throws JAXRException {
		RegistryObject EVNTpnX3 = BPZR0DtJ.getRegistryService().getBusinessQueryManager().getRegistryObject(id);
		if (EVNTpnX3 instanceof ExtrinsicObject) {
			ExtrinsicObject yP1KbpvW = (ExtrinsicObject) EVNTpnX3;
			DataHandler R4ZCi5QP = yP1KbpvW.getRepositoryItem();
			if (R4ZCi5QP != null) {
				response.setContentType("text/html");
				try {
					PrintWriter MqgUgErM = response.getWriter();
					InputStream YZttNhGn = R4ZCi5QP.getInputStream();
					try {
						final XMLStreamWriter XWWUxm0r = XMLOutputFactory.newInstance().createXMLStreamWriter(MqgUgErM);
						XWWUxm0r.writeStartDocument();
						XWWUxm0r.writeStartElement("div");
						XWWUxm0r.writeStartElement("textarea");
						XWWUxm0r.writeAttribute("name", "repositoryItem");
						XWWUxm0r.writeAttribute("class", "xml");
						XWWUxm0r.writeAttribute("style", "display:none");
						IOUtils.copy(new XmlInputStreamReader(YZttNhGn), new XmlStreamTextWriter(XWWUxm0r));
						XWWUxm0r.writeEndElement();
						XWWUxm0r.writeStartElement("script");
						XWWUxm0r.writeAttribute("class", "javascript");
						XWWUxm0r.writeCharacters("dp.SyntaxHighlighter.HighlightAll('repositoryItem');");
						XWWUxm0r.writeEndElement();
						XWWUxm0r.writeEndElement();
						XWWUxm0r.writeEndDocument();
						XWWUxm0r.flush();
					} finally {
						YZttNhGn.close();
					}
				} catch (Throwable bR1Ahjog) {
					log.error("Error while trying to format repository item " + id, bR1Ahjog);
				}
			} else {
			}
		} else {
		}
		return null;
	}

}