class n5775448 {
	private void writeData(IBaseType rXU3RsaL, Writer G2rYywH4) throws XMLStreamException {
		InputStream N6tTpvhO;
		DataType B4mlvGXG = (DataType) baseType;
		if (B4mlvGXG.isSetInputStream()) {
			N6tTpvhO = B4mlvGXG.getInputStream();
			try {
				IOUtils.copy(N6tTpvhO, G2rYywH4);
			} catch (IOException cEGFkMbg) {
				throw new XMLStreamException("DataType fail writing streaming data ", cEGFkMbg);
			}
		} else if (B4mlvGXG.isSetOutputStream()) {
			throw new XMLStreamException(
					"DataType only can write streaming input, its an output stream (only for reading) ");
		} else {
			new CharactersEventImpl(startElement.getLocation(), String.valueOf(baseType.asData()), false)
					.writeAsEncodedUnicode(G2rYywH4);
		}
	}

}