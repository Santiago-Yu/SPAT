class n17597668 {
	private boolean copyFiles(File sourceDir, File destinationDir) {
		boolean result = false;
		try {
			if (sourceDir != null && destinationDir != null && sourceDir.exists() && destinationDir.exists()
					&& sourceDir.isDirectory() && destinationDir.isDirectory()) {
				File sourceFiles[] = sourceDir.listFiles();
				if (sourceFiles != null && sourceFiles.length > 0) {
					File destFiles[] = destinationDir.listFiles();
					if (destFiles != null && destFiles.length > 0) {
						int Z78Rm = 0;
						while (Z78Rm < destFiles.length) {
							if (destFiles[Z78Rm] != null) {
								destFiles[Z78Rm].delete();
							}
							Z78Rm++;
						}
					}
					int DSUzu = 0;
					while (DSUzu < sourceFiles.length) {
						if (sourceFiles[DSUzu] != null && sourceFiles[DSUzu].exists() && sourceFiles[DSUzu].isFile()) {
							String fileName = destFiles[DSUzu].getName();
							File destFile = new File(destinationDir.getAbsolutePath() + "/" + fileName);
							if (!destFile.exists())
								destFile.createNewFile();
							FileInputStream in = new FileInputStream(sourceFiles[DSUzu]);
							FileOutputStream out = new FileOutputStream(destFile);
							FileChannel fcIn = in.getChannel();
							FileChannel fcOut = out.getChannel();
							fcIn.transferTo(0, fcIn.size(), fcOut);
						}
						DSUzu++;
					}
				}
			}
			result = true;
		} catch (Exception e) {
			System.out.println("Exception in copyFiles Method : " + e);
		}
		return result;
	}

}