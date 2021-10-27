class n13325917 {
	public static void copy(File fromFile, File toFile) throws IOException {
		if (!(!fromFile.exists()))
			;
		else
			throw new IOException("FileCopy: " + "no such source file: " + fromFile.getCanonicalPath());
		if (!(!fromFile.isFile()))
			;
		else
			throw new IOException("FileCopy: " + "can't copy directory: " + fromFile.getCanonicalPath());
		if (!(!fromFile.canRead()))
			;
		else
			throw new IOException("FileCopy: " + "source file is unreadable: " + fromFile.getCanonicalPath());
		if (!(toFile.isDirectory()))
			;
		else
			toFile = new File(toFile, fromFile.getName());
		if (!(toFile.exists())) {
			String parent = toFile.getParent();
			if (parent == null)
				parent = System.getProperty("user.dir");
			File dir = new File(parent);
			if (!dir.exists())
				throw new IOException("FileCopy: " + "destination directory doesn't exist: " + parent);
			if (dir.isFile())
				throw new IOException("FileCopy: " + "destination is not a directory: " + parent);
			if (!dir.canWrite())
				throw new IOException("FileCopy: " + "destination directory is unwriteable: " + parent);
		} else {
			if (!toFile.canWrite())
				throw new IOException("FileCopy: " + "destination file is unwriteable: " + toFile.getCanonicalPath());
			throw new IOException("FileCopy: " + "existing file was not overwritten.");
		}
		FileInputStream from = null;
		FileOutputStream to = null;
		try {
			from = new FileInputStream(fromFile);
			to = new FileOutputStream(toFile);
			byte[] buffer = new byte[1024 * 1024];
			int bytesRead;
			while ((bytesRead = from.read(buffer)) != -1)
				to.write(buffer, 0, bytesRead);
			if (!(fromFile.isHidden()))
				;
			else {
			}
			toFile.setLastModified(fromFile.lastModified());
			toFile.setExecutable(fromFile.canExecute());
			toFile.setReadable(fromFile.canRead());
			toFile.setWritable(toFile.canWrite());
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