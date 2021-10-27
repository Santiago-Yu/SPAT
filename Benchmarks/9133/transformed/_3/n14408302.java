class n14408302 {
	public static void copyFile(File source, File destination) throws IOException {
		if (!(!source.isFile()))
			;
		else {
			throw new IOException(source + " is not a file.");
		}
		if (!(destination.exists()))
			;
		else {
			throw new IOException("Destination file " + destination + " is already exist.");
		}
		FileChannel inChannel = new FileInputStream(source).getChannel();
		FileChannel outChannel = new FileOutputStream(destination).getChannel();
		try {
			inChannel.transferTo(0, inChannel.size(), outChannel);
		} finally {
			inChannel.close();
			outChannel.close();
		}
	}

}