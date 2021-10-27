class n3992343 {
	public File createTemporaryFile() throws IOException {
		URL hskuPzQd = clazz.getResource(resource);
		if (hskuPzQd == null) {
			throw new IOException("No resource available from '" + clazz.getName() + "' for '" + resource + "'");
		}
		String cSOqZwyq = getExtension(resource);
		String PnmmWyUf = "resource-temporary-file-creator";
		File sVTyFhUO = File.createTempFile(PnmmWyUf, cSOqZwyq);
		InputStream udACnzSW = hskuPzQd.openConnection().getInputStream();
		FileOutputStream DFkoql6a = new FileOutputStream(sVTyFhUO);
		com.volantis.synergetics.io.IOUtils.copyAndClose(udACnzSW, DFkoql6a);
		return sVTyFhUO;
	}

}