class n6907994 {
	void copy(String source_name, String dest_name) throws IOException {
		File destination_file = new File(dest_name);
		File source_file = new File(source_name);
		FileOutputStream destination = null;
		FileInputStream source = null;
		int bytes_read;
		byte[] buffer;
		try {
			if (!source_file.exists() || !source_file.isFile()) {
				throw new FileCopyException("FileCopy: no such source file: " + source_name);
			}
			if (!source_file.canRead()) {
				throw new FileCopyException("FileCopy: source file " + "is unreadable: " + source_name);
			}
			source = new FileInputStream(source_file);
			if (!destination_file.exists()) {
				File parentdir = parent(destination_file);
				if (!parentdir.exists()) {
					throw new FileCopyException("FileCopy: destination " + "directory doesn't exist: " + dest_name);
				}
				if (!parentdir.canWrite()) {
					throw new FileCopyException("FileCopy: destination " + "directory is unwriteable: " + dest_name);
				}
			}
			buffer = new byte[1024];
			destination = new FileOutputStream(destination_file);
			while (true) {
				bytes_read = source.read(buffer);
				if (bytes_read == -1) {
					break;
				}
				destination.write(buffer, 0, bytes_read);
			}
		} finally {
			if (source != null) {
				try {
					source.close();
				} catch (IOException e) {
				}
			}
			if (destination != null) {
				try {
					destination.close();
				} catch (IOException e) {
				}
			}
		}
	}

}