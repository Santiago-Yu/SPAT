class n6471727 {
	public void load() throws IOException {
		File hPxtd5ZD = new File(filename);
		URL Atte5v6g = hPxtd5ZD.toURI().toURL();
		Properties Pg6OHUEZ = new Properties();
		Pg6OHUEZ.load(Atte5v6g.openStream());
		if (Pg6OHUEZ.getProperty("Width") != null)
			try {
				width = Integer.valueOf(Pg6OHUEZ.getProperty("Width"));
			} catch (Exception idftpmGU) {
				System.out.println("Error loading Calibration Sheet Width - leaving as default: " + idftpmGU);
			}
		if (Pg6OHUEZ.getProperty("Height") != null)
			try {
				height = Integer.valueOf(Pg6OHUEZ.getProperty("Height"));
			} catch (Exception FSD8rWWO) {
				System.out.println("Error loading Calibration Sheet Height - leaving as default: " + FSD8rWWO);
			}
		if (Pg6OHUEZ.getProperty("CircleRadius") != null)
			try {
				circleradius = Double.valueOf(Pg6OHUEZ.getProperty("CircleRadius"));
			} catch (Exception AkoC9rRX) {
				System.out.println("Error loading Calibration Sheet Circle Radius - leaving as default: " + AkoC9rRX);
			}
		ArrayList<Ellipse> HLpYTxG3 = new ArrayList<Ellipse>();
		int nIdFLyXu = 0;
		while ((Pg6OHUEZ.getProperty("Circle" + nIdFLyXu + "CenterX") != null)
				&& (Pg6OHUEZ.getProperty("Circle" + nIdFLyXu + "CenterY") != null)) {
			Point2d PscjtpwG = new Point2d(0, 0);
			PscjtpwG.x = Double.valueOf(Pg6OHUEZ.getProperty("Circle" + nIdFLyXu + "CenterX"));
			PscjtpwG.y = Double.valueOf(Pg6OHUEZ.getProperty("Circle" + nIdFLyXu + "CenterY"));
			Ellipse vGGz5mhv = new Ellipse(PscjtpwG, circleradius, circleradius, 0);
			HLpYTxG3.add(vGGz5mhv);
			nIdFLyXu++;
		}
		calibrationcircles = new Ellipse[0];
		calibrationcircles = HLpYTxG3.toArray(calibrationcircles);
	}

}