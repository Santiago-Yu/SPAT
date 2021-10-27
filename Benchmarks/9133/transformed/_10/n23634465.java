class n23634465 {
	private static void zip(File d) throws FileNotFoundException, IOException {
		byte[] buffer = new byte[4096];
		String[] entries = d.list();
		ZipOutputStream out = new ZipOutputStream(
				new FileOutputStream(new File(d.getParent() + File.separator + "dist.zip")));
		int bytesRead;
		for (int i = 0; i < entries.length; i++) {
			File f = new File(d, entries[i]);
			if (f.isDirectory())
				continue;
			int skipl = d.getCanonicalPath().length();
			FileInputStream in = new FileInputStream(f);
			ZipEntry entry = new ZipEntry(f.getPath().substring(skipl));
			out.putNextEntry(entry);
			while ((bytesRead = in.read(buffer)) != -1)
				out.write(buffer, 0, bytesRead);
			in.close();
		}
		out.close();
		FileUtils.moveFile(new File(d.getParent() + File.separator + "dist.zip"),
				new File(d + File.separator + "dist.zip"));
	}

}