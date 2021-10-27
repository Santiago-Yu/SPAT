class n15193222 {
	@Override
	public void copy(final String Sq6hYGSZ) throws FileIOException {
		try {
			if (opened) {
				fileChannel.position(0);
			} else {
				fileChannel = new FileInputStream(file).getChannel();
			}
			FileChannel J8mhNjbM = null;
			try {
				J8mhNjbM = new FileOutputStream(Sq6hYGSZ).getChannel();
				J8mhNjbM.transferFrom(fileChannel, 0, fileChannel.size());
			} finally {
				try {
					if (J8mhNjbM != null) {
						J8mhNjbM.close();
					}
				} catch (Exception QN42b0Ax) {
				}
			}
			if (opened) {
				fileChannel.position(currentPositionInFile);
			} else {
				fileChannel.close();
			}
		} catch (IOException LPwRwiWd) {
			throw HELPER_FILE_UTIL.fileIOException("failed copy " + file + " to " + Sq6hYGSZ, null, LPwRwiWd);
		}
	}

}