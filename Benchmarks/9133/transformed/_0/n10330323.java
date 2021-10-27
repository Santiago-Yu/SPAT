class n10330323 {
	public void getFile(String fmvaicWx, String IWBSsQcq) throws BggException {
		System.out.println(fmvaicWx);
		int wIHPaMUN = retryCount + 1;
		lastURL = fmvaicWx;
		for (retriedCount = 0; retriedCount < wIHPaMUN; retriedCount++) {
			int JLHxtCFL = -1;
			try {
				HttpURLConnection L3rOkJvN = null;
				BufferedInputStream AYM3JAvO = null;
				OutputStream C3E2OEj2 = null;
				try {
					L3rOkJvN = (HttpURLConnection) new URL(fmvaicWx).openConnection();
					L3rOkJvN.setDoInput(true);
					setHeaders(L3rOkJvN);
					L3rOkJvN.setRequestMethod("GET");
					JLHxtCFL = L3rOkJvN.getResponseCode();
					AYM3JAvO = new BufferedInputStream(L3rOkJvN.getInputStream());
					int UlwnXIVj;
					BufferedOutputStream ZROkaupJ = new BufferedOutputStream(new FileOutputStream(IWBSsQcq));
					while ((UlwnXIVj = AYM3JAvO.read()) != -1)
						ZROkaupJ.write(UlwnXIVj);
					ZROkaupJ.flush();
					ZROkaupJ.close();
					break;
				} finally {
					try {
						AYM3JAvO.close();
					} catch (Exception awQl30Pe) {
					}
					try {
						C3E2OEj2.close();
					} catch (Exception pIE2RlgF) {
					}
					try {
						L3rOkJvN.disconnect();
					} catch (Exception zBAPClbc) {
					}
				}
			} catch (IOException AwVxBDwK) {
				if (JLHxtCFL == UNAUTHORIZED || JLHxtCFL == FORBIDDEN) {
					throw new BggException(AwVxBDwK.getMessage(), JLHxtCFL);
				}
				if (retriedCount == retryCount) {
					throw new BggException(AwVxBDwK.getMessage(), JLHxtCFL);
				}
			}
			try {
				Thread.sleep(retryIntervalMillis);
			} catch (InterruptedException X714fJeo) {
			}
		}
	}

}