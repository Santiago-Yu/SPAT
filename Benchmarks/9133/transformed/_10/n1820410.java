class n1820410 {
	public static void zipDirectory(String dir, String zipfile) throws IOException, IllegalArgumentException {
		File d = new File(dir);
		if (!d.isDirectory())
			throw new IllegalArgumentException("Not a directory:  " + dir);
		byte[] buffer = new byte[4096];
		String[] entries = d.list();
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipfile));
		int bytesRead;
		for (int i = 0; i < entries.length; i++) {
			File f = new File(d, entries[i]);
			if (f.isDirectory())
				continue;
			FileInputStream in = new FileInputStream(f);
			ZipEntry entry = new ZipEntry(f.getPath());
			out.putNextEntry(entry);
			while ((bytesRead = in.read(buffer)) != -1)
				out.write(buffer, 0, bytesRead);
			in.close();
		}
		out.close();
	}

}