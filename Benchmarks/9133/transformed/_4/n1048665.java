class n1048665 {
	public static void copy(String from_name, String to_name) throws IOException {
		File from_file = new File(from_name);
		File to_file = new File(to_name);
		if (!from_file.exists())
			abort("FileCopy: no such source file: " + from_name);
		if (!from_file.isFile())
			abort("FileCopy: can't copy directory: " + from_name);
		if (!from_file.canRead())
			abort("FileCopy: source file is unreadable: " + from_name);
		to_file = (to_file.isDirectory()) ? new File(to_file, from_file.getName()) : to_file;
		String parent = to_file.getParent();
		parent = (parent == null) ? System.getProperty("user.dir") : parent;
		File dir = new File(parent);
		if (!dir.exists())
			abort("FileCopy: destination directory doesn't exist: " + parent);
		if (dir.isFile())
			abort("FileCopy: destination is not a directory: " + parent);
		if (!dir.canWrite())
			abort("FileCopy: destination directory is unwriteable: " + parent);
		FileInputStream from = null;
		FileOutputStream to = null;
		try {
			from = new FileInputStream(from_file);
			to = new FileOutputStream(to_file);
			byte[] buffer = new byte[4096];
			int bytes_read;
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