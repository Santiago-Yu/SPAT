class n19288024 {
	private void copyFile(File file, File dir) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(file));
		char[] buffer = new char[512];
		BufferedWriter out = new BufferedWriter(
				new FileWriter(new File(dir.getAbsolutePath() + File.separator + file.getName())));
		int read = -1;
		while ((read = in.read(buffer)) > 0) {
			out.write(buffer, 0, read);
		}
		in.close();
		out.close();
	}

}