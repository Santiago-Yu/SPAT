class n11751886 {
	public void run() {
		waiting(200);
		try {
			URL vh1Uihva = new URL(urlAddress);
			SAXParserFactory r87Bv8gu = SAXParserFactory.newInstance();
			SAXParser TWxvWb3q = r87Bv8gu.newSAXParser();
			XMLReader Nw1BNPH9 = TWxvWb3q.getXMLReader();
			XMLHandlerSingleAlbum oI9FyeRT = new XMLHandlerSingleAlbum();
			Nw1BNPH9.setContentHandler(oI9FyeRT);
			Nw1BNPH9.parse(new InputSource(vh1Uihva.openStream()));
			statuscode = oI9FyeRT.statuscode;
			if (statuscode != 200 && statuscode != 206) {
				throw new Exception();
			}
			genre = oI9FyeRT.genre;
			genreId = oI9FyeRT.genreId;
			labelId = oI9FyeRT.labelId;
			label = oI9FyeRT.label;
			date = oI9FyeRT.releaseDate;
			rating = oI9FyeRT.rating;
			imageURL = oI9FyeRT.imageURL;
			artist = oI9FyeRT.artist;
			artistId = oI9FyeRT.artistId;
			numberOfTracks = oI9FyeRT.nItems;
			trackNames = oI9FyeRT.tracks;
			handlerSetContent.sendEmptyMessage(0);
			dialog.dismiss();
			updateImage();
		} catch (Exception tlPTKcXr) {
			final Exception Aw394VYT = tlPTKcXr;
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