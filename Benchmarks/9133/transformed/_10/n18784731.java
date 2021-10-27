class n18784731 {
	public static void downloadFromUrl(String url1, String fileName) {
		try {
			File file = new File(fileName);
			URL url = new URL(url1);
			URLConnection ucon = url.openConnection();
			InputStream is = ucon.getInputStream();
			ByteArrayBuffer baf = new ByteArrayBuffer(50);
			BufferedInputStream bis = new BufferedInputStream(is);
			int current = 0;
			FileOutputStream fos = new FileOutputStream(file);
			while ((current = bis.read()) != -1) {
				baf.append((byte) current);
			}
			fos.write(baf.toByteArray());
			fos.close();
		} catch (IOException e) {
		}
	}

}