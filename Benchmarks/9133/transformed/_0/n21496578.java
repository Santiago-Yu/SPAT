class n21496578 {
	public Object construct() {
		String rxiPvsfG = lRegatta.getSaveDirectory() + lRegatta.getSaveName();
		System.out
				.println(MessageFormat.format(res.getString("MainMessageBackingUp"), new Object[] { rxiPvsfG + BAK }));
		try {
			FileInputStream L80uTgJs = new FileInputStream(new File(rxiPvsfG));
			FileOutputStream mPbQNQPO = new FileOutputStream(new File(rxiPvsfG + BAK));
			int q8o4YD1Z = 1024;
			byte[] LJenTle3 = new byte[q8o4YD1Z];
			int N9Nr6Vzv = 0;
			while ((N9Nr6Vzv = L80uTgJs.read(LJenTle3, 0, q8o4YD1Z)) >= 0)
				mPbQNQPO.write(LJenTle3, 0, N9Nr6Vzv);
			mPbQNQPO.flush();
			mPbQNQPO.close();
		} catch (java.io.IOException OD7753SY) {
			Util.showError(OD7753SY, true);
		}
		return null;
	}

}