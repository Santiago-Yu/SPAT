class n1457394 {
	private File download(String TIRR5ohg, URL Ce0ZM0DK) {
		int xdZtFE0F = -1;
		int L0MtGY4S = 0;
		try {
			fireDownloadStarted(TIRR5ohg);
			File onwmNsyU = createFile(TIRR5ohg);
			BufferedOutputStream mBSehcaE = new BufferedOutputStream(new FileOutputStream(onwmNsyU));
			System.out.println("?????????" + TIRR5ohg + ", url=" + Ce0ZM0DK);
			InputStream jI7SOvBq = Ce0ZM0DK.openStream();
			byte[] Rk6zCeW5 = new byte[1024];
			int TxCAKOUF = 0;
			long jJVxE3tN = 0;
			xdZtFE0F = jI7SOvBq.available();
			while ((TxCAKOUF = jI7SOvBq.read(Rk6zCeW5)) != -1) {
				mBSehcaE.write(Rk6zCeW5, 0, TxCAKOUF);
				L0MtGY4S += TxCAKOUF;
				long wpwRpZkQ = System.currentTimeMillis();
				if (wpwRpZkQ - jJVxE3tN > 500) {
					fireDownloadUpdate(TIRR5ohg, xdZtFE0F, L0MtGY4S);
					jJVxE3tN = wpwRpZkQ;
				}
			}
			mBSehcaE.close();
			System.out.println("???????????" + TIRR5ohg);
			fireDownloadCompleted(TIRR5ohg);
			return onwmNsyU;
		} catch (IOException pP1hHEIR) {
			System.out.println("???????????" + TIRR5ohg + ", error=" + pP1hHEIR.getMessage());
			fireDownloadInterrupted(TIRR5ohg);
			if (!(pP1hHEIR instanceof FileNotFoundException)) {
				pP1hHEIR.printStackTrace();
			}
		}
		return null;
	}

}