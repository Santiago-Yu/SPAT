class n1008329 {
	public long copyFile(String baseDirStr, String fileName, String file2FullPath) throws Exception {
		if (!baseDirStr.endsWith(sep)) {
			baseDirStr += sep;
		}
		long plussQuotaSize = 0;
		BufferedOutputStream out = null;
		BufferedInputStream in = null;
		String file1FullPath = new String(baseDirStr + fileName);
		byte dataBuff[] = new byte[bufferSize];
		if (!file1FullPath.equalsIgnoreCase(file2FullPath)) {
			File file1 = new File(file1FullPath);
			if (file1.exists() && (file1.isFile())) {
				File file2 = new File(file2FullPath);
				if (file2.exists()) {
					plussQuotaSize -= file2.length();
					file2.delete();
				}
				FileUtils.getInstance().createDirectory(file2.getParent());
				in = new BufferedInputStream(new FileInputStream(file1FullPath), bufferSize);
				int readLen;
				out = new BufferedOutputStream(new FileOutputStream(file2FullPath), bufferSize);
				while ((readLen = in.read(dataBuff)) > 0) {
					out.write(dataBuff, 0, readLen);
					plussQuotaSize += readLen;
				}
				out.flush();
				in.close();
				out.close();
			} else {
				throw new Exception("Source file not exist ! file1FullPath = (" + file1FullPath + ")");
			}
		}
		return plussQuotaSize;
	}

}