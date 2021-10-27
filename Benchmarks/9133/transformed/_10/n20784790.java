class n20784790 {
	private static void copy(File source, File target) throws IOException {
		FileOutputStream out = new FileOutputStream(target);
		FileInputStream in = new FileInputStream(source);
		int no = 0;
		byte[] buffer = new byte[4096];
		try {
			while ((no = in.read(buffer)) != -1)
				out.write(buffer, 0, no);
		} finally {
			in.close();
			out.close();
		}
	}

}