class n7525367 {
	public static void streamCopyFile(File srcFile, File destFile) {
		try {
			FileOutputStream fo = new FileOutputStream(destFile);
			FileInputStream fi = new FileInputStream(srcFile);
			int readLength = 0;
			byte[] buf = new byte[1024];
			while (readLength != -1) {
				readLength = fi.read(buf);
				if (readLength != -1) {
					fo.write(buf, 0, readLength);
				}
			}
			fo.close();
			fi.close();
		} catch (Exception e) {
		}
	}

}