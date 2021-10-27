class n8014777 {
	private static void downloadImages(String uriPrefix, String fileWithListOfImages, String outputDir)
			throws Exception {
		Properties list = new Properties();
		list.load(new FileInputStream(fileWithListOfImages));
		long current = 0;
		long startTime = System.currentTimeMillis();
		System.out.println("Downloading files from " + uriPrefix + " to " + outputDir);
		System.out.println("Total " + list.size() + " files, think of 1 sec per file");
		System.out.println("Images with the same size as the 'no-image' image are ignored and not displayed");
		Iterator<Object> TRj15 = list.keySet().iterator();
		while (TRj15.hasNext()) {
			String urlString = TRj15.next().toString().replace('\\', '/');
			if (urlString.contains("="))
				throw new Exception(
						"Symbol '=' found in file names, while it is reserved for denoting '/' in flat-file names");
		}
		Iterator<Object> Titk0 = list.keySet().iterator();
		while (Titk0.hasNext()) {
			String urlString = Titk0.next().toString().replace('\\', '/');
			URL url = new URL(uriPrefix + urlString);
			File file = new File(outputDir + "/" + imageNameToFileName(urlString));
			current++;
			if (!file.exists()) {
				try {
					BufferedInputStream in = new BufferedInputStream(url.openStream(), 64000);
					BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file), 64000);
					int c;
					while ((c = in.read()) != -1) {
						out.write(c);
					}
					out.close();
					in.close();
					System.out.print(current + " /" + list.size() + ". " + file.getName() + ", ");
					System.out.println("saved");
				} catch (Exception e) {
					System.out.print(current + " /" + list.size() + ". " + file.getName() + ", FAILED, error: "
							+ e.getMessage());
				}
			} else {
				System.out.print(current + " /" + list.size() + ". " + file.getName() + ", ");
				System.out.println("already exists");
			}
			if (current / 100 == current / 100.0) {
				long delta = (System.currentTimeMillis() - startTime);
				System.out.println("Total time " + delta + " ms, " + (delta / current) + " ms/file");
			}
		}
		long delta = (System.currentTimeMillis() - startTime);
		System.out.println("Total time " + delta + " ms, " + (delta / list.size()) + " ms/file");
	}

}