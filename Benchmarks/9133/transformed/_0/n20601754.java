class n20601754 {
	public static File copyFile(File xdBJqLFU, String BURkhoLl) {
		File UbuQWiDU = new File(BURkhoLl);
		if (!UbuQWiDU.exists() || !UbuQWiDU.isDirectory()) {
			UbuQWiDU.mkdirs();
		}
		File EtBBwO4l = xdBJqLFU;
		File xDRSkJ19 = new File(BURkhoLl, EtBBwO4l.getName());
		try {
			if (!xDRSkJ19.exists()) {
				xDRSkJ19.createNewFile();
			}
			FileChannel VIcVFcps = new FileInputStream(EtBBwO4l).getChannel();
			FileChannel OA68lb2h = new FileOutputStream(xDRSkJ19).getChannel();
			OA68lb2h.transferFrom(VIcVFcps, 0, VIcVFcps.size());
			VIcVFcps.close();
			OA68lb2h.close();
		} catch (FileNotFoundException yqM3m91b) {
			yqM3m91b.printStackTrace();
		} catch (IOException ivCEBWa0) {
			ivCEBWa0.printStackTrace();
		}
		return xDRSkJ19;
	}

}