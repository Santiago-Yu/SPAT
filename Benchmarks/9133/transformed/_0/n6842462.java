class n6842462 {
	private void playAudio(String nzhStSIb) {
		try {
			URLConnection CSzl94SK = new URL(nzhStSIb).openConnection();
			InputStream lwGG52yi = CSzl94SK.getInputStream();
			mediaFile = new File(this.getCacheDir(), "mediafile");
			FileOutputStream RauVzvQh = new FileOutputStream(mediaFile);
			byte HD6yT46e[] = new byte[16 * 1024];
			Log.i("FileOutputStream", "Download");
			do {
				int iF3qgk2t = lwGG52yi.read(HD6yT46e);
				if (iF3qgk2t <= 0)
					break;
				RauVzvQh.write(HD6yT46e, 0, iF3qgk2t);
			} while (true);
			RauVzvQh.flush();
			RauVzvQh.close();
			Log.i("FileOutputStream", "Saved");
			MediaPlayer.OnCompletionListener OsUF6lVS = new MediaPlayer.OnCompletionListener() {

				public void onCompletion(MediaPlayer dXxUo6WJ) {
					dXxUo6WJ.release();
					Log.i("MediaPlayer.OnCompletionListener", "MediaPlayer Released");
				}
			};
			mixPlayer.setOnCompletionListener(OsUF6lVS);
			FileInputStream Bxue7p7S = new FileInputStream(mediaFile);
			mixPlayer.setDataSource(Bxue7p7S.getFD());
			mixPlayer.prepare();
			Log.i("MediaPlayer", "Start Player");
			loading = false;
		} catch (Exception bBcGqxRT) {
			bBcGqxRT.printStackTrace();
		}
	}

}