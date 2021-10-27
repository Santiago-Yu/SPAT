class n23030047 {
	public static void downloadImage(File yzwGFw7L, String Uvxpw2mq) throws IOException {
		int kikM3clS = 0;
		int cSY6zNP6 = 0;
		InputStream OQgzkvFB = null;
		FileOutputStream KNSfB8qb = null;
		try {
			URL Fkt7z7Az;
			Fkt7z7Az = new URL(Uvxpw2mq);
			HttpURLConnection TbQYqYTU = (HttpURLConnection) Fkt7z7Az.openConnection();
			TbQYqYTU.setDoInput(true);
			TbQYqYTU.setDoOutput(false);
			TbQYqYTU.setUseCaches(false);
			TbQYqYTU.setRequestMethod("GET");
			TbQYqYTU.connect();
			kikM3clS = TbQYqYTU.getContentLength();
			OQgzkvFB = TbQYqYTU.getInputStream();
			KNSfB8qb = new FileOutputStream(yzwGFw7L);
			byte[] cemHhwjx = new byte[DEFAULT_BUFFER_SIZE];
			int xPLlgKA9 = 0;
			int M7blamD3 = 0;
			int JL85uJW2 = 0;
			while (-1 != (xPLlgKA9 = OQgzkvFB.read(cemHhwjx))) {
				KNSfB8qb.write(cemHhwjx, 0, xPLlgKA9);
				cSY6zNP6 += xPLlgKA9;
				M7blamD3 = cSY6zNP6 * 100 / kikM3clS;
				if (JL85uJW2 != M7blamD3) {
					JL85uJW2 = M7blamD3;
					String CUBR08yO = MessageUtils.getMessage(JWallpaperChanger.class, "downloadPercent",
							"" + M7blamD3 + "%");
					Platform.getPlatform().setTrayCaption(CUBR08yO);
				}
			}
			KNSfB8qb.flush();
		} finally {
			Platform.getPlatform().setTrayCaption(null);
			IOUtils.closeQuietly(OQgzkvFB);
			IOUtils.closeQuietly(KNSfB8qb);
		}
	}

}