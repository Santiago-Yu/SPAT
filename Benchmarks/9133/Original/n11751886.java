class n11751886{
            public void run() {
                waiting(200);
                try {
                    URL url = new URL(urlAddress);
                    SAXParserFactory spf = SAXParserFactory.newInstance();
                    SAXParser sp = spf.newSAXParser();
                    XMLReader xr = sp.getXMLReader();
                    XMLHandlerSingleAlbum myXMLHandler = new XMLHandlerSingleAlbum();
                    xr.setContentHandler(myXMLHandler);
                    xr.parse(new InputSource(url.openStream()));
                    statuscode = myXMLHandler.statuscode;
                    if (statuscode != 200 && statuscode != 206) {
                        throw new Exception();
                    }
                    genre = myXMLHandler.genre;
                    genreId = myXMLHandler.genreId;
                    labelId = myXMLHandler.labelId;
                    label = myXMLHandler.label;
                    date = myXMLHandler.releaseDate;
                    rating = myXMLHandler.rating;
                    imageURL = myXMLHandler.imageURL;
                    artist = myXMLHandler.artist;
                    artistId = myXMLHandler.artistId;
                    numberOfTracks = myXMLHandler.nItems;
                    trackNames = myXMLHandler.tracks;
                    handlerSetContent.sendEmptyMessage(0);
                    dialog.dismiss();
                    updateImage();
                } catch (Exception e) {
                    final Exception ef = e;
                    nameTextView.post(new Runnable() {

                        public void run() {
                            nameTextView.setText(R.string.couldnt_get_album_info);
                        }
                    });
                }
                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
                handlerDoneLoading.sendEmptyMessage(0);
            }

}