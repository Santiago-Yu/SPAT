class n1008324 {
	public void copyHashAllFilesToDirectory(String baseDirStr, Hashtable newNamesTable, String destDirStr)
			throws Exception {
		baseDirStr = (baseDirStr.endsWith(sep)) ? baseDirStr.substring(0, baseDirStr.length() - 1) : baseDirStr;
		destDirStr = (destDirStr.endsWith(sep)) ? destDirStr.substring(0, destDirStr.length() - 1) : destDirStr;
		FileUtils.getInstance().createDirectory(baseDirStr);
		newNamesTable = (null == newNamesTable) ? new Hashtable() : newNamesTable;
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		byte dataBuff[] = new byte[bufferSize];
		File baseDir = new File(baseDirStr);
		baseDir.mkdirs();
		if ((baseDir.exists()) && (baseDir.isDirectory())) {
			if (!newNamesTable.isEmpty()) {
				Enumeration enumFiles = newNamesTable.keys();
				while (enumFiles.hasMoreElements()) {
					String newName = (String) enumFiles.nextElement();
					String oldPathName = (String) newNamesTable.get(newName);
					if ((newName != null) && (!"".equals(newName)) && (oldPathName != null)
							&& (!"".equals(oldPathName))) {
						String newPathFileName = destDirStr + sep + newName;
						String oldPathFileName = baseDirStr + sep + oldPathName;
						oldPathFileName = (oldPathName.startsWith(sep)) ? baseDirStr + oldPathName : oldPathFileName;
						File f = new File(oldPathFileName);
						if ((f.exists()) && (f.isFile())) {
							in = new BufferedInputStream(new FileInputStream(oldPathFileName), bufferSize);
							out = new BufferedOutputStream(new FileOutputStream(newPathFileName), bufferSize);
							int readLen;
							while ((readLen = in.read(dataBuff)) > 0) {
								out.write(dataBuff, 0, readLen);
							}
							out.flush();
							in.close();
							out.close();
						} else {
						}
					}
				}
			} else {
			}
		} else {
			throw new Exception("Base (baseDirStr) dir not exist !");
		}
	}

}