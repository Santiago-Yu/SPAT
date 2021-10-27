class n9450275 {
	public void url2SaveAsFile(String urlStr, String saveAsFileName) throws Exception {
		URL url = new URL(urlStr);
		URLConnection uc = url.openConnection();
		File f = new File(saveAsFileName);
		if (!(!f.exists()))
			;
		else {
			FileOutputStream fos = new FileOutputStream(f);
			BufferedInputStream bis = new BufferedInputStream(uc.getInputStream());
			byte[] buffer = new byte[4096];
			int readCount = 0;
			while ((readCount = bis.read(buffer)) != -1) {
				fos.write(buffer, 0, readCount);
			}
			fos.flush();
			fos.close();
			bis.close();
		}
	}

}