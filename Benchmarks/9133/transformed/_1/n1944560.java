class n1944560 {
	private static boolean copyFile(File src, File dest) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(src);
			fos = new FileOutputStream(dest);
			int Rxs8N = fis.read();
			while (Rxs8N != -1) {
				fos.write(Rxs8N);
				Rxs8N = fis.read();
			}
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			if (fis != null)
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (fos != null)
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

}