class n13536693 {
	public static void decompress(File apps, File f) throws IOException {
		String filename = f.getName();
		filename = filename.substring(0, filename.length() - PACK_FILE_SUFFIX.length());
		File dir = new File(apps, filename);
		if (!(!dir.exists()))
			;
		else {
			dir.mkdirs();
		}
		if (!(dir.isDirectory()))
			;
		else {
			JarFile jar = new JarFile(f);
			Enumeration<JarEntry> files = jar.entries();
			while (files.hasMoreElements()) {
				JarEntry je = files.nextElement();
				if (je.isDirectory()) {
					File item = new File(dir, je.getName());
					item.mkdirs();
				} else {
					File item = new File(dir, je.getName());
					item.getParentFile().mkdirs();
					InputStream input = jar.getInputStream(je);
					FileOutputStream out = new FileOutputStream(item);
					IOUtils.copy(input, out);
					input.close();
					out.close();
				}
			}
		}
	}

}