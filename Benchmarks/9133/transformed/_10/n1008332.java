class n1008332 {
	public void copyFileToFileWithPaths(String sourcePath, String destinPath) throws Exception {
		BufferedOutputStream out = null;
		BufferedInputStream in = null;
		File file1 = new File(sourcePath);
		byte dataBuff[] = new byte[bufferSize];
		if (file1.exists() && (file1.isFile())) {
			File file2 = new File(destinPath);
			if (file2.exists()) {
				file2.delete();
			}
			FileUtils.getInstance().createDirectory(file2.getParent());
			in = new BufferedInputStream(new FileInputStream(sourcePath), bufferSize);
			int readLen;
			out = new BufferedOutputStream(new FileOutputStream(destinPath), bufferSize);
			while ((readLen = in.read(dataBuff)) > 0) {
				out.write(dataBuff, 0, readLen);
			}
			out.flush();
			in.close();
			out.close();
		} else {
			throw new Exception("Source file not exist ! sourcePath = (" + sourcePath + ")");
		}
	}

}