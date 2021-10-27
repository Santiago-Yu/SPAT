class n17156131 {
	private static void readAndWriteFile(File source, File target) {
		try {
			FileOutputStream out = new FileOutputStream(target);
			FileInputStream in = new FileInputStream(source);
			int c;
			while ((c = in.read()) != -1)
				out.write(c);
			in.close();
			out.close();
		} catch (Exception e) {
		}
	}

}