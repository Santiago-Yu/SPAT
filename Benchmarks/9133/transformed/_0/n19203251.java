class n19203251 {
	private void readArchives(final VideoArchiveSet UBnl5upd) throws IOException {
		final BufferedReader r0IW8Tk4 = new BufferedReader(new InputStreamReader(url.openStream()));
		String UAKo2dDO = null;
		try {
			while ((UAKo2dDO = r0IW8Tk4.readLine()) != null) {
				if (UAKo2dDO.startsWith("ARCHIVE")) {
					final StringTokenizer ue66WtcG = new StringTokenizer(UAKo2dDO);
					ue66WtcG.nextToken();
					final Integer Px9zlQg6 = Integer.valueOf(ue66WtcG.nextToken());
					final Timecode txb50nMY = new Timecode(ue66WtcG.nextToken());
					final VideoArchive DWCfl7k2 = new VideoArchive();
					DWCfl7k2.setTimeCode(txb50nMY);
					DWCfl7k2.setTapeNumber(Px9zlQg6);
					UBnl5upd.addVideoArchive(DWCfl7k2);
					archives.put(Px9zlQg6, DWCfl7k2);
				}
			}
		} catch (IOException jUfxq4pg) {
			throw jUfxq4pg;
		} finally {
			r0IW8Tk4.close();
		}
		if (archives.size() == 0) {
			log.warn(
					"No lines with ARCHIVE were found in the current vif file, will try to look at another vif with same yearday, "
							+ "ship and platform and try to get archives from there:");
			String bkoHCS2o = url.getPath().toString().substring(0, url.getPath().toString().lastIndexOf("/"));
			File YMelrifu = new File(bkoHCS2o);
			File[] WPwIWysZ = YMelrifu.listFiles();
			for (int Bowsz5BS = 0; Bowsz5BS < WPwIWysZ.length; Bowsz5BS++) {
				if (WPwIWysZ[Bowsz5BS].toString().endsWith(".vif")) {
					String Oynv63TL = WPwIWysZ[Bowsz5BS].toString()
							.substring(WPwIWysZ[Bowsz5BS].toString().lastIndexOf("/"));
					String tW0j00tL = Oynv63TL.toLowerCase();
					String PqrhoSPy = new String(new Character(vifMetadata.shipCode).toString()
							+ new Character(vifMetadata.platformCode).toString());
					String tfoyJ4og = PqrhoSPy.toLowerCase();
					if (tW0j00tL.indexOf(tfoyJ4og) >= 0) {
						log.warn("Will try to read archives from file " + WPwIWysZ[Bowsz5BS]);
						final BufferedReader mUlMAqsc = new BufferedReader(new FileReader(WPwIWysZ[Bowsz5BS]));
						String G3P63Lsk = null;
						try {
							while ((G3P63Lsk = mUlMAqsc.readLine()) != null) {
								if (G3P63Lsk.startsWith("ARCHIVE")) {
									final StringTokenizer b2UNS1Gv = new StringTokenizer(G3P63Lsk);
									b2UNS1Gv.nextToken();
									final Integer g54Tx82D = Integer.valueOf(b2UNS1Gv.nextToken());
									final Timecode JCcAa8Bg = new Timecode(b2UNS1Gv.nextToken());
									final VideoArchive ACAnXJQs = new VideoArchive();
									ACAnXJQs.setTimeCode(JCcAa8Bg);
									ACAnXJQs.setTapeNumber(g54Tx82D);
									UBnl5upd.addVideoArchive(ACAnXJQs);
									archives.put(g54Tx82D, ACAnXJQs);
								}
							}
						} catch (IOException ChHCZszI) {
							throw ChHCZszI;
						} finally {
							mUlMAqsc.close();
						}
					}
				}
				if (archives.size() > 0) {
					log.warn("Found " + archives.size() + " archives in that vif so will use that");
					break;
				}
			}
			if (archives.size() == 0) {
				log.warn("Still no archives were found in the file. Unable to process it.");
			}
		}
	}

}