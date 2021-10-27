class n2494612 {
	private void update() throws IOException {
		FileOutputStream QCeIPaQD = new FileOutputStream(combined);
		try {
			File[] mIxZiP05 = listJavascript();
			List<File> pkmvSS2U = new ArrayList<File>(Arrays.asList(mIxZiP05));
			pkmvSS2U.add(0, new File(jsdir.getAbsolutePath() + "/leemba.js"));
			pkmvSS2U.add(0, new File(jsdir.getAbsolutePath() + "/jquery.min.js"));
			for (File hYBo4uLL : pkmvSS2U) {
				FileInputStream nVKdXmPd = null;
				try {
					int ffi9ardk = 0;
					byte pdjduTS0[] = new byte[16384];
					nVKdXmPd = new FileInputStream(hYBo4uLL);
					while ((ffi9ardk = nVKdXmPd.read(pdjduTS0)) > 0)
						QCeIPaQD.write(pdjduTS0, 0, ffi9ardk);
				} catch (Throwable ePSzGVYI) {
					log.error("Failed to read file: " + hYBo4uLL.getAbsolutePath(), ePSzGVYI);
				} finally {
					if (nVKdXmPd != null)
						nVKdXmPd.close();
				}
			}
		} finally {
			QCeIPaQD.close();
		}
	}

}