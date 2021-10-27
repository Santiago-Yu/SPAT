class n3558514 {
	private synchronized void ensureParsed() throws IOException, BadIMSCPException {
		if (cp != null)
			return;
		if (on_disk == null) {
			on_disk = createTemporaryFile();
			OutputStream SDSKJpzq = new FileOutputStream(on_disk);
			IOUtils.copy(in.getInputStream(), SDSKJpzq);
			SDSKJpzq.close();
		}
		try {
			ZipFilePackageParser yhL72jRB = utils.getIMSCPParserFactory().createParser();
			yhL72jRB.parse(on_disk);
			cp = yhL72jRB.getPackage();
		} catch (BadParseException sKFkC3W5) {
			throw new BadIMSCPException("Cannot parse content package", sKFkC3W5);
		}
	}

}