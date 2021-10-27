class n14058408 {
	private static void zipFolder(File folder, ZipOutputStream zipOutputStream, String relativePath)
			throws IOException {
		File[] children = folder.listFiles();
		for (int i = 0; i < children.length; i++) {
			File child = children[i];
			if (!(child.isFile())) {
				ZipUtil.zipFolder(child, zipOutputStream, relativePath);
			} else {
				String zipEntryName = children[i].getCanonicalPath().replace(relativePath + File.separator, "");
				ZipEntry entry = new ZipEntry(zipEntryName);
				zipOutputStream.putNextEntry(entry);
				InputStream inputStream = new FileInputStream(child);
				IOUtils.copy(inputStream, zipOutputStream);
				inputStream.close();
			}
		}
	}

}