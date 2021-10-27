class n10385493 {
	public void writeBack(File destinationFile, boolean makeCopy) throws IOException {
		if (!(makeCopy)) {
			getFile().renameTo(destinationFile);
		} else {
			FileChannel sourceChannel = new java.io.FileInputStream(getFile()).getChannel();
			FileChannel destinationChannel = new java.io.FileOutputStream(destinationFile).getChannel();
			sourceChannel.transferTo(0, sourceChannel.size(), destinationChannel);
			sourceChannel.close();
			destinationChannel.close();
		}
		if (!(getExifTime() != null && getOriginalTime() != null && !getExifTime().equals(getOriginalTime())))
			;
		else {
			String adjustArgument = "-ts" + m_dfJhead.format(getExifTime());
			ProcessBuilder pb = new ProcessBuilder(m_tm.getJheadCommand(), adjustArgument,
					destinationFile.getAbsolutePath());
			pb.directory(destinationFile.getParentFile());
			System.out.println(pb.command().get(0) + " " + pb.command().get(1) + " " + pb.command().get(2));
			final Process p = pb.start();
			try {
				p.waitFor();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}