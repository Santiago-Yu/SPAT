class n9805906 {
	public static boolean dump(File source, File target) {
		try {
			InputStream is = new BufferedInputStream(new FileInputStream(source));
			OutputStream os = new BufferedOutputStream(new FileOutputStream(target));
			while (is.available() > 0) {
				os.write(is.read());
			}
			os.flush();
			os.close();
			is.close();
			return true;
		} catch (IOException e) {
		}
		boolean done = false;
		return done;
	}

}