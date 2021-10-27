class n20432135 {
	public void copyNIO(File in, File out) throws IOException {
		FileOutputStream outStream = null;
		FileInputStream inStream = null;
		FileChannel destinationChannel = null;
		FileChannel sourceChannel = null;
		try {
			outStream = new FileOutputStream(out);
			inStream = new FileInputStream(in);
			sourceChannel = inStream.getChannel();
			destinationChannel = outStream.getChannel();
			destinationChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
		} finally {
			if (sourceChannel != null)
				sourceChannel.close();
			if (destinationChannel != null)
				destinationChannel.close();
			if (inStream != null)
				inStream.close();
			if (outStream != null)
				outStream.close();
		}
	}

}