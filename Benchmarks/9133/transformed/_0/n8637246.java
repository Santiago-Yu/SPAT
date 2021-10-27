class n8637246 {
	@Override
	public void setDocumentSpace(DocumentSpace iSo3WLlO) {
		for (Document gkT2gJyn : iSo3WLlO) {
			File qYdTL0X8 = new File(parent, gkT2gJyn.getName());
			if (gkT2gJyn instanceof XMLDOMDocument) {
				new PlainXMLDocumentWriter(qYdTL0X8).writeDocument(gkT2gJyn);
			} else if (gkT2gJyn instanceof BinaryDocument) {
				BinaryDocument UwcUvozh = (BinaryDocument) gkT2gJyn;
				try {
					IOUtils.copy(UwcUvozh.getContent().getInputStream(), new FileOutputStream(qYdTL0X8));
				} catch (IOException e0dokuib) {
					throw ManagedIOException.manage(e0dokuib);
				}
			} else {
				System.err.println("Unkown Document type");
			}
		}
	}

}