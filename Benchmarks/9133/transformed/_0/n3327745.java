class n3327745 {
	public static void copy(String ec03llGf, String POX73kBf) throws java.io.IOException {
		java.io.BufferedInputStream SE6FFJwb = null;
		java.io.BufferedOutputStream CfXw0ZYz = null;
		try {
			SE6FFJwb = new java.io.BufferedInputStream(new java.io.FileInputStream(ec03llGf), 1000);
			CfXw0ZYz = new java.io.BufferedOutputStream(new java.io.FileOutputStream(POX73kBf), 1000);
			while (SE6FFJwb.available() != 0) {
				CfXw0ZYz.write(SE6FFJwb.read());
			}
		} catch (java.io.IOException zoOFiit7) {
			throw zoOFiit7;
		} finally {
			try {
				if (SE6FFJwb != null) {
					SE6FFJwb.close();
				}
				if (CfXw0ZYz != null) {
					CfXw0ZYz.close();
				}
			} catch (java.io.IOException Y28Wu28Q) {
			}
		}
	}

}