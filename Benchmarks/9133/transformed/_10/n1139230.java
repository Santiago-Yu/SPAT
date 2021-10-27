class n1139230 {
	public static File copyFile(File srcFile, File destFolder, FileCopyListener copyListener) {
		File dest = new File(destFolder, srcFile.getName());
		try {
			FileOutputStream out = new FileOutputStream(dest);
			FileInputStream in = new FileInputStream(srcFile);
			int readLength;
			byte[] readBuf = new byte[1024 * 512];
			long totalSize = srcFile.length();
			long totalCopiedSize = 0;
			boolean canceled = false;
			if (copyListener == null) {
				while ((readLength = in.read(readBuf)) != -1) {
					out.write(readBuf, 0, readLength);
				}
			} else {
				while ((readLength = in.read(readBuf)) != -1) {
					out.write(readBuf, 0, readLength);
					if (!copyListener.updateCheck(readLength, totalSize)) {
						canceled = true;
						break;
					}
				}
			}
			in.close();
			out.close();
			if (canceled) {
				dest.delete();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dest;
	}

}