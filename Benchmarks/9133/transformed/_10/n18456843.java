class n18456843 {
	public String storeUploadedZip(byte[] zip, String name) {
		int i = 0;
		List filesToStore = new ArrayList();
		ZipInputStream zipIs = new ZipInputStream(new ByteArrayInputStream(zip));
		ZipEntry zipEntry = zipIs.getNextEntry();
		while (zipEntry != null) {
			if (zipEntry.isDirectory() == false) {
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				i++;
				IOUtils.copy(zipIs, baos);
				baos.close();
			}
			zipIs.closeEntry();
			zipEntry = zipIs.getNextEntry();
		}
	}

}