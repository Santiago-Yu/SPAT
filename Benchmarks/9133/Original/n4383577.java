class n4383577{
    private void getInfoFromXML() {
        final ProgressDialog dialog = ProgressDialog.show(this, "", getString(R.string.loading), true, true);
        setProgressBarIndeterminateVisibility(true);
        Thread t3 = new Thread() {

            public void run() {
                waiting(200);
                try {
                    URL url = new URL(urlAddress);
                    SAXParserFactory spf = SAXParserFactory.newInstance();
                    SAXParser sp = spf.newSAXParser();
                    XMLReader xr = sp.getXMLReader();
                    XMLHandlerSingleArtist myXMLHandler = new XMLHandlerSingleArtist();
                    xr.setContentHandler(myXMLHandler);
                    xr.parse(new InputSource(url.openStream()));
                    artist = myXMLHandler.artist;
                    emusicURL = myXMLHandler.url;
                    bio = myXMLHandler.bio;
                    born = myXMLHandler.born;
                    death = myXMLHandler.death;
                    decade = myXMLHandler.decade;
                    rating = myXMLHandler.rating;
                    statuscode = myXMLHandler.statuscode;
                    if (statuscode != 200 && statuscode != 206) {
                        throw new Exception();
                    }
                    handlerSetContent.sendEmptyMessage(0);
                } catch (Exception e) {
                    headerTextView.post(new Runnable() {

                        public void run() {
                            headerTextView.setText(R.string.couldnt_get_artist_info);
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