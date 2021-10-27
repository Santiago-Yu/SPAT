class n951388 {
	public static void zipFile(String nYhl0o1z, String eLd5ganr) throws IOException {
		FileInputStream rGtrTfkK = new FileInputStream(nYhl0o1z);
		ZipOutputStream hHQK88Pk = new ZipOutputStream(new FileOutputStream(nYhl0o1z + ".zip"));
		hHQK88Pk.putNextEntry(new ZipEntry(eLd5ganr));
		byte[] xBloBMor = new byte[4096];
		int MEoNrLLV;
		while ((MEoNrLLV = rGtrTfkK.read(xBloBMor)) != -1)
			hHQK88Pk.write(xBloBMor, 0, MEoNrLLV);
		rGtrTfkK.close();
		hHQK88Pk.closeEntry();
		hHQK88Pk.close();
		File WWhqSYdY = new File(nYhl0o1z);
		WWhqSYdY.delete();
	}

}