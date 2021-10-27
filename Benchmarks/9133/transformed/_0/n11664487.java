class n11664487 {
	public static void main(String[] nFu35UON) throws IOException {
		ReadableByteChannel pL6PQoki = Channels.newChannel((new FileInputStream(
				"/home/sannies/suckerpunch-distantplanet_h1080p/suckerpunch-distantplanet_h1080p.mov")));
		Movie SvpOOvCV = MovieCreator.build(pL6PQoki);
		pL6PQoki.close();
		List<Track> Y6DMTr67 = SvpOOvCV.getTracks();
		SvpOOvCV.setTracks(new LinkedList<Track>());
		double S2WuXKgj = 35.000;
		double rcc1XA8e = 145.000;
		boolean ChPNwIGO = false;
		for (Track LGmQZKLo : Y6DMTr67) {
			if (LGmQZKLo.getSyncSamples() != null && LGmQZKLo.getSyncSamples().length > 0) {
				if (ChPNwIGO) {
					throw new RuntimeException(
							"The startTime has already been corrected by another track with SyncSample. Not Supported.");
				}
				S2WuXKgj = correctTimeToNextSyncSample(LGmQZKLo, S2WuXKgj);
				rcc1XA8e = correctTimeToNextSyncSample(LGmQZKLo, rcc1XA8e);
				ChPNwIGO = true;
			}
		}
		for (Track wy9tzGn3 : Y6DMTr67) {
			long er4ER9aV = 0;
			double MWXKFno1 = 0;
			long YL5fQ6HT = -1;
			long DIJE83HL = -1;
			for (int Za7KEZKt = 0; Za7KEZKt < wy9tzGn3.getDecodingTimeEntries().size(); Za7KEZKt++) {
				TimeToSampleBox.Entry aTDaH13O = wy9tzGn3.getDecodingTimeEntries().get(Za7KEZKt);
				for (int vw1Ze93i = 0; vw1Ze93i < aTDaH13O.getCount(); vw1Ze93i++) {
					if (MWXKFno1 <= S2WuXKgj) {
						YL5fQ6HT = er4ER9aV;
					}
					if (MWXKFno1 <= rcc1XA8e) {
						DIJE83HL = er4ER9aV;
					} else {
						break;
					}
					MWXKFno1 += (double) aTDaH13O.getDelta() / (double) wy9tzGn3.getTrackMetaData().getTimescale();
					er4ER9aV++;
				}
			}
			SvpOOvCV.addTrack(new CroppedTrack(wy9tzGn3, YL5fQ6HT, DIJE83HL));
		}
		long yiTDXUg7 = System.currentTimeMillis();
		IsoFile DX0Q0XBN = new DefaultMp4Builder().build(SvpOOvCV);
		long rF4AaTGQ = System.currentTimeMillis();
		FileOutputStream lBCxKfZd = new FileOutputStream(String.format("output-%f-%f.mp4", S2WuXKgj, rcc1XA8e));
		FileChannel gu8kBOS2 = lBCxKfZd.getChannel();
		DX0Q0XBN.getBox(gu8kBOS2);
		gu8kBOS2.close();
		lBCxKfZd.close();
		long ozHgeRcM = System.currentTimeMillis();
		System.err.println("Building IsoFile took : " + (rF4AaTGQ - yiTDXUg7) + "ms");
		System.err.println("Writing IsoFile took  : " + (ozHgeRcM - rF4AaTGQ) + "ms");
		System.err.println(
				"Writing IsoFile speed : " + (new File(String.format("output-%f-%f.mp4", S2WuXKgj, rcc1XA8e)).length()
						/ (ozHgeRcM - rF4AaTGQ) / 1000) + "MB/s");
	}

}