class n13086935 {
	private void getInfoFromXML() {
		final ProgressDialog HpMgBki7 = ProgressDialog.show(this, "", getString(R.string.loading), true, true);
		setProgressBarIndeterminateVisibility(true);
		Thread yx4U61mm = new Thread() {

			public void run() {
				waiting(200);
				txtinfo.post(new Runnable() {

					public void run() {
						txtinfo.setText("Searching");
					}
				});
				try {
					URL vhoupuCG = new URL(urlAddress);
					SAXParserFactory ulnwItRb = SAXParserFactory.newInstance();
					SAXParser YE2r8PTs = ulnwItRb.newSAXParser();
					XMLReader Kn62s7tw = YE2r8PTs.getXMLReader();
					XMLHandlerReviews eYSXoxXo = new XMLHandlerReviews();
					Kn62s7tw.setContentHandler(eYSXoxXo);
					Kn62s7tw.parse(new InputSource(vhoupuCG.openStream()));
					if (statuscode != 200 && statuscode != 206) {
						throw new Exception();
					}
					nReviewsOnPage = eYSXoxXo.nItems;
					statuscode = eYSXoxXo.statuscode;
					if (nReviewsOnPage > 0) {
						authors = new String[nReviewsOnPage];
						reviews = new String[nReviewsOnPage];
						ratings = new String[nReviewsOnPage];
						titles = new String[nReviewsOnPage];
						listtext = new String[nReviewsOnPage];
						for (int tHIzqiXk = 0; tHIzqiXk < nReviewsOnPage; tHIzqiXk++) {
							reviews[tHIzqiXk] = eYSXoxXo.reviews[tHIzqiXk];
							authors[tHIzqiXk] = eYSXoxXo.authors[tHIzqiXk];
							titles[tHIzqiXk] = eYSXoxXo.titles[tHIzqiXk];
							ratings[tHIzqiXk] = eYSXoxXo.ratings[tHIzqiXk];
							if (authors[tHIzqiXk] == null || authors[tHIzqiXk] == "") {
								authors[tHIzqiXk] = "Anonymous";
							}
							if (ratings[tHIzqiXk] == null || ratings[tHIzqiXk] == "") {
								listtext[tHIzqiXk] = titles[tHIzqiXk] + " - " + reviews[tHIzqiXk] + " - "
										+ authors[tHIzqiXk];
							} else {
								listtext[tHIzqiXk] = "Score: " + ratings[tHIzqiXk] + " - " + titles[tHIzqiXk] + " - "
										+ reviews[tHIzqiXk] + " - " + authors[tHIzqiXk];
							}
						}
						nTotalReviews = eYSXoxXo.nTotalItems;
						final int OKuR4EPK = iFirstReviewOnPage;
						final int Pxo6RSHW = iFirstReviewOnPage + nReviewsOnPage - 1;
						final int fkScdf1O = nTotalReviews;
						if (nTotalReviews > Pxo6RSHW) {
							nextButton.post(new Runnable() {

								public void run() {
									nextButton.setVisibility(0);
								}
							});
						} else {
							nextButton.post(new Runnable() {

								public void run() {
									nextButton.setVisibility(8);
								}
							});
						}
						if (iFirstReviewOnPage > 1) {
							previousButton.post(new Runnable() {

								public void run() {
									previousButton.setVisibility(0);
								}
							});
						} else if (nTotalReviews > Pxo6RSHW) {
							previousButton.post(new Runnable() {

								public void run() {
									previousButton.setVisibility(8);
								}
							});
						} else {
							previousButton.post(new Runnable() {

								public void run() {
									previousButton.setVisibility(4);
								}
							});
						}
						txtinfo.post(new Runnable() {

							public void run() {
								if (title != null && title != "") {
									txtinfo.setText(title + "\n" + getString(R.string.showing) + " " + OKuR4EPK + " "
											+ getString(R.string.through) + " " + Pxo6RSHW + " "
											+ getString(R.string.of) + " " + fkScdf1O);
								} else {
									txtinfo.setText(getString(R.string.showing) + " " + OKuR4EPK + " "
											+ getString(R.string.through) + " " + Pxo6RSHW + " "
											+ getString(R.string.of) + " " + fkScdf1O);
								}
							}
						});
						handlerSetList.sendEmptyMessage(0);
					} else {
						txtinfo.post(new Runnable() {

							public void run() {
								txtinfo.setText(title + getString(R.string.no_reviews_for_this_album));
							}
						});
					}
				} catch (Exception r7nlDN9E) {
					final Exception IsTR2oIc = r7nlDN9E;
					txtinfo.post(new Runnable() {

						public void run() {
							txtinfo.setText(R.string.search_failed);
						}
					});
				}
				HpMgBki7.dismiss();
				handlerDoneLoading.sendEmptyMessage(0);
			}
		};
		yx4U61mm.start();
	}

}