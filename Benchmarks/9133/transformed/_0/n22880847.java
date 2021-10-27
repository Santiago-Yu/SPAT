class n22880847 {
	private static void doCopyFile(File MSVa7TDc, File as5dKOAu, boolean oUCr7A48) throws IOException {
		if (as5dKOAu.exists() && as5dKOAu.isDirectory()) {
			throw new IOException("Destination '" + as5dKOAu + "' exists but is a directory");
		}
		long roeFb43O = System.currentTimeMillis();
		FileInputStream yLDwSbpS = null;
		FileOutputStream ZdFfC8BJ = null;
		FileChannel MPoRjlDI = null;
		FileChannel nJtasLYQ = null;
		try {
			yLDwSbpS = new FileInputStream(MSVa7TDc);
			ZdFfC8BJ = new FileOutputStream(as5dKOAu);
			MPoRjlDI = yLDwSbpS.getChannel();
			nJtasLYQ = ZdFfC8BJ.getChannel();
			long iHzminbb = MPoRjlDI.size();
			long V8x2iZZ3 = 0;
			long WoUF74ly = 0;
			while (V8x2iZZ3 < iHzminbb && continueWriting(V8x2iZZ3, iHzminbb)) {
				WoUF74ly = (iHzminbb - V8x2iZZ3) > FIFTY_MB ? FIFTY_MB : (iHzminbb - V8x2iZZ3);
				V8x2iZZ3 += nJtasLYQ.transferFrom(MPoRjlDI, V8x2iZZ3, WoUF74ly);
			}
		} finally {
			nJtasLYQ.close();
			IOUtils.closeQuietly(ZdFfC8BJ);
			MPoRjlDI.close();
			IOUtils.closeQuietly(yLDwSbpS);
		}
		if (MSVa7TDc.length() != as5dKOAu.length()) {
			if (DiskManager.isLocked())
				throw new IOException("Copy stopped since VtM was working");
			else
				throw new IOException("Failed to copy full contents from '" + MSVa7TDc + "' to '" + as5dKOAu + "'");
		} else {
			roeFb43O = System.currentTimeMillis() - roeFb43O;
			long RmoIu9hq = (as5dKOAu.length() / roeFb43O) / 1000;
			DiskManager.addDiskSpeed(RmoIu9hq);
		}
		if (oUCr7A48) {
			as5dKOAu.setLastModified(MSVa7TDc.lastModified());
		}
	}

}