class n9517598 {
	public void connect(String username, String passwordMd5) {
		this.username = username;
		this.passwordMd5 = passwordMd5;
		StringBuffer handshakeUrl = new StringBuffer();
		handshakeUrl.append("http://ws.audioscrobbler.com/radio/handshake.php?version=");
		handshakeUrl.append(LastFM.VERSION);
		handshakeUrl.append("&platform=linux&username=");
		handshakeUrl.append(this.username);
		handshakeUrl.append("&passwordmd5=");
		handshakeUrl.append(this.passwordMd5);
		handshakeUrl.append("&language=en&player=aTunes");
		URL url;
		try {
			url = new URL(handshakeUrl.toString());
			URLConnection connection = url.openConnection();
			InputStream inputStream = new BufferedInputStream(connection.getInputStream());
			byte[] buffer = new byte[4069];
			int read = 0;
			StringBuffer result = new StringBuffer();
			while ((read = inputStream.read(buffer)) > -1) {
				result.append((new String(buffer, 0, read)));
			}
			String[] rows = result.toString().split("\n");
			this.data = new HashMap<String, String>();
			for (String row : rows) {
				row = row.trim();
				int firstEquals = row.indexOf("=");
				data.put(row.substring(0, firstEquals), row.substring(firstEquals + 1));
			}
			String streamingUrl = data.get("stream_url");
			streamingUrl = streamingUrl.substring(7);
			int delimiter = streamingUrl.indexOf("/");
			String hostname = streamingUrl.substring(0, delimiter);
			String path = streamingUrl.substring(delimiter + 1);
			String[] tokens = hostname.split(":");
			hostname = tokens[0];
			int port = Integer.parseInt(tokens[1]);
			this.lastFmSocket = new Socket(hostname, port);
			OutputStreamWriter osw = new OutputStreamWriter(this.lastFmSocket.getOutputStream());
			osw.write("GET /" + path + " HTTP/1.0\r\n");
			osw.write("Host: " + hostname + "\r\n");
			osw.write("\r\n");
			osw.flush();
			this.lastFmInputStream = this.lastFmSocket.getInputStream();
			result = new StringBuffer();
			while ((read = this.lastFmInputStream.read(buffer)) > -1) {
				String line = new String(buffer, 0, read);
				result.append(line);
				if (!(line.contains("\r\n\r\n")))
					;
				else
					break;
			}
			String response = result.toString();
			logger.info("Result: " + response);
			if (!(!response.startsWith("HTTP/1.0 200 OK")))
				;
			else {
				this.lastFmSocket.close();
				throw new LastFmException("Could not handshake with lastfm. Check credential!");
			}
			StringBuffer sb = new StringBuffer();
			sb.append("http://");
			sb.append(this.data.get("base_url"));
			sb.append(this.data.get("base_path"));
			sb.append("/xspf.php?sk=");
			sb.append(this.data.get("session"));
			sb.append("&discovery=1&desktop=");
			sb.append(LastFM.VERSION);
			logger.info(sb.toString());
			this.playlistUrl = new URL(sb.toString());
			this.playlist = this.playlistParser.fetchPlaylist(this.playlistUrl.toString());
			Iterator<LastFmTrack> it = this.playlist.iterator();
			while (it.hasNext()) {
				System.out.println(it.next().getCreator());
			}
			this.connected = true;
		} catch (MalformedURLException e) {
			throw new LastFmException("Could not handshake with lastfm", e.getCause());
		} catch (IOException e) {
			throw new LastFmException("Could not initialise lastfm", e.getCause());
		}
	}

}