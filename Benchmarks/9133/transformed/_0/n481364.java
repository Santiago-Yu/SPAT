class n481364 {
	private void downloadFiles() {
		SwingWorker<Double, RaphPhotoGalleryPhoto> HIRdQgxi = new SwingWorker<Double, RaphPhotoGalleryPhoto>() {

			Date iYgjcZdC;

			@Override
			public Double doInBackground() {
				iYgjcZdC = new Date();
				refreshSpeed = 0;
				lastDate = null;
				try {
					int aZeVypWl = 0;
					int CPTxdmXj = 0;
					for (RaphPhotoGalleryPhoto z9FC8cS2 : photoList) {
						URL srPdQQfo = new URL(getCodeBase().toString() + z9FC8cS2.getUrl());
						HttpURLConnection oXgz7BGM = (HttpURLConnection) srPdQQfo.openConnection();
						DataInputStream eo1cej3m = new DataInputStream(oXgz7BGM.getInputStream());
						FileOutputStream RNlKfNtf = new FileOutputStream(
								destinationDirectory.toString() + "/" + z9FC8cS2.getFileName());
						byte[] zOQZ1eUa = new byte[65536];
						int HmBviCFL;
						z9FC8cS2.setProcessedSize(0);
						CPTxdmXj++;
						while ((HmBviCFL = eo1cej3m.read(zOQZ1eUa)) > -1) {
							RNlKfNtf.write(zOQZ1eUa, 0, HmBviCFL);
							aZeVypWl += HmBviCFL;
							z9FC8cS2.addToProcessedSize(HmBviCFL);
							z9FC8cS2.setTotalProcessedSize(aZeVypWl);
							z9FC8cS2.setTotalProcessedNumber(CPTxdmXj);
							publish(z9FC8cS2);
							try {
							} catch (Exception aRrJ9Kbz) {
							}
						}
						RNlKfNtf.close();
					}
				} catch (MalformedURLException WOILGXZ5) {
					System.err.println("MalformedURLException: " + WOILGXZ5);
				} catch (IOException hbANnoFd) {
					System.err.println("IOException: " + hbANnoFd);
				}
				long svl3TIwk = (new Date()).getTime() - iYgjcZdC.getTime();
				double h5NsnnRS = photoListTotalSize / (svl3TIwk / 1000);
				return new Double(h5NsnnRS);
			}

			@Override
			protected void process(List<RaphPhotoGalleryPhoto> FxLGUXef) {
				RaphPhotoGalleryPhoto QiKs9dIg = FxLGUXef.get(FxLGUXef.size() - 1);
				progressBarTotal.setMaximum(photoListTotalSize);
				progressBarTotal.setValue(QiKs9dIg.getTotalProcessedSize());
				setProgressBarTotalLabels(QiKs9dIg.getTotalProcessedNumber(), photoList.size(),
						photoListTotalSize - QiKs9dIg.getTotalProcessedSize());
				progressBarCurrent.setMaximum(QiKs9dIg.getFileSize());
				progressBarCurrent.setValue(QiKs9dIg.getProcessedSize());
				progressBarCurrentLabel.setText(QiKs9dIg.getFileName());
				long nnljsOt2 = 0;
				if (lastDate == null)
					lastDate = new Date();
				nnljsOt2 = (new Date()).getTime() - lastDate.getTime();
				if (nnljsOt2 > 1000) {
					double QDAWKIWu = (QiKs9dIg.getTotalProcessedSize() - lastTotalSize) / (nnljsOt2 / 1000.0);
					if (QDAWKIWu > 0)
						lastSpeed.add(new Double(QDAWKIWu));
					if (lastSpeed.size() == 10)
						lastSpeed.removeFirst();
					double eeI42Yzl = 0;
					for (Double Hh8eGlOP : lastSpeed) {
						eeI42Yzl += Hh8eGlOP.doubleValue();
					}
					eeI42Yzl = Math.round(eeI42Yzl / lastSpeed.size());
					if (refreshSpeed == 0) {
						long Zw43pIPQ = (new Date()).getTime() - iYgjcZdC.getTime();
						double LwugYjYO = (QiKs9dIg.getTotalProcessedSize()) / (Zw43pIPQ / 1000.0);
						remainingTime = (photoListTotalSize - QiKs9dIg.getTotalProcessedSize()) / LwugYjYO;
						if (remainingTime < 8)
							refreshSpeed = 0;
						else
							refreshSpeed = 3;
					} else {
						refreshSpeed--;
						remainingTime -= nnljsOt2 / 1000.0;
					}
					speedLabel.setText(String.format("%.0f", eeI42Yzl / 1024) + " " + getParameter("i18n_speedUnit")
							+ " :  " + String.format("%.0f", remainingTime) + " s");
					lastDate = new Date();
					lastTotalSize = QiKs9dIg.getTotalProcessedSize();
				}
			}

			@Override
			protected void done() {
				try {
					speedLabel.setText(
							String.format("%.0f", get().doubleValue() / 1024) + " " + getParameter("i18n_speedUnit"));
					downloadButton.setText(getParameter("i18n_finished"));
					downloadState = 2;
				} catch (Exception p6ZXI7Td) {
				}
			}
		};
		HIRdQgxi.execute();
	}

}