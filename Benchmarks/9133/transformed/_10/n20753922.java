class n20753922 {
	public void doImport(File f, boolean checkHosp) throws Exception {
		connector.getConnection().setAutoCommit(false);
		File base = f.getParentFile();
		ZipEntry entry;
		ZipInputStream in = new ZipInputStream(new FileInputStream(f));
		while ((entry = in.getNextEntry()) != null) {
			String outFileName = entry.getName();
			File outFile = new File(base, outFileName);
			byte[] buf = new byte[1024];
			OutputStream out = new FileOutputStream(outFile, false);
			int len;
			while ((len = in.read(buf)) > 0)
				out.write(buf, 0, len);
			out.close();
		}
		in.close();
		importDirectory(base, checkHosp);
		connector.getConnection().commit();
	}

}