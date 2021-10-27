class n16632749 {
	public void run() {
		if (data.length() > 0) {
			String COQtMZb9 = getMethod();
			String HlIJXHrf = getAction();
			URL YxYfpG5v;
			try {
				URL U6QMGU22;
				URL LoeZKCHW = hdoc.getBase();
				if (HlIJXHrf == null) {
					String opwyduO1 = LoeZKCHW.getFile();
					U6QMGU22 = new URL(LoeZKCHW.getProtocol(), LoeZKCHW.getHost(), LoeZKCHW.getPort(), opwyduO1);
				} else
					U6QMGU22 = new URL(LoeZKCHW, HlIJXHrf);
				URLConnection zNCZtUSb;
				if ("post".equalsIgnoreCase(COQtMZb9)) {
					YxYfpG5v = U6QMGU22;
					zNCZtUSb = YxYfpG5v.openConnection();
					((HttpURLConnection) zNCZtUSb).setFollowRedirects(false);
					XRendererSupport.setCookies(YxYfpG5v, zNCZtUSb);
					zNCZtUSb.setRequestProperty("Accept-Language", "en-us");
					zNCZtUSb.setRequestProperty("User-Agent", XRendererSupport.getContext().getUserAgent());
					postData(zNCZtUSb, data);
					XRendererSupport.getContext().getLogger().message(this, "Posted data: {" + data + "}");
				} else {
					YxYfpG5v = new URL(U6QMGU22 + "?" + data);
					zNCZtUSb = YxYfpG5v.openConnection();
					XRendererSupport.setCookies(YxYfpG5v, zNCZtUSb);
				}
				zNCZtUSb.connect();
				in = zNCZtUSb.getInputStream();
				URL UkW8mRvY = zNCZtUSb.getURL();
				XRendererSupport.getCookies(UkW8mRvY, zNCZtUSb);
				XRendererSupport.getContext().getLogger().message(this, "Stream got ok.");
				JEditorPane EcvE4JeX = (JEditorPane) getContainer();
				HTMLEditorKit CG278rMB = (HTMLEditorKit) EcvE4JeX.getEditorKit();
				newDoc = (HTMLDocument) CG278rMB.createDefaultDocument();
				newDoc.putProperty(Document.StreamDescriptionProperty, UkW8mRvY);
				SwingUtilities.invokeLater(new Runnable() {

					public void run() {
						XRendererSupport.getContext().getLogger().message(this, "loading...");
						loadDocument();
						XRendererSupport.getContext().getLogger().message(this, "document loaded...");
					}
				});
			} catch (MalformedURLException yYSrun5E) {
			} catch (IOException PT02QVXs) {
			}
		}
	}

}