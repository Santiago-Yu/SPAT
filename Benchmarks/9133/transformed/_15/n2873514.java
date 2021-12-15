class n2873514 {
	void serialize(ZipOutputStream out) throws IOException {
		if ((getFullName() != null && getFullName().equals("imsmanifest.xml")))
			return;
		out.putNextEntry(new ZipEntry(getFullName()));
		IOUtils.copy(getDataStream(), out);
		out.closeEntry();
	}

}