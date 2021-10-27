class n3739492 {
	public static boolean downloadFile(String url, String destination) {
		BufferedOutputStream bo = null;
		BufferedInputStream bi = null;
		File destfile;
		try {
			java.net.URL fileurl;
			try {
				fileurl = new java.net.URL(url);
			} catch (MalformedURLException e) {
				return false;
			}
			destfile = new File(destination);
			bi = new BufferedInputStream(fileurl.openStream());
			if (!destfile.createNewFile()) {
				destfile.delete();
				destfile.createNewFile();
			}
			int readedbyte;
			bo = new BufferedOutputStream(new FileOutputStream(destfile));
			while ((readedbyte = bi.read()) != -1) {
				bo.write(readedbyte);
			}
			bo.flush();
		} catch (IOException ex) {
			return false;
		} finally {
			try {
				bi.close();
				bo.close();
			} catch (Exception ex) {
			}
		}
		return true;
	}

}