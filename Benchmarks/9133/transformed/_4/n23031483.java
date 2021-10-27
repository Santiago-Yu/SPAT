class n23031483 {
	private static void copy(File source, File target, byte[] buffer) throws FileNotFoundException, IOException {
		InputStream in = new FileInputStream(source);
		File parent = target.getParentFile();
		if (!parent.exists()) {
			parent.mkdirs();
		}
		target = (target.isDirectory()) ? new File(target, source.getName()) : target;
		OutputStream out = new FileOutputStream(target);
		int read;
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