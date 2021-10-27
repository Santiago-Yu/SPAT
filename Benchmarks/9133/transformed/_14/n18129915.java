class n18129915 {
	private void album(String albumTitle, String albumNbSong, URL url) {
		try {
			if (SWT.COLOR_WHITE == color) {
				color = SWT.COLOR_GRAY;
			} else {
				color = SWT.COLOR_WHITE;
			}
			url.openConnection();
			InputStream is = url.openStream();
			Image coverPicture = new Image(this.getDisplay(), is);
			Composite albumComposite = new Composite(main, SWT.NONE);
			albumComposite.setLayout(new FormLayout());
			FormData data = new FormData();
			data.left = new FormAttachment(0, 5);
			data.right = new FormAttachment(100, -5);
			if (null == prevCompo) {
				data.top = new FormAttachment(0, 0);
			} else {
				data.top = new FormAttachment(prevCompo, 0, SWT.BOTTOM);
			}
			albumComposite.setLayoutData(data);
			albumComposite.setBackground(Display.getDefault().getSystemColor(color));
			Label cover = new Label(albumComposite, SWT.LEFT);
			cover.setText("cover");
			cover.setImage(coverPicture);
			data = new FormData(75, 75);
			cover.setLayoutData(data);
			Label title = new Label(albumComposite, SWT.CENTER);
			title.setFont(new Font(this.getDisplay(), "Arial", 10, SWT.BOLD));
			title.setText(albumTitle);
			data = new FormData();
			data.bottom = new FormAttachment(50, -5);
			data.left = new FormAttachment(cover, 5);
			title.setBackground(Display.getDefault().getSystemColor(color));
			title.setLayoutData(data);
			Label nbSong = new Label(albumComposite, SWT.LEFT | SWT.BOLD);
			nbSong.setFont(new Font(this.getDisplay(), "Arial", 8, SWT.ITALIC));
			nbSong.setText("Release date : " + albumNbSong);
			data = new FormData();
			data.top = new FormAttachment(50, 5);
			data.left = new FormAttachment(cover, 5);
			nbSong.setBackground(Display.getDefault().getSystemColor(color));
			nbSong.setLayoutData(data);
			prevCompo = albumComposite;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}