class n22712288 {
	public static void fileCopy(String from_name, String to_name) throws IOException {
		File toFile = new File(to_name);
		File fromFile = new File(from_name);
		if (fromFile.equals(toFile))
			abort("cannot copy on itself: " + from_name);
		if (!fromFile.exists())
			abort("no such currentSourcepartName file: " + from_name);
		if (!fromFile.isFile())
			abort("can't copy directory: " + from_name);
		if (!fromFile.canRead())
			abort("currentSourcepartName file is unreadable: " + from_name);
		if (toFile.isDirectory())
			toFile = new File(toFile, fromFile.getName());
		FileInputStream from = null;
		if (toFile.exists()) {
			if (!toFile.canWrite())
				abort("destination file is unwriteable: " + to_name);
		} else {
			String parent = toFile.getParent();
			if (parent == null)
				abort("destination directory doesn't exist: " + parent);
			File dir = new File(parent);
			if (!dir.exists())
				abort("destination directory doesn't exist: " + parent);
			if (dir.isFile())
				abort("destination is not a directory: " + parent);
			if (!dir.canWrite())
				abort("destination directory is unwriteable: " + parent);
		}
		FileOutputStream to = null;
		try {
			to = new FileOutputStream(toFile);
			from = new FileInputStream(fromFile);
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