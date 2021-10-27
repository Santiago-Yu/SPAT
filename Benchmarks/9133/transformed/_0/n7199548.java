class n7199548 {
	protected GVTFontFamily getFontFamily(BridgeContext pCB3bwK2, ParsedURL tVhSi4eb) {
		String mijvrD1N = tVhSi4eb.toString();
		Element i0fCu5h8 = getBaseElement(pCB3bwK2);
		SVGDocument BUXVAwP1 = (SVGDocument) i0fCu5h8.getOwnerDocument();
		String XxcgIVdF = BUXVAwP1.getURL();
		ParsedURL Fgc1EpNJ = null;
		if (XxcgIVdF != null)
			Fgc1EpNJ = new ParsedURL(XxcgIVdF);
		String atpWlg4D = XMLBaseSupport.getCascadedXMLBase(i0fCu5h8);
		tVhSi4eb = new ParsedURL(atpWlg4D, mijvrD1N);
		UserAgent WqRB1AeS = pCB3bwK2.getUserAgent();
		try {
			WqRB1AeS.checkLoadExternalResource(tVhSi4eb, Fgc1EpNJ);
		} catch (SecurityException U5fJmFQm) {
			WqRB1AeS.displayError(U5fJmFQm);
			return null;
		}
		if (tVhSi4eb.getRef() != null) {
			Element sCW0VVmT = pCB3bwK2.getReferencedElement(i0fCu5h8, mijvrD1N);
			if (!sCW0VVmT.getNamespaceURI().equals(SVG_NAMESPACE_URI)
					|| !sCW0VVmT.getLocalName().equals(SVG_FONT_TAG)) {
				return null;
			}
			SVGDocument Z1j8t1KS = (SVGDocument) i0fCu5h8.getOwnerDocument();
			SVGDocument F0htYquF = (SVGDocument) sCW0VVmT.getOwnerDocument();
			Element z4lsaglC = sCW0VVmT;
			if (Z1j8t1KS != F0htYquF) {
				z4lsaglC = (Element) Z1j8t1KS.importNode(sCW0VVmT, true);
				String qhFqQvwr = XMLBaseSupport.getCascadedXMLBase(sCW0VVmT);
				Element tbcev3Ax = Z1j8t1KS.createElementNS(SVG_NAMESPACE_URI, SVG_G_TAG);
				tbcev3Ax.appendChild(z4lsaglC);
				tbcev3Ax.setAttributeNS(XMLBaseSupport.XML_NAMESPACE_URI, "xml:base", qhFqQvwr);
				CSSUtilities.computeStyleAndURIs(sCW0VVmT, z4lsaglC, mijvrD1N);
			}
			Element xHWWgzGC = null;
			for (Node ETOvFhag = z4lsaglC.getFirstChild(); ETOvFhag != null; ETOvFhag = ETOvFhag.getNextSibling()) {
				if ((ETOvFhag.getNodeType() == Node.ELEMENT_NODE)
						&& ETOvFhag.getNamespaceURI().equals(SVG_NAMESPACE_URI)
						&& ETOvFhag.getLocalName().equals(SVG_FONT_FACE_TAG)) {
					xHWWgzGC = (Element) ETOvFhag;
					break;
				}
			}
			SVGFontFaceElementBridge ioMd99wo;
			ioMd99wo = (SVGFontFaceElementBridge) pCB3bwK2.getBridge(SVG_NAMESPACE_URI, SVG_FONT_FACE_TAG);
			GVTFontFace lr6YuKIH = ioMd99wo.createFontFace(pCB3bwK2, xHWWgzGC);
			return new SVGFontFamily(lr6YuKIH, z4lsaglC, pCB3bwK2);
		}
		try {
			Font ESJ0kG3X = Font.createFont(Font.TRUETYPE_FONT, tVhSi4eb.openStream());
			return new AWTFontFamily(this, ESJ0kG3X);
		} catch (Exception zMUT9Ddk) {
		}
		return null;
	}

}