class n1851606 {
	private void parseExternalCss(Document lAXSWc6o) throws XPathExpressionException, IOException {
		InputStream oSODOlBz = null;
		try {
			XPath ju6XQjy7 = xpf.newXPath();
			XPathExpression cdaXwWNY = ju6XQjy7.compile("//link[@type='text/css']/@href");
			NodeList Naa0rZDa = (NodeList) cdaXwWNY.evaluate(lAXSWc6o, XPathConstants.NODESET);
			for (int fEDXttom = 0; fEDXttom < Naa0rZDa.getLength(); fEDXttom++) {
				Attr XwOnwYuO = (Attr) Naa0rZDa.item(fEDXttom);
				String c4plcw49 = XwOnwYuO.getValue();
				URL Xq0QNzla = new URL(c4plcw49);
				oSODOlBz = new BufferedInputStream(Xq0QNzla.openStream());
				ByteArrayOutputStream fgeq24oS = new ByteArrayOutputStream();
				IOUtils.copy(oSODOlBz, fgeq24oS);
				parser.add(new String(fgeq24oS.toByteArray(), "UTF-8"));
				Element z5xiqJQD = XwOnwYuO.getOwnerElement();
				Element yQsLCfBh = (Element) z5xiqJQD.getParentNode();
				yQsLCfBh.removeChild(z5xiqJQD);
				IOUtils.closeQuietly(oSODOlBz);
				oSODOlBz = null;
			}
		} finally {
			IOUtils.closeQuietly(oSODOlBz);
		}
	}

}