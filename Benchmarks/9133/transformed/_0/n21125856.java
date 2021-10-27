class n21125856 {
	public File createWindow(String hAdTnQap) {
		URL IxITTuEs;
		InputStream a7YvoxpS;
		try {
			int YIPAtTZG = 0;
			String qKPisDZP;
			if (hAdTnQap.startsWith("jar:/")) {
				qKPisDZP = "file.pdf";
				a7YvoxpS = this.getClass().getResourceAsStream(hAdTnQap.substring(4));
			} else {
				IxITTuEs = new URL(hAdTnQap);
				a7YvoxpS = IxITTuEs.openStream();
				qKPisDZP = IxITTuEs.getPath().substring(IxITTuEs.getPath().lastIndexOf('/') + 1);
				YIPAtTZG = IxITTuEs.openConnection().getContentLength();
			}
			final String uS7GAhDd = qKPisDZP;
			tempURLFile = File.createTempFile(uS7GAhDd.substring(0, uS7GAhDd.lastIndexOf('.')),
					uS7GAhDd.substring(uS7GAhDd.lastIndexOf('.')), new File(ObjectStore.temp_dir));
			FileOutputStream CsAJqtvM = new FileOutputStream(tempURLFile);
			if (visible) {
				download.setLocation((coords.x - (download.getWidth() / 2)), (coords.y - (download.getHeight() / 2)));
				download.setVisible(true);
			}
			if (visible) {
				pb.setMinimum(0);
				pb.setMaximum(YIPAtTZG);
				String NWdBdAG4 = Messages.getMessage("PageLayoutViewMenu.DownloadWindowMessage");
				NWdBdAG4 = NWdBdAG4.replaceAll("FILENAME", uS7GAhDd);
				downloadFile.setText(NWdBdAG4);
				Font JU0wQLU2 = turnOff.getFont();
				turnOff.setFont(new Font(JU0wQLU2.getName(), JU0wQLU2.getStyle(), 8));
				turnOff.setAlignmentY(JLabel.RIGHT_ALIGNMENT);
				turnOff.setText(Messages.getMessage("PageLayoutViewMenu.DownloadWindowTurnOff"));
			}
			byte[] bFKCiccO = new byte[4096];
			int RAUUX2Mq;
			int m8ziFdS0 = 0;
			String u76aFTzY = "kb";
			int STMq7P8a = 1000;
			if (YIPAtTZG > 1000000) {
				u76aFTzY = "mb";
				STMq7P8a = 1000000;
			}
			if (visible) {
				progress = Messages.getMessage("PageLayoutViewMenu.DownloadWindowProgress");
				if (YIPAtTZG < 1000000)
					progress = progress.replaceAll("DVALUE", (YIPAtTZG / STMq7P8a) + " " + u76aFTzY);
				else {
					String pSnqQHyD = String.valueOf(((YIPAtTZG % STMq7P8a) / 10000));
					if (((YIPAtTZG % STMq7P8a) / 10000) < 10)
						pSnqQHyD = "0" + pSnqQHyD;
					progress = progress.replaceAll("DVALUE", (YIPAtTZG / STMq7P8a) + "." + pSnqQHyD + " " + u76aFTzY);
				}
			}
			while ((RAUUX2Mq = a7YvoxpS.read(bFKCiccO)) != -1) {
				m8ziFdS0 = m8ziFdS0 + RAUUX2Mq;
				downloadCount = downloadCount + RAUUX2Mq;
				if (visible) {
					if (YIPAtTZG < 1000000)
						downloadMessage.setText(progress.replaceAll("DSOME", (m8ziFdS0 / STMq7P8a) + " " + u76aFTzY));
					else {
						String oXvAjgPe = String.valueOf(((m8ziFdS0 % STMq7P8a) / 10000));
						if (((m8ziFdS0 % STMq7P8a) / 10000) < 10)
							oXvAjgPe = "0" + oXvAjgPe;
						downloadMessage.setText(
								progress.replaceAll("DSOME", (m8ziFdS0 / STMq7P8a) + "." + oXvAjgPe + " " + u76aFTzY));
					}
					pb.setValue(m8ziFdS0);
					download.repaint();
				}
				CsAJqtvM.write(bFKCiccO, 0, RAUUX2Mq);
			}
			CsAJqtvM.flush();
			a7YvoxpS.close();
			CsAJqtvM.close();
			if (visible)
				downloadMessage.setText("Download of " + uS7GAhDd + " is complete.");
		} catch (Exception O3sjGYi2) {
			LogWriter.writeLog("[PDF] Exception " + O3sjGYi2 + " opening URL " + hAdTnQap);
			O3sjGYi2.printStackTrace();
		}
		if (visible)
			download.setVisible(false);
		return tempURLFile;
	}

}