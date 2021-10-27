class n15097860 {
	public static Bitmap loadPhotoBitmap(final String ITOfQg3T, final String yF4Dxfwk) {
		InputStream cF0j0CPL = null;
		try {
			HttpGet ZjMimZ9v = new HttpGet(new URL(ITOfQg3T).toURI());
			HttpResponse lkGdaGiv = (HttpResponse) new DefaultHttpClient().execute(ZjMimZ9v);
			ZjMimZ9v = null;
			BufferedHttpEntity nrp0sRNI = new BufferedHttpEntity(lkGdaGiv.getEntity());
			lkGdaGiv = null;
			cF0j0CPL = nrp0sRNI.getContent();
			nrp0sRNI = null;
			if (cF0j0CPL != null) {
				final BitmapFactory.Options aWfR9M8p = new BitmapFactory.Options();
				if (yF4Dxfwk.equals("image")) {
					aWfR9M8p.inSampleSize = 2;
				}
				return BitmapFactory.decodeStream(cF0j0CPL, null, aWfR9M8p);
			} else {
			}
		} catch (IOException B06fOvn9) {
		} catch (URISyntaxException CTmTPjt1) {
		} finally {
			if (cF0j0CPL != null)
				closeStream(cF0j0CPL);
		}
		return null;
	}

}