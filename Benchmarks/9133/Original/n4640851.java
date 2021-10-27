class n4640851{
    private void menuOpenURL() {
        animate = false;
        resetScaleCombos();
        InputDialog dialog = new InputDialog(shell, "Open URL Dialog", "Enter URL of the image", "http://", new IInputValidator() {

            @Override
            public String isValid(String newText) {
                if (newText.startsWith("http://") || newText.startsWith("https://") || newText.startsWith("ftp://") || newText.startsWith("file://")) return newText;
                return null;
            }
        });
        if (dialog.open() == SWT.CANCEL) return;
        String urlName = dialog.getValue();
        Cursor waitCursor = new Cursor(display, SWT.CURSOR_WAIT);
        shell.setCursor(waitCursor);
        imageCanvas.setCursor(waitCursor);
        try {
            URL url = new URL(urlName);
            InputStream stream = url.openStream();
            loader = new ImageLoader();
            if (incremental) {
                loader.addImageLoaderListener(new ImageLoaderListener() {

                    public void imageDataLoaded(ImageLoaderEvent event) {
                        incrementalDataLoaded(event);
                    }
                });
                incrementalThreadStart();
            }
            imageDataArray = loader.load(stream);
            stream.close();
            if (imageDataArray.length > 0) {
                currentName = urlName;
                fileName = null;
                previousButton.setEnabled(imageDataArray.length > 1);
                nextButton.setEnabled(imageDataArray.length > 1);
                animateButton.setEnabled(imageDataArray.length > 1 && loader.logicalScreenWidth > 0 && loader.logicalScreenHeight > 0);
                imageDataIndex = 0;
                displayImage(imageDataArray[imageDataIndex]);
                resetScrollBars();
            }
        } catch (Exception e) {
            showErrorDialog("Loading", urlName, e);
        } finally {
            shell.setCursor(null);
            imageCanvas.setCursor(crossCursor);
            waitCursor.dispose();
        }
    }

}