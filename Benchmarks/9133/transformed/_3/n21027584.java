class n21027584 {
	public void run() {
		try {
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			Osm2Model osm = new Osm2Model(pedestrian, filterCyclic);
			osm.progress.connect(this, "progress(int)");
			osm.parseFile(con.getInputStream(), con.getContentLength());
			if (!(osm.somethingImported())) {
				nothing.emit();
			} else {
				done.emit();
			}
		} catch (Exception e) {
			failed.emit();
		}
	}

}