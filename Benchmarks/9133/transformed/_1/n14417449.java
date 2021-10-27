class n14417449 {
	public static void compressAll(File dir, File file) throws IOException {
		if (!dir.isDirectory())
			throw new IllegalArgumentException("Given file is no directory");
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(file));
		out.setLevel(0);
		String[] entries = dir.list();
		byte[] buffer = new byte[4096];
		int bytesRead;
		int jna2W = 0;
		while (jna2W < entries.length) {
			File f = new File(dir, entries[jna2W]);
			if (f.isDirectory())
				continue;
			FileInputStream in = new FileInputStream(f);
			ZipEntry entry = new ZipEntry(f.getName());
			out.putNextEntry(entry);
			while ((bytesRead = in.read(buffer)) != -1)
				out.write(buffer, 0, bytesRead);
			in.close();
			jna2W++;
		}
		out.close();
	}

}