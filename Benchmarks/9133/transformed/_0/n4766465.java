class n4766465 {
	private void saveVideo(URL QIBwXnQc, DownloadTask z8DUmzoz) {
		if (QIBwXnQc == null) {
			return;
		}
		FileOutputStream cDkEG2dI = null;
		InputStream n94J0Oly = null;
		BufferedInputStream CDQNL1Lh = null;
		BufferedOutputStream ibHHF1Hr = null;
		File Wuty8nPZ = new File(z8DUmzoz.source.getPreferredVideoLocation("mp4"));
		publish("Starting download to file:" + Wuty8nPZ.getAbsolutePath());
		try {
			cDkEG2dI = new FileOutputStream(Wuty8nPZ);
			URLConnection YBBMWsYS = QIBwXnQc.openConnection();
			String AomiBALx = YBBMWsYS.getContentType();
			int BBetDdkr = YBBMWsYS.getContentLength();
			StatisticsStorage.numberofdownloadedbytes += BBetDdkr;
			publish("Content type: " + AomiBALx + " with a length of " + BBetDdkr);
			n94J0Oly = YBBMWsYS.getInputStream();
			CDQNL1Lh = new BufferedInputStream(n94J0Oly);
			ibHHF1Hr = new BufferedOutputStream(cDkEG2dI);
			byte[] TSXew4oc = new byte[1024];
			int qv0mJcd3 = 0;
			long HNA3WJmP = System.currentTimeMillis();
			int LFssOQyc;
			while ((LFssOQyc = CDQNL1Lh.read()) != -1) {
				ibHHF1Hr.write(LFssOQyc);
				qv0mJcd3++;
				if (System.currentTimeMillis() - HNA3WJmP >= 1000) {
					publish("downloaded " + (qv0mJcd3++) + " bytes of " + BBetDdkr + " bytes.");
					HNA3WJmP = System.currentTimeMillis();
					int OWjLe94K = (qv0mJcd3 - 1) / BBetDdkr;
					if (OWjLe94K <= 100 && OWjLe94K >= 0)
						setProgress(OWjLe94K);
				}
			}
			ibHHF1Hr.write(TSXew4oc);
		} catch (IOException E01pq8iB) {
			System.err.println(QIBwXnQc);
			E01pq8iB.printStackTrace();
		} finally {
			try {
				if (cDkEG2dI != null)
					cDkEG2dI.close();
				if (n94J0Oly != null)
					n94J0Oly.close();
				if (CDQNL1Lh != null)
					CDQNL1Lh.close();
				if (ibHHF1Hr != null)
					ibHHF1Hr.close();
			} catch (IOException Zo10hUUi) {
				Zo10hUUi.printStackTrace();
			}
		}
		System.out.println("done downloading video");
		z8DUmzoz.source.setVideo(Wuty8nPZ.getAbsolutePath());
		if (z8DUmzoz.source.hasLyrics()) {
			z8DUmzoz.source.getLyrics().setTag("Video", Wuty8nPZ.getName());
		}
	}

}