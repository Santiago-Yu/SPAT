class n5659863 {
	public static FileChannel newFileChannel(File R7HcW6SD, String cI3lLc8W, boolean ivErixs7) throws IOException {
		if (R7HcW6SD == null)
			return null;
		if (cI3lLc8W == null || cI3lLc8W.length() == 0) {
			return null;
		}
		cI3lLc8W = cI3lLc8W.toLowerCase();
		if (cI3lLc8W.equals(MODE_READ)) {
			if (FileUtil.exists(R7HcW6SD, ivErixs7)) {
				FileInputStream TBf3LHks = new FileInputStream(R7HcW6SD);
				FileChannel WIYwELZ0 = TBf3LHks.getChannel();
				setObjectMap(WIYwELZ0.hashCode(), TBf3LHks, FIS);
				return WIYwELZ0;
			}
		} else if (cI3lLc8W.equals(MODE_WRITE)) {
			FileOutputStream UdPM5KjH = new FileOutputStream(R7HcW6SD);
			FileChannel ToZXa2VT = UdPM5KjH.getChannel();
			setObjectMap(ToZXa2VT.hashCode(), UdPM5KjH, FOS_W);
			return ToZXa2VT;
		} else if (cI3lLc8W.equals(MODE_APPEND)) {
			if (FileUtil.exists(R7HcW6SD, ivErixs7)) {
				RandomAccessFile ACHVmL4s = new RandomAccessFile(R7HcW6SD, "rw");
				FileChannel tTTbVt9D = ACHVmL4s.getChannel();
				tTTbVt9D.position(tTTbVt9D.size());
				setObjectMap(tTTbVt9D.hashCode(), ACHVmL4s, FOS_A);
				return tTTbVt9D;
			}
		} else if (cI3lLc8W.equals(MODE_READ_WRITE)) {
			if (FileUtil.exists(R7HcW6SD, ivErixs7)) {
				RandomAccessFile ZxTQtk9a = new RandomAccessFile(R7HcW6SD, cI3lLc8W);
				FileChannel GUulIGRq = ZxTQtk9a.getChannel();
				setObjectMap(GUulIGRq.hashCode(), ZxTQtk9a, RAF);
				return GUulIGRq;
			}
		} else {
			throw new IllegalArgumentException("Illegal read/write type : [" + cI3lLc8W + "]\n"
					+ "You can use following types for: \n" + "  (1) Read Only  = \"r\"\n"
					+ "  (2) Write Only = \"w\"\n" + "  (3) Read/Write = \"rw\"\n" + "  (4) Append     = \"a\"");
		}
		return null;
	}

}