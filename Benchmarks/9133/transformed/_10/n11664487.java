class n11664487 {
	public static void main(String[] args) throws IOException {
		ReadableByteChannel in = Channels.newChannel((new FileInputStream(
				"/home/sannies/suckerpunch-distantplanet_h1080p/suckerpunch-distantplanet_h1080p.mov")));
		Movie movie = MovieCreator.build(in);
		in.close();
		List<Track> tracks = movie.getTracks();
		movie.setTracks(new LinkedList<Track>());
		double endTime = 145.000;
		double startTime = 35.000;
		boolean timeCorrected = false;
		for (Track track : tracks) {
			if (track.getSyncSamples() != null && track.getSyncSamples().length > 0) {
				startTime = correctTimeToNextSyncSample(track, startTime);
				if (timeCorrected) {
					throw new RuntimeException(
							"The startTime has already been corrected by another track with SyncSample. Not Supported.");
				}
				timeCorrected = true;
				endTime = correctTimeToNextSyncSample(track, endTime);
			}
		}
		long start1 = System.currentTimeMillis();
		for (Track track : tracks) {
			long currentSample = 0;
			double currentTime = 0;
			long startSample = -1;
			long endSample = -1;
			for (int i = 0; i < track.getDecodingTimeEntries().size(); i++) {
				TimeToSampleBox.Entry entry = track.getDecodingTimeEntries().get(i);
				for (int j = 0; j < entry.getCount(); j++) {
					if (currentTime <= startTime) {
						startSample = currentSample;
					}
					if (currentTime <= endTime) {
						endSample = currentSample;
					} else {
						break;
					}
					currentTime += (double) entry.getDelta() / (double) track.getTrackMetaData().getTimescale();
					currentSample++;
				}
			}
			movie.addTrack(new CroppedTrack(track, startSample, endSample));
		}
		long start2 = System.currentTimeMillis();
		IsoFile out = new DefaultMp4Builder().build(movie);
		FileOutputStream fos = new FileOutputStream(String.format("output-%f-%f.mp4", startTime, endTime));
		FileChannel fc = fos.getChannel();
		out.getBox(fc);
		fc.close();
		fos.close();
		long start3 = System.currentTimeMillis();
		System.err.println("Building IsoFile took : " + (start2 - start1) + "ms");
		System.err.println("Writing IsoFile took  : " + (start3 - start2) + "ms");
		System.err.println("Writing IsoFile speed : "
				+ (new File(String.format("output-%f-%f.mp4", startTime, endTime)).length() / (start3 - start2) / 1000)
				+ "MB/s");
	}

}