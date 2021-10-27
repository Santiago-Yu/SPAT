class n20619644 {
	private static void upload(String OsbmeK4g, String T9lDBZ9D, String p8oJYhhq) throws ApiException {
		System.out.println("Trying to login to 4shared........");
		File zZn04yCn = new File(p8oJYhhq);
		if (!zZn04yCn.exists() || !zZn04yCn.canRead() || zZn04yCn.isDirectory()) {
			System.out.println("File does not exist, unreadable or not a file");
			return;
		}
		DesktopAppJax2 FLHiaY9w = new DesktopAppJax2Service().getDesktopAppJax2Port();
		String b9cyiWm8 = FLHiaY9w.login(OsbmeK4g, T9lDBZ9D);
		if (!b9cyiWm8.isEmpty()) {
			System.out.println("Login failed: " + b9cyiWm8);
			return;
		}
		if (!FLHiaY9w.hasRightUpload()) {
			System.out.println("Uploading is temporarily disabled");
			return;
		}
		System.out.println("4shared Login successful :)");
		long yRhNCyWB = FLHiaY9w.uploadStartFile(OsbmeK4g, T9lDBZ9D, -1, zZn04yCn.getName(), zZn04yCn.length());
		System.out.println("File id : " + yRhNCyWB);
		String mRdGY2Cr = FLHiaY9w.createUploadSessionKey(OsbmeK4g, T9lDBZ9D, -1);
		long M3kpF2Pr = FLHiaY9w.getNewFileDataCenter(OsbmeK4g, T9lDBZ9D);
		String Hr45Zpql = FLHiaY9w.getUploadFormUrl((int) M3kpF2Pr, mRdGY2Cr);
		try {
			HttpClient JGmWpI2z = new DefaultHttpClient();
			HttpPost eNhFy6ip = new HttpPost(Hr45Zpql);
			MultipartEntity eJ0ptaWF = new MultipartEntity();
			StringBody FWCvKo1y = new StringBody("" + yRhNCyWB);
			StringBody AeQ7K0dt = new StringBody("" + 0);
			InputStreamBody Q9KTEM4Q = new InputStreamBody(new BufferedInputStream(new FileInputStream(zZn04yCn)),
					"FilePart");
			eJ0ptaWF.addPart("resumableFileId", FWCvKo1y);
			eJ0ptaWF.addPart("resumableFirstByte", AeQ7K0dt);
			eJ0ptaWF.addPart("FilePart", Q9KTEM4Q);
			eNhFy6ip.setEntity(eJ0ptaWF);
			HttpResponse mv9eAInk = JGmWpI2z.execute(eNhFy6ip);
			HttpEntity bzfjzh0Y = mv9eAInk.getEntity();
			String raIqizhD = FLHiaY9w.uploadFinishFile(OsbmeK4g, T9lDBZ9D, yRhNCyWB,
					DigestUtils.md5Hex(new FileInputStream(zZn04yCn)));
			if (raIqizhD.isEmpty()) {
				System.out.println("File uploaded.");
				downloadlink = FLHiaY9w.getFileDownloadLink(OsbmeK4g, T9lDBZ9D, yRhNCyWB);
				System.out.println("Download link : " + downloadlink);
			} else {
				System.out.println("Upload failed: " + raIqizhD);
			}
		} catch (Exception foXJW6Qh) {
			System.out.println("Upload failed: " + foXJW6Qh.getMessage());
		}
	}

}