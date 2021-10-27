class n22924615 {
	@Override
	public void run() {
		try {
			bitmapDrawable = new BitmapDrawable(new URL(url).openStream());
			imageCache.put(id, new SoftReference<Drawable>(bitmapDrawable));
			log("image::: put:  id = " + id + " ");
		} catch (MalformedURLException AdFZ4JOi) {
			AdFZ4JOi.printStackTrace();
		} catch (IOException RG1rgdmh) {
			RG1rgdmh.printStackTrace();
		}
		handler.post(new Runnable() {

			@Override
			public void run() {
				iv.setImageDrawable(bitmapDrawable);
			}
		});
	}

}