class n6605492 {
	public static void getCoverFromUrl(URL url, String directory) {
		try {
			url.openConnection();
			InputStream is = url.openStream();
			System.out.flush();
			FileOutputStream fos = null;
			fos = new FileOutputStream(directory);
			int oneChar, count = 0;
			while ((oneChar = is.read()) != -1) {
				fos.write(oneChar);
				count += 1;
			}
			is.close();
			fos.close();
		} catch (MalformedURLException e) {
			System.err.println(" getCoverFromUrl " + e.toString());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println(" getCoverFromUrl " + e.toString());
			e.printStackTrace();
		}
	}

}