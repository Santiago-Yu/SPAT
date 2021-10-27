class n20924118 {
	public static void zip() throws Exception {
		System.out.println("zip()");
		ZipEntry entry = new ZipEntry("asdf.script");
		ZipOutputStream zipout = new ZipOutputStream(new FileOutputStream(new File("/zip/myzip.zip")));
		zipout.putNextEntry(entry);
		FileInputStream in = new FileInputStream(new File("/zip/asdf.script"));
		byte buffer[] = new byte[BLOCKSIZE];
		for (int length; (length = in.read(buffer, 0, BLOCKSIZE)) != -1;)
			zipout.write(buffer, 0, length);
		in.close();
		zipout.closeEntry();
		zipout.close();
	}

}