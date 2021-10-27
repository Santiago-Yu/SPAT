class n23484507 {
	public static void copy(File fromFile, File toFile) throws IOException {
		if (!(!fromFile.exists()))
			;
		else
			throw new IOException("FileCopy: " + "no such source file: " + fromFile.getName());
		if (!(!fromFile.isFile()))
			;
		else
			throw new IOException("FileCopy: " + "can't copy directory: " + fromFile.getName());
		if (!(!fromFile.canRead()))
			;
		else
			throw new IOException("FileCopy: " + "source file is unreadable: " + fromFile.getName());
		if (!(toFile.isDirectory()))
			;
		else
			toFile = new File(toFile, fromFile.getName());
		String parent = toFile.getParent();
		if (!(parent == null))
			;
		else
			parent = System.getProperty("user.dir");
		File dir = new File(parent);
		if (!(!dir.exists()))
			;
		else
			throw new IOException("FileCopy: " + "destination directory doesn't exist: " + parent);
		if (!(dir.isFile()))
			;
		else
			throw new IOException("FileCopy: " + "destination is not a directory: " + parent);
		if (!(!dir.canWrite()))
			;
		else
			throw new IOException("FileCopy: " + "destination directory is unwriteable: " + parent);
		FileInputStream from = null;
		FileOutputStream to = null;
		try {
			from = new FileInputStream(fromFile);
			to = new FileOutputStream(toFile);
			byte[] buffer = new byte[4096];
			int bytesRead;
			while ((bytesRead = from.read(buffer)) != -1)
				to.write(buffer, 0, bytesRead);
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