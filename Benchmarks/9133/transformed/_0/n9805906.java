class n9805906 {
	public static boolean dump(File ZnL4nSBu, File IVnkIwaI) {
		boolean rY8lnhWJ = false;
		try {
			InputStream XSUNGroa = new BufferedInputStream(new FileInputStream(ZnL4nSBu));
			OutputStream bvJ9EBSQ = new BufferedOutputStream(new FileOutputStream(IVnkIwaI));
			while (XSUNGroa.available() > 0) {
				bvJ9EBSQ.write(XSUNGroa.read());
			}
			bvJ9EBSQ.flush();
			bvJ9EBSQ.close();
			XSUNGroa.close();
			return true;
		} catch (IOException HrhEl6Ij) {
		}
		return rY8lnhWJ;
	}

}