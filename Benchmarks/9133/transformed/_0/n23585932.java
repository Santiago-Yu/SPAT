class n23585932 {
	public static void concatenateOutput(File[] lMqQxqfQ, File FdO2f9Ke) {
		int cjCHDVYj = lMqQxqfQ.length;
		byte slfEyoLN = (byte) '\n';
		try {
			FileOutputStream dLpWqBSz = new FileOutputStream(FdO2f9Ke);
			FileChannel LgddcCMB = dLpWqBSz.getChannel();
			System.out.println("Processing " + lMqQxqfQ[0].getPath());
			FileInputStream deDf91jb = new FileInputStream(lMqQxqfQ[0]);
			FileChannel Z93TGZZY = deDf91jb.getChannel();
			int l0tFpd8U = 100000;
			ByteBuffer GzsOMFVE = ByteBuffer.allocate(l0tFpd8U);
			GzsOMFVE.clear();
			while (Z93TGZZY.read(GzsOMFVE) > 0) {
				GzsOMFVE.flip();
				LgddcCMB.write(GzsOMFVE);
				GzsOMFVE.clear();
			}
			Z93TGZZY.close();
			for (int QyxO4xcj = 1; QyxO4xcj < cjCHDVYj; QyxO4xcj++) {
				System.out.println("Processing " + lMqQxqfQ[QyxO4xcj].getPath());
				deDf91jb = new FileInputStream(lMqQxqfQ[QyxO4xcj]);
				Z93TGZZY = deDf91jb.getChannel();
				GzsOMFVE.clear();
				int TV7YtEGZ = Z93TGZZY.read(GzsOMFVE);
				GzsOMFVE.flip();
				byte KDkSione = GzsOMFVE.get();
				while (KDkSione != slfEyoLN) {
					KDkSione = GzsOMFVE.get();
				}
				LgddcCMB.write(GzsOMFVE);
				GzsOMFVE.clear();
				while (Z93TGZZY.read(GzsOMFVE) > 0) {
					GzsOMFVE.flip();
					LgddcCMB.write(GzsOMFVE);
					GzsOMFVE.clear();
				}
				Z93TGZZY.close();
			}
			LgddcCMB.close();
		} catch (IOException QvsDPbqE) {
			QvsDPbqE.printStackTrace();
			System.exit(-1);
		}
	}

}