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
			int read, current = 0;
			String rate = "kb";
			int mod = 1000;
			if (fileLength > 1000000) {
				rate = "mb";
				mod = 1000000;
			}
			if (visible) {
				progress = Messages.getMessage("PageLayoutViewMenu.DownloadWindowProgress");
				if (fileLength < 1000000)
					progress = progress.replaceAll("DVALUE", (fileLength / mod) + " " + rate);
				else {
					String fraction = String.valueOf(((fileLength % mod) / 10000));
					if (((fileLength % mod) / 10000) < 10)
						fraction = "0" + fraction;
					progress = progress.replaceAll("DVALUE", (fileLength / mod) + "." + fraction + " " + rate);
				}
			}
			while ((read = is.read(buffer)) != -1) {
				current = current + read;
				downloadCount = downloadCount + read;
				if (visible) {
					if (fileLength < 1000000)
						downloadMessage.setText(progress.replaceAll("DSOME", (current / mod) + " " + rate));
					else {
						String fraction = String.valueOf(((current % mod) / 10000));
						if (((current % mod) / 10000) < 10)
							fraction = "0" + fraction;
						downloadMessage
								.setText(progress.replaceAll("DSOME", (current / mod) + "." + fraction + " " + rate));
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