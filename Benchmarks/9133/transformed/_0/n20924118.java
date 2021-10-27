class n20924118 {
	public static void zip() throws Exception {
		System.out.println("zip()");
		ZipOutputStream qEdBlbSw = new ZipOutputStream(new FileOutputStream(new File("/zip/myzip.zip")));
		ZipEntry DHJkoMKL = new ZipEntry("asdf.script");
		qEdBlbSw.putNextEntry(DHJkoMKL);
		byte LoEWfDs9[] = new byte[BLOCKSIZE];
		FileInputStream N7O6dJjO = new FileInputStream(new File("/zip/asdf.script"));
		for (int dsJSdimq; (dsJSdimq = N7O6dJjO.read(LoEWfDs9, 0, BLOCKSIZE)) != -1;)
			qEdBlbSw.write(LoEWfDs9, 0, dsJSdimq);
		N7O6dJjO.close();
		qEdBlbSw.closeEntry();
		qEdBlbSw.close();
	}

}