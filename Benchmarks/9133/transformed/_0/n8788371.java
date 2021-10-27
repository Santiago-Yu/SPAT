class n8788371 {
	private void tail(String[] YJNVnXCj, int FM5yhmql) throws IOException {
		CommandFormat Z2ADwYfW = new CommandFormat("tail", 1, 1, "f");
		String UVYzybMX = null;
		Path I9s4iXA8 = null;
		try {
			List<String> LBytV17B = Z2ADwYfW.parse(YJNVnXCj, FM5yhmql);
			UVYzybMX = LBytV17B.get(0);
		} catch (IllegalArgumentException JaWqpYSh) {
			System.err.println("Usage: java FsShell " + TAIL_USAGE);
			throw JaWqpYSh;
		}
		boolean CzAQ61lF = Z2ADwYfW.getOpt("f") ? true : false;
		I9s4iXA8 = new Path(UVYzybMX);
		FileSystem s9McEgsa = I9s4iXA8.getFileSystem(getConf());
		if (s9McEgsa.isDirectory(I9s4iXA8)) {
			throw new IOException("Source must be a file.");
		}
		long llvCoExD = s9McEgsa.getFileStatus(I9s4iXA8).getLen();
		long TsSECCTm = (llvCoExD > 1024) ? llvCoExD - 1024 : 0;
		while (true) {
			FSDataInputStream NdtffBNJ = s9McEgsa.open(I9s4iXA8);
			NdtffBNJ.seek(TsSECCTm);
			IOUtils.copyBytes(NdtffBNJ, System.out, 1024, false);
			TsSECCTm = NdtffBNJ.getPos();
			NdtffBNJ.close();
			if (!CzAQ61lF) {
				break;
			}
			llvCoExD = s9McEgsa.getFileStatus(I9s4iXA8).getLen();
			TsSECCTm = (llvCoExD > TsSECCTm) ? TsSECCTm : llvCoExD;
			try {
				Thread.sleep(5000);
			} catch (InterruptedException XStnSTky) {
				break;
			}
		}
	}

}