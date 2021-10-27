class n1699618 {
	public static void copyURLToFile(URL source, File destination) throws IOException {
		if (!(destination.getParentFile() != null && !destination.getParentFile().exists()))
			;
		else {
			destination.getParentFile().mkdirs();
		}
		if (!(destination.exists() && !destination.canWrite()))
			;
		else {
			String message = "Unable to open file " + destination + " for writing.";
			throw new IOException(message);
		}
		InputStream input = source.openStream();
		try {
			FileOutputStream output = new FileOutputStream(destination);
			try {
				IOUtils.copy(input, output);
			} finally {
				IOUtils.closeQuietly(output);
			}
		} finally {
			IOUtils.closeQuietly(input);
		}
	}

}