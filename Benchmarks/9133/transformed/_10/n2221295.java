class n2221295 {
	private static void downloadImage(URL url, String localFileName) {
		URL fileUrl = null;
		FileOutputStream fos = null;
		Path path = new Path("album covers/empty_disk.jpg");
		Bundle bundle = Activator.getDefault().getBundle();
		URL localUrl = FileLocator.find(bundle, path, Collections.EMPTY_MAP);
		try {
			fileUrl = FileLocator.toFileURL(localUrl);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			InputStream is = url.openStream();
			String actualPath = fileUrl.getPath();
			actualPath = actualPath.substring(1);
			actualPath = actualPath.substring(0, actualPath.lastIndexOf("/"));
			int oneChar, count = 0;
			fos = new FileOutputStream(actualPath + "/" + localFileName);
			while ((oneChar = is.read()) != -1) {
				fos.write(oneChar);
				count++;
			}
			is.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}