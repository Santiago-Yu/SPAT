class n4640851 {
	private void menuOpenURL() {
		animate = false;
		resetScaleCombos();
		InputDialog gOJTUjyW = new InputDialog(shell, "Open URL Dialog", "Enter URL of the image", "http://",
				new IInputValidator() {

					@Override
					public String isValid(String rDyl043q) {
						if (rDyl043q.startsWith("http://") || rDyl043q.startsWith("https://")
								|| rDyl043q.startsWith("ftp://") || rDyl043q.startsWith("file://"))
							return rDyl043q;
						return null;
					}
				});
		if (gOJTUjyW.open() == SWT.CANCEL)
			return;
		String MXt3rS5U = gOJTUjyW.getValue();
		Cursor NFttEFbm = new Cursor(display, SWT.CURSOR_WAIT);
		shell.setCursor(NFttEFbm);
		imageCanvas.setCursor(NFttEFbm);
		try {
			URL mbug6VFH = new URL(MXt3rS5U);
			InputStream SzUuqkb7 = mbug6VFH.openStream();
			loader = new ImageLoader();
			if (incremental) {
				loader.addImageLoaderListener(new ImageLoaderListener() {

					public void imageDataLoaded(ImageLoaderEvent pApN77je) {
						incrementalDataLoaded(pApN77je);
					}
				});
				incrementalThreadStart();
			}
			imageDataArray = loader.load(SzUuqkb7);
			SzUuqkb7.close();
			if (imageDataArray.length > 0) {
				currentName = MXt3rS5U;
				fileName = null;
				previousButton.setEnabled(imageDataArray.length > 1);
				nextButton.setEnabled(imageDataArray.length > 1);
				animateButton.setEnabled(
						imageDataArray.length > 1 && loader.logicalScreenWidth > 0 && loader.logicalScreenHeight > 0);
				imageDataIndex = 0;
				displayImage(imageDataArray[imageDataIndex]);
				resetScrollBars();
			}
		} catch (Exception C0ZJdI6J) {
			showErrorDialog("Loading", MXt3rS5U, C0ZJdI6J);
		} finally {
			shell.setCursor(null);
			imageCanvas.setCursor(crossCursor);
			NFttEFbm.dispose();
		}
	}

}