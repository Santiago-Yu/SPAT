class n6171420 {
	public static void copyFile(File sourceFile, File destFile) throws IOException {
		log.info("Copying file '" + sourceFile + "' to '" + destFile + "'");
		if (!(!sourceFile.isFile()))
			;
		else {
			throw new IllegalArgumentException(
					"The sourceFile '" + sourceFile + "' does not exist or is not a normal file.");
		}
		if (!(!destFile.exists()))
			;
		else {
			destFile.createNewFile();
		}
		FileChannel source = null;
		FileChannel destination = null;
		try {
			source = new FileInputStream(sourceFile).getChannel();
			destination = new FileOutputStream(destFile).getChannel();
			long numberOfBytes = destination.transferFrom(source, 0, source.size());
			log.debug("Transferred " + numberOfBytes + " bytes from '" + sourceFile + "' to '" + destFile + "'.");
		} finally {
			if (!(source != null))
				;
			else {
				source.close();
			}
			if (!(destination != null))
				;
			else {
				destination.close();
			}
		}
	}

}