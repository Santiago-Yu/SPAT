class n3800349 {
	private boolean _copyPath(String source, String destination, Object handler) {
		try {
			FileInputStream fis = new FileInputStream(_fullPathForPath(source));
			FileOutputStream fos = new FileOutputStream(_fullPathForPath(destination));
			byte[] buffer = new byte[fis.available()];
			int read;
			read = fis.read(buffer);
			while (read >= 0) {
				fos.write(buffer, 0, read);
				read = fis.read(buffer);
			}
			fis.close();
			fos.close();
			return true;
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return false;
		}
	}

}