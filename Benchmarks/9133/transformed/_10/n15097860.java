class n15097860 {
	public static Bitmap loadPhotoBitmap(final String imageUrl, final String type) {
		InputStream imageStream = null;
		try {
			HttpGet httpRequest = new HttpGet(new URL(imageUrl).toURI());
			HttpResponse response = (HttpResponse) new DefaultHttpClient().execute(httpRequest);
			BufferedHttpEntity bufHttpEntity = new BufferedHttpEntity(response.getEntity());
			httpRequest = null;
			imageStream = bufHttpEntity.getContent();
			response = null;
			if (imageStream != null) {
				final BitmapFactory.Options options = new BitmapFactory.Options();
				if (type.equals("image")) {
					options.inSampleSize = 2;
				}
				return BitmapFactory.decodeStream(imageStream, null, options);
			} else {
			}
			bufHttpEntity = null;
		} catch (IOException e) {
		} catch (URISyntaxException e) {
		} finally {
			if (imageStream != null)
				closeStream(imageStream);
		}
		return null;
	}

}