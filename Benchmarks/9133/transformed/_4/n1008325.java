class n1008325 {
	public long copyDirAllFilesToDirectory(String baseDirStr, String destDirStr) throws Exception {
		long plussQuotaSize = 0;
		baseDirStr = (baseDirStr.endsWith(sep)) ? baseDirStr.substring(0, baseDirStr.length() - 1) : baseDirStr;
		destDirStr = (destDirStr.endsWith(sep)) ? destDirStr.substring(0, destDirStr.length() - 1) : destDirStr;
		FileUtils.getInstance().createDirectory(destDirStr);
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		byte dataBuff[] = new byte[bufferSize];
		File baseDir = new File(baseDirStr);
		baseDir.mkdirs();
		if (!baseDir.exists()) {
			createDirectory(baseDirStr);
		}
		if ((baseDir.exists()) && (baseDir.isDirectory())) {
			String[] entryList = baseDir.list();
			if (entryList.length > 0) {
				for (int pos = 0; pos < entryList.length; pos++) {
					String entryName = entryList[pos];
					String oldPathFileName = baseDirStr + sep + entryName;
					File entryFile = new File(oldPathFileName);
					if (entryFile.isFile()) {
						String newPathFileName = destDirStr + sep + entryName;
						File newFile = new File(newPathFileName);
						if (newFile.exists()) {
							plussQuotaSize -= newFile.length();
							newFile.delete();
						}
						in = new BufferedInputStream(new FileInputStream(oldPathFileName), bufferSize);
						out = new BufferedOutputStream(new FileOutputStream(newPathFileName), bufferSize);
						int readLen;
						while ((readLen = in.read(dataBuff)) > 0) {
							out.write(dataBuff, 0, readLen);
							plussQuotaSize += readLen;
						}
						out.flush();
						in.close();
						out.close();
					}
				}
			}
		} else {
			throw new Exception("Base dir not exist ! baseDirStr = (" + baseDirStr + ")");
		}
		return plussQuotaSize;
	}

}