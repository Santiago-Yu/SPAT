class n9450275 {
	public void url2SaveAsFile(String urlStr, String saveAsFileName) throws Exception {
		URL url = new URL(urlStr);
		File f = new File(saveAsFileName);
		URLConnection uc = url.openConnection();
		if (!f.exists()) {
			BufferedInputStream bis = new BufferedInputStream(uc.getInputStream());
			FileOutputStream fos = new FileOutputStream(f);
			int readCount = 0;
			byte[] buffer = new byte[4096];
			while ((readCount = bis.read(buffer)) != -1) {
				fos.write(buffer, 0, readCount);
			}
			fos.flush();
			fos.close();
			bis.close();
		}
	}

}