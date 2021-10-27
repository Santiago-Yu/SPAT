class n3854738 {
	public void loadProperties() throws IOException {
		File RwRjswa0 = new File(filename);
		URL LB01EAoH = RwRjswa0.toURI().toURL();
		Properties zVhFFDIX = new Properties();
		zVhFFDIX.load(LB01EAoH.openStream());
		Point2d UX4EXtrU = new Point2d();
		Point2d V6MRgREa = new Point2d();
		if (zVhFFDIX.getProperty("StartX") != null)
			try {
				UX4EXtrU.x = Double.valueOf(zVhFFDIX.getProperty("StartX"));
			} catch (Exception SEBi1pEY) {
				System.out.println("Error loading StartX - leaving as default: " + SEBi1pEY);
			}
		if (zVhFFDIX.getProperty("StartY") != null)
			try {
				UX4EXtrU.y = Double.valueOf(zVhFFDIX.getProperty("StartY"));
			} catch (Exception fvOisSje) {
				System.out.println("Error loading StartY - leaving as default: " + fvOisSje);
			}
		if (zVhFFDIX.getProperty("EndX") != null)
			try {
				V6MRgREa.x = Double.valueOf(zVhFFDIX.getProperty("EndX"));
			} catch (Exception OGe6fjXA) {
				System.out.println("Error loading EndX - leaving as default: " + OGe6fjXA);
			}
		if (zVhFFDIX.getProperty("EndY") != null)
			try {
				V6MRgREa.y = Double.valueOf(zVhFFDIX.getProperty("EndY"));
			} catch (Exception quvFnYBh) {
				System.out.println("Error loading EndY - leaving as default: " + quvFnYBh);
			}
		initialline = new LineSegment2D(UX4EXtrU, V6MRgREa);
		if (zVhFFDIX.getProperty("ReferenceImage") != null)
			try {
				referenceimage = Integer.valueOf(zVhFFDIX.getProperty("ReferenceImage"));
			} catch (Exception kxhREV3C) {
				System.out.println("Error loading ReferenceImage - leaving as default: " + kxhREV3C);
			}
	}

}