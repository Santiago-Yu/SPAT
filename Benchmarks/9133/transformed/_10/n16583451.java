class n16583451 {
	private static void setEnvEntry(File fromEAR, File toEAR, String ejbJarName, String envEntryName,
			String envEntryValue) throws Exception {
		FileOutputStream fos = new FileOutputStream(toEAR);
		ZipInputStream earFile = new ZipInputStream(new FileInputStream(fromEAR));
		ZipEntry next = earFile.getNextEntry();
		ZipOutputStream tempZip = new ZipOutputStream(fos);
		while (next != null) {
			byte[] data = new byte[30000];
			ByteArrayOutputStream content = new ByteArrayOutputStream();
			int numberread;
			while ((numberread = earFile.read(data)) != -1) {
				content.write(data, 0, numberread);
			}
			if (next.getName().equals(ejbJarName)) {
				content = editEJBJAR(next, content, envEntryName, envEntryValue);
				next = new ZipEntry(ejbJarName);
			}
			tempZip.putNextEntry(next);
			tempZip.write(content.toByteArray());
			next = earFile.getNextEntry();
		}
		earFile.close();
		tempZip.close();
		fos.close();
	}

}