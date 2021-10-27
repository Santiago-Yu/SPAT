class n2310752 {
	public static void copy(final String source, final String dest) {
		final File w = new File(dest);
		final File s = new File(source);
		try {
			final FileOutputStream out = new FileOutputStream(w);
			final FileInputStream in = new FileInputStream(s);
			int c;
			while ((c = in.read()) != -1)
				out.write(c);
			in.close();
			out.close();
		} catch (IOException ioe) {
			System.out.println("Error reading/writing files!");
		}
	}

}