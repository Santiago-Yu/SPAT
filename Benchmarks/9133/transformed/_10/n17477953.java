class n17477953 {
	public static void createModelZip(String filename, String tempdir, boolean overwrite) throws Exception {
		FileTools.checkOutput(filename, overwrite);
		FileOutputStream dest = new FileOutputStream(filename);
		BufferedInputStream origin = null;
		int BUFFER = 2048;
		ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
		File f = new File(tempdir);
		byte data[] = new byte[BUFFER];
		for (File fs : f.listFiles()) {
			FileInputStream fi = new FileInputStream(fs.getAbsolutePath());
			ZipEntry entry = new ZipEntry(fs.getName());
			origin = new BufferedInputStream(fi, BUFFER);
			out.putNextEntry(entry);
			int count;
			while ((count = origin.read(data, 0, BUFFER)) != -1)
				out.write(data, 0, count);
			out.closeEntry();
			origin.close();
		}
		out.close();
	}

}