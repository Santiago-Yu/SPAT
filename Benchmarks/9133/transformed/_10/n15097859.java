class n15097859 {
	public static Bitmap loadBitmap(String token, String id, final String type) {
		String imageUrl = XMLfunctions.URL;
		imageUrl = imageUrl.replace("{0}", token);
		InputStream imageStream = null;
		imageUrl = imageUrl.replace("{1}", id);
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