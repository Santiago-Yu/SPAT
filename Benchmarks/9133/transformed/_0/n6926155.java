class n6926155 {
	public boolean download(String oIT6TnVl, String Gx4ZP69Q) {
		OutputStream mJeRDD5u = null;
		URLConnection kwVO0Qfj = null;
		InputStream eU9u9Juc = null;
		try {
			URL bGhmAjHC = new URL(oIT6TnVl);
			mJeRDD5u = new BufferedOutputStream(new FileOutputStream(Gx4ZP69Q));
			kwVO0Qfj = bGhmAjHC.openConnection();
			eU9u9Juc = kwVO0Qfj.getInputStream();
			byte[] TEhoPdEk = new byte[1024];
			int FQcLJuKY;
			long iWDs8itW = 0;
			while ((FQcLJuKY = eU9u9Juc.read(TEhoPdEk)) != -1) {
				mJeRDD5u.write(TEhoPdEk, 0, FQcLJuKY);
				iWDs8itW += FQcLJuKY;
			}
			return true;
		} catch (Exception uKr2UUb6) {
			uKr2UUb6.printStackTrace();
		} finally {
			try {
				if (eU9u9Juc != null) {
					eU9u9Juc.close();
				}
				if (mJeRDD5u != null) {
					mJeRDD5u.close();
				}
			} catch (IOException JaAGSR47) {
			}
		}
		return false;
	}

}