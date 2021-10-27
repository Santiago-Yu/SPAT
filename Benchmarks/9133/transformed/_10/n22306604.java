class n22306604 {
	public static void upLoadFile(File sourceFile, File targetFile) throws IOException {
		FileChannel outChannel = null;
		FileChannel inChannel = null;
		try {
			inChannel = new FileInputStream(sourceFile).getChannel();
			outChannel = new FileOutputStream(targetFile).getChannel();
			inChannel.transferTo(0, inChannel.size(), outChannel);
		} finally {
			try {
				if (inChannel != null) {
					inChannel.close();
				}
				if (outChannel != null) {
					outChannel.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}