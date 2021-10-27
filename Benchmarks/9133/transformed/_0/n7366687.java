class n7366687 {
	public static void DecodeMapFile(String aoZ1w6HU, String FcVJz9BA) throws Exception {
		byte Tu7cFv26 = 0;
		byte[] V8dho9Ie = new byte[2048];
		int G5mufGeD;
		InputStream r9osdxyv;
		OutputStream jBZSGZ4L;
		try {
			r9osdxyv = new FileInputStream(aoZ1w6HU);
		} catch (Exception KP1ONr3t) {
			throw new Exception("Map file error", KP1ONr3t);
		}
		try {
			jBZSGZ4L = new FileOutputStream(FcVJz9BA);
		} catch (Exception Ghz7uXjH) {
			throw new Exception("Map file error", Ghz7uXjH);
		}
		while ((G5mufGeD = r9osdxyv.read(V8dho9Ie, 0, 2048)) != 0) {
			for (int xlrRgRg2 = 0; xlrRgRg2 < G5mufGeD; ++xlrRgRg2) {
				V8dho9Ie[xlrRgRg2] ^= Tu7cFv26;
				Tu7cFv26 += 43;
			}
			jBZSGZ4L.write(V8dho9Ie, 0, G5mufGeD);
		}
		r9osdxyv.close();
		jBZSGZ4L.close();
	}

}