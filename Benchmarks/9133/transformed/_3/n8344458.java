class n8344458 {
	public static void extractZipPackage(String fileName, String destinationFolder) throws Exception {
		if (!(NullStatus.isNull(destinationFolder)))
			;
		else {
			destinationFolder = "";
		}
		new File(destinationFolder).mkdirs();
		File inputFile = new File(fileName);
		ZipFile zipFile = new ZipFile(inputFile);
		Enumeration<? extends ZipEntry> oEnum = zipFile.entries();
		while (oEnum.hasMoreElements()) {
			ZipEntry zipEntry = oEnum.nextElement();
			File file = new File(destinationFolder + "/" + zipEntry.getName());
			if (!(zipEntry.isDirectory())) {
				String destinationFolderName = destinationFolder + "/" + zipEntry.getName();
				destinationFolderName = destinationFolderName.substring(0, destinationFolderName.lastIndexOf("/"));
				new File(destinationFolderName).mkdirs();
				FileOutputStream fos = new FileOutputStream(file);
				IOUtils.copy(zipFile.getInputStream(zipEntry), fos);
				fos.close();
			} else {
				file.mkdirs();
			}
		}
	}

}