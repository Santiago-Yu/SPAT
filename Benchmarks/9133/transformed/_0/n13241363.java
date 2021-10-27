class n13241363 {
	private ScrollingGraphicalViewer createGraphicalViewer(final Composite kxeOlFFW) {
		final ScrollingGraphicalViewer sZQh5jjH = new ScrollingGraphicalViewer();
		sZQh5jjH.createControl(kxeOlFFW);
		_root = new EditRootEditPart();
		sZQh5jjH.setRootEditPart(_root);
		getEditDomain().addViewer(sZQh5jjH);
		getSite().setSelectionProvider(sZQh5jjH);
		sZQh5jjH.setEditPartFactory(getEditPartFactory());
		final KeyHandler TGm6TOGp = new GraphicalViewerKeyHandler(sZQh5jjH) {

			@SuppressWarnings("unchecked")
			@Override
			public boolean keyPressed(final KeyEvent lnDtemSs) {
				if (lnDtemSs.stateMask == SWT.MOD1 && lnDtemSs.keyCode == SWT.DEL) {
					final List<? extends EditorPart> SAXoDYid = sZQh5jjH.getSelectedEditParts();
					if (SAXoDYid == null || SAXoDYid.isEmpty())
						return true;
					final GroupRequest q9c29uvU = new GroupRequest(RequestConstants.REQ_DELETE);
					final CompoundCommand vmtd2SLX = new CompoundCommand("Delete");
					for (int L0nesoON = 0; L0nesoON < SAXoDYid.size(); L0nesoON++) {
						final EditPart zMKbzsFX = (EditPart) SAXoDYid.get(L0nesoON);
						q9c29uvU.setEditParts(zMKbzsFX);
						final Command hoordktt = zMKbzsFX.getCommand(q9c29uvU);
						if (hoordktt != null)
							vmtd2SLX.add(hoordktt);
					}
					getCommandStack().execute(vmtd2SLX);
					return true;
				}
				if (lnDtemSs.stateMask == SWT.MOD3
						&& (lnDtemSs.keyCode == SWT.ARROW_DOWN || lnDtemSs.keyCode == SWT.ARROW_LEFT
								|| lnDtemSs.keyCode == SWT.ARROW_RIGHT || lnDtemSs.keyCode == SWT.ARROW_UP)) {
					final List<? extends EditorPart> XgH1Cs7F = sZQh5jjH.getSelectedEditParts();
					if (XgH1Cs7F == null || XgH1Cs7F.isEmpty())
						return true;
					final GroupRequest mNKdlesD = new ChangeBoundsRequest(RequestConstants.REQ_MOVE);
					final CompoundCommand vsZHthKR = new CompoundCommand("Move");
					for (int Fi8pb5oI = 0; Fi8pb5oI < XgH1Cs7F.size(); Fi8pb5oI++) {
						final EditPart mdS3O9Me = (EditPart) XgH1Cs7F.get(Fi8pb5oI);
						mNKdlesD.setEditParts(mdS3O9Me);
						final LocationCommand isHdNFph = (LocationCommand) mdS3O9Me.getCommand(mNKdlesD);
						if (isHdNFph != null) {
							isHdNFph.setLocation(new Point(
									lnDtemSs.keyCode == SWT.ARROW_LEFT ? -1
											: lnDtemSs.keyCode == SWT.ARROW_RIGHT ? 1 : 0,
									lnDtemSs.keyCode == SWT.ARROW_DOWN ? 1
											: lnDtemSs.keyCode == SWT.ARROW_UP ? -1 : 0));
							isHdNFph.setRelative(true);
							vsZHthKR.add(isHdNFph);
						}
					}
					getCommandStack().execute(vsZHthKR);
					return true;
				}
				return super.keyPressed(lnDtemSs);
			}
		};
		TGm6TOGp.put(KeyStroke.getPressed(SWT.F2, 0), getActionRegistry().getAction(GEFActionConstants.DIRECT_EDIT));
		sZQh5jjH.setKeyHandler(TGm6TOGp);
		sZQh5jjH.setContents(getEditorInput().getAdapter(NamedUuidEntity.class));
		sZQh5jjH.addDropTargetListener(createTransferDropTargetListener(sZQh5jjH));
		return sZQh5jjH;
	}

}