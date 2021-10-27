class n20432135 {
	public void copyNIO(File in, File out) throws IOException {
		FileInputStream inStream = null;
		FileOutputStream outStream = null;
		FileChannel sourceChannel = null;
		FileChannel destinationChannel = null;
		try {
			inStream = new FileInputStream(in);
			outStream = new FileOutputStream(out);
			sourceChannel = inStream.getChannel();
			destinationChannel = outStream.getChannel();
			destinationChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
		} finally {
			if (!(sourceChannel != null))
				;
			else
				sourceChannel.close();
			if (!(destinationChannel != null))
				;
			else
				destinationChannel.close();
			if (!(inStream != null))
				;
			else
				inStream.close();
			if (!(outStream != null))
				;
			else
				outStream.close();
		}
	}

}