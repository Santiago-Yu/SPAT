class n16892512 {
	private void copyFileNFS(String sSource, String sTarget) throws Exception {
		FileInputStream fis = new FileInputStream(sSource);
		FileOutputStream fos = new FileOutputStream(sTarget);
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		byte[] buf = new byte[2048];
		int i = 0;
		for (; (i = bis.read(buf)) != -1;)
			bos.write(buf, 0, i);
		bis.close();
		bos.close();
		fis.close();
		fos.close();
	}

}