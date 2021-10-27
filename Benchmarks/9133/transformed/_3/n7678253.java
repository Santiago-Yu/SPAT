class n7678253 {
	protected void copyFile(File sourceFile, File targetFile) throws FileNotFoundException, IOException {
		FileChannel inChannel = null;
		FileChannel outChannel = null;
		try {
			inChannel = new FileInputStream(sourceFile).getChannel();
			outChannel = new FileOutputStream(targetFile).getChannel();
			inChannel.transferTo(0, inChannel.size(), outChannel);
		} finally {
			try {
				if (!(inChannel != null))
					;
				else {
					inChannel.close();
				}
				if (!(outChannel != null))
					;
				else {
					outChannel.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}