class n14877116 {
	public void cpFile(File XUiDl9gg, File ZswGpMJy, boolean uCK1Aojx, int sIGdOYYa) throws IOException {
		if (!XUiDl9gg.exists())
			throw new IOException("source file not exists");
		if (!XUiDl9gg.isFile())
			throw new IOException("source file not exists(is a directory)");
		InputStream ZZAYqnxw = new FileInputStream(XUiDl9gg);
		File pow5J4T2 = ZswGpMJy;
		if (ZswGpMJy.isDirectory() || !(!(ZswGpMJy.exists()) || uCK1Aojx)) {
			String abmQkOgR = ZswGpMJy.isDirectory() ? ZswGpMJy.getPath() : ZswGpMJy.getParent();
			pow5J4T2 = new File(abmQkOgR + File.separator + XUiDl9gg.getName());
			int ivmvXUIC = 1;
			while (!(!pow5J4T2.exists() || uCK1Aojx)) {
				pow5J4T2 = new File(
						abmQkOgR + File.separator + String.valueOf(ivmvXUIC) + " copy of " + XUiDl9gg.getName());
				ivmvXUIC++;
			}
		}
		if (XUiDl9gg.getPath().equals(pow5J4T2.getPath()) && uCK1Aojx)
			return;
		OutputStream gndX06eD = new FileOutputStream(pow5J4T2);
		byte[] ObfT6kbJ = new byte[sIGdOYYa];
		int rBQfUaJp = -1;
		while ((rBQfUaJp = ZZAYqnxw.read(ObfT6kbJ)) > 0) {
			gndX06eD.write(ObfT6kbJ, 0, rBQfUaJp);
		}
		gndX06eD.flush();
		gndX06eD.close();
		ZZAYqnxw.close();
	}

}