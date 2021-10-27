class n5135689 {
	private boolean saveNodeData(NodeInfo ETLG6dR7) {
		boolean cjSfxGDC = false;
		String dT02Ss9m = mServer + "save.php" + ("?id=" + ETLG6dR7.getId());
		try {
			URL nkQRmOpc = new URL(dT02Ss9m);
			HttpURLConnection SsuUQx2S = (HttpURLConnection) nkQRmOpc.openConnection();
			String Rn3okNW2 = ETLG6dR7.getMIMEType().toString();
			byte[] aEhZWmOG = ETLG6dR7.getData();
			SsuUQx2S.setAllowUserInteraction(false);
			SsuUQx2S.setRequestMethod("PUT");
			if (Rn3okNW2.equals("")) {
				Rn3okNW2 = "application/octet-stream";
			}
			System.out.println("contentType: " + Rn3okNW2);
			SsuUQx2S.setRequestProperty("Content-Type", Rn3okNW2);
			setCredentials(SsuUQx2S);
			SsuUQx2S.setDoOutput(true);
			SsuUQx2S.getOutputStream().write(aEhZWmOG);
			cjSfxGDC = saveNode(ETLG6dR7, SsuUQx2S);
		} catch (Exception bxElLaNA) {
			System.out.println("Exception: " + bxElLaNA.toString());
		}
		return cjSfxGDC;
	}

}