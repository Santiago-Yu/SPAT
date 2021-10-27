class n13966304 {
	private void work(String[] args) throws Exception {
		String dictLocation = CONTENT_URL;
		String cpeContentDirName = CONTENT_DIR;
		String fn = dictLocation.substring(dictLocation.lastIndexOf("/") + 1);
		URL url = new URL(dictLocation);
		File destFile = new File(cpeContentDirName + File.separator + fn);
		URLConnection conn = url.openConnection();
		conn.connect();
		boolean needToDownload = false;
		long lmodifiedRemote = conn.getLastModified();
		if (destFile.exists()) {
			System.out.println(destFile.getAbsolutePath() + " exists, check modification time");
			long lmodifiedLocal = destFile.lastModified();
			if (lmodifiedRemote > lmodifiedLocal) {
				System.out.println("Server file is newer, need to download");
				needToDownload = true;
			} else {
				System.out.println("Local version is newer, no need to download");
			}
		} else {
			System.out.println("Local version doesn't exist, need to download");
			needToDownload = true;
		}
		if (needToDownload) {
			FileOutputStream fos = new FileOutputStream(destFile);
			InputStream is = conn.getInputStream();
			int read = 0;
			byte[] buff = new byte[8192];
			while ((read = is.read(buff)) > 0) {
				fos.write(buff, 0, read);
			}
			fos.flush();
			fos.close();
			is.close();
		}
	}

}