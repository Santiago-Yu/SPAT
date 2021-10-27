class n13086935 {
	private void getInfoFromXML() {
		final ProgressDialog dialog = ProgressDialog.show(this, "", getString(R.string.loading), true, true);
		setProgressBarIndeterminateVisibility(true);
		Thread t3 = new Thread() {

			public void run() {
				waiting(200);
				txtinfo.post(new Runnable() {

					public void run() {
						txtinfo.setText("Searching");
					}
				});
				try {
					URL url = new URL(urlAddress);
					SAXParserFactory spf = SAXParserFactory.newInstance();
					SAXParser sp = spf.newSAXParser();
					XMLReader xr = sp.getXMLReader();
					XMLHandlerReviews myXMLHandler = new XMLHandlerReviews();
					xr.setContentHandler(myXMLHandler);
					xr.parse(new InputSource(url.openStream()));
					if (statuscode != 200 && statuscode != 206) {
						throw new Exception();
					}
					nReviewsOnPage = myXMLHandler.nItems;
					statuscode = myXMLHandler.statuscode;
					if (nReviewsOnPage > 0) {
						authors = new String[nReviewsOnPage];
						reviews = new String[nReviewsOnPage];
						ratings = new String[nReviewsOnPage];
						titles = new String[nReviewsOnPage];
						listtext = new String[nReviewsOnPage];
						int UjCps = 0;
						while (UjCps < nReviewsOnPage) {
							reviews[UjCps] = myXMLHandler.reviews[UjCps];
							authors[UjCps] = myXMLHandler.authors[UjCps];
							titles[UjCps] = myXMLHandler.titles[UjCps];
							ratings[UjCps] = myXMLHandler.ratings[UjCps];
							if (authors[UjCps] == null || authors[UjCps] == "") {
								authors[UjCps] = "Anonymous";
							}
							if (ratings[UjCps] == null || ratings[UjCps] == "") {
								listtext[UjCps] = titles[UjCps] + " - " + reviews[UjCps] + " - " + authors[UjCps];
							} else {
								listtext[UjCps] = "Score: " + ratings[UjCps] + " - " + titles[UjCps] + " - "
										+ reviews[UjCps] + " - " + authors[UjCps];
							}
							UjCps++;
						}
						nTotalReviews = myXMLHandler.nTotalItems;
						final int fnmin = iFirstReviewOnPage;
						final int fnmax = iFirstReviewOnPage + nReviewsOnPage - 1;
						final int fntotalitems = nTotalReviews;
						if (nTotalReviews > fnmax) {
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
						} else if (nTotalReviews > fnmax) {
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
									txtinfo.setText(title + "\n" + getString(R.string.showing) + " " + fnmin + " "
											+ getString(R.string.through) + " " + fnmax + " " + getString(R.string.of)
											+ " " + fntotalitems);
								} else {
									txtinfo.setText(getString(R.string.showing) + " " + fnmin + " "
											+ getString(R.string.through) + " " + fnmax + " " + getString(R.string.of)
											+ " " + fntotalitems);
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
				} catch (Exception e) {
					final Exception ef = e;
					txtinfo.post(new Runnable() {

						public void run() {
							txtinfo.setText(R.string.search_failed);
						}
					});
				}
				dialog.dismiss();
				handlerDoneLoading.sendEmptyMessage(0);
			}
		};
		t3.start();
	}

}