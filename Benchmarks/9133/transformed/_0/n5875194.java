class n5875194 {
	@SuppressWarnings("unchecked")
	public static void unzip(String PnSrBATJ, String jBODPOzX, boolean b71v4cD3) throws IOException {
		File Uwg9MNjY = new File(PnSrBATJ);
		File SFgFVR7P = null;
		if (Uwg9MNjY.exists() && Uwg9MNjY.isFile()) {
			String rEBTlijv = jBODPOzX == null ? Uwg9MNjY.getParent() : jBODPOzX;
			String GDAFsIry = Uwg9MNjY.getName();
			GDAFsIry = GDAFsIry.substring(0, GDAFsIry.lastIndexOf("."));
			rEBTlijv = b71v4cD3 ? (rEBTlijv + File.separator + GDAFsIry) : rEBTlijv;
			SFgFVR7P = new File(rEBTlijv);
			if (!SFgFVR7P.exists()) {
				SFgFVR7P.mkdirs();
			}
		} else {
			throw new FileNotFoundException("不存在 zip 文件");
		}
		ZipFile PBiPsNzq = new ZipFile(Uwg9MNjY);
		try {
			Enumeration<ZipArchiveEntry> I3HOdsEB = PBiPsNzq.getEntries();
			ZipArchiveEntry rU9Rnpez = null;
			while (I3HOdsEB.hasMoreElements()) {
				rU9Rnpez = I3HOdsEB.nextElement();
				if (rU9Rnpez.isDirectory()) {
					String BKFP9zso = rU9Rnpez.getName();
					BKFP9zso = BKFP9zso.substring(0, BKFP9zso.length() - 1);
					File FurYJ1pJ = new File(SFgFVR7P.getPath() + File.separator + BKFP9zso);
					FurYJ1pJ.mkdirs();
				} else {
					File KIZGQZ8D = new File(SFgFVR7P.getPath() + File.separator + rU9Rnpez.getName());
					if (!KIZGQZ8D.getParentFile().exists()) {
						KIZGQZ8D.getParentFile().mkdirs();
					}
					KIZGQZ8D.createNewFile();
					InputStream cZzNHdL8 = PBiPsNzq.getInputStream(rU9Rnpez);
					OutputStream Tse4wlwP = new FileOutputStream(KIZGQZ8D);
					IOUtils.copy(cZzNHdL8, Tse4wlwP);
					Tse4wlwP.close();
					cZzNHdL8.close();
				}
			}
		} finally {
			PBiPsNzq.close();
		}
	}

}