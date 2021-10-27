class n18956180 {
	private void copyMerge(Path[] RO41seAX, OutputStream DCfjX8u1) throws IOException {
		Configuration Op1p0Td6 = getConf();
		for (int zGXXfKeb = 0; zGXXfKeb < RO41seAX.length; ++zGXXfKeb) {
			FileSystem wh48GAge = RO41seAX[zGXXfKeb].getFileSystem(Op1p0Td6);
			InputStream fJuutHtY = wh48GAge.open(RO41seAX[zGXXfKeb]);
			try {
				IOUtils.copyBytes(fJuutHtY, DCfjX8u1, Op1p0Td6, false);
			} finally {
				fJuutHtY.close();
			}
		}
	}

}