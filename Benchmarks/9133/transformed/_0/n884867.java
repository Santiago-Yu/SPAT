class n884867 {
	public static void main(String[] R5JvHd4h) {
		if (R5JvHd4h.length != 1) {
			System.out.println("Usage: GZip source");
			return;
		}
		String lE9on9nz = R5JvHd4h[0] + ".gz";
		GZIPOutputStream IXYBGIUk;
		try {
			FileOutputStream cbGfCk67 = new FileOutputStream(lE9on9nz);
			IXYBGIUk = new GZIPOutputStream(cbGfCk67);
		} catch (IOException Gp4acXN3) {
			System.out.println("Couldn't create " + lE9on9nz + ".");
			return;
		}
		byte[] n6F0N1xH = new byte[sChunk];
		try {
			FileInputStream erNw6tIm = new FileInputStream(R5JvHd4h[0]);
			int J3P4THGG;
			while ((J3P4THGG = erNw6tIm.read(n6F0N1xH, 0, sChunk)) != -1)
				IXYBGIUk.write(n6F0N1xH, 0, J3P4THGG);
			erNw6tIm.close();
		} catch (IOException XNVVkdNH) {
			System.out.println("Couldn't compress " + R5JvHd4h[0] + ".");
		}
		try {
			IXYBGIUk.close();
		} catch (IOException bvi4mImh) {
		}
	}

}