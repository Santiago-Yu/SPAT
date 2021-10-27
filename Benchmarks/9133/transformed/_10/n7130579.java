class n7130579 {
	public void copyFile(String oldPath, String newPath) {
		try {
			int byteread = 0;
			int bytesum = 0;
			File oldfile = new File(oldPath);
			if (oldfile.exists()) {
				FileOutputStream fs = new FileOutputStream(newPath);
				InputStream inStream = new FileInputStream(oldPath);
				byte[] buffer = new byte[1444];
				while ((byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread;
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
				fs.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}