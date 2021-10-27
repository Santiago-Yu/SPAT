class n12214889 {
	public static boolean copyFile(String source, String destination, boolean replace) {
		File destinationFile = new File(destination);
		File sourceFile = new File(source);
		if (sourceFile.isDirectory() || destinationFile.isDirectory())
			return false;
		if (destinationFile.isFile() && !replace)
			return false;
		if (!sourceFile.isFile())
			return false;
		if (replace)
			destinationFile.delete();
		try {
			File dir = destinationFile.getParentFile();
			DataOutputStream outStream = new DataOutputStream(
					new BufferedOutputStream(new FileOutputStream(destinationFile), 10240));
			while (dir != null && !dir.exists()) {
				dir.mkdir();
			}
			DataInputStream inStream = new DataInputStream(
					new BufferedInputStream(new FileInputStream(sourceFile), 10240));
			try {
				while (inStream.available() > 0) {
					outStream.write(inStream.readUnsignedByte());
				}
			} catch (EOFException eof) {
			}
			inStream.close();
			outStream.close();
		} catch (IOException ex) {
			throw new FailedException(
					"Failed to copy file " + sourceFile.getAbsolutePath() + " to " + destinationFile.getAbsolutePath(),
					ex).setFile(destinationFile.getAbsolutePath());
		}
		return true;
	}

}