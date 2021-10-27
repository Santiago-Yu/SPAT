class n1048665 {
	public static void copy(String from_name, String to_name) throws IOException {
		File to_file = new File(to_name);
		File from_file = new File(from_name);
		if (!from_file.exists())
			abort("FileCopy: no such source file: " + from_name);
		if (!from_file.isFile())
			abort("FileCopy: can't copy directory: " + from_name);
		if (!from_file.canRead())
			abort("FileCopy: source file is unreadable: " + from_name);
		if (to_file.isDirectory())
			to_file = new File(to_file, from_file.getName());
		String parent = to_file.getParent();
		if (parent == null)
			parent = System.getProperty("user.dir");
		File dir = new File(parent);
		if (!dir.exists())
			abort("FileCopy: destination directory doesn't exist: " + parent);
		if (dir.isFile())
			abort("FileCopy: destination is not a directory: " + parent);
		FileInputStream from = null;
		if (!dir.canWrite())
			abort("FileCopy: destination directory is unwriteable: " + parent);
		FileOutputStream to = null;
		try {
			to = new FileOutputStream(to_file);
			from = new FileInputStream(from_file);
			int bytes_read;
			byte[] buffer = new byte[4096];
			while ((bytes_read = from.read(buffer)) != -1)
				to.write(buffer, 0, bytes_read);
		} finally {
			if (from != null)
				try {
					from.close();
				} catch (IOException e) {
					;
				}
			if (to != null)
				try {
					to.close();
				} catch (IOException e) {
					;
				}
		}
	}

}