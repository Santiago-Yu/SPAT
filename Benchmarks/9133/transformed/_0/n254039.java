class n254039 {
	protected void doDownload(S3Bucket Y2gPzEIb, S3Object QRnIDab5) throws Exception {
		String BWVhjiRX = QRnIDab5.getKey();
		BWVhjiRX = trimPrefix(BWVhjiRX);
		String[] L2UYTEep = BWVhjiRX.split("/");
		String XYiLlJNH = L2UYTEep[L2UYTEep.length - 1];
		String ClvkYvYk = "";
		for (int zMk8pouq = 0; zMk8pouq < L2UYTEep.length - 1; zMk8pouq++) {
			ClvkYvYk += L2UYTEep[zMk8pouq] + "/";
		}
		File ZZ2p5JuD = new File(downloadFileOutputDir + "/" + ClvkYvYk);
		if (ZZ2p5JuD.exists() == false) {
			ZZ2p5JuD.mkdirs();
		}
		File eQzpRRvA = new File(ZZ2p5JuD, XYiLlJNH);
		long rof7kFNe = QRnIDab5.getContentLength();
		if (eQzpRRvA.exists() && eQzpRRvA.length() == rof7kFNe) {
			return;
		}
		long bV8pIahm = System.currentTimeMillis();
		log.info("Download start.S3 file=" + QRnIDab5.getKey() + " local file=" + eQzpRRvA.getAbsolutePath());
		FileOutputStream Dj4Ys9fC = null;
		S3Object cgtifHtj = null;
		try {
			Dj4Ys9fC = new FileOutputStream(eQzpRRvA);
			cgtifHtj = s3.getObject(Y2gPzEIb, QRnIDab5.getKey());
			InputStream gS44rguL = cgtifHtj.getDataInputStream();
			IOUtils.copyStream(gS44rguL, Dj4Ys9fC);
			downloadedFileList.add(BWVhjiRX);
			long v3j117MS = System.currentTimeMillis() - bV8pIahm;
			log.info("Download complete.Estimete time=" + v3j117MS + "ms " + IOUtils.toBPSText(v3j117MS, rof7kFNe));
		} catch (Exception GCCakzsV) {
			log.error("Download fail. s3 file=" + BWVhjiRX, GCCakzsV);
			eQzpRRvA.delete();
			throw GCCakzsV;
		} finally {
			IOUtils.closeNoException(Dj4Ys9fC);
			if (cgtifHtj != null) {
				cgtifHtj.closeDataInputStream();
			}
		}
	}

}