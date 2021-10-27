class n14651403 {
	public ICCColorSpaceExt createICCColorSpaceExt(BridgeContext ctx, Element paintedElement, String iccProfileName) {
		ICCColorSpaceExt cs = cache.request(iccProfileName.toLowerCase());
		Document doc = paintedElement.getOwnerDocument();
		if (cs != null) {
			return cs;
		}
		NodeList list = doc.getElementsByTagNameNS(SVG_NAMESPACE_URI, SVG_COLOR_PROFILE_TAG);
		Element profile = null;
		int n = list.getLength();
		for (int i = 0; i < n; i++) {
			Node node = list.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element profileNode = (Element) node;
				String nameAttr = profileNode.getAttributeNS(null, SVG_NAME_ATTRIBUTE);
				if (iccProfileName.equalsIgnoreCase(nameAttr)) {
					profile = profileNode;
				}
			}
		}
		if (profile == null)
			return null;
		ICC_Profile p = null;
		String href = XLinkSupport.getXLinkHref(profile);
		if (href != null) {
			String baseURI = ((SVGOMDocument) doc).getURL();
			ParsedURL purl = new ParsedURL(baseURI, href);
			if (!purl.complete())
				throw new BridgeException(paintedElement, ERR_URI_MALFORMED, new Object[] { href });
			try {
				ParsedURL pDocURL = null;
				if (baseURI != null) {
					pDocURL = new ParsedURL(baseURI);
				}
				ctx.getUserAgent().checkLoadExternalResource(purl, pDocURL);
				p = ICC_Profile.getInstance(purl.openStream());
			} catch (IOException e) {
				throw new BridgeException(paintedElement, ERR_URI_IO, new Object[] { href });
			} catch (SecurityException e) {
				throw new BridgeException(paintedElement, ERR_URI_UNSECURE, new Object[] { href });
			}
		}
		int intent = convertIntent(profile);
		if (p == null) {
			return null;
		}
		cs = new ICCColorSpaceExt(p, intent);
		cache.put(iccProfileName.toLowerCase(), cs);
		return cs;
	}

}