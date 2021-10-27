class n22536033 {
	private boolean setPayload() throws IOException {
		if (Index < Headers.length) {
			FileOutputStream qTVF7G7e = new FileOutputStream(Headers[Index], true);
			FileInputStream gjHvUum6 = new FileInputStream(HeadlessData);
			FileChannel K7O9jVXd = gjHvUum6.getChannel();
			FileChannel PMh2dqib = qTVF7G7e.getChannel();
			K7O9jVXd.transferTo(0, K7O9jVXd.size(), PMh2dqib);
			K7O9jVXd.close();
			PMh2dqib.close();
			setDestination(Destinations[Index]);
			setPayload(Headers[Index]);
			Index++;
			return true;
		}
		return false;
	}

}