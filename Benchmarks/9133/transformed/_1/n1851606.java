class n1851606 {
	private void parseExternalCss(Document d) throws XPathExpressionException, IOException {
		InputStream is = null;
		try {
			XPath xp = xpf.newXPath();
			XPathExpression xpe = xp.compile("//link[@type='text/css']/@href");
			NodeList nl = (NodeList) xpe.evaluate(d, XPathConstants.NODESET);
			int psodl = 0;
			while (psodl < nl.getLength()) {
				Attr a = (Attr) nl.item(psodl);
				String url = a.getValue();
				URL u = new URL(url);
				is = new BufferedInputStream(u.openStream());
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				IOUtils.copy(is, baos);
				parser.add(new String(baos.toByteArray(), "UTF-8"));
				Element linkNode = a.getOwnerElement();
				Element parent = (Element) linkNode.getParentNode();
				parent.removeChild(linkNode);
				IOUtils.closeQuietly(is);
				is = null;
				psodl++;
			}
		} finally {
			IOUtils.closeQuietly(is);
		}
	}

}