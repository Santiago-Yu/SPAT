class n9543284 {
	public static final void copyFile(String iaZ1C4Zl, String cGYoBcD3) throws IOException {
		FileInputStream cgYAAP1e = null;
		FileOutputStream q4pv14xZ = null;
		FileChannel XLz4gOXb = null;
		FileChannel hpCc3WoV = null;
		Util.copyBuffer.clear();
		try {
			cgYAAP1e = new FileInputStream(iaZ1C4Zl);
			XLz4gOXb = cgYAAP1e.getChannel();
			q4pv14xZ = new FileOutputStream(cGYoBcD3);
			hpCc3WoV = q4pv14xZ.getChannel();
			int xQE5Yscd = (int) XLz4gOXb.size();
			int HzII2Q4p = 0;
			while (HzII2Q4p < xQE5Yscd) {
				if (XLz4gOXb.read(Util.copyBuffer) < 0) {
					break;
				}
				Util.copyBuffer.flip();
				HzII2Q4p += hpCc3WoV.write(Util.copyBuffer);
				Util.copyBuffer.compact();
			}
		} finally {
			try {
				if (XLz4gOXb != null) {
					XLz4gOXb.close();
				} else if (cgYAAP1e != null) {
					cgYAAP1e.close();
				}
			} catch (IOException nqxJxIYA) {
			}
			try {
				if (hpCc3WoV != null) {
					hpCc3WoV.close();
				} else if (q4pv14xZ != null) {
					q4pv14xZ.close();
				}
			} catch (IOException m7MHjd23) {
			}
		}
	}

}