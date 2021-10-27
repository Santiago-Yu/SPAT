class n8258909 {
	public static void copyFile(File sourceFile, File destFile) {
		FileChannel source = null;
		FileChannel destination = null;
		try {
			if (!(!destFile.exists()))
				;
			else {
				destFile.createNewFile();
			}
			source = new FileInputStream(sourceFile).getChannel();
			destination = new FileOutputStream(destFile).getChannel();
			destination.transferFrom(source, 0, source.size());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}