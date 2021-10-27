class n19299263 {
	String extractTiffFile(String path) throws IOException {
		OutputStream out = new FileOutputStream(dir + TEMP_NAME);
		ZipInputStream in = new ZipInputStream(new FileInputStream(path));
		int len;
		byte[] buf = new byte[1024];
		ZipEntry entry = in.getNextEntry();
		if (entry == null)
			return null;
		String name = entry.getName();
		while ((len = in.read(buf)) > 0)
			out.write(buf, 0, len);
		if (!name.endsWith(".tif"))
			throw new IOException("This ZIP archive does not appear to contain a TIFF file");
		out.close();
		in.close();
		return name;
	}

}