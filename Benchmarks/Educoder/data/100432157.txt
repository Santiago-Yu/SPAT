    private void downloadFiles() {
        SwingWorker<Double, RaphPhotoGalleryPhoto> downloadFilesWorker = new SwingWorker<Double, RaphPhotoGalleryPhoto>() {

            Date startDownloadDate;

            @Override
            public Double doInBackground() {
                startDownloadDate = new Date();
                refreshSpeed = 0;
                lastDate = null;
                try {
                    int totalSizeRead = 0;
                    int totalNumberRead = 0;
                    for (RaphPhotoGalleryPhoto photo : photoList) {
                        URL url = new URL(getCodeBase().toString() + photo.getUrl());
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        DataInputStream dis = new DataInputStream(connection.getInputStream());
                        FileOutputStream fos = new FileOutputStream(destinationDirectory.toString() + "/" + photo.getFileName());
                        byte[] b = new byte[65536];
                        int sizeRead;
                        photo.setProcessedSize(0);
                        totalNumberRead++;
                        while ((sizeRead = dis.read(b)) > -1) {
                            fos.write(b, 0, sizeRead);
                            totalSizeRead += sizeRead;
                            photo.addToProcessedSize(sizeRead);
                            photo.setTotalProcessedSize(totalSizeRead);
                            photo.setTotalProcessedNumber(totalNumberRead);
                            publish(photo);
                            try {
                            } catch (Exception ignore) {
                            }
                        }
                        fos.close();
                    }
                } catch (MalformedURLException e1) {
                    System.err.println("MalformedURLException: " + e1);
                } catch (IOException e2) {
                    System.err.println("IOException: " + e2);
                }
                long totalDiffTime = (new Date()).getTime() - startDownloadDate.getTime();
                double totalSpeed = photoListTotalSize / (totalDiffTime / 1000);
                return new Double(totalSpeed);
            }

            @Override
            protected void process(List<RaphPhotoGalleryPhoto> list) {
                RaphPhotoGalleryPhoto photo = list.get(list.size() - 1);
                progressBarTotal.setMaximum(photoListTotalSize);
                progressBarTotal.setValue(photo.getTotalProcessedSize());
                setProgressBarTotalLabels(photo.getTotalProcessedNumber(), photoList.size(), photoListTotalSize - photo.getTotalProcessedSize());
                progressBarCurrent.setMaximum(photo.getFileSize());
                progressBarCurrent.setValue(photo.getProcessedSize());
                progressBarCurrentLabel.setText(photo.getFileName());
                long diffTime = 0;
                if (lastDate == null) lastDate = new Date();
                diffTime = (new Date()).getTime() - lastDate.getTime();
                if (diffTime > 1000) {
                    double currentSpeed = (photo.getTotalProcessedSize() - lastTotalSize) / (diffTime / 1000.0);
                    if (currentSpeed > 0) lastSpeed.add(new Double(currentSpeed));
                    if (lastSpeed.size() == 10) lastSpeed.removeFirst();
                    double speed = 0;
                    for (Double d : lastSpeed) {
                        speed += d.doubleValue();
                    }
                    speed = Math.round(speed / lastSpeed.size());
                    if (refreshSpeed == 0) {
                        long totalDiffTime = (new Date()).getTime() - startDownloadDate.getTime();
                        double totalSpeed = (photo.getTotalProcessedSize()) / (totalDiffTime / 1000.0);
                        remainingTime = (photoListTotalSize - photo.getTotalProcessedSize()) / totalSpeed;
                        if (remainingTime < 8) refreshSpeed = 0; else refreshSpeed = 3;
                    } else {
                        refreshSpeed--;
                        remainingTime -= diffTime / 1000.0;
                    }
                    speedLabel.setText(String.format("%.0f", speed / 1024) + " " + getParameter("i18n_speedUnit") + " :  " + String.format("%.0f", remainingTime) + " s");
                    lastDate = new Date();
                    lastTotalSize = photo.getTotalProcessedSize();
                }
            }

            @Override
            protected void done() {
                try {
                    speedLabel.setText(String.format("%.0f", get().doubleValue() / 1024) + " " + getParameter("i18n_speedUnit"));
                    downloadButton.setText(getParameter("i18n_finished"));
                    downloadState = 2;
                } catch (Exception ignore) {
                }
            }
        };
        downloadFilesWorker.execute();
    }
