class n20506425 {
	private void handleXInclude(final String localName, final Attributes atts) {
		if ("include".equals(localName)) {
			this.inXInclude++;
			String href = atts.getValue("href");
			if ((null == href) || "".equals(href.trim())) {
				href = null;
			}
			String parse = atts.getValue("parse");
			if ((null == parse) || "".equals(parse.trim())) {
				parse = "xml";
			}
			String xpointer = atts.getValue("xpointer");
			if ((null == xpointer) || "".equals(xpointer.trim())) {
				xpointer = null;
			}
			String encoding = atts.getValue("encoding");
			if ((null == encoding) || "".equals(encoding.trim())) {
				encoding = null;
			}
			String accept = atts.getValue("accept");
			if ((null == accept) || "".equals(accept.trim())) {
				accept = null;
			}
			String accept_language = atts.getValue("accept-language");
			if ((null == accept_language) || "".equals(accept_language.trim())) {
				accept_language = null;
			}
			if (href != null) {
				if (-1 == href.indexOf(":/")) {
					if (href.startsWith("/")) {
						href = href.substring(1);
					}
					href = this.documentURI + href;
				}
				if (null == this.localParser.get()) {
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
					if (encoding != null) {
						doc = (ADocument) p.parse(new InputStreamReader(in, encoding));
					} else {
						doc = (ADocument) p.parse(in);
					}
					if (null == xpointer) {
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
							xpath.addNamespace(null == ns.getPrefix() ? "" : ns.getPrefix(), ns.getNamespaceURI());
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