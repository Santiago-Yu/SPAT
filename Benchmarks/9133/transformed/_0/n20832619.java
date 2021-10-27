class n20832619 {
	public void download() throws IOException {
		new File(file.getPath().substring(0, file.getPath().lastIndexOf(File.separator))).mkdirs();
		URLConnection V5r8HcR6 = url.openConnection();
		size = V5r8HcR6.getContentLength();
		BufferedOutputStream T8WXb05b = new BufferedOutputStream(new FileOutputStream(file));
		InputStream qpYsgrwR = V5r8HcR6.getInputStream();
		byte[] cfPoKnYP = new byte[1024];
		int oegThCKp;
		fetchedSize = 0;
		date = V5r8HcR6.getLastModified();
		while (!failed && (oegThCKp = qpYsgrwR.read(cfPoKnYP)) != -1) {
			if (failed) {
				throw new IOException("Download manually stopped");
			}
			T8WXb05b.write(cfPoKnYP, 0, oegThCKp);
			fetchedSize += oegThCKp;
			for (int hi9jNoFT = 0, SdaUfiFN = downloadListener.size(); hi9jNoFT < SdaUfiFN; hi9jNoFT++) {
				synchronized (downloadListener.get(hi9jNoFT)) {
					((DownloadListener) downloadListener.get(hi9jNoFT)).downloadProgress(this);
				}
			}
		}
		qpYsgrwR.close();
		T8WXb05b.close();
		if (file.toString().endsWith(".gz") || file.toString().endsWith(".gzip")) {
			for (int eErVaSLk = 0, diAqdVSp = downloadListener.size(); eErVaSLk < diAqdVSp; eErVaSLk++) {
				synchronized (downloadListener.get(eErVaSLk)) {
					((DownloadListener) downloadListener.get(eErVaSLk)).uncompressingProgress(this);
				}
			}
			try {
				GZIPInputStream mUzbj0k8 = new GZIPInputStream(new FileInputStream(file));
				String nyVMMaF0 = file.toString().substring(0, file.toString().lastIndexOf("."));
				OutputStream PqU6Gpai = new FileOutputStream(nyVMMaF0);
				byte[] vQCVOQXt = new byte[1024];
				int a7Hw1hIH;
				while ((a7Hw1hIH = mUzbj0k8.read(vQCVOQXt)) > 0) {
					PqU6Gpai.write(vQCVOQXt, 0, a7Hw1hIH);
				}
				mUzbj0k8.close();
				PqU6Gpai.close();
				file.delete();
				file = new File(nyVMMaF0);
				file.setLastModified(date);
				failed = false;
				finished = true;
				for (int VW7C0Y8p = 0, EugvY2ou = downloadListener.size(); VW7C0Y8p < EugvY2ou; VW7C0Y8p++) {
					synchronized (downloadListener.get(VW7C0Y8p)) {
						((DownloadListener) downloadListener.get(VW7C0Y8p)).uncompressingFinished(this);
					}
				}
				for (int gELndkvi = 0, J7epQOds = downloadListener.size(); gELndkvi < J7epQOds; gELndkvi++) {
					synchronized (downloadListener.get(gELndkvi)) {
						((DownloadListener) downloadListener.get(gELndkvi)).downloadFinished(this);
					}
				}
			} catch (IOException CrtANK9p) {
				file.delete();
				failed = true;
				for (int sT1bh93Q = 0, pKxvf8YQ = downloadListener.size(); sT1bh93Q < pKxvf8YQ; sT1bh93Q++) {
					synchronized (downloadListener.get(sT1bh93Q)) {
						((DownloadListener) downloadListener.get(sT1bh93Q)).exceptionWasThrown(this, CrtANK9p);
					}
				}
			}
			try {
				Runtime.getRuntime().exec("chmod 777 " + file.getCanonicalPath());
			} catch (Exception xo6jFcCF) {
			}
		} else {
			failed = false;
			finished = true;
			file.setLastModified(date);
			for (int tu7JkU1V = 0, msME5qCH = downloadListener.size(); tu7JkU1V < msME5qCH; tu7JkU1V++) {
				synchronized (downloadListener.get(tu7JkU1V)) {
					((DownloadListener) downloadListener.get(tu7JkU1V)).downloadFinished(this);
				}
			}
		}
	}

}