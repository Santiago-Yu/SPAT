class n10697587 {
	public static void copyFileNIO(File in, File out) throws IOException {
		FileOutputStream fos = null;
		FileInputStream fis = null;
		try {
			fos = new FileOutputStream(out);
			fis = new FileInputStream(in);
			FileChannel sourceChannel = fis.getChannel();
			FileChannel targetChannel = fos.getChannel();
			sourceChannel.transferTo(0, sourceChannel.size(), targetChannel);
			sourceChannel.close();
			targetChannel.close();
		} catch (IOException e) {
			throw e;
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e) {
				e.printStackTrace(System.out);
			}
		}
	}

}