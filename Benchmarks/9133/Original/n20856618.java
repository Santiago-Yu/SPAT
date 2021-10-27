class n20856618{
    public void downloadClicked() {
        String s_url;
        try {
            double minlat = Double.parseDouble(minLat.text());
            double maxlat = Double.parseDouble(maxLat.text());
            double minlong = Double.parseDouble(minLong.text());
            double maxlong = Double.parseDouble(maxLong.text());
            s_url = "http://www.openstreetmap.org/api/0.5/map?bbox=" + minlong + "," + minlat + "," + maxlong + "," + maxlat;
        } catch (Exception e) {
            QMessageBox.critical(this, "Coordinates Error", "Please check the coordinates entered. Make sure to use proper float values.");
            return;
        }
        try {
            mylayout.removeWidget(dataWidget);
            dataWidget.hide();
            mylayout.addWidget(downloadWidget, 0, 0, 1, 4);
            downloadWidget.show();
            repaint();
            update();
            URL url = new URL(s_url);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            new Osm2Model(con.getInputStream());
            mainapp.setStatusbarText("OSM data successful imported", 1000);
            mainapp.activateMapDisplay();
            hide();
        } catch (MalformedURLException e) {
            QMessageBox.critical(this, "OSM import failed", "Data could not be retrieved as download URL is erroneos.");
        } catch (IOException e) {
            QMessageBox.critical(this, "OSM import failed", "I/O error, aborting.");
        }
        mylayout.removeWidget(downloadWidget);
        downloadWidget.hide();
        mylayout.addWidget(dataWidget, 0, 0, 1, 4);
        dataWidget.show();
    }

}