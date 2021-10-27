class n17340376 {
	private static String fetchImageViaHttp(URL o1UdyaEG) throws IOException {
		String mSQREj5u = o1UdyaEG.toString();
		String KCFPvR0K = o1UdyaEG.getPath();
		HttpURLConnection gPBOFPf1 = (HttpURLConnection) o1UdyaEG.openConnection();
		String qorvboXU = null;
		try {
			gPBOFPf1.setAllowUserInteraction(false);
			gPBOFPf1.setDoOutput(true);
			gPBOFPf1.addRequestProperty("Cache-Control", "no-cache");
			RequestContext HLF3kAVV = RequestContext.get();
			if (HLF3kAVV != null)
				gPBOFPf1.addRequestProperty("User-Agent", HLF3kAVV.header("user-agent"));
			else
				gPBOFPf1.addRequestProperty("User-Agent", user_agent);
			gPBOFPf1.addRequestProperty("Referer",
					mSQREj5u.substring(0, mSQREj5u.indexOf('/', mSQREj5u.indexOf('.')) + 1));
			gPBOFPf1.connect();
			if (gPBOFPf1.getResponseCode() != HttpURLConnection.HTTP_OK)
				return null;
			InputStream UllLQl6X = gPBOFPf1.getInputStream();
			String WjxBHM0m = FilenameUtils.getExtension(KCFPvR0K).toLowerCase();
			if (!Multimedia.isImageFile("aa." + WjxBHM0m))
				WjxBHM0m = "jpg";
			qorvboXU = FMT_FN.format(new Date()) + RandomStringUtils.randomAlphanumeric(4) + '.' + WjxBHM0m;
			File wy7PKknM = new File(img_path + qorvboXU);
			if (!wy7PKknM.getParentFile().exists())
				wy7PKknM.getParentFile().mkdirs();
			FileOutputStream DKcdKxJS = new FileOutputStream(wy7PKknM);
			try {
				IOUtils.copy(UllLQl6X, DKcdKxJS);
			} finally {
				IOUtils.closeQuietly(UllLQl6X);
				IOUtils.closeQuietly(DKcdKxJS);
			}
		} finally {
			gPBOFPf1.disconnect();
		}
		return RequestContext.get().contextPath() + "/uploads/img/" + qorvboXU;
	}

}