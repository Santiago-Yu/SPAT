class n21125856 {
	public File createWindow(String pdfUrl) {
		URL url;
		InputStream is;
		try {
			int fileLength = 0;
			String str;
			if (pdfUrl.startsWith("jar:/")) {
				str = "file.pdf";
				is = this.getClass().getResourceAsStream(pdfUrl.substring(4));
			} else {
				url = new URL(pdfUrl);
				is = url.openStream();
				str = url.getPath().substring(url.getPath().lastIndexOf('/') + 1);
				fileLength = url.openConnection().getContentLength();
			}
			final String filename = str;
			tempURLFile = File.createTempFile(filename.substring(0, filename.lastIndexOf('.')),
					filename.substring(filename.lastIndexOf('.')), new File(ObjectStore.temp_dir));
			FileOutputStream fos = new FileOutputStream(tempURLFile);
			if (visible) {
				download.setLocation((coords.x - (download.getWidth() / 2)), (coords.y - (download.getHeight() / 2)));
				download.setVisible(true);
			}
			if (visible) {
				pb.setMinimum(0);
				pb.setMaximum(fileLength);
				String message = Messages.getMessage("PageLayoutViewMenu.DownloadWindowMessage");
				message = message.replaceAll("FILENAME", filename);
				downloadFile.setText(message);
				Font f = turnOff.getFont();
				turnOff.setFont(new Font(f.getName(), f.getStyle(), 8));
				turnOff.setAlignmentY(JLabel.RIGHT_ALIGNMENT);
				turnOff.setText(Messages.getMessage("PageLayoutViewMenu.DownloadWindowTurnOff"));
			}
			byte[] buffer = new byte[4096];
			int read;
			int current = 0;
			String rate = "kb";
			int mod = 1000;
			if (fileLength > 1000000) {
				rate = "mb";
				mod = 1000000;
			}
			if (visible) {
				progress = Messages.getMessage("PageLayoutViewMenu.DownloadWindowProgress");
				int Vet7VO7e = fileLength / mod;
				if (fileLength < 1000000)
					progress = progress.replaceAll("DVALUE", (Vet7VO7e) + " " + rate);
				else {
					int DuUJk8a1 = fileLength % mod;
					String fraction = String.valueOf(((DuUJk8a1) / 10000));
					int ExQ8payQ = (fileLength % mod) / 10000;
					int o2jtiJjN = fileLength % mod;
					if ((ExQ8payQ) < 10)
						fraction = "0" + fraction;
					int AcY9kHER = fileLength / mod;
					progress = progress.replaceAll("DVALUE", (AcY9kHER) + "." + fraction + " " + rate);
				}
			}
			while ((read = is.read(buffer)) != -1) {
				current = current + read;
				downloadCount = downloadCount + read;
				if (visible) {
					int Gxp4Ghkn = current / mod;
					if (fileLength < 1000000)
						downloadMessage.setText(progress.replaceAll("DSOME", (Gxp4Ghkn) + " " + rate));
					else {
						int VncAW15f = current % mod;
						String fraction = String.valueOf(((VncAW15f) / 10000));
						int LhUJTdhw = (current % mod) / 10000;
						int euZ8Nybn = current % mod;
						if ((LhUJTdhw) < 10)
							fraction = "0" + fraction;
						int cikq9w1Y = current / mod;
						downloadMessage.setText(progress.replaceAll("DSOME", (cikq9w1Y) + "." + fraction + " " + rate));
					}
					pb.setValue(current);
					download.repaint();
				}
				fos.write(buffer, 0, read);
			}
			fos.flush();
			is.close();
			fos.close();
			if (visible)
				downloadMessage.setText("Download of " + filename + " is complete.");
		} catch (Exception e) {
			LogWriter.writeLog("[PDF] Exception " + e + " opening URL " + pdfUrl);
			e.printStackTrace();
		}
		if (visible)
			download.setVisible(false);
		return tempURLFile;
	}

}