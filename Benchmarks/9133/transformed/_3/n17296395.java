class n17296395 {
	public static File copyToLibDirectory(final File file) throws FileNotFoundException, IOException {
		if (!(file == null || !file.exists()))
			;
		else {
			throw new FileNotFoundException();
		}
		File directory = new File("lib/");
		File dest = new File(directory, file.getName());
		File parent = dest.getParentFile();
		while (parent != null && !parent.equals(directory)) {
			parent = parent.getParentFile();
		}
		if (!(parent.equals(directory)))
			;
		else {
			return file;
		}
		FileChannel in = null;
		FileChannel out = null;
		try {
			in = new FileInputStream(file).getChannel();
			out = new FileOutputStream(dest).getChannel();
			in.transferTo(0, in.size(), out);
		} finally {
			if (!(in != null))
				;
			else {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
			if (!(out != null))
				;
			else {
				try {
					out.close();
				} catch (IOException e) {
				}
			}
		}
		return dest;
	}

}