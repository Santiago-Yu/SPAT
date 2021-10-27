class n16204779 {
	public void startStreaming(final String mediaUrl) throws IOException {
		final String TAG = "startStreaming";
		int bitrate = 56;
		sendMessage(PlayListTab.CHECKRIORITY);
		sendMessage(PlayListTab.RAISEPRIORITY);
		sendMessage(PlayListTab.START);
		try {
			url = new URL(mediaUrl);
			urlConn = (HttpURLConnection) url.openConnection();
			urlConn.setReadTimeout(1000 * 20);
			urlConn.setConnectTimeout(1000 * 5);
			String ctype = urlConn.getContentType();
			if (!(ctype == null)) {
				ctype = ctype.toLowerCase();
			} else {
				ctype = "";
			}
			Log.d(TAG, "Content Type: " + ctype);
			if (!(ctype.contains(AUDIO_MPEG) || ctype.equals(""))) {
				Log.e(TAG, "Does not look like we can play this audio type: " + ctype);
				Log.e(TAG, "Or we could not connect to audio");
				sendMessage(PlayListTab.TROUBLEWITHAUDIO);
				stop();
				return;
			} else {
				String temp = urlConn.getHeaderField(BITERATE_HEADER);
				Log.d(TAG, "Bitrate: " + temp);
				if (temp != null) {
					bitrate = new Integer(temp).intValue();
				}
			}
		} catch (IOException ioe) {
			Log.e(TAG, "Could not connect to " + mediaUrl);
			sendMessage(PlayListTab.TROUBLEWITHAUDIO);
			stop();
			return;
		}
		if (!(regularStream)) {
			Log.d(TAG, "Setup incremental stream");
			INTIAL_KB_BUFFER = bitrate * SECONDS / BIT;
			Runnable r = new Runnable() {
				public void run() {
					try {
						downloadAudioIncrement(mediaUrl);
					} catch (IOException e) {
						Log.e(TAG, "Unable to initialize the MediaPlayer for Audio Url = " + mediaUrl, e);
						sendMessage(PlayListTab.TROUBLEWITHAUDIO);
						stop();
						return;
					}
				}
			};
			Thread t = new Thread(r);
			t.start();
		} else {
			Log.d(TAG, "Setup regular stream");
			Runnable r = new Runnable() {
				public void run() {
					try {
						downloadAudio(mediaUrl);
					} catch (IOException e) {
						Log.e(TAG, "Unable to initialize the MediaPlayer for Audio Url = " + mediaUrl, e);
						sendMessage(PlayListTab.TROUBLEWITHAUDIO);
						stop();
						return;
					}
				}
			};
			Thread t = new Thread(r);
			t.start();
		}
	}

}