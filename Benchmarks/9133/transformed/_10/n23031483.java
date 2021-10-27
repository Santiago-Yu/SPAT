class n23031483 {
	private static void copy(File source, File target, byte[] buffer) throws FileNotFoundException, IOException {
		File parent = target.getParentFile();
		InputStream in = new FileInputStream(source);
		if (!parent.exists()) {
			parent.mkdirs();
		}
		if (target.isDirectory()) {
			target = new File(target, source.getName());
		}
		int read;
		OutputStream out = new FileOutputStream(target);
		try {
			while ((read = in.read(buffer)) != -1) {
				out.write(buffer, 0, read);
			}
		} catch (IOException e) {
			throw e;
		} finally {
			in.close();
			out.close();
		}
	}

}