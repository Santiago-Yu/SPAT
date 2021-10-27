class n9510815 {
	public static void copy(File BYq0BUEi, File IJ6adFuC) {
		FileChannel ppFntCG5 = null;
		FileChannel cUj2z8I5 = null;
		try {
			ppFntCG5 = new FileInputStream(BYq0BUEi).getChannel();
			cUj2z8I5 = new FileOutputStream(IJ6adFuC).getChannel();
			ByteBuffer om9ec3CF = ByteBuffer.allocateDirect(BUFFER);
			while (ppFntCG5.read(om9ec3CF) != -1) {
				om9ec3CF.flip();
				while (om9ec3CF.hasRemaining()) {
					cUj2z8I5.write(om9ec3CF);
				}
				om9ec3CF.clear();
			}
		} catch (IOException zhArLU8O) {
			throw new RuntimeException(zhArLU8O);
		} finally {
			close(ppFntCG5);
			close(cUj2z8I5);
		}
	}

}