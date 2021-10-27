class n14651403 {
	public ICCColorSpaceExt createICCColorSpaceExt(BridgeContext E4NQQWuK, Element MQKqHDx2, String lsaFwStB) {
		ICCColorSpaceExt BHMJ8rK2 = cache.request(lsaFwStB.toLowerCase());
		if (BHMJ8rK2 != null) {
			return BHMJ8rK2;
		}
		Document I7R0WTtR = MQKqHDx2.getOwnerDocument();
		NodeList EvVdW3jh = I7R0WTtR.getElementsByTagNameNS(SVG_NAMESPACE_URI, SVG_COLOR_PROFILE_TAG);
		int q4lmbXPZ = EvVdW3jh.getLength();
		Element PpEWvVRf = null;
		for (int t1nw2Mr7 = 0; t1nw2Mr7 < q4lmbXPZ; t1nw2Mr7++) {
			Node vNJFDGFU = EvVdW3jh.item(t1nw2Mr7);
			if (vNJFDGFU.getNodeType() == Node.ELEMENT_NODE) {
				Element lZIgTdiY = (Element) vNJFDGFU;
				String nKh3FH3s = lZIgTdiY.getAttributeNS(null, SVG_NAME_ATTRIBUTE);
				if (lsaFwStB.equalsIgnoreCase(nKh3FH3s)) {
					PpEWvVRf = lZIgTdiY;
				}
			}
		}
		if (PpEWvVRf == null)
			return null;
		String WOuwBq8V = XLinkSupport.getXLinkHref(PpEWvVRf);
		ICC_Profile N0CP5diu = null;
		if (WOuwBq8V != null) {
			String NGe8Q0QZ = ((SVGOMDocument) I7R0WTtR).getURL();
			ParsedURL XG6B8lig = new ParsedURL(NGe8Q0QZ, WOuwBq8V);
			if (!XG6B8lig.complete())
				throw new BridgeException(MQKqHDx2, ERR_URI_MALFORMED, new Object[] { WOuwBq8V });
			try {
				ParsedURL ABTfcXf5 = null;
				if (NGe8Q0QZ != null) {
					ABTfcXf5 = new ParsedURL(NGe8Q0QZ);
				}
				E4NQQWuK.getUserAgent().checkLoadExternalResource(XG6B8lig, ABTfcXf5);
				N0CP5diu = ICC_Profile.getInstance(XG6B8lig.openStream());
			} catch (IOException sYMszazP) {
				throw new BridgeException(MQKqHDx2, ERR_URI_IO, new Object[] { WOuwBq8V });
			} catch (SecurityException LlKmzt4t) {
				throw new BridgeException(MQKqHDx2, ERR_URI_UNSECURE, new Object[] { WOuwBq8V });
			}
		}
		if (N0CP5diu == null) {
			return null;
		}
		int F4TwqfZc = convertIntent(PpEWvVRf);
		BHMJ8rK2 = new ICCColorSpaceExt(N0CP5diu, F4TwqfZc);
		cache.put(lsaFwStB.toLowerCase(), BHMJ8rK2);
		return BHMJ8rK2;
	}

}