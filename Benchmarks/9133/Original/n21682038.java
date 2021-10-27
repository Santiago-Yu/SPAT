class n21682038{
    public void downloadFrinika() throws Exception {
        if (!frinikaFile.exists()) {
            String urlString = remoteURLPath + frinikaFileName;
            showMessage("Connecting to " + urlString);
            URLConnection uc = new URL(urlString).openConnection();
            progressBar.setIndeterminate(false);
            showMessage("Downloading from " + urlString);
            progressBar.setValue(0);
            progressBar.setMinimum(0);
            progressBar.setMaximum(fileSize);
            InputStream is = uc.getInputStream();
            FileOutputStream fos = new FileOutputStream(frinikaFile);
            byte[] b = new byte[BUFSIZE];
            int c;
            while ((c = is.read(b)) != -1) {
                fos.write(b, 0, c);
                progressBar.setValue(progressBar.getValue() + c);
            }
            fos.close();
        }
    }

}