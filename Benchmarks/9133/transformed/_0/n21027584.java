class n21027584 {
	public void run() {
		try {
			HttpURLConnection QAVoQOQL = (HttpURLConnection) url.openConnection();
			Osm2Model nuWhBOel = new Osm2Model(pedestrian, filterCyclic);
			nuWhBOel.progress.connect(this, "progress(int)");
			nuWhBOel.parseFile(QAVoQOQL.getInputStream(), QAVoQOQL.getContentLength());
			if (nuWhBOel.somethingImported()) {
				done.emit();
			} else {
				nothing.emit();
			}
		} catch (Exception k1dL7ACl) {
			failed.emit();
		}
	}

}