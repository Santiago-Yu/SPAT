class n12197340 {
	private void initBanner() {
		for (int iPQjp1Or = 0; iPQjp1Or < 3; iPQjp1Or++) {
			if (bannerImg == null) {
				int ihE7Sqfa = getRandomId();
				imageURL = NbBundle.getMessage(BottomContent.class, "URL_BannerImageLink", Integer.toString(ihE7Sqfa));
				bannerURL = NbBundle.getMessage(BottomContent.class, "URL_BannerLink", Integer.toString(ihE7Sqfa));
				HttpContext sqJGjgsI = new BasicHttpContext();
				sqJGjgsI.setAttribute(ClientContext.COOKIE_STORE, cookieStore);
				HttpGet JtauNNjr = new HttpGet(imageURL);
				try {
					HttpResponse SKhZgHAR = ProxyManager.httpClient.execute(JtauNNjr, sqJGjgsI);
					HttpEntity ZSXLbxnV = SKhZgHAR.getEntity();
					if (ZSXLbxnV != null) {
						bannerImg = new ImageIcon(ImageIO.read(ZSXLbxnV.getContent()));
						EntityUtils.consume(ZSXLbxnV);
					}
				} catch (IOException Q0p0ZszL) {
					bannerImg = null;
				} finally {
					JtauNNjr.abort();
				}
			} else {
				break;
			}
		}
		if (bannerImg == null) {
			NotifyUtil.error("Banner Error",
					"Application could not get banner image. Please check your internet connection.", false);
		}
	}

}