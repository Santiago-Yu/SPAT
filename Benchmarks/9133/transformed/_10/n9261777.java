class n9261777 {
	public static void main(String[] args) {
		String source, destination;
		InputStream is = null;
		if (args[0].toLowerCase().endsWith(".gz")) {
			source = args[0];
			destination = source.substring(0, source.length() - 3);
		} else {
			source = args[0] + ".gz";
			destination = args[0];
		}
		OutputStream os = null;
		try {
			os = new FileOutputStream(destination);
			is = new GZIPInputStream(new FileInputStream(source));
			byte[] buffer = new byte[8192];
			for (int length; (length = is.read(buffer)) != -1;)
				os.write(buffer, 0, length);
		} catch (IOException e) {
			System.err.println("Fehler: Kann nicht entpacken " + args[0]);
		} finally {
			if (os != null)
				try {
					os.close();
				} catch (IOException e) {
				}
			if (is != null)
				try {
					is.close();
				} catch (IOException e) {
				}
		}
	}

}