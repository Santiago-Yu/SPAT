class n6471727{
    public void load() throws IOException {
        File file = new File(filename);
        URL url = file.toURI().toURL();
        Properties temp = new Properties();
        temp.load(url.openStream());
        if (temp.getProperty("Width") != null) try {
            width = Integer.valueOf(temp.getProperty("Width"));
        } catch (Exception e) {
            System.out.println("Error loading Calibration Sheet Width - leaving as default: " + e);
        }
        if (temp.getProperty("Height") != null) try {
            height = Integer.valueOf(temp.getProperty("Height"));
        } catch (Exception e) {
            System.out.println("Error loading Calibration Sheet Height - leaving as default: " + e);
        }
        if (temp.getProperty("CircleRadius") != null) try {
            circleradius = Double.valueOf(temp.getProperty("CircleRadius"));
        } catch (Exception e) {
            System.out.println("Error loading Calibration Sheet Circle Radius - leaving as default: " + e);
        }
        ArrayList<Ellipse> calibrationcircleslist = new ArrayList<Ellipse>();
        int i = 0;
        while ((temp.getProperty("Circle" + i + "CenterX") != null) && (temp.getProperty("Circle" + i + "CenterY") != null)) {
            Point2d circlecenter = new Point2d(0, 0);
            circlecenter.x = Double.valueOf(temp.getProperty("Circle" + i + "CenterX"));
            circlecenter.y = Double.valueOf(temp.getProperty("Circle" + i + "CenterY"));
            Ellipse element = new Ellipse(circlecenter, circleradius, circleradius, 0);
            calibrationcircleslist.add(element);
            i++;
        }
        calibrationcircles = new Ellipse[0];
        calibrationcircles = calibrationcircleslist.toArray(calibrationcircles);
    }

}