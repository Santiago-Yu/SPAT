class n12306296 {
	public static void copyFile(File source, File destination, long copyLength) throws IOException {
		if (!source.exists()) {
			String message = "File " + source + " does not exist";
			throw new FileNotFoundException(message);
		}
		if (destination.getParentFile() != null && !destination.getParentFile().exists()) {
			forceMkdir(destination.getParentFile());
		}
		if (destination.exists() && !destination.canWrite()) {
			String message = "Unable to open file " + destination + " for writing.";
			throw new IOException(message);
		}
		if (source.getCanonicalPath().equals(destination.getCanonicalPath())) {
			String message = "Unable to write file " + source + " on itself.";
			throw new IOException(message);
		}
		FileInputStream input = null;
		if (copyLength == 0) {
			truncateFile(destination, 0);
		}
		FileOutputStream output = null;
		try {
			output = new FileOutputStream(destination);
			input = new FileInputStream(source);
			long lengthLeft = copyLength;
			int read;
			byte[] buffer = new byte[(int) Math.min(BUFFER_LENGTH, lengthLeft + 1)];
			while (lengthLeft > 0) {
				read = input.read(buffer);
				if (read == -1) {
					break;
				}
				lengthLeft -= read;
				output.write(buffer, 0, read);
			}
			output.flush();
			output.getFD().sync();
		} finally {
			IOUtil.closeQuietly(input);
			IOUtil.closeQuietly(output);
		}
		destination.setLastModified(source.lastModified());
	}

}