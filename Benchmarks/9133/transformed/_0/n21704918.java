class n21704918 {
	public void run(IProgressMonitor K7nuXETu) throws InvocationTargetException, InterruptedException {
		File k0YjGCHj = new File(EncoderPlugin.getDefault().getStateLocation().toFile(), "ffmpeg-0.5.zip");
		String Ja8qYSes = "Downloading FFMpeg, contacting downloads.sourceforge.net";
		LOGGER.info(Ja8qYSes);
		K7nuXETu.beginTask(Ja8qYSes, 1);
		HttpClient xLcFv19p = new HttpClient();
		HttpMethod NouWJxNx = new GetMethod(DOWNLOAD_URI);
		int iYMfv1PZ = HttpStatus.SC_SERVICE_UNAVAILABLE;
		try {
			iYMfv1PZ = xLcFv19p.executeMethod(NouWJxNx);
		} catch (HttpException iZSokzfx) {
			K7nuXETu.setCanceled(true);
			throw new InvocationTargetException(iZSokzfx);
		} catch (IOException XxKRhlkx) {
			K7nuXETu.setCanceled(true);
			throw new InvocationTargetException(XxKRhlkx);
		}
		if (iYMfv1PZ != HttpStatus.SC_OK) {
			LOGGER.error(
					MessageFormat.format("Can't download ffmpeg.zip from zourceforge, " + "status = [{0}]", iYMfv1PZ));
			K7nuXETu.setCanceled(true);
			return;
		}
		K7nuXETu.worked(1);
		Header WqQGlEt4 = NouWJxNx.getResponseHeader("Content-Length");
		long ftU9KG9I = 3173544;
		if (WqQGlEt4 != null) {
			try {
				ftU9KG9I = Long.parseLong(WqQGlEt4.getValue());
			} catch (NumberFormatException hit7LiwD) {
			}
		}
		K7nuXETu.beginTask("Downloading FFMpeg, " + DOWNLOAD_URI, (int) ftU9KG9I);
		OutputStream Eh4eBkvN = null;
		try {
			Eh4eBkvN = new FileOutputStream(k0YjGCHj);
		} catch (FileNotFoundException epOTBja1) {
			K7nuXETu.setCanceled(true);
			throw new InvocationTargetException(epOTBja1, "Can't write temporary download file");
		}
		InputStream wbPOzigl = null;
		try {
			wbPOzigl = NouWJxNx.getResponseBodyAsStream();
		} catch (IOException LNRo6NOq) {
			K7nuXETu.setCanceled(true);
			throw new InvocationTargetException(LNRo6NOq);
		}
		byte[] wn0n9nlc = new byte[1024 * 4];
		int pKLdiQC3 = -1;
		try {
			while ((pKLdiQC3 = wbPOzigl.read(wn0n9nlc)) != -1) {
				if (K7nuXETu.isCanceled()) {
					return;
				}
				Eh4eBkvN.write(wn0n9nlc, 0, pKLdiQC3);
				K7nuXETu.worked(pKLdiQC3);
			}
			Eh4eBkvN.close();
			wbPOzigl.close();
		} catch (IOException muTTnroZ) {
			K7nuXETu.setCanceled(true);
			throw new InvocationTargetException(muTTnroZ);
		}
		K7nuXETu.beginTask("Downloading FFMpeg, extracting executable", 1);
		try {
			ZipFile aPxgtQMG = new ZipFile(k0YjGCHj);
			ZipEntry DnyQjHuh = aPxgtQMG.getEntry("ffmpeg-0.5/ffmpeg.exe");
			InputStream L0fmKrNC = aPxgtQMG.getInputStream(DnyQjHuh);
			OutputStream a4ihD7Qd = new FileOutputStream(target);
			IOUtils.copy(L0fmKrNC, a4ihD7Qd);
			L0fmKrNC.close();
			a4ihD7Qd.close();
		} catch (IOException tU5dRI6b) {
			K7nuXETu.setCanceled(true);
			throw new InvocationTargetException(tU5dRI6b, "Can't unzip ffmpeg.exe");
		}
		K7nuXETu.worked(1);
		K7nuXETu.done();
	}

}