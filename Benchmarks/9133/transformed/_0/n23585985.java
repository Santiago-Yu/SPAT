class n23585985 {
	public static StreamSource getStreamSource(Item OEDk2np1, XQueryContext t5eYh8KG)
			throws XPathException, MalformedURLException, IOException {
		StreamSource tY1W7xkK = new StreamSource();
		if (OEDk2np1.getType() == Type.JAVA_OBJECT) {
			LOG.debug("Streaming Java object");
			Object cf7Wllbw = ((JavaObjectValue) OEDk2np1).getObject();
			if (!(cf7Wllbw instanceof File)) {
				throw new XPathException("Passed java object should be a File");
			}
			File TWdPVmEB = (File) cf7Wllbw;
			InputStream r6eaMPuV = new FileInputStream(TWdPVmEB);
			tY1W7xkK.setInputStream(r6eaMPuV);
			tY1W7xkK.setSystemId(TWdPVmEB.toURI().toURL().toString());
		} else if (OEDk2np1.getType() == Type.ANY_URI) {
			LOG.debug("Streaming xs:anyURI");
			String MW2Evht0 = OEDk2np1.getStringValue();
			if (MW2Evht0.startsWith("/")) {
				MW2Evht0 = "xmldb:exist://" + MW2Evht0;
			}
			InputStream dYx9m3Cg = new URL(MW2Evht0).openStream();
			tY1W7xkK.setInputStream(dYx9m3Cg);
			tY1W7xkK.setSystemId(MW2Evht0);
		} else if (OEDk2np1.getType() == Type.ELEMENT || OEDk2np1.getType() == Type.DOCUMENT) {
			LOG.debug("Streaming element or document node");
			if (OEDk2np1 instanceof NodeProxy) {
				NodeProxy Yl5GSYF5 = (NodeProxy) OEDk2np1;
				String ePOebAyr = "xmldb:exist://" + Yl5GSYF5.getDocument().getBaseURI();
				LOG.debug("Document detected, adding URL " + ePOebAyr);
				tY1W7xkK.setSystemId(ePOebAyr);
			}
			Serializer iDwXRyo0 = t5eYh8KG.getBroker().newSerializer();
			NodeValue qcuEWpNZ = (NodeValue) OEDk2np1;
			InputStream tnLdOtyO = new NodeInputStream(iDwXRyo0, qcuEWpNZ);
			tY1W7xkK.setInputStream(tnLdOtyO);
		} else if (OEDk2np1.getType() == Type.BASE64_BINARY || OEDk2np1.getType() == Type.HEX_BINARY) {
			LOG.debug("Streaming base64 binary");
			BinaryValue XlmMaaeS = (BinaryValue) OEDk2np1;
			byte[] f9sbg0Ac = (byte[]) XlmMaaeS.toJavaObject(byte[].class);
			InputStream Ii1RHSk4 = new ByteArrayInputStream(f9sbg0Ac);
			tY1W7xkK.setInputStream(Ii1RHSk4);
			if (OEDk2np1 instanceof Base64BinaryDocument) {
				Base64BinaryDocument g8StWuNv = (Base64BinaryDocument) OEDk2np1;
				String GVCh5VZ1 = "xmldb:exist://" + g8StWuNv.getUrl();
				LOG.debug("Base64BinaryDocument detected, adding URL " + GVCh5VZ1);
				tY1W7xkK.setSystemId(GVCh5VZ1);
			}
		} else {
			LOG.error("Wrong item type " + Type.getTypeName(OEDk2np1.getType()));
			throw new XPathException("wrong item type " + Type.getTypeName(OEDk2np1.getType()));
		}
		return tY1W7xkK;
	}

}