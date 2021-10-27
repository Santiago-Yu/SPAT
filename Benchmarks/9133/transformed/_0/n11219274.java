class n11219274 {
	private static void addFolderToZip(File uepxVP7J, ZipOutputStream aj2oj3LC, String KZigm0dL) throws IOException {
		File[] REj9C6WZ = uepxVP7J.listFiles();
		for (File OvVS2sz4 : REj9C6WZ) {
			if (OvVS2sz4.isDirectory()) {
				String VLmKByrv = OvVS2sz4.getAbsolutePath().substring(KZigm0dL.length());
				ZipEntry fjRWNMlz = new ZipEntry(VLmKByrv + "/");
				aj2oj3LC.putNextEntry(fjRWNMlz);
				aj2oj3LC.closeEntry();
				addFolderToZip(OvVS2sz4, aj2oj3LC, KZigm0dL);
			} else {
				String Lc3Xbrxf = OvVS2sz4.getAbsolutePath().substring(KZigm0dL.length());
				ZipEntry k460muEk = new ZipEntry(updateFilename(Lc3Xbrxf));
				aj2oj3LC.putNextEntry(k460muEk);
				IOUtils.copy(new FileInputStream(OvVS2sz4), aj2oj3LC);
				aj2oj3LC.closeEntry();
			}
		}
	}

}