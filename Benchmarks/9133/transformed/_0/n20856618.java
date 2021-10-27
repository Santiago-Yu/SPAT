class n20856618 {
	public void downloadClicked() {
		String tQUGBLjs;
		try {
			double kvvnyDyr = Double.parseDouble(minLat.text());
			double UjBos2j6 = Double.parseDouble(maxLat.text());
			double D0MaeVuw = Double.parseDouble(minLong.text());
			double pUyUzrMx = Double.parseDouble(maxLong.text());
			tQUGBLjs = "http://www.openstreetmap.org/api/0.5/map?bbox=" + D0MaeVuw + "," + kvvnyDyr + "," + pUyUzrMx
					+ "," + UjBos2j6;
		} catch (Exception dkSlGKIl) {
			QMessageBox.critical(this, "Coordinates Error",
					"Please check the coordinates entered. Make sure to use proper float values.");
			return;
		}
		try {
			mylayout.removeWidget(dataWidget);
			dataWidget.hide();
			mylayout.addWidget(downloadWidget, 0, 0, 1, 4);
			downloadWidget.show();
			repaint();
			update();
			URL NTq9OYn8 = new URL(tQUGBLjs);
			HttpURLConnection cjDSuWtY = (HttpURLConnection) NTq9OYn8.openConnection();
			new Osm2Model(cjDSuWtY.getInputStream());
			mainapp.setStatusbarText("OSM data successful imported", 1000);
			mainapp.activateMapDisplay();
			hide();
		} catch (MalformedURLException Q07b5P2O) {
			QMessageBox.critical(this, "OSM import failed", "Data could not be retrieved as download URL is erroneos.");
		} catch (IOException KAA5GjGN) {
			QMessageBox.critical(this, "OSM import failed", "I/O error, aborting.");
		}
		mylayout.removeWidget(downloadWidget);
		downloadWidget.hide();
		mylayout.addWidget(dataWidget, 0, 0, 1, 4);
		dataWidget.show();
	}

}