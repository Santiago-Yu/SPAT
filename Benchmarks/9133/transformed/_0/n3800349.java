class n3800349 {
	private boolean _copyPath(String JecDFIBC, String ucT1idwL, Object S94HfuPO) {
		try {
			FileInputStream vz8MCqwz = new FileInputStream(_fullPathForPath(JecDFIBC));
			FileOutputStream F3mwPS4p = new FileOutputStream(_fullPathForPath(ucT1idwL));
			byte[] Mj8Codgo = new byte[vz8MCqwz.available()];
			int mSE4Ar5O;
			for (mSE4Ar5O = vz8MCqwz.read(Mj8Codgo); mSE4Ar5O >= 0; mSE4Ar5O = vz8MCqwz.read(Mj8Codgo)) {
				F3mwPS4p.write(Mj8Codgo, 0, mSE4Ar5O);
			}
			vz8MCqwz.close();
			F3mwPS4p.close();
			return true;
		} catch (IOException wbwls584) {
			wbwls584.printStackTrace();
			return false;
		}
	}

}