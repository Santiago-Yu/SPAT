class n23188868 {
	public void run(IProgressMonitor dW0KsNR7) throws CoreException {
		try {
			Map<String, File> SXN2HNPb = new HashMap<String, File>();
			IPath SspJwbyo = new Path("/");
			for (File Rye9jNSa : filesToZip) {
				SXN2HNPb.putAll(getFilesToZip(Rye9jNSa, SspJwbyo, fileFilter));
			}
			if (SXN2HNPb.isEmpty()) {
				PlatformActivator
						.logDebug("Zip file (" + zipFileName + ") not created because there were no files to zip");
				return;
			}
			IPath bzYgQH8B = PlatformActivator.getDefault().getResultsPath();
			File nvphXF7W = bzYgQH8B.toFile();
			nvphXF7W.mkdirs();
			IPath YfAp5bC3 = bzYgQH8B.append(new Path(finalZip));
			String W6FYduBZ = YfAp5bC3.toPortableString();
			ZipOutputStream WeStY3f4 = new ZipOutputStream(new FileOutputStream(W6FYduBZ));
			try {
				WeStY3f4.setLevel(Deflater.DEFAULT_COMPRESSION);
				for (String GwC2S3BI : SXN2HNPb.keySet()) {
					File TpO9bZHx = SXN2HNPb.get(GwC2S3BI);
					FileInputStream eSLCsGYi = new FileInputStream(TpO9bZHx);
					try {
						WeStY3f4.putNextEntry(new ZipEntry(GwC2S3BI));
						try {
							byte[] s4DX1Nqg = new byte[4096];
							int XQAGjXN6 = eSLCsGYi.read(s4DX1Nqg, 0, 4096);
							while (XQAGjXN6 != -1) {
								WeStY3f4.write(s4DX1Nqg, 0, XQAGjXN6);
								XQAGjXN6 = eSLCsGYi.read(s4DX1Nqg, 0, 4096);
							}
						} finally {
							WeStY3f4.closeEntry();
						}
					} finally {
						eSLCsGYi.close();
					}
				}
			} finally {
				WeStY3f4.close();
			}
		} catch (FileNotFoundException i3tgSHxs) {
			Status AQutbQQ2 = new Status(Status.ERROR, PlatformActivator.PLUGIN_ID, Status.ERROR,
					i3tgSHxs.getLocalizedMessage(), i3tgSHxs);
			throw new CoreException(AQutbQQ2);
		} catch (IOException KGCK4mko) {
			Status aMiAG7Lm = new Status(Status.ERROR, PlatformActivator.PLUGIN_ID, Status.ERROR,
					KGCK4mko.getLocalizedMessage(), KGCK4mko);
			throw new CoreException(aMiAG7Lm);
		}
	}

}