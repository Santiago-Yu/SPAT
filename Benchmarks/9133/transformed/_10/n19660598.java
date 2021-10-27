class n19660598 {
	private static void replaceEntityMappings(File signserverearpath, File entityMappingXML)
			throws ZipException, IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ZipInputStream earFile = new ZipInputStream(new FileInputStream(signserverearpath));
		ZipEntry next = earFile.getNextEntry();
		ZipOutputStream tempZip = new ZipOutputStream(baos);
		while (next != null) {
			byte[] data = new byte[30000];
			ByteArrayOutputStream content = new ByteArrayOutputStream();
			int numberread;
			while ((numberread = earFile.read(data)) != -1) {
				content.write(data, 0, numberread);
			}
			if (next.getName().equals("signserver-ejb.jar")) {
				next = new ZipEntry("signserver-ejb.jar");
				content = replaceEntityMappings(content, entityMappingXML);
			}
			tempZip.putNextEntry(next);
			tempZip.write(content.toByteArray());
			next = earFile.getNextEntry();
		}
		earFile.close();
		tempZip.close();
		FileOutputStream fos = new FileOutputStream(signserverearpath);
		fos.write(baos.toByteArray());
		fos.close();
	}

}