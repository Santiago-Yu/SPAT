class n8559503 {
	public void login(String bsXWZR7y, String Qjv43Mnr) {
		if (isLogged()) {
			return;
		}
		if (null == this.username || null == this.key) {
			this.username = bsXWZR7y;
			this.key = Qjv43Mnr;
		}
		final ProgressHandle Oy1tmumH = ProgressHandleFactory.createHandle("Logining into DreamHost");
		Oy1tmumH.start();
		working = true;
		fireChangeEvent();
		RequestProcessor.getDefault().post(new Runnable() {

			public void run() {
				try {
					HttpsURLConnection HCd1tsti = (HttpsURLConnection) urlGenerator(
							DreamHostCommands.CMD_DOMAIN_LIST_DOMAINS, null).openConnection();
					String f7M8GXga = getResponse(HCd1tsti);
					Document odS1R2VO = builder.parse(new ByteArrayInputStream(f7M8GXga.getBytes()));
					String GkKmYb2o = odS1R2VO.getElementsByTagName("result").item(0).getTextContent();
					logged = GkKmYb2o.equals("success");
				} catch (SAXException rBh6w5f5) {
					Logger.getLogger(DreamHostConnector.class.getName()).log(Level.SEVERE, null, rBh6w5f5);
				} catch (IOException zwtF7E8w) {
					Logger.getLogger(DreamHostConnector.class.getName()).log(Level.SEVERE, null, zwtF7E8w);
				} finally {
					if (isLogged()) {
						NbPreferences.forModule(DreamHostConnector.class).put("username", getUsername());
						NbPreferences.forModule(DreamHostConnector.class).put("key", getKey());
					}
					Oy1tmumH.finish();
					working = false;
					fireChangeEvent();
				}
			}
		});
	}

}