class n1692778 {
	public synchronized void downloadTile(TileNumber dtEX11a6) {
		try {
			Bitmap US2DFBoD = getMapFromSdCache(dtEX11a6);
			if (US2DFBoD == null) {
				URL fGzCgmPD = new URL("http://tile.openstreetmap.org/" + dtEX11a6.getZoom() + "/" + dtEX11a6.getX()
						+ "/" + dtEX11a6.getY() + ".png");
				US2DFBoD = BitmapFactory.decodeStream(fGzCgmPD.openStream());
				File gggEGFYh = Environment.getExternalStorageDirectory();
				Log.d(ctx.getResources().getString(open.gps.gopens.R.string.TEST),
						"Path to SD :: " + gggEGFYh.getAbsolutePath());
				File q0Yxwmbr = new File(gggEGFYh + ctx.getResources().getString(open.gps.gopens.R.string.CACHE_PATH)
						+ dtEX11a6.getZoom() + "/" + dtEX11a6.getX() + "/");
				q0Yxwmbr.mkdirs();
				File F5kngu5q = new File(q0Yxwmbr.getAbsolutePath() + "/" + dtEX11a6.getY() + ".png");
				F5kngu5q.createNewFile();
				FileOutputStream vLBTjnrt = new FileOutputStream(F5kngu5q);
				US2DFBoD.compress(Bitmap.CompressFormat.PNG, 100, vLBTjnrt);
			}
			cacheManager.put(dtEX11a6.toString(), US2DFBoD);
			setChanged();
			notifyObservers();
			Log.d("OBS", "OBS : Notify");
		} catch (MalformedURLException ZQh9Pnf4) {
			Log.e("Error", ZQh9Pnf4.getMessage());
		} catch (IOException MzkEjDCH) {
			Log.e("Error", MzkEjDCH.getMessage());
		}
	}

}