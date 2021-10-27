class n4383577 {
	private void getInfoFromXML() {
		final ProgressDialog ldbGe2zy = ProgressDialog.show(this, "", getString(R.string.loading), true, true);
		setProgressBarIndeterminateVisibility(true);
		Thread aBTidc96 = new Thread() {

			public void run() {
				waiting(200);
				try {
					URL X7lDIUb8 = new URL(urlAddress);
					SAXParserFactory QAbYBoVx = SAXParserFactory.newInstance();
					SAXParser TddHOlwo = QAbYBoVx.newSAXParser();
					XMLReader BzEXlPZE = TddHOlwo.getXMLReader();
					XMLHandlerSingleArtist np93r5sw = new XMLHandlerSingleArtist();
					BzEXlPZE.setContentHandler(np93r5sw);
					BzEXlPZE.parse(new InputSource(X7lDIUb8.openStream()));
					artist = np93r5sw.artist;
					emusicURL = np93r5sw.url;
					bio = np93r5sw.bio;
					born = np93r5sw.born;
					death = np93r5sw.death;
					decade = np93r5sw.decade;
					rating = np93r5sw.rating;
					statuscode = np93r5sw.statuscode;
					if (statuscode != 200 && statuscode != 206) {
						throw new Exception();
					}
					handlerSetContent.sendEmptyMessage(0);
				} catch (Exception SiS4ihAI) {
					headerTextView.post(new Runnable() {

						public void run() {
							headerTextView.setText(R.string.couldnt_get_artist_info);
						}
					});
				}
				ldbGe2zy.dismiss();
				handlerDoneLoading.sendEmptyMessage(0);
			}
		};
		aBTidc96.start();
	}

}