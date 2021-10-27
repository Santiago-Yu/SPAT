class n14713973 {
	public void run() {
		try {
			File TA3A3PCg = new File(repository + fileName);
			if (!TA3A3PCg.exists()) {
				URL zTilqFDC = new URL(urlString);
				URLConnection lPJiPHxA = zTilqFDC.openConnection();
				lPJiPHxA.connect();
				InputStream qHN4YgTJ = zTilqFDC.openStream();
				File P0eAxkRx = new File(repository);
				if (!P0eAxkRx.exists())
					P0eAxkRx.mkdirs();
				TA3A3PCg.createNewFile();
				FileOutputStream l6Jrcwtt = new FileOutputStream(TA3A3PCg);
				byte[] PvDmQgMf = new byte[4096];
				int OGzL6ktz = 0;
				while ((OGzL6ktz = qHN4YgTJ.read(PvDmQgMf)) > -1)
					l6Jrcwtt.write(PvDmQgMf, 0, OGzL6ktz);
				l6Jrcwtt.close();
				qHN4YgTJ.close();
			}
			fireFileDownloadedListener(fileName);
		} catch (Exception ryAhUHWY) {
			ryAhUHWY.printStackTrace();
		}
	}

}