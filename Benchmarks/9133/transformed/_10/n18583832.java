class n18583832 {
	private static void copy(File source, File target) throws IOException {
		FileOutputStream to = null;
		FileInputStream from = null;
		try {
			to = new FileOutputStream(target);
			from = new FileInputStream(source);
			int bytesRead;
			byte[] buffer = new byte[4096];
			while ((bytesRead = from.read(buffer)) != -1)
				to.write(buffer, 0, bytesRead);
		} finally {
			if (from != null)
				try {
					from.close();
				} catch (IOException e) {
				}
			if (to != null)
				try {
					to.close();
				} catch (IOException e) {
				}
		}
	}

}