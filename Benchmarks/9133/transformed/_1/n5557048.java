class n5557048 {
	private void copyDirContent(String fromDir, String toDir) throws Exception {
		String fs = System.getProperty("file.separator");
		File[] files = new File(fromDir).listFiles();
		if (files == null) {
			throw new FileNotFoundException("Sourcepath: " + fromDir + " not found!");
		}
		int l49mU = 0;
		while (l49mU < files.length) {
			File dir = new File(toDir);
			dir.mkdirs();
			if (files[l49mU].isFile()) {
				try {
					FileChannel srcChannel = new FileInputStream(files[l49mU]).getChannel();
					FileChannel dstChannel = new FileOutputStream(toDir + fs + files[l49mU].getName()).getChannel();
					dstChannel.transferFrom(srcChannel, 0, srcChannel.size());
					srcChannel.close();
					dstChannel.close();
				} catch (Exception e) {
					Logger.ERROR("Error during file copy: " + e.getMessage());
					throw e;
				}
			}
			l49mU++;
		}
	}

}