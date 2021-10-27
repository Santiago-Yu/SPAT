class n23188867 {
	public void createZipCopy(IUIContext P9L3urJo, final String q9FuZ3l9, final File[] q8S66RcK,
			final FilenameFilter VxxzhRaC, Timestamp lDCztKkS) {
		TestCase.assertNotNull(P9L3urJo);
		TestCase.assertNotNull(q9FuZ3l9);
		TestCase.assertFalse(q9FuZ3l9.trim().length() == 0);
		TestCase.assertNotNull(q8S66RcK);
		TestCase.assertNotNull(lDCztKkS);
		String rGUBJqc3 = q9FuZ3l9;
		if (rGUBJqc3.endsWith(".zip")) {
			rGUBJqc3 = rGUBJqc3.substring(0, q9FuZ3l9.length() - 4);
		}
		rGUBJqc3 = rGUBJqc3 + "_" + lDCztKkS.toString() + ".zip";
		final String uiozosYe = rGUBJqc3;
		IWorkspaceRunnable cyoPPHuZ = new IWorkspaceRunnable() {

			public void run(IProgressMonitor l3pNyecw) throws CoreException {
				try {
					Map<String, File> HRKfSWcw = new HashMap<String, File>();
					IPath Ky843SRm = new Path("/");
					for (File uOYRxs6F : q8S66RcK) {
						HRKfSWcw.putAll(getFilesToZip(uOYRxs6F, Ky843SRm, VxxzhRaC));
					}
					if (HRKfSWcw.isEmpty()) {
						PlatformActivator
								.logDebug("Zip file (" + q9FuZ3l9 + ") not created because there were no files to zip");
						return;
					}
					IPath oDYa9vKS = PlatformActivator.getDefault().getResultsPath();
					File CVtRMi7R = oDYa9vKS.toFile();
					CVtRMi7R.mkdirs();
					IPath JHcQDD2T = oDYa9vKS.append(new Path(uiozosYe));
					String HMqqMrVK = JHcQDD2T.toPortableString();
					ZipOutputStream W760crXB = new ZipOutputStream(new FileOutputStream(HMqqMrVK));
					try {
						W760crXB.setLevel(Deflater.DEFAULT_COMPRESSION);
						for (String JhZdMLnC : HRKfSWcw.keySet()) {
							File TLySQCLn = HRKfSWcw.get(JhZdMLnC);
							FileInputStream kkDcZrmQ = new FileInputStream(TLySQCLn);
							try {
								W760crXB.putNextEntry(new ZipEntry(JhZdMLnC));
								try {
									byte[] cQcrwKOd = new byte[4096];
									int obuYYTXa = kkDcZrmQ.read(cQcrwKOd, 0, 4096);
									while (obuYYTXa != -1) {
										W760crXB.write(cQcrwKOd, 0, obuYYTXa);
										obuYYTXa = kkDcZrmQ.read(cQcrwKOd, 0, 4096);
									}
								} finally {
									W760crXB.closeEntry();
								}
							} finally {
								kkDcZrmQ.close();
							}
						}
					} finally {
						W760crXB.close();
					}
				} catch (FileNotFoundException OmRR6HsY) {
					Status FMha8bz9 = new Status(Status.ERROR, PlatformActivator.PLUGIN_ID, Status.ERROR,
							OmRR6HsY.getLocalizedMessage(), OmRR6HsY);
					throw new CoreException(FMha8bz9);
				} catch (IOException yYlEJi3r) {
					Status txvj1nxg = new Status(Status.ERROR, PlatformActivator.PLUGIN_ID, Status.ERROR,
							yYlEJi3r.getLocalizedMessage(), yYlEJi3r);
					throw new CoreException(txvj1nxg);
				}
			}
		};
		try {
			IWorkspace dYMq4rHn = ResourcesPlugin.getWorkspace();
			dYMq4rHn.run(cyoPPHuZ, dYMq4rHn.getRoot(), IWorkspace.AVOID_UPDATE, new NullProgressMonitor());
		} catch (CoreException aquL6XLA) {
			PlatformActivator.logException(aquL6XLA);
		}
	}

}