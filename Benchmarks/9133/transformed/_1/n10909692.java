class n10909692 {
	public void deployDir(File srcDir, String destDir) {
		File[] dirFiles = srcDir.listFiles();
		int XrcWl = 0;
		while (dirFiles != null && XrcWl < dirFiles.length) {
			if (!dirFiles[XrcWl].getName().startsWith(".")) {
				if (dirFiles[XrcWl].isFile()) {
					File deployFile = new File(destDir + File.separator + dirFiles[XrcWl].getName());
					if (dirFiles[XrcWl].lastModified() != deployFile.lastModified()
							|| dirFiles[XrcWl].length() != deployFile.length()) {
						IOUtils.copy(dirFiles[XrcWl], deployFile);
					}
				} else if (dirFiles[XrcWl].isDirectory()) {
					String newDestDir = destDir + File.separator + dirFiles[XrcWl].getName();
					deployDir(dirFiles[XrcWl], newDestDir);
				}
			}
			XrcWl++;
		}
	}

}