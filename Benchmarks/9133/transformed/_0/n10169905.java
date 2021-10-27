class n10169905 {
	public void copy(File XVenMZgx, File zx8V7Gkx) throws IOException {
		FileChannel hc6sR9wo = (new FileInputStream(XVenMZgx)).getChannel();
		FileChannel d7BoqUD8 = (new FileOutputStream(zx8V7Gkx)).getChannel();
		hc6sR9wo.transferTo(0, XVenMZgx.length(), d7BoqUD8);
		hc6sR9wo.close();
		d7BoqUD8.close();
	}

}