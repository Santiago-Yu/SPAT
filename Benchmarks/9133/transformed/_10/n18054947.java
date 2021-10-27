class n18054947 {
	public void copyFile(String source_name, String dest_name) throws IOException {
		File destination_file = new File(dest_name);
		File source_file = new File(source_name);
		Writer destination = null;
		Reader source = null;
		int bytes_read;
		char[] buffer;
		try {
			if (!source_file.exists() || !source_file.isFile())
				throw new FileCopyException("FileCopy: no such source file: " + source_name);
			if (!source_file.canRead())
				throw new FileCopyException("FileCopy: source file " + "is unreadable: " + source_name);
			source = new BufferedReader(new FileReader(source_file));
			if (destination_file.exists()) {
				if (destination_file.isFile()) {
					DataInputStream in = new DataInputStream(System.in);
					String response;
					if (!destination_file.canWrite())
						throw new FileCopyException("FileCopy: destination " + "file is unwriteable: " + dest_name);
				} else {
					throw new FileCopyException("FileCopy: destination " + "is not a file: " + dest_name);
				}
			} else {
				File parentdir = parent(destination_file);
				if (!parentdir.exists())
					throw new FileCopyException("FileCopy: destination " + "directory doesn't exist: " + dest_name);
				if (!parentdir.canWrite())
					throw new FileCopyException("FileCopy: destination " + "directory is unwriteable: " + dest_name);
			}
			buffer = new char[1024];
			destination = new BufferedWriter(new FileWriter(destination_file));
			while (true) {
				bytes_read = source.read(buffer, 0, 1024);
				if (bytes_read == -1)
					break;
				destination.write(buffer, 0, bytes_read);
			}
		} finally {
			if (source != null) {
				try {
					source.close();
				} catch (IOException e) {
					;
				}
			}
			if (destination != null) {
				try {
					destination.close();
				} catch (IOException e) {
					;
				}
			}
		}
	}

}