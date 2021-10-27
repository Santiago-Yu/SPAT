class n1526593 {
	protected Control createContents(Composite Kk7gPyl1) {
		this.getShell().setText("Chisio");
		this.getShell().setSize(800, 600);
		this.getShell()
				.setImage(ImageDescriptor.createFromFile(ChisioMain.class, "icon/chisio-icon.png").createImage());
		Composite NiXW5bEy = new Composite(Kk7gPyl1, SWT.BORDER);
		NiXW5bEy.setLayout(new FillLayout());
		this.viewer = new ScrollingGraphicalViewer();
		this.viewer.setEditDomain(this.editDomain);
		this.viewer.createControl(NiXW5bEy);
		this.viewer.getControl().setBackground(ColorConstants.white);
		this.rootEditPart = new ChsScalableRootEditPart();
		this.viewer.setRootEditPart(this.rootEditPart);
		this.viewer.setEditPartFactory(new ChsEditPartFactory());
		((FigureCanvas) this.viewer.getControl()).setScrollBarVisibility(FigureCanvas.ALWAYS);
		this.viewer.addDropTargetListener(new ChsFileDropTargetListener(this.viewer, this));
		this.viewer.addDragSourceListener(new ChsFileDragSourceListener(this.viewer));
		CompoundModel eB4pIy8d = new CompoundModel();
		eB4pIy8d.setAsRoot();
		this.viewer.setContents(eB4pIy8d);
		this.viewer.getControl().addMouseListener(this);
		this.popupManager = new PopupManager(this);
		this.popupManager.setRemoveAllWhenShown(true);
		this.popupManager.addMenuListener(new IMenuListener() {

			public void menuAboutToShow(IMenuManager NJdStxat) {
				ChisioMain.this.popupManager.createActions(NJdStxat);
			}
		});
		KeyHandler ebtD64za = new KeyHandler();
		ActionRegistry qe6Y4aVj = new ActionRegistry();
		ebtD64za.put(KeyStroke.getPressed(SWT.DEL, 127, 0), new DeleteAction(this.viewer));
		ebtD64za.put(KeyStroke.getPressed('+', SWT.KEYPAD_ADD, 0), new ZoomAction(this, 1, null));
		ebtD64za.put(KeyStroke.getPressed('-', SWT.KEYPAD_SUBTRACT, 0), new ZoomAction(this, -1, null));
		ebtD64za.put(KeyStroke.getPressed(SWT.F2, 0), qe6Y4aVj.getAction(GEFActionConstants.DIRECT_EDIT));
		this.viewer.setKeyHandler(ebtD64za);
		this.higlightColor = ColorConstants.yellow;
		this.createCombos();
		return NiXW5bEy;
	}

}