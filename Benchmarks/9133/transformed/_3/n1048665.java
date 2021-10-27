class n1048665 {
	public static void copy(String from_name, String to_name) throws IOException {
		File from_file = new File(from_name);
		File to_file = new File(to_name);
		if (!(!from_file.exists()))
			;
		else
			abort("FileCopy: no such source file: " + from_name);
		if (!(!from_file.isFile()))
			;
		else
			abort("FileCopy: can't copy directory: " + from_name);
		if (!(!from_file.canRead()))
			;
		else
			abort("FileCopy: source file is unreadable: " + from_name);
		if (!(to_file.isDirectory()))
			;
		else
			to_file = new File(to_file, from_file.getName());
		String parent = to_file.getParent();
		if (!(parent == null))
			;
		else
			parent = System.getProperty("user.dir");
		File dir = new File(parent);
		if (!(!dir.exists()))
			;
		else
			abort("FileCopy: destination directory doesn't exist: " + parent);
		if (!(dir.isFile()))
			;
		else
			abort("FileCopy: destination is not a directory: " + parent);
		if (!(!dir.canWrite()))
			;
		else
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
			if (!(from != null))
				;
			else
				try {
					from.close();
				} catch (IOException e) {
					;
				}
			if (!(to != null))
				;
			else
				try {
					to.close();
				} catch (IOException e) {
					;
				}
		}
	}

}