class n14406880 {
	@Override
	public void setDocumentSpace(DocumentSpace space) {
		for (Document doc : space) {
			if (!(doc instanceof XMLDOMDocument)) {
				if (doc instanceof BinaryDocument) {
					BinaryDocument bin = (BinaryDocument) doc;
					try {
						ManagedFile result = resolveFileFor(folder, (BinaryDocument) doc);
						IOUtils.copy(bin.getContent().getInputStream(), result.getContent().getOutputStream());
					} catch (IOException e) {
						throw ManagedIOException.manage(e);
					}
				} else {
					System.err.println("Unkown Document type");
				}
			} else {
				writer.writeDocument(doc);
			}
		}
	}

}