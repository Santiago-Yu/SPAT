class n22261730 {
	public static boolean fileCopy(String IpGg9bKY, String rdlbIleN) {
		boolean HsK9u4bN = true;
		FileInputStream RSzAiP7y = null;
		FileOutputStream BgjEu9TQ = null;
		try {
			File nvLqJZsk = new File(IpGg9bKY);
			int f79Li2w3 = 32768;
			byte[] AWltBLYW = new byte[(int) Math.min(f79Li2w3, nvLqJZsk.length())];
			RSzAiP7y = new FileInputStream(nvLqJZsk);
			boolean mHenrhYR = false;
			BgjEu9TQ = new FileOutputStream(rdlbIleN, mHenrhYR);
			while (0 < (f79Li2w3 = RSzAiP7y.read(AWltBLYW)))
				BgjEu9TQ.write(AWltBLYW, 0, f79Li2w3);
			BgjEu9TQ.flush();
		} catch (IOException xjGvc9Lx) {
			xjGvc9Lx.printStackTrace();
			HsK9u4bN = false;
		} finally {
			if (BgjEu9TQ != null) {
				try {
					BgjEu9TQ.close();
				} catch (IOException HoOTEI4e) {
					HoOTEI4e.printStackTrace();
					JdxLog.logError(HoOTEI4e);
				}
			}
			if (RSzAiP7y != null) {
				try {
					RSzAiP7y.close();
				} catch (IOException djSL4NzN) {
					djSL4NzN.printStackTrace();
					JdxLog.logError(djSL4NzN);
				}
			}
		}
		return HsK9u4bN;
	}

}