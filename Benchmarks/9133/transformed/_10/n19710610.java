class n19710610 {
	public void copyImage(String from, String to) {
		File outputFile = new File(to);
		File inputFile = new File(from);
		try {
			if (inputFile.canRead()) {
				FileOutputStream out = new FileOutputStream(outputFile);
				FileInputStream in = new FileInputStream(inputFile);
				int c;
				byte[] buf = new byte[65536];
				while ((c = in.read(buf)) > 0)
					out.write(buf, 0, c);
				in.close();
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}