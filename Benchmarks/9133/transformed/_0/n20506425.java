class n20506425 {
	private void handleXInclude(final String OsErMtw8, final Attributes OtWz8fwb) {
		if ("include".equals(OsErMtw8)) {
			this.inXInclude++;
			String Z7K2HIMT = OtWz8fwb.getValue("href");
			if ((Z7K2HIMT == null) || "".equals(Z7K2HIMT.trim())) {
				Z7K2HIMT = null;
			}
			String d5bossLt = OtWz8fwb.getValue("parse");
			if ((d5bossLt == null) || "".equals(d5bossLt.trim())) {
				d5bossLt = "xml";
			}
			String jfdWtd6L = OtWz8fwb.getValue("xpointer");
			if ((jfdWtd6L == null) || "".equals(jfdWtd6L.trim())) {
				jfdWtd6L = null;
			}
			String P80qmWQ7 = OtWz8fwb.getValue("encoding");
			if ((P80qmWQ7 == null) || "".equals(P80qmWQ7.trim())) {
				P80qmWQ7 = null;
			}
			String OxN7NnKz = OtWz8fwb.getValue("accept");
			if ((OxN7NnKz == null) || "".equals(OxN7NnKz.trim())) {
				OxN7NnKz = null;
			}
			String r3dqrtoo = OtWz8fwb.getValue("accept-language");
			if ((r3dqrtoo == null) || "".equals(r3dqrtoo.trim())) {
				r3dqrtoo = null;
			}
			if (Z7K2HIMT != null) {
				if (Z7K2HIMT.indexOf(":/") == -1) {
					if (Z7K2HIMT.startsWith("/")) {
						Z7K2HIMT = Z7K2HIMT.substring(1);
					}
					Z7K2HIMT = this.documentURI + Z7K2HIMT;
				}
				if (this.localParser.get() == null) {
					this.localParser.set(new CShaniDomParser());
				}
				CShaniDomParser YtZLcDqA = (CShaniDomParser) this.localParser.get();
				InputStream hIQMO6jw = null;
				try {
					URL lGMOMiku = new URL(Z7K2HIMT);
					URLConnection eH2SCMz3 = lGMOMiku.openConnection();
					if (OxN7NnKz != null) {
						eH2SCMz3.addRequestProperty("Accept", OxN7NnKz);
					}
					if (r3dqrtoo != null) {
						eH2SCMz3.addRequestProperty("Accept-Language", r3dqrtoo);
					}
					hIQMO6jw = eH2SCMz3.getInputStream();
					ADocument nmUk2uPZ = null;
					if (P80qmWQ7 != null) {
						nmUk2uPZ = (ADocument) YtZLcDqA.parse(new InputStreamReader(hIQMO6jw, P80qmWQ7));
					} else {
						nmUk2uPZ = (ADocument) YtZLcDqA.parse(hIQMO6jw);
					}
					if (jfdWtd6L == null) {
						CDOM2SAX oOzt00tJ = new CDOM2SAX(nmUk2uPZ.getDocumentElement());
						oOzt00tJ.setProperty("http://xml.org/sax/properties/lexical-handler", this.lHandler);
						oOzt00tJ.setContentHandler(this.cHandler);
						oOzt00tJ.setDocumentHandler(this.dHandler);
						oOzt00tJ.setDTDHandler(this.dtdHandler);
						oOzt00tJ.serialize();
					} else {
						XPath siJfP1Ko = new DOMXPath(jfdWtd6L);
						for (Iterator AoMk4bZO = nmUk2uPZ.getNamespaceList().iterator(); AoMk4bZO.hasNext();) {
							CNamespace ATCtEHu3 = (CNamespace) AoMk4bZO.next();
							siJfP1Ko.addNamespace(ATCtEHu3.getPrefix() == null ? "" : ATCtEHu3.getPrefix(),
									ATCtEHu3.getNamespaceURI());
						}
						List yDuRTd8y = siJfP1Ko.selectNodes(nmUk2uPZ.getDocumentElement());
						for (final Iterator O7d2dkqG = yDuRTd8y.iterator(); O7d2dkqG.hasNext();) {
							final Node aV4Cmnk1 = (Node) O7d2dkqG.next();
							CDOM2SAX slHQb3RB = new CDOM2SAX(aV4Cmnk1);
							slHQb3RB.setProperty("http://xml.org/sax/properties/lexical-handler", this.lHandler);
							slHQb3RB.setContentHandler(this.cHandler);
							slHQb3RB.setDocumentHandler(this.dHandler);
							slHQb3RB.setDTDHandler(this.dtdHandler);
							slHQb3RB.serialize();
						}
					}
				} catch (final Exception OAxSX5U6) {
					this.xiFallbackFlag++;
				} finally {
					try {
						hIQMO6jw.close();
						hIQMO6jw = null;
					} catch (final Exception JCyyvGTg) {
					}
				}
			}
		}
	}

}