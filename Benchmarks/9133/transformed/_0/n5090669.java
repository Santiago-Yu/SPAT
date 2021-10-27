class n5090669 {
	private static void copyFile(File gZ1lEUdx, File YJZu0vD8) throws IOException {
		if (!YJZu0vD8.exists()) {
			YJZu0vD8.createNewFile();
		}
		FileChannel A50CgEN5 = null;
		FileChannel w6PEgFC3 = null;
		try {
			A50CgEN5 = new FileInputStream(gZ1lEUdx).getChannel();
			w6PEgFC3 = new FileOutputStream(YJZu0vD8).getChannel();
			w6PEgFC3.transferFrom(A50CgEN5, 0, A50CgEN5.size());
		} finally {
			if (A50CgEN5 != null) {
				A50CgEN5.close();
			}
			if (w6PEgFC3 != null) {
				w6PEgFC3.close();
			}
		}
	}

}