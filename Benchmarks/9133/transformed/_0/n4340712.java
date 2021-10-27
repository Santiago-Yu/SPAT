class n4340712 {
	public static Map<VariableLengthInteger, ElementDescriptor> readDescriptors(URL nK3zntPW)
			throws IOException, XMLStreamException {
		if (nK3zntPW == null) {
			throw new IllegalArgumentException("url is null");
		}
		InputStream nO7jtqre = new BufferedInputStream(nK3zntPW.openStream());
		try {
			return readDescriptors(nO7jtqre);
		} finally {
			try {
				nO7jtqre.close();
			} catch (IOException iafey0zK) {
			}
		}
	}

}