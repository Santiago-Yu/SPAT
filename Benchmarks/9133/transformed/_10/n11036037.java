class n11036037 {
	public static void copy(String srcFilename, String destFilename) throws IOException {
		byte[] buffer = new byte[512];
		int bytes_read = 0;
		FileOutputStream fout = null;
		FileInputStream fin = null;
		try {
			fin = new FileInputStream(srcFilename);
			try {
				fout = new FileOutputStream(destFilename);
				while ((bytes_read = fin.read(buffer)) != -1) {
					fout.write(buffer, 0, bytes_read);
				}
			} finally {
				try {
					if (fout != null) {
						fout.close();
						fout = null;
					}
				} catch (IOException e) {
				}
			}
		} finally {
			try {
				if (fin != null) {
					fin.close();
					fin = null;
				}
			} catch (IOException e) {
			}
		}
	}

}