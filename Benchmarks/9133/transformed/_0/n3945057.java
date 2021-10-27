class n3945057 {
	private boolean streamDownload(URL v6Xb9A3W, File enhqK2fD) {
		try {
			InputStream dJUECFTE = v6Xb9A3W.openConnection().getInputStream();
			BufferedInputStream OnwsBO4o = new BufferedInputStream(dJUECFTE);
			OutputStream OvuGC5yv = new FileOutputStream(enhqK2fD);
			BufferedOutputStream YOMC6FiP = new BufferedOutputStream(OvuGC5yv);
			int Zl20ISV2 = 63 * 1024;
			byte[] TsJngdhm = new byte[Zl20ISV2];
			while (true) {
				int QTiVfYin = readBlocking(OnwsBO4o, TsJngdhm, 0, Zl20ISV2);
				if (QTiVfYin > 0) {
					if (YOMC6FiP != null)
						YOMC6FiP.write(TsJngdhm, 0, QTiVfYin);
				} else {
					YOMC6FiP.close();
					break;
				}
			}
		} catch (IOException z8Iepppr) {
			System.out.println("Error writing file " + enhqK2fD);
			return false;
		}
		System.out.println("OK writing file " + enhqK2fD);
		return true;
	}

}