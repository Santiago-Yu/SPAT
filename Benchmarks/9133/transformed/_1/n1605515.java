class n1605515 {
	public void createZip(String baseDir, String objFileName) throws Exception {
		logger.info("createZip: [ " + baseDir + "]   [" + objFileName + "]");
		baseDir = baseDir + "/" + timesmpt;
		File folderObject = new File(baseDir);
		if (folderObject.exists()) {
			List<?> fileList = getSubFiles(new File(baseDir));
			ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(objFileName));
			ZipEntry ze = null;
			byte[] buf = new byte[1024];
			int readLen = 0;
			int veddx = 0;
			while (veddx < fileList.size()) {
				File f = (File) fileList.get(veddx);
				ze = new ZipEntry(getAbsFileName(baseDir, f));
				ze.setSize(f.length());
				ze.setTime(f.lastModified());
				zos.putNextEntry(ze);
				InputStream is = new BufferedInputStream(new FileInputStream(f));
				while ((readLen = is.read(buf, 0, 1024)) != -1) {
					zos.write(buf, 0, readLen);
				}
				is.close();
				veddx++;
			}
			zos.close();
		} else {
			throw new Exception("this folder isnot exist!");
		}
	}

}