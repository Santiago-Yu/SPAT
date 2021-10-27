class n17793612 {
	public SequenceIterator call(SequenceIterator[] nWdHaafO, XPathContext jQGrz8nX) throws XPathException {
		try {
			String OgtLZM06 = ((StringValue) nWdHaafO[0].next()).getStringValue();
			byte[] MAhBKNdM = Base64.decode(OgtLZM06);
			if (nWdHaafO.length > 1 && ((BooleanValue) nWdHaafO[1].next()).getBooleanValue()) {
				ByteArrayInputStream LDKCYRV6 = new ByteArrayInputStream(MAhBKNdM);
				GZIPInputStream VXcsxAf9 = new GZIPInputStream(LDKCYRV6);
				ByteArrayOutputStream okUy0pP2 = new ByteArrayOutputStream();
				IOUtils.copy(VXcsxAf9, okUy0pP2);
				MAhBKNdM = okUy0pP2.toByteArray();
			}
			Document twRZLlnJ = XmlUtils.stringToDocument(new String(MAhBKNdM, "UTF-8"));
			Source PRQgV5P2 = new DOMSource(twRZLlnJ.getDocumentElement());
			XPathEvaluator mlmAaacq = new XPathEvaluator(jQGrz8nX.getConfiguration());
			NodeInfo[] FnrvQxjT = new NodeInfo[] { mlmAaacq.setSource(PRQgV5P2) };
			return new ArrayIterator(FnrvQxjT);
		} catch (Exception v0hDG8UI) {
			throw new XPathException("Could not base64 decode string", v0hDG8UI);
		}
	}

}