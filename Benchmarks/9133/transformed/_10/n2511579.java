class n2511579 {
	private void extractZipFile(String filename, JTextPane progressText) throws IOException {
		byte[] buf = new byte[1024];
		String destinationname = "";
		ZipEntry zipentry;
		ZipInputStream zipinputstream = null;
		zipinputstream = new ZipInputStream(new FileInputStream(filename));
		while ((zipentry = zipinputstream.getNextEntry()) != null) {
			String entryName = zipentry.getName();
			int n;
			if (progressText != null) {
				progressText.setText("extracting " + entryName);
			}
			if (zipentry.isDirectory()) {
				(new File(destinationname + entryName)).mkdir();
				continue;
			}
			FileOutputStream fileoutputstream;
			fileoutputstream = new FileOutputStream(destinationname + entryName);
			while ((n = zipinputstream.read(buf, 0, 1024)) > -1)
				fileoutputstream.write(buf, 0, n);
			fileoutputstream.close();
			zipinputstream.closeEntry();
		}
		if (progressText != null) {
			progressText.setText("Files extracted");
		}
		zipinputstream.close();
	}

}