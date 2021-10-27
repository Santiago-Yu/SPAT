class n1692778{
    public synchronized void downloadTile(TileNumber tn) {
        try {
            Bitmap tile = getMapFromSdCache(tn);
            if (tile == null) {
                URL url = new URL("http://tile.openstreetmap.org/" + tn.getZoom() + "/" + tn.getX() + "/" + tn.getY() + ".png");
                tile = BitmapFactory.decodeStream(url.openStream());
                File sdCardPath = Environment.getExternalStorageDirectory();
                Log.d(ctx.getResources().getString(open.gps.gopens.R.string.TEST), "Path to SD :: " + sdCardPath.getAbsolutePath());
                File dir = new File(sdCardPath + ctx.getResources().getString(open.gps.gopens.R.string.CACHE_PATH) + tn.getZoom() + "/" + tn.getX() + "/");
                dir.mkdirs();
                File imgFile = new File(dir.getAbsolutePath() + "/" + tn.getY() + ".png");
                imgFile.createNewFile();
                FileOutputStream fOut = new FileOutputStream(imgFile);
                tile.compress(Bitmap.CompressFormat.PNG, 100, fOut);
            }
            cacheManager.put(tn.toString(), tile);
            setChanged();
            notifyObservers();
            Log.d("OBS", "OBS : Notify");
        } catch (MalformedURLException e) {
            Log.e("Error", e.getMessage());
        } catch (IOException e) {
            Log.e("Error", e.getMessage());
        }
    }

}