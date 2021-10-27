class n14651403{
    public ICCColorSpaceExt createICCColorSpaceExt(BridgeContext ctx, Element paintedElement, String iccProfileName) {
        ICCColorSpaceExt cs = cache.request(iccProfileName.toLowerCase());
        if (cs != null) {
            return cs;
        }
        Document doc = paintedElement.getOwnerDocument();
        NodeList list = doc.getElementsByTagNameNS(SVG_NAMESPACE_URI, SVG_COLOR_PROFILE_TAG);
        int n = list.getLength();
        Element profile = null;
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
        if (profile == null) return null;
        String href = XLinkSupport.getXLinkHref(profile);
        ICC_Profile p = null;
        if (href != null) {
            String baseURI = ((SVGOMDocument) doc).getURL();
            ParsedURL purl = new ParsedURL(baseURI, href);
            if (!purl.complete()) throw new BridgeException(paintedElement, ERR_URI_MALFORMED, new Object[] { href });
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
        if (p == null) {
            return null;
        }
        int intent = convertIntent(profile);
        cs = new ICCColorSpaceExt(p, intent);
        cache.put(iccProfileName.toLowerCase(), cs);
        return cs;
    }

}