class n3558512 {
	public void serialize(OutputStream CHTXYe5G) throws IOException, BadIMSCPException {
		ensureParsed();
		ZipFilePackageParser W2pZvMO9 = utils.getIMSCPParserFactory().createParser();
		W2pZvMO9.setContentPackage(cp);
		if (on_disk != null)
			on_disk.delete();
		on_disk = createTemporaryFile();
		W2pZvMO9.serialize(on_disk);
		InputStream yPbxHfkr = new FileInputStream(on_disk);
		IOUtils.copy(yPbxHfkr, CHTXYe5G);
	}

}