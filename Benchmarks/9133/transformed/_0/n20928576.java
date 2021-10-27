class n20928576 {
	@Override
	protected Control createDialogArea(final Composite z5bCiewV) {
		this.area = new Composite((Composite) super.createDialogArea(z5bCiewV), SWT.NONE);
		this.area.setLayout(new FillLayout());
		this.area.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		this.scrolledComposite = new ScrolledComposite(this.area, SWT.V_SCROLL | SWT.H_SCROLL);
		this.scrolledComposite.setLayout(new FillLayout());
		this.scrolledComposite.setExpandVertical(true);
		this.scrolledComposite.setExpandHorizontal(true);
		ViewForm Ucf5CigU = new ViewForm(this.scrolledComposite, SWT.BORDER | SWT.FLAT);
		Ucf5CigU.horizontalSpacing = 0;
		Ucf5CigU.verticalSpacing = 0;
		ToolBarManager cJoAZNko = new ToolBarManager(SWT.FLAT | SWT.HORIZONTAL | SWT.RIGHT);
		long n8dFbewi = InformationUtil.getChildByType(this.image, ImagePlugin.NODE_NAME_WIDTH).getLongValue();
		long Ku0CRs5P = InformationUtil.getChildByType(this.image, ImagePlugin.NODE_NAME_HEIGHT).getLongValue();
		this.graphicalViewer = new ScrollingGraphicalViewer();
		ScalableRootEditPart nTx3nsYe = new ScalableRootEditPart();
		this.graphicalViewer.setRootEditPart(nTx3nsYe);
		this.graphicalViewer.setEditDomain(new EditDomain());
		this.graphicalViewer.setEditPartFactory(new ImageLinkEditPartFactory(this.editingDomain));
		this.canvas = (FigureCanvas) this.graphicalViewer.createControl(Ucf5CigU);
		this.canvas.getHorizontalBar().setVisible(true);
		this.canvas.getVerticalBar().setVisible(true);
		this.graphicalViewer.setContents(this.image);
		DeleteCommentAction GNSJ5xqD = new DeleteCommentAction(this.image);
		GNSJ5xqD.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ETOOL_DELETE));
		CreateCommentAction sRDnmB4S = new CreateCommentAction(this.image);
		sRDnmB4S.setEditingDomain(this.editingDomain);
		GNSJ5xqD.setEditingDomain(this.editingDomain);
		cJoAZNko.add(sRDnmB4S);
		cJoAZNko.add(GNSJ5xqD);
		this.scrolledComposite.setContent(Ucf5CigU);
		this.graphicalViewer.addSelectionChangedListener(GNSJ5xqD);
		Ucf5CigU.setTopLeft(cJoAZNko.createControl(Ucf5CigU));
		Ucf5CigU.setContent(this.canvas);
		GridData ixP1zGeg = new GridData(SWT.BEGINNING, SWT.TOP);
		ixP1zGeg.widthHint = (int) n8dFbewi;
		ixP1zGeg.heightHint = (int) Ku0CRs5P;
		this.canvas.setLayoutData(ixP1zGeg);
		Ucf5CigU.addControlListener(new ControlAdapter() {

			@Override
			public void controlResized(final ControlEvent Q0JuKuFC) {
				CommentImageDialog.this.canvas.redraw();
				super.controlResized(Q0JuKuFC);
			}
		});
		setTitle(Messages.CommentImageDialog_Title);
		setMessage(Messages.CommentImageDialog_Message);
		setTitleImage(ResourceManager.getPluginImage(ImagePlugin.getDefault(),
				"icons/iconexperience/comment_wizard_title.png"));
		return this.area;
	}

}