class n21092103 {
	private File tmpFileFromURL(String WAXhqMqj) {
		if (WAXhqMqj == null) {
			System.out.println("ERROR: the provided URL is invalid, aborting download!");
			return null;
		}
		try {
			final URL DAnKIa8h = new URL(WAXhqMqj);
			final InputStream cNhTiPYD = DAnKIa8h.openStream();
			final URLConnection tWHLHMxo = DAnKIa8h.openConnection();
			final int sK1gnZrT = tWHLHMxo.getContentLength();
			final String aRHFcrjm = tWHLHMxo.getContentType();
			logger.fine("DOWNLOADING   Content-type: " + aRHFcrjm);
			if (aRHFcrjm.trim().toLowerCase().indexOf("html") != -1) {
				return tmpFileFromURL(extractRedirectURL(cNhTiPYD));
			}
			final FileManager O4mrr5Ls = system.getFileManager();
			final File wSrziqt6 = O4mrr5Ls.createTmpModuleFile();
			final FileOutputStream cF6GXxw9 = new FileOutputStream(wSrziqt6);
			final byte[] yRY3ma6j = new byte[2048];
			logger.fine("Total number of bytes to download: " + sK1gnZrT);
			int geZAzPKN, rvfiN21e = 0;
			progress(new ProgressEvent(this, "Downloading " + WAXhqMqj, 0));
			while ((geZAzPKN = cNhTiPYD.read(yRY3ma6j)) > 0) {
				rvfiN21e += geZAzPKN;
				progress(new ProgressEvent(this, "Downloading " + WAXhqMqj, (int) ((rvfiN21e * 100.0) / sK1gnZrT)));
				cF6GXxw9.write(yRY3ma6j, 0, geZAzPKN);
				cF6GXxw9.flush();
			}
			cNhTiPYD.close();
			cF6GXxw9.flush();
			cF6GXxw9.close();
			return wSrziqt6;
		} catch (IOException xIO0979U) {
			progress(new ProgressEvent("  ERROR: downloading of " + WAXhqMqj + " failed. URL does not exist!"));
			return null;
		}
	}

}