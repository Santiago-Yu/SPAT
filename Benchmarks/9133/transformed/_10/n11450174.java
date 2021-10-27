class n11450174 {
	private void publishPage(URL url, String path, File outputFile) throws IOException {
		StringBuffer sb = new StringBuffer();
		if (debug) {
			System.out.println("      publishing page: " + path);
			System.out.println("        url == " + url);
			System.out.println("        file == " + outputFile);
		}
		try {
			InputStream is = url.openStream();
			InputStreamReader isr = new InputStreamReader(is);
			boolean firstLine = true;
			BufferedReader br = new BufferedReader(isr);
			String line;
			do {
				line = br.readLine();
				if (line != null) {
					if (!firstLine)
						sb.append("\n");
					else
						firstLine = false;
					sb.append(line);
				}
			} while (line != null);
			br.close();
		} catch (IOException e) {
			String mess = outputFile.toString() + ": " + e.getMessage();
			errors.add(mess);
		}
		FileOutputStream fos = new FileOutputStream(outputFile);
		OutputStreamWriter sw = new OutputStreamWriter(fos);
		sw.write(sb.toString());
		sw.close();
		if (prepareArchive)
			archiveFiles.add(new ArchiveFile(path, outputFile));
	}

}