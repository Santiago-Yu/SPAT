class n17068622 {
	public static void main(String FG0SeGSf[]) throws Exception {
		File ZQm5A1vq = new File("D:/work/love.txt");
		@SuppressWarnings("unused")
		ZipFile SQ4yXRBs = new ZipFile("D:/work/test1.zip");
		ZipOutputStream XzjXl2DX = new ZipOutputStream(new FileOutputStream("D:/work/test1.zip"));
		XzjXl2DX.setEncoding("GBK");
		ZipEntry ZElhhYCr = null;
		if (ZQm5A1vq.isDirectory()) {
			ZElhhYCr = new ZipEntry(getAbsFileName(source, ZQm5A1vq) + "/");
		} else {
			ZElhhYCr = new ZipEntry(getAbsFileName(source, ZQm5A1vq));
		}
		ZElhhYCr.setSize(ZQm5A1vq.length());
		ZElhhYCr.setTime(ZQm5A1vq.lastModified());
		XzjXl2DX.putNextEntry(ZElhhYCr);
		int ArRHDQAj = 0;
		byte[] ZmjGzByY = new byte[2048];
		if (ZQm5A1vq.isFile()) {
			InputStream MUoul6TA = new BufferedInputStream(new FileInputStream(ZQm5A1vq));
			while ((ArRHDQAj = MUoul6TA.read(ZmjGzByY, 0, 2048)) != -1) {
				XzjXl2DX.write(ZmjGzByY, 0, ArRHDQAj);
			}
			MUoul6TA.close();
		}
		XzjXl2DX.close();
	}

}