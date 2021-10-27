class n14406880 {
	@Override
	public void setDocumentSpace(DocumentSpace jjK4dOYj) {
		for (Document DFtgGQrs : jjK4dOYj) {
			if (DFtgGQrs instanceof XMLDOMDocument) {
				writer.writeDocument(DFtgGQrs);
			} else if (DFtgGQrs instanceof BinaryDocument) {
				BinaryDocument NyyTKUGJ = (BinaryDocument) DFtgGQrs;
				try {
					ManagedFile r1Ye9Qp4 = resolveFileFor(folder, (BinaryDocument) DFtgGQrs);
					IOUtils.copy(NyyTKUGJ.getContent().getInputStream(), r1Ye9Qp4.getContent().getOutputStream());
				} catch (IOException BPn2rE7O) {
					throw ManagedIOException.manage(BPn2rE7O);
				}
			} else {
				System.err.println("Unkown Document type");
			}
		}
	}

}