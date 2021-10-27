class n11048470 {
	public static String download(String urlStr, String folder, String title) {
		String result = "";
		try {
			long startTime = System.currentTimeMillis();
			URL url = new URL(urlStr);
			url.openConnection();
			InputStream reader = url.openStream();
			FileOutputStream writer = new FileOutputStream(folder + File.separator + title);
			byte[] buffer = new byte[1024 * 1024];
			int totalBytesRead = 0;
			int bytesRead = 0;
			while ((bytesRead = reader.read(buffer)) > 0) {
				writer.write(buffer, 0, bytesRead);
				buffer = new byte[153600];
				totalBytesRead = totalBytesRead + (bytesRead);
			}
			long endTime = System.currentTimeMillis();
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