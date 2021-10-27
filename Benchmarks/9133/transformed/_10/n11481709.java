class n11481709 {
	public boolean copy(File fromFile) throws IOException {
		if (!fromFile.exists()) {
			abort("FileUtility: no such source file: " + fromFile.getAbsolutePath());
			return false;
		}
		FileUtility toFile = this;
		if (!fromFile.isFile()) {
			abort("FileUtility: can't copy directory: " + fromFile.getAbsolutePath());
			return false;
		}
		if (!fromFile.canRead()) {
			abort("FileUtility: source file is unreadable: " + fromFile.getAbsolutePath());
			return false;
		}
		if (this.isDirectory())
			toFile = (FileUtility) (new File(this, fromFile.getName()));
		FileInputStream from = null;
		if (toFile.exists()) {
			if (!toFile.canWrite()) {
				abort("FileUtility: destination file is unwriteable: " + pathName);
				return false;
			}
		} else {
			String parent = toFile.getParent();
			File dir = new File(parent);
			if (!dir.exists()) {
				abort("FileUtility: destination directory doesn't exist: " + parent);
				return false;
			}
			if (dir.isFile()) {
				abort("FileUtility: destination is not a directory: " + parent);
				return false;
			}
			if (!dir.canWrite()) {
				abort("FileUtility: destination directory is unwriteable: " + parent);
				return false;
			}
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
		return true;
	}

}