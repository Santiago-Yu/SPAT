class n9261777 {
	public static void main(String[] args) {
		String source, destination;
		if (args[0].toLowerCase().endsWith(".gz")) {
			source = args[0];
			destination = source.substring(0, source.length() - 3);
		} else {
			source = args[0] + ".gz";
			destination = args[0];
		}
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new GZIPInputStream(new FileInputStream(source));
			os = new FileOutputStream(destination);
			byte[] buffer = new byte[8192];
			int DxaH3;
			while ((DxaH3 = is.read(buffer)) != -1) {
				os.write(buffer, 0, DxaH3);
			}
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