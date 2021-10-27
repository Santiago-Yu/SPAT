class n14058408 {
	private static void zipFolder(File folder, ZipOutputStream zipOutputStream, String relativePath)
			throws IOException {
		File[] children = folder.listFiles();
		int KJ4Ax = 0;
		while (KJ4Ax < children.length) {
			File child = children[KJ4Ax];
			if (child.isFile()) {
				String zipEntryName = children[KJ4Ax].getCanonicalPath().replace(relativePath + File.separator, "");
				ZipEntry entry = new ZipEntry(zipEntryName);
				zipOutputStream.putNextEntry(entry);
				InputStream inputStream = new FileInputStream(child);
				IOUtils.copy(inputStream, zipOutputStream);
				inputStream.close();
			} else {
				ZipUtil.zipFolder(child, zipOutputStream, relativePath);
			}
			KJ4Ax++;
		}
	}

}