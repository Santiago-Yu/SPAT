class n12977779 {
	public void run() {
		FileInputStream rsIPaHGZ;
		FileOutputStream pB7y2ahm;
		try {
			pB7y2ahm = new FileOutputStream(srcName);
		} catch (FileNotFoundException wUjvOfVv) {
			wUjvOfVv.printStackTrace();
			return;
		}
		FileChannel ev3VfPx3 = pB7y2ahm.getChannel();
		FileChannel CDw6235J;
		ByteBuffer TwQyO4QO = ByteBuffer.allocateDirect(BUFFER_SIZE);
		try {
			int vPlMFOFb = 0;
			while (true) {
				int uTtO3IpA = 1;
				String Dpl8tO4K = srcName + "_" + vPlMFOFb;
				rsIPaHGZ = new FileInputStream(Dpl8tO4K);
				CDw6235J = rsIPaHGZ.getChannel();
				while ((uTtO3IpA > 0)) {
					uTtO3IpA = CDw6235J.read(TwQyO4QO);
					TwQyO4QO.flip();
					ev3VfPx3.write(TwQyO4QO);
					TwQyO4QO.compact();
				}
				CDw6235J.close();
				rsIPaHGZ.close();
				vPlMFOFb++;
			}
		} catch (IOException gGTou9LN) {
			gGTou9LN.printStackTrace();
			return;
		}
	}

}