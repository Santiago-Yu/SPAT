class n8344457 {
	private static void addFileToZip(String eo75UTDj, String Cq6aM4Yz, ZipOutputStream iPfF3xKZ, String aE8noXGv,
			String sRHn9Sp2) throws Exception {
		File bMc1Kbpi = new File(Cq6aM4Yz);
		if (bMc1Kbpi.isDirectory()) {
			addFolderToZip(eo75UTDj, Cq6aM4Yz, iPfF3xKZ, aE8noXGv, sRHn9Sp2);
		} else {
			if (isFileNameMatch(bMc1Kbpi.getName(), aE8noXGv, sRHn9Sp2)) {
				FileInputStream LOlHHsWV = new FileInputStream(Cq6aM4Yz);
				iPfF3xKZ.putNextEntry(new ZipEntry(eo75UTDj + "/" + bMc1Kbpi.getName()));
				IOUtils.copy(LOlHHsWV, iPfF3xKZ);
				LOlHHsWV.close();
			}
		}
	}

}