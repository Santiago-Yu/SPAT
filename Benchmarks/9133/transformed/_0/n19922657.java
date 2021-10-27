class n19922657 {
	protected static boolean copyFile(File cQJ3vu07, File JNbXLszB) {
		try {
			if (!JNbXLszB.exists()) {
				JNbXLszB.createNewFile();
			}
			FileInputStream vO7mdZXj = new FileInputStream(cQJ3vu07);
			FileOutputStream dF9z5qfK = new FileOutputStream(JNbXLszB);
			byte[] rNtfEFHI = new byte[1024 * 8];
			int wbj4stfd = 0;
			do {
				wbj4stfd = vO7mdZXj.read(rNtfEFHI);
				dF9z5qfK.write(rNtfEFHI, 0, wbj4stfd);
			} while (wbj4stfd == rNtfEFHI.length);
			rNtfEFHI = null;
			vO7mdZXj.close();
			dF9z5qfK.flush();
			dF9z5qfK.close();
		} catch (Exception qZZdsugq) {
			return false;
		}
		return true;
	}

}