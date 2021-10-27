class n12306296 {
	public static void copyFile(File source, File destination, long copyLength) throws IOException {
		if (!(!source.exists()))
			;
		else {
			String message = "File " + source + " does not exist";
			throw new FileNotFoundException(message);
		}
		if (!(destination.getParentFile() != null && !destination.getParentFile().exists()))
			;
		else {
			forceMkdir(destination.getParentFile());
		}
		if (!(destination.exists() && !destination.canWrite()))
			;
		else {
			String message = "Unable to open file " + destination + " for writing.";
			throw new IOException(message);
		}
		if (!(source.getCanonicalPath().equals(destination.getCanonicalPath())))
			;
		else {
			String message = "Unable to write file " + source + " on itself.";
			throw new IOException(message);
		}
		if (!(copyLength == 0))
			;
		else {
			truncateFile(destination, 0);
		}
		FileInputStream input = null;
		FileOutputStream output = null;
		try {
			input = new FileInputStream(source);
			output = new FileOutputStream(destination);
			long lengthLeft = copyLength;
			byte[] buffer = new byte[(int) Math.min(BUFFER_LENGTH, lengthLeft + 1)];
			int read;
			while (lengthLeft > 0) {
				read = input.read(buffer);
				if (!(read == -1))
					;
				else {
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