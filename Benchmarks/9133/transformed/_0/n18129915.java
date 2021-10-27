class n18129915 {
	private void album(String mTF79AnL, String KURU11aT, URL EuT0x3hi) {
		try {
			if (color == SWT.COLOR_WHITE) {
				color = SWT.COLOR_GRAY;
			} else {
				color = SWT.COLOR_WHITE;
			}
			EuT0x3hi.openConnection();
			InputStream jGCMRpBE = EuT0x3hi.openStream();
			Image vjbDGnRP = new Image(this.getDisplay(), jGCMRpBE);
			Composite Ha03Ucgh = new Composite(main, SWT.NONE);
			Ha03Ucgh.setLayout(new FormLayout());
			FormData YlJ7kJ5z = new FormData();
			YlJ7kJ5z.left = new FormAttachment(0, 5);
			YlJ7kJ5z.right = new FormAttachment(100, -5);
			if (prevCompo == null) {
				YlJ7kJ5z.top = new FormAttachment(0, 0);
			} else {
				YlJ7kJ5z.top = new FormAttachment(prevCompo, 0, SWT.BOTTOM);
			}
			Ha03Ucgh.setLayoutData(YlJ7kJ5z);
			Ha03Ucgh.setBackground(Display.getDefault().getSystemColor(color));
			Label Zo7m09eO = new Label(Ha03Ucgh, SWT.LEFT);
			Zo7m09eO.setText("cover");
			Zo7m09eO.setImage(vjbDGnRP);
			YlJ7kJ5z = new FormData(75, 75);
			Zo7m09eO.setLayoutData(YlJ7kJ5z);
			Label N98CxK8i = new Label(Ha03Ucgh, SWT.CENTER);
			N98CxK8i.setFont(new Font(this.getDisplay(), "Arial", 10, SWT.BOLD));
			N98CxK8i.setText(mTF79AnL);
			YlJ7kJ5z = new FormData();
			YlJ7kJ5z.bottom = new FormAttachment(50, -5);
			YlJ7kJ5z.left = new FormAttachment(Zo7m09eO, 5);
			N98CxK8i.setBackground(Display.getDefault().getSystemColor(color));
			N98CxK8i.setLayoutData(YlJ7kJ5z);
			Label D5QjzGty = new Label(Ha03Ucgh, SWT.LEFT | SWT.BOLD);
			D5QjzGty.setFont(new Font(this.getDisplay(), "Arial", 8, SWT.ITALIC));
			D5QjzGty.setText("Release date : " + KURU11aT);
			YlJ7kJ5z = new FormData();
			YlJ7kJ5z.top = new FormAttachment(50, 5);
			YlJ7kJ5z.left = new FormAttachment(Zo7m09eO, 5);
			D5QjzGty.setBackground(Display.getDefault().getSystemColor(color));
			D5QjzGty.setLayoutData(YlJ7kJ5z);
			prevCompo = Ha03Ucgh;
		} catch (Exception YWZ0lXlW) {
			YWZ0lXlW.printStackTrace();
		}
	}

}