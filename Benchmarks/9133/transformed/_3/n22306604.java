class n22306604 {
	public static void upLoadFile(File sourceFile, File targetFile) throws IOException {
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