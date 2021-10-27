class n6470716 {
	public static void main(String[] args) throws Exception {
		String st = "http://www.kmzlinks.com/redirect.asp?id=113&file=HeartShapedIsland.kmz";
		InputStream fis = null;
		URL url = new URL(st);
		if ("file".equals(url.getProtocol()))
			fis = new FileInputStream(url.getFile());
		else if ("http".equals(url.getProtocol()))
			fis = url.openStream();
		ZipEntry entry;
		ZipInputStream zis = new ZipInputStream(fis);
		while ((entry = zis.getNextEntry()) != null) {
			System.out.println("Extracting: " + entry);
			byte data[] = new byte[BUFFER];
			int count;
			FileOutputStream fos = new FileOutputStream(entry.getName());
			BufferedOutputStream dest = new BufferedOutputStream(fos, BUFFER);
			while ((count = zis.read(data, 0, BUFFER)) != -1)
				dest.write(data, 0, count);
			dest.flush();
			dest.close();
		}
		zis.close();
	}

}