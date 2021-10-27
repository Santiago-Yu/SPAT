class n13086936 {
	public void run() {
		waiting(200);
		txtinfo.post(new Runnable() {

			public void run() {
				txtinfo.setText("Searching");
			}
		});
		try {
			URL J5dBvtyb = new URL(urlAddress);
			SAXParserFactory F74gpbsi = SAXParserFactory.newInstance();
			SAXParser DJvGlovQ = F74gpbsi.newSAXParser();
			XMLReader DoILAFa8 = DJvGlovQ.getXMLReader();
			XMLHandlerReviews VAI5VEaK = new XMLHandlerReviews();
			DoILAFa8.setContentHandler(VAI5VEaK);
			DoILAFa8.parse(new InputSource(J5dBvtyb.openStream()));
			if (statuscode != 200 && statuscode != 206) {
				throw new Exception();
			}
			nReviewsOnPage = VAI5VEaK.nItems;
			statuscode = VAI5VEaK.statuscode;
			if (nReviewsOnPage > 0) {
				authors = new String[nReviewsOnPage];
				reviews = new String[nReviewsOnPage];
				ratings = new String[nReviewsOnPage];
				titles = new String[nReviewsOnPage];
				listtext = new String[nReviewsOnPage];
				for (int xCn5EipV = 0; xCn5EipV < nReviewsOnPage; xCn5EipV++) {
					reviews[xCn5EipV] = VAI5VEaK.reviews[xCn5EipV];
					authors[xCn5EipV] = VAI5VEaK.authors[xCn5EipV];
					titles[xCn5EipV] = VAI5VEaK.titles[xCn5EipV];
					ratings[xCn5EipV] = VAI5VEaK.ratings[xCn5EipV];
					if (authors[xCn5EipV] == null || authors[xCn5EipV] == "") {
						authors[xCn5EipV] = "Anonymous";
					}
					if (ratings[xCn5EipV] == null || ratings[xCn5EipV] == "") {
						listtext[xCn5EipV] = titles[xCn5EipV] + " - " + reviews[xCn5EipV] + " - " + authors[xCn5EipV];
					} else {
						listtext[xCn5EipV] = "Score: " + ratings[xCn5EipV] + " - " + titles[xCn5EipV] + " - "
								+ reviews[xCn5EipV] + " - " + authors[xCn5EipV];
					}
				}
				nTotalReviews = VAI5VEaK.nTotalItems;
				final int kb4lm2m0 = iFirstReviewOnPage;
				final int a4483hUG = iFirstReviewOnPage + nReviewsOnPage - 1;
				final int HRLnRX5X = nTotalReviews;
				if (nTotalReviews > a4483hUG) {
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
				} else if (nTotalReviews > a4483hUG) {
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
							txtinfo.setText(title + "\n" + getString(R.string.showing) + " " + kb4lm2m0 + " "
									+ getString(R.string.through) + " " + a4483hUG + " " + getString(R.string.of) + " "
									+ HRLnRX5X);
						} else {
							txtinfo.setText(
									getString(R.string.showing) + " " + kb4lm2m0 + " " + getString(R.string.through)
											+ " " + a4483hUG + " " + getString(R.string.of) + " " + HRLnRX5X);
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
		} catch (Exception s0Y73EDk) {
			final Exception kitqm3ja = s0Y73EDk;
			txtinfo.post(new Runnable() {

				public void run() {
					txtinfo.setText(R.string.search_failed);
				}
			});
		}
		dialog.dismiss();
		handlerDoneLoading.sendEmptyMessage(0);
	}

}