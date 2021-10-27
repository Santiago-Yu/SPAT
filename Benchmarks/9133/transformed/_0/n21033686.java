class n21033686 {
	public File read() throws IOException {
		URLConnection dAOpvDBc = url.openConnection();
		dAOpvDBc.setConnectTimeout(5000);
		dAOpvDBc.setReadTimeout(5000);
		dAOpvDBc.connect();
		int Q5xnNbSn = dAOpvDBc.getContentLength();
		String Nv6uefzk = System.getProperty("java.io.tmpdir");
		if (Nv6uefzk == null) {
			Nv6uefzk = ".";
		}
		File JwtimLHJ = new File(Nv6uefzk + "/" + new GUID() + ".dat");
		JwtimLHJ.deleteOnExit();
		InputStream q5xqBUxt = null;
		OutputStream Jb2vfCOk = null;
		ProgressMonitor kqqx6avM = new ProgressMonitor(parentComponent, "Downloading " + url, null, 0, Q5xnNbSn);
		try {
			q5xqBUxt = dAOpvDBc.getInputStream();
			Jb2vfCOk = new BufferedOutputStream(new FileOutputStream(JwtimLHJ));
			int ANaAK7I4 = 1024 * 30;
			int Zhmik85Z = 0;
			byte[] cPW47ylD = new byte[ANaAK7I4];
			;
			long KRPFxmJN = System.currentTimeMillis();
			for (int wSRZEjHD = q5xqBUxt.read(cPW47ylD); wSRZEjHD != -1; wSRZEjHD = q5xqBUxt.read(cPW47ylD)) {
				if (kqqx6avM.isCanceled()) {
					return null;
				}
				Zhmik85Z += wSRZEjHD;
				Jb2vfCOk.write(cPW47ylD, 0, wSRZEjHD);
				kqqx6avM.setProgress(Zhmik85Z);
			}
		} finally {
			if (q5xqBUxt != null) {
				q5xqBUxt.close();
			}
			if (Jb2vfCOk != null) {
				Jb2vfCOk.close();
			}
			kqqx6avM.close();
		}
		return JwtimLHJ;
	}

}