class n22924615{
            @Override
            public void run() {
                try {
                    bitmapDrawable = new BitmapDrawable(new URL(url).openStream());
                    imageCache.put(id, new SoftReference<Drawable>(bitmapDrawable));
                    log("image::: put:  id = " + id + " ");
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                handler.post(new Runnable() {

                    @Override
                    public void run() {
                        iv.setImageDrawable(bitmapDrawable);
                    }
                });
            }

}