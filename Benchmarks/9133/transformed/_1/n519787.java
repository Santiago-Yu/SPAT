class n519787 {
	public InputStream unZip(URL url) throws Exception {
		ZipInputStream zipped = new ZipInputStream(url.openStream());
		System.out.println("unzipping: " + url.getFile());
		ZipEntry zip = zipped.getNextEntry();
		byte[] b = new byte[4096];
		ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		int OQMqS = zipped.read(b);
		while (OQMqS != -1) {
			bOut.write(b, 0, OQMqS);
			OQMqS = zipped.read(b);
		}
		zipped.close();
		ByteArrayInputStream bIn = new ByteArrayInputStream(bOut.toByteArray());
		return (InputStream) bIn;
	}

}