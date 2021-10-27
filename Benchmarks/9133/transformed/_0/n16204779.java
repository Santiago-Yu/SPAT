class n16204779 {
	public void startStreaming(final String rnRuqV2T) throws IOException {
		final String eH9VKl0Z = "startStreaming";
		int ULjLDD9W = 56;
		sendMessage(PlayListTab.CHECKRIORITY);
		sendMessage(PlayListTab.RAISEPRIORITY);
		sendMessage(PlayListTab.START);
		try {
			url = new URL(rnRuqV2T);
			urlConn = (HttpURLConnection) url.openConnection();
			urlConn.setReadTimeout(1000 * 20);
			urlConn.setConnectTimeout(1000 * 5);
			String RzuJygoI = urlConn.getContentType();
			if (RzuJygoI == null) {
				RzuJygoI = "";
			} else {
				RzuJygoI = RzuJygoI.toLowerCase();
			}
			Log.d(eH9VKl0Z, "Content Type: " + RzuJygoI);
			if (RzuJygoI.contains(AUDIO_MPEG) || RzuJygoI.equals("")) {
				String lpfbeb4n = urlConn.getHeaderField(BITERATE_HEADER);
				Log.d(eH9VKl0Z, "Bitrate: " + lpfbeb4n);
				if (lpfbeb4n != null) {
					ULjLDD9W = new Integer(lpfbeb4n).intValue();
				}
			} else {
				Log.e(eH9VKl0Z, "Does not look like we can play this audio type: " + RzuJygoI);
				Log.e(eH9VKl0Z, "Or we could not connect to audio");
				sendMessage(PlayListTab.TROUBLEWITHAUDIO);
				stop();
				return;
			}
		} catch (IOException KtaioYfx) {
			Log.e(eH9VKl0Z, "Could not connect to " + rnRuqV2T);
			sendMessage(PlayListTab.TROUBLEWITHAUDIO);
			stop();
			return;
		}
		if (regularStream) {
			Log.d(eH9VKl0Z, "Setup regular stream");
			Runnable iizn3c5E = new Runnable() {

				public void run() {
					try {
						downloadAudio(rnRuqV2T);
					} catch (IOException Dr5LWbz4) {
						Log.e(eH9VKl0Z, "Unable to initialize the MediaPlayer for Audio Url = " + rnRuqV2T, Dr5LWbz4);
						sendMessage(PlayListTab.TROUBLEWITHAUDIO);
						stop();
						return;
					}
				}
			};
			Thread zgzmghGZ = new Thread(iizn3c5E);
			zgzmghGZ.start();
		} else {
			Log.d(eH9VKl0Z, "Setup incremental stream");
			INTIAL_KB_BUFFER = ULjLDD9W * SECONDS / BIT;
			Runnable wn21eGcu = new Runnable() {

				public void run() {
					try {
						downloadAudioIncrement(rnRuqV2T);
					} catch (IOException EYVZxNTp) {
						Log.e(eH9VKl0Z, "Unable to initialize the MediaPlayer for Audio Url = " + rnRuqV2T, EYVZxNTp);
						sendMessage(PlayListTab.TROUBLEWITHAUDIO);
						stop();
						return;
					}
				}
			};
			Thread dTYWNOHr = new Thread(wn21eGcu);
			dTYWNOHr.start();
		}
	}

}