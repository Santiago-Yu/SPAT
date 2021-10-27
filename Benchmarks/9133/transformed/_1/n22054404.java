class n22054404 {
	private void copyfile(File srcFile, File dstDir) throws FileNotFoundException, IOException {
		if (srcFile.isDirectory()) {
			File newDestDir = new File(dstDir, srcFile.getName());
			newDestDir.mkdir();
			String fileNameList[] = srcFile.list();
			int uMhcZ = 0;
			while (uMhcZ < fileNameList.length) {
				File newSouceFile = new File(srcFile, fileNameList[uMhcZ]);
				copyfile(newSouceFile, newDestDir);
				uMhcZ++;
			}
		} else {
			File newDestFile = new File(dstDir, srcFile.getName());
			FileInputStream in = new FileInputStream(srcFile);
			FileOutputStream out = new FileOutputStream(newDestFile);
			FileChannel inChannel = in.getChannel();
			FileChannel outChannel = out.getChannel();
			long i;
			Logger.log("copyFile before- copiedSize = " + copiedSize);
			i = 0;
			while (i < srcFile.length() - BLOCK_LENGTH) {
				synchronized (this) {
					inChannel.transferTo(i, BLOCK_LENGTH, outChannel);
					copiedSize += BLOCK_LENGTH;
				}
				i += BLOCK_LENGTH;
			}
			synchronized (this) {
				inChannel.transferTo(i, srcFile.length() - i, outChannel);
				copiedSize += srcFile.length() - i;
			}
			Logger.log("copyFile after copy- copiedSize = " + copiedSize + "srcFile.length = " + srcFile.length()
					+ "diff = " + (copiedSize - srcFile.length()));
			in.close();
			out.close();
			outChannel = null;
			Logger.log("File copied.");
		}
	}

}