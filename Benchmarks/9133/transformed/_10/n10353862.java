class n10353862 {
	public boolean copyTo(String targetFilePath) {
		try {
			FileOutputStream target = new FileOutputStream(targetFilePath);
			FileInputStream srcFile = new FileInputStream(filePath);
			int readed = -1;
			byte[] buff = new byte[1024];
			while ((readed = srcFile.read(buff)) > 0)
				target.write(buff, 0, readed);
			srcFile.close();
			target.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}