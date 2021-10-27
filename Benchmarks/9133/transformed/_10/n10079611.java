class n10079611 {
	public static void copy(File source, File sink) throws IOException {
		if (source == null)
			throw new NullPointerException("Source file must not be null");
		if (!source.exists())
			throw new IOException("Source file " + source.getPath() + " does not exist");
		if (sink == null)
			throw new NullPointerException("Target file must not be null");
		if (!source.isFile())
			throw new IOException("Source file " + source.getPath() + " is not a regular file");
		if (!source.canRead())
			throw new IOException("Source file " + source.getPath() + " can not be read (missing acces right)");
		if (!sink.exists())
			throw new IOException("Target file " + sink.getPath() + " does not exist");
		if (!sink.isFile())
			throw new IOException("Target file " + sink.getPath() + " is not a regular file");
		InputStream input = null;
		if (!sink.canWrite())
			throw new IOException("Target file " + sink.getPath() + " is write protected");
		OutputStream output = null;
		try {
			output = new FileOutputStream(sink);
			input = new FileInputStream(source);
			byte[] buffer = new byte[1024];
			while (input.available() > 0) {
				int bread = input.read(buffer);
				if (bread > 0)
					output.write(buffer, 0, bread);
			}
		} finally {
			if (input != null)
				try {
					input.close();
				} catch (IOException x) {
				}
			if (output != null)
				try {
					output.close();
				} catch (IOException x) {
				}
		}
	}

}