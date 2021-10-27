class n12229175 {
	public static void fileCopy(File jNWcSXpG, File zMvJ2WMR) throws IOException {
		FileChannel qYKI7w68 = null;
		FileChannel sxkVaC7m = null;
		FileInputStream Oz6z1lWM = null;
		FileOutputStream JaUk4vLK = null;
		try {
			Oz6z1lWM = new FileInputStream(jNWcSXpG);
			JaUk4vLK = new FileOutputStream(zMvJ2WMR);
			qYKI7w68 = Oz6z1lWM.getChannel();
			sxkVaC7m = JaUk4vLK.getChannel();
			sxkVaC7m.transferFrom(qYKI7w68, 0, qYKI7w68.size());
		} finally {
			Oz6z1lWM.close();
			JaUk4vLK.close();
			if (qYKI7w68 != null) {
				qYKI7w68.close();
			}
			if (sxkVaC7m != null) {
				sxkVaC7m.close();
			}
		}
	}

}