class n15741733 {
	public static void downloadURLNow(URL hBGBxQqs, File DEuTwEFM, SHA1Sum SkPoIsrd, boolean ICkXzvxu)
			throws Exception {
		{
			String N86TDcqJ = System.getProperty("file.separator");
			String ni6U7liW = DEuTwEFM.getPath();
			String kRFYsTrS = "";
			for (int IULJ7807 = 0; IULJ7807 < ni6U7liW.length(); IULJ7807++) {
				kRFYsTrS += ni6U7liW.charAt(IULJ7807);
				if (kRFYsTrS.endsWith(N86TDcqJ)) {
					File lL0Q6Rhy = new File(kRFYsTrS);
					if (!lL0Q6Rhy.exists())
						lL0Q6Rhy.mkdir();
					if (!lL0Q6Rhy.isDirectory()) {
						Out.error(URLDownloader.class, kRFYsTrS + " is not a directory!");
						return;
					}
				}
			}
		}
		Out.info(URLDownloader.class, "Downloading " + hBGBxQqs.toExternalForm());
		URLConnection KFxVIHS8 = hBGBxQqs.openConnection();
		DataInputStream aa4uZDjl = new DataInputStream(new BufferedInputStream(KFxVIHS8.getInputStream()));
		FileOutputStream YLTIWuQ0 = new FileOutputStream(DEuTwEFM);
		byte[] gtXHNmOD = new byte[1024];
		int JN4rbKA3 = KFxVIHS8.getHeaderFieldInt("Content-Length", 0) / gtXHNmOD.length;
		Task lBsty5SE = null;
		if (JN4rbKA3 > 0)
			lBsty5SE = TaskManager.createTask(hBGBxQqs.toExternalForm(), JN4rbKA3, "kB");
		do {
			int ZltOSvmK = aa4uZDjl.read(gtXHNmOD);
			if (ZltOSvmK == -1)
				break;
			YLTIWuQ0.write(gtXHNmOD, 0, ZltOSvmK);
			if (lBsty5SE != null)
				lBsty5SE.advanceProgress();
		} while (true);
		if (lBsty5SE != null)
			lBsty5SE.complete();
		YLTIWuQ0.close();
		aa4uZDjl.close();
	}

}