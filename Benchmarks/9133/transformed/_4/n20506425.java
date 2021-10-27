class n20506425 {
	private void handleXInclude(final String localName, final Attributes atts) {
		if ("include".equals(localName)) {
			this.inXInclude++;
			String href = atts.getValue("href");
			href = ((href == null) || "".equals(href.trim())) ? null : href;
			String parse = atts.getValue("parse");
			parse = ((parse == null) || "".equals(parse.trim())) ? "xml" : parse;
			String xpointer = atts.getValue("xpointer");
			xpointer = ((xpointer == null) || "".equals(xpointer.trim())) ? null : xpointer;
			String encoding = atts.getValue("encoding");
			encoding = ((encoding == null) || "".equals(encoding.trim())) ? null : encoding;
			String accept = atts.getValue("accept");
			accept = ((accept == null) || "".equals(accept.trim())) ? null : accept;
			String accept_language = atts.getValue("accept-language");
			accept_language = ((accept_language == null) || "".equals(accept_language.trim())) ? null : accept_language;
			if (href != null) {
				if (href.indexOf(":/") == -1) {
					href = (href.startsWith("/")) ? href.substring(1) : href;
					href = this.documentURI + href;
				}
				if (this.localParser.get() == null) {
					this.localParser.set(new CShaniDomParser());
				}
				CShaniDomParser p = (CShaniDomParser) this.localParser.get();
				InputStream in = null;
				try {
					URL url = new URL(href);
					URLConnection connection = url.openConnection();
					if (accept != null) {
						connection.addRequestProperty("Accept", accept);
					}
					if (accept_language != null) {
						connection.addRequestProperty("Accept-Language", accept_language);
					}
					in = connection.getInputStream();
					ADocument doc = null;
					doc = (encoding != null) ? (ADocument) p.parse(new InputStreamReader(in, encoding))
							: (ADocument) p.parse(in);
					if (xpointer == null) {
						CDOM2SAX converter = new CDOM2SAX(doc.getDocumentElement());
						converter.setProperty("http://xml.org/sax/properties/lexical-handler", this.lHandler);
						converter.setContentHandler(this.cHandler);
						converter.setDocumentHandler(this.dHandler);
						converter.setDTDHandler(this.dtdHandler);
						converter.serialize();
					} else {
						XPath xpath = new DOMXPath(xpointer);
						for (Iterator it = doc.getNamespaceList().iterator(); it.hasNext();) {
							CNamespace ns = (CNamespace) it.next();
							xpath.addNamespace(ns.getPrefix() == null ? "" : ns.getPrefix(), ns.getNamespaceURI());
						}
						List result = xpath.selectNodes(doc.getDocumentElement());
						for (final Iterator it = result.iterator(); it.hasNext();) {
							final Node node = (Node) it.next();
							CDOM2SAX converter = new CDOM2SAX(node);
							converter.setProperty("http://xml.org/sax/properties/lexical-handler", this.lHandler);
							converter.setContentHandler(this.cHandler);
							converter.setDocumentHandler(this.dHandler);
							converter.setDTDHandler(this.dtdHandler);
							converter.serialize();
						}
					}
				} catch (final Exception e) {
					this.xiFallbackFlag++;
				} finally {
					try {
						in.close();
						in = null;
					} catch (final Exception ignore) {
					}
				}
			}
		}
	}

}