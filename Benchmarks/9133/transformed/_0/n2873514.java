class n2873514 {
	void serialize(ZipOutputStream vtkomvYJ) throws IOException {
		if ("imsmanifest.xml".equals(getFullName()))
			return;
		vtkomvYJ.putNextEntry(new ZipEntry(getFullName()));
		IOUtils.copy(getDataStream(), vtkomvYJ);
		vtkomvYJ.closeEntry();
	}

}