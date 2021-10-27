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
                        for (int i = 0; i < nReviewsOnPage; i++) {
                            reviews[i] = myXMLHandler.reviews[i];
                            authors[i] = myXMLHandler.authors[i];
                            titles[i] = myXMLHandler.titles[i];
                            ratings[i] = myXMLHandler.ratings[i];
                            if (authors[i] == null || authors[i] == "") {
                                authors[i] = "Anonymous";
                            }
                            if (ratings[i] == null || ratings[i] == "") {
                                listtext[i] = titles[i] + " - " + reviews[i] + " - " + authors[i];
                            } else {
                                listtext[i] = "Score: " + ratings[i] + " - " + titles[i] + " - " + reviews[i] + " - " + authors[i];
                            }
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
                                    txtinfo.setText(title + "\n" + getString(R.string.showing) + " " + fnmin + " " + getString(R.string.through) + " " + fnmax + " " + getString(R.string.of) + " " + fntotalitems);
                                } else {
                                    txtinfo.setText(getString(R.string.showing) + " " + fnmin + " " + getString(R.string.through) + " " + fnmax + " " + getString(R.string.of) + " " + fntotalitems);
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
