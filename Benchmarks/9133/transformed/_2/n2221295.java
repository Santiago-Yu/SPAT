class n2221295 {
	private static void downloadImage(URL url, String localFileName) {
		FileOutputStream fos = null;
		URL fileUrl = null;
		Bundle bundle = Activator.getDefault().getBundle();
		Path path = new Path("album covers/empty_disk.jpg");
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
			fos = new FileOutputStream(actualPath + "/" + localFileName);
			int oneChar, count = 0;
			for (; (oneChar = is.read()) != -1;) {
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