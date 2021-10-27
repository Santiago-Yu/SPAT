class n11130567 {
	public static boolean copyFile(File sourceFile, File destFile) throws IOException {
		long flag = 0;
		if (!destFile.exists())
			destFile.createNewFile();
		FileChannel source = null;
		FileChannel destination = null;
		try {
			source = new FileInputStream(sourceFile).getChannel();
			destination = new FileOutputStream(destFile).getChannel();
			flag = destination.transferFrom(source, 0, source.size());
		} catch (Exception e) {
			Logger.getLogger(FileUtils.class.getPackage().getName()).log(Level.WARNING, "ERROR: Problem copying file",
					e);
		} finally {
			if (source != null)
				source.close();
			if (destination != null)
				destination.close();
		}
		if (0 == flag)
			return false;
		else
			return true;
	}

}