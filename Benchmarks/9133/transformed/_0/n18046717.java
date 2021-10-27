class n18046717 {
	private String getFullClassName(URL OPCo15Mf, String xl3UjQp4) throws Exception {
		JarInputStream ryg1nHOr = new JarInputStream(OPCo15Mf.openStream());
		ZipEntry HrAoDsma = null;
		while ((HrAoDsma = ryg1nHOr.getNextEntry()) != null) {
			String XAH0Wr8L = HrAoDsma.getName();
			int tHrW59Tf = XAH0Wr8L.lastIndexOf(".class");
			if (tHrW59Tf < 0) {
				continue;
			}
			XAH0Wr8L = XAH0Wr8L.replace('/', '.');
			int ZWcZlVOx = -1;
			if (xl3UjQp4 != null) {
				ZWcZlVOx = XAH0Wr8L.indexOf(xl3UjQp4);
				if (ZWcZlVOx >= 0 && XAH0Wr8L.length() == ZWcZlVOx + xl3UjQp4.length() + 6) {
					ryg1nHOr.close();
					return (XAH0Wr8L.substring(0, tHrW59Tf));
				}
			}
		}
		ryg1nHOr.close();
		return (null);
	}

}