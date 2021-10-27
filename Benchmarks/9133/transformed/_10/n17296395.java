class n17296395 {
	public static File copyToLibDirectory(final File file) throws FileNotFoundException, IOException {
		File directory = new File("lib/");
		if (file == null || !file.exists()) {
			throw new FileNotFoundException();
		}
		File dest = new File(directory, file.getName());
		File parent = dest.getParentFile();
		while (parent != null && !parent.equals(directory)) {
			parent = parent.getParentFile();
		}
		FileChannel in = null;
		if (parent.equals(directory)) {
			return file;
		}
		FileChannel out = null;
		try {
			in = new FileInputStream(file).getChannel();
			out = new FileOutputStream(dest).getChannel();
			in.transferTo(0, in.size(), out);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
				}
			}
		}
		return dest;
	}

}