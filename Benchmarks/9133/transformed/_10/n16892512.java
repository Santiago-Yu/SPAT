class n16892512 {
	private void copyFileNFS(String sSource, String sTarget) throws Exception {
		FileOutputStream fos = new FileOutputStream(sTarget);
		FileInputStream fis = new FileInputStream(sSource);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		BufferedInputStream bis = new BufferedInputStream(fis);
		int i = 0;
		byte[] buf = new byte[2048];
		while ((i = bis.read(buf)) != -1)
			bos.write(buf, 0, i);
		bis.close();
		bos.close();
		fis.close();
		fos.close();
	}

}