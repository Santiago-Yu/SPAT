class n9517598 {
	public void connect(String SfOgoXs3, String z84KoBVA) {
		this.username = SfOgoXs3;
		this.passwordMd5 = z84KoBVA;
		StringBuffer xzIJaNrr = new StringBuffer();
		xzIJaNrr.append("http://ws.audioscrobbler.com/radio/handshake.php?version=");
		xzIJaNrr.append(LastFM.VERSION);
		xzIJaNrr.append("&platform=linux&username=");
		xzIJaNrr.append(this.username);
		xzIJaNrr.append("&passwordmd5=");
		xzIJaNrr.append(this.passwordMd5);
		xzIJaNrr.append("&language=en&player=aTunes");
		URL V8E4pwSU;
		try {
			V8E4pwSU = new URL(xzIJaNrr.toString());
			URLConnection MhPmHeMn = V8E4pwSU.openConnection();
			InputStream WMyStThI = new BufferedInputStream(MhPmHeMn.getInputStream());
			byte[] W0iugO0k = new byte[4069];
			int Gzh0nb42 = 0;
			StringBuffer X9fwBa92 = new StringBuffer();
			while ((Gzh0nb42 = WMyStThI.read(W0iugO0k)) > -1) {
				X9fwBa92.append((new String(W0iugO0k, 0, Gzh0nb42)));
			}
			String[] p0ZZRTy7 = X9fwBa92.toString().split("\n");
			this.data = new HashMap<String, String>();
			for (String pSXcJNzf : p0ZZRTy7) {
				pSXcJNzf = pSXcJNzf.trim();
				int NjWhjDMU = pSXcJNzf.indexOf("=");
				data.put(pSXcJNzf.substring(0, NjWhjDMU), pSXcJNzf.substring(NjWhjDMU + 1));
			}
			String ess12vIM = data.get("stream_url");
			ess12vIM = ess12vIM.substring(7);
			int qHolEiLj = ess12vIM.indexOf("/");
			String r8Dfvp5R = ess12vIM.substring(0, qHolEiLj);
			String hfnIYy76 = ess12vIM.substring(qHolEiLj + 1);
			String[] FEPQkKNS = r8Dfvp5R.split(":");
			r8Dfvp5R = FEPQkKNS[0];
			int GL6ObM9b = Integer.parseInt(FEPQkKNS[1]);
			this.lastFmSocket = new Socket(r8Dfvp5R, GL6ObM9b);
			OutputStreamWriter JKlBrTPR = new OutputStreamWriter(this.lastFmSocket.getOutputStream());
			JKlBrTPR.write("GET /" + hfnIYy76 + " HTTP/1.0\r\n");
			JKlBrTPR.write("Host: " + r8Dfvp5R + "\r\n");
			JKlBrTPR.write("\r\n");
			JKlBrTPR.flush();
			this.lastFmInputStream = this.lastFmSocket.getInputStream();
			X9fwBa92 = new StringBuffer();
			while ((Gzh0nb42 = this.lastFmInputStream.read(W0iugO0k)) > -1) {
				String USkRXZxk = new String(W0iugO0k, 0, Gzh0nb42);
				X9fwBa92.append(USkRXZxk);
				if (USkRXZxk.contains("\r\n\r\n"))
					break;
			}
			String nbjYGj42 = X9fwBa92.toString();
			logger.info("Result: " + nbjYGj42);
			if (!nbjYGj42.startsWith("HTTP/1.0 200 OK")) {
				this.lastFmSocket.close();
				throw new LastFmException("Could not handshake with lastfm. Check credential!");
			}
			StringBuffer aH5eWz4P = new StringBuffer();
			aH5eWz4P.append("http://");
			aH5eWz4P.append(this.data.get("base_url"));
			aH5eWz4P.append(this.data.get("base_path"));
			aH5eWz4P.append("/xspf.php?sk=");
			aH5eWz4P.append(this.data.get("session"));
			aH5eWz4P.append("&discovery=1&desktop=");
			aH5eWz4P.append(LastFM.VERSION);
			logger.info(aH5eWz4P.toString());
			this.playlistUrl = new URL(aH5eWz4P.toString());
			this.playlist = this.playlistParser.fetchPlaylist(this.playlistUrl.toString());
			Iterator<LastFmTrack> TaGi24Rn = this.playlist.iterator();
			while (TaGi24Rn.hasNext()) {
				System.out.println(TaGi24Rn.next().getCreator());
			}
			this.connected = true;
		} catch (MalformedURLException fkbeDp4F) {
			throw new LastFmException("Could not handshake with lastfm", fkbeDp4F.getCause());
		} catch (IOException Gw0HM5Rg) {
			throw new LastFmException("Could not initialise lastfm", Gw0HM5Rg.getCause());
		}
	}

}