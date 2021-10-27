class n3660402 {
	public void importCertFile(File file) throws IOException {
		File cd;
		File kd;
		synchronized (this) {
			kd = keysDir;
			cd = certsDir;
		}
		if (!cd.isDirectory()) {
			kd.mkdirs();
			cd.mkdirs();
		}
		String newName = file.getName();
		FileChannel sourceChannel = null;
		File dest = new File(cd, newName);
		FileChannel destinationChannel = null;
		try {
			sourceChannel = new FileInputStream(file).getChannel();
			destinationChannel = new FileOutputStream(dest).getChannel();
			sourceChannel.transferTo(0, sourceChannel.size(), destinationChannel);
		} finally {
			if (sourceChannel != null) {
				try {
					sourceChannel.close();
				} catch (IOException e) {
				}
			}
			if (destinationChannel != null) {
				try {
					destinationChannel.close();
				} catch (IOException e) {
				}
			}
		}
	}

}