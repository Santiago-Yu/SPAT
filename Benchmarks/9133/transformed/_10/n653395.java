class n653395 {
	public static boolean downloadFile(String url, String destination) throws Exception {
		BufferedOutputStream bo = null;
		BufferedInputStream bi = null;
		java.net.URL fileurl;
		File destfile;
		fileurl = new java.net.URL(url);
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
		bi.close();
		bo.close();
		return true;
	}

}