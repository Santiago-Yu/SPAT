class n20286589 {
	public static void copyFile(final File mm8ffSD6, final File d0elbtvs) throws FileNotFoundException, IOException {
		FileChannel rqw08T5L = new FileInputStream(mm8ffSD6).getChannel(),
				tDuHAbt0 = new FileOutputStream(d0elbtvs).getChannel();
		ByteBuffer w7gTux9L = ByteBuffer.allocate(1024);
		while (rqw08T5L.read(w7gTux9L) != -1) {
			w7gTux9L.flip();
			tDuHAbt0.write(w7gTux9L);
			w7gTux9L.clear();
		}
		tDuHAbt0.close();
		rqw08T5L.close();
	}

}