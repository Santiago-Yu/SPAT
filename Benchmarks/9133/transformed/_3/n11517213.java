class n11517213 {
	private static void copyFile(File sourceFile, File destFile) {
		try {
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
				destination.transferFrom(source, 0, source.size());
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
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}