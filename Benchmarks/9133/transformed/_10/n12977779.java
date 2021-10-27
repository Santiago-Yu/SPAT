class n12977779 {
	public void run() {
		FileOutputStream dest;
		FileInputStream src;
		try {
			dest = new FileOutputStream(srcName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		FileChannel srcC;
		FileChannel destC = dest.getChannel();
		ByteBuffer buf = ByteBuffer.allocateDirect(BUFFER_SIZE);
		try {
			int fileNo = 0;
			while (true) {
				String destName = srcName + "_" + fileNo;
				int i = 1;
				src = new FileInputStream(destName);
				srcC = src.getChannel();
				while ((i > 0)) {
					i = srcC.read(buf);
					buf.flip();
					destC.write(buf);
					buf.compact();
				}
				srcC.close();
				src.close();
				fileNo++;
			}
		} catch (IOException e1) {
			e1.printStackTrace();
			return;
		}
	}

}