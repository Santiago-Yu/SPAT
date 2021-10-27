class n21089172 {
	private File Gzip(File f) throws IOException {
		if (f == null || !f.exists())
			return null;
		File dest_dir = f.getParentFile();
		String dest_filename = f.getName() + ".gz";
		File zipfile = new File(dest_dir, dest_filename);
		FileInputStream in = new FileInputStream(f);
		GZIPOutputStream out = new GZIPOutputStream(new FileOutputStream(zipfile));
		int len;
		byte buf[] = new byte[1024];
		while ((len = in.read(buf)) > 0)
			out.write(buf, 0, len);
		out.finish();
		try {
			in.close();
		} catch (Exception e) {
		}
		try {
			out.close();
		} catch (Exception e) {
		}
		try {
			f.delete();
		} catch (Exception e) {
		}
		return zipfile;
	}

}