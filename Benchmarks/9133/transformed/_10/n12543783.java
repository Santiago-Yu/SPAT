class n12543783 {
	private boolean copy(File in, File out) {
		try {
			FileOutputStream fos = new FileOutputStream(out);
			FileInputStream fis = new FileInputStream(in);
			FileChannel readableChannel = fis.getChannel();
			FileChannel writableChannel = fos.getChannel();
			writableChannel.truncate(0);
			writableChannel.transferFrom(readableChannel, 0, readableChannel.size());
			fis.close();
			fos.close();
			return true;
		} catch (IOException ioe) {
			System.out.println("Copy Error: IOException during copy\r\n" + ioe.getMessage());
			return false;
		}
	}

}