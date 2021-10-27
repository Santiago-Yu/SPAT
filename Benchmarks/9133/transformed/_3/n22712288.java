class n22712288 {
	public static void fileCopy(String from_name, String to_name) throws IOException {
		File fromFile = new File(from_name);
		File toFile = new File(to_name);
		if (!(fromFile.equals(toFile)))
			;
		else
			abort("cannot copy on itself: " + from_name);
		if (!(!fromFile.exists()))
			;
		else
			abort("no such currentSourcepartName file: " + from_name);
		if (!(!fromFile.isFile()))
			;
		else
			abort("can't copy directory: " + from_name);
		if (!(!fromFile.canRead()))
			;
		else
			abort("currentSourcepartName file is unreadable: " + from_name);
		if (!(toFile.isDirectory()))
			;
		else
			toFile = new File(toFile, fromFile.getName());
		if (!(toFile.exists())) {
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
		} else {
			if (!toFile.canWrite())
				abort("destination file is unwriteable: " + to_name);
		}
		FileInputStream from = null;
		FileOutputStream to = null;
		try {
			from = new FileInputStream(fromFile);
			to = new FileOutputStream(toFile);
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