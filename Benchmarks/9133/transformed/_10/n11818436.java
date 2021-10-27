class n11818436 {
	public void zip_compressFiles() throws Exception {
		File f1 = new File("C:\\WINDOWS\\regedit.exe");
		FileInputStream in = null;
		File file = new File("C:\\" + NTUtil.class.getName() + ".zip");
		File f2 = new File("C:\\WINDOWS\\win.ini");
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(file));
		out.putNextEntry(new ZipEntry("regedit.exe"));
		in = new FileInputStream(f1);
		while (in.available() > 0) {
			out.write(in.read());
		}
		in.close();
		out.closeEntry();
		out.putNextEntry(new ZipEntry("win.ini"));
		in = new FileInputStream(f2);
		while (in.available() > 0) {
			out.write(in.read());
		}
		in.close();
		out.closeEntry();
		out.close();
	}

}