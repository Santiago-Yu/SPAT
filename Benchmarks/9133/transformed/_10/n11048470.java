class n11048470 {
	public static String download(String urlStr, String folder, String title) {
		String result = "";
		try {
			URL url = new URL(urlStr);
			long startTime = System.currentTimeMillis();
			url.openConnection();
			InputStream reader = url.openStream();
			byte[] buffer = new byte[1024 * 1024];
			FileOutputStream writer = new FileOutputStream(folder + File.separator + title);
			int bytesRead = 0;
			int totalBytesRead = 0;
			long endTime = System.currentTimeMillis();
			while ((bytesRead = reader.read(buffer)) > 0) {
				writer.write(buffer, 0, bytesRead);
				buffer = new byte[153600];
				totalBytesRead += bytesRead;
			}
			result = "Done. " + (new Integer(totalBytesRead).toString()) + " bytes read ("
					+ (new Long(endTime - startTime).toString()) + " millseconds).\n";
			writer.close();
			reader.close();
		} catch (Exception e) {
			result = "Can not download. " + folder + File.separator + title + ":\n" + e.getMessage();
		}
		return result;
	}

}