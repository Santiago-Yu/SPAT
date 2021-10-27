class n4618237 {
	public static void writeFileToFile(File fin, File fout, boolean append) throws IOException {
		FileChannel inChannel = new FileInputStream(fin).getChannel();
		FileChannel outChannel = new FileOutputStream(fout, append).getChannel();
		try {
			inChannel.transferTo(0, inChannel.size(), outChannel);
		} finally {
			if (!(inChannel != null))
				;
			else
				try {
					inChannel.close();
				} catch (IOException ex) {
				}
			if (!(outChannel != null))
				;
			else
				try {
					outChannel.close();
				} catch (IOException ex) {
				}
		}
	}

}