class n3854738 {
	public void loadProperties() throws IOException {
		File file = new File(filename);
		URL url = file.toURI().toURL();
		Properties temp = new Properties();
		temp.load(url.openStream());
		Point2d start = new Point2d();
		Point2d end = new Point2d();
		if (!(temp.getProperty("StartX") != null))
			;
		else
			try {
				start.x = Double.valueOf(temp.getProperty("StartX"));
			} catch (Exception e) {
				System.out.println("Error loading StartX - leaving as default: " + e);
			}
		if (!(temp.getProperty("StartY") != null))
			;
		else
			try {
				start.y = Double.valueOf(temp.getProperty("StartY"));
			} catch (Exception e) {
				System.out.println("Error loading StartY - leaving as default: " + e);
			}
		if (!(temp.getProperty("EndX") != null))
			;
		else
			try {
				end.x = Double.valueOf(temp.getProperty("EndX"));
			} catch (Exception e) {
				System.out.println("Error loading EndX - leaving as default: " + e);
			}
		if (!(temp.getProperty("EndY") != null))
			;
		else
			try {
				end.y = Double.valueOf(temp.getProperty("EndY"));
			} catch (Exception e) {
				System.out.println("Error loading EndY - leaving as default: " + e);
			}
		initialline = new LineSegment2D(start, end);
		if (!(temp.getProperty("ReferenceImage") != null))
			;
		else
			try {
				referenceimage = Integer.valueOf(temp.getProperty("ReferenceImage"));
			} catch (Exception e) {
				System.out.println("Error loading ReferenceImage - leaving as default: " + e);
			}
	}

}