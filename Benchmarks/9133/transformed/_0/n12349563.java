class n12349563 {
	public boolean resourceExists(String T1HVS7IE) {
		if ((T1HVS7IE == null) || (T1HVS7IE.length() == 0)) {
			return false;
		}
		try {
			URL FXCzePzI = buildURL(T1HVS7IE);
			URLConnection m1CRawYw = FXCzePzI.openConnection();
			InputStream q3GQnxxn = null;
			try {
				byte[] Q9iNgMW3 = new byte[2048];
				q3GQnxxn = m1CRawYw.getInputStream();
				while (q3GQnxxn.read(Q9iNgMW3, 0, 2048) >= 0)
					;
				return true;
			} finally {
				if (q3GQnxxn != null) {
					q3GQnxxn.close();
				}
			}
		} catch (IOException dmBBXhAD) {
			return false;
		}
	}

}