class n13241363 {
	private ScrollingGraphicalViewer createGraphicalViewer(final Composite parent) {
		final ScrollingGraphicalViewer viewer = new ScrollingGraphicalViewer();
		viewer.createControl(parent);
		_root = new EditRootEditPart();
		viewer.setRootEditPart(_root);
		getEditDomain().addViewer(viewer);
		getSite().setSelectionProvider(viewer);
		viewer.setEditPartFactory(getEditPartFactory());
		final KeyHandler keyHandler = new GraphicalViewerKeyHandler(viewer) {

			@SuppressWarnings("unchecked")
			@Override
			public boolean keyPressed(final KeyEvent event) {
				if (SWT.MOD1 == event.stateMask && SWT.DEL == event.keyCode) {
					final List<? extends EditorPart> objects = viewer.getSelectedEditParts();
					if (null == objects || objects.isEmpty())
						return true;
					final GroupRequest deleteReq = new GroupRequest(RequestConstants.REQ_DELETE);
					final CompoundCommand compoundCmd = new CompoundCommand("Delete");
					for (int i = 0; i < objects.size(); i++) {
						final EditPart object = (EditPart) objects.get(i);
						deleteReq.setEditParts(object);
						final Command cmd = object.getCommand(deleteReq);
						if (cmd != null)
							compoundCmd.add(cmd);
					}
					getCommandStack().execute(compoundCmd);
					return true;
				}
				if (SWT.MOD3 == event.stateMask && (SWT.ARROW_DOWN == event.keyCode || SWT.ARROW_LEFT == event.keyCode
						|| SWT.ARROW_RIGHT == event.keyCode || SWT.ARROW_UP == event.keyCode)) {
					final List<? extends EditorPart> objects = viewer.getSelectedEditParts();
					if (null == objects || objects.isEmpty())
						return true;
					final GroupRequest moveReq = new ChangeBoundsRequest(RequestConstants.REQ_MOVE);
					final CompoundCommand compoundCmd = new CompoundCommand("Move");
					for (int i = 0; i < objects.size(); i++) {
						final EditPart object = (EditPart) objects.get(i);
						moveReq.setEditParts(object);
						final LocationCommand cmd = (LocationCommand) object.getCommand(moveReq);
						if (cmd != null) {
							cmd.setLocation(new Point(
									SWT.ARROW_LEFT == event.keyCode ? -1 : SWT.ARROW_RIGHT == event.keyCode ? 1 : 0,
									SWT.ARROW_DOWN == event.keyCode ? 1 : SWT.ARROW_UP == event.keyCode ? -1 : 0));
							cmd.setRelative(true);
							compoundCmd.add(cmd);
						}
					}
					getCommandStack().execute(compoundCmd);
					return true;
				}
				return super.keyPressed(event);
			}
		};
		keyHandler.put(KeyStroke.getPressed(SWT.F2, 0), getActionRegistry().getAction(GEFActionConstants.DIRECT_EDIT));
		viewer.setKeyHandler(keyHandler);
		viewer.setContents(getEditorInput().getAdapter(NamedUuidEntity.class));
		viewer.addDropTargetListener(createTransferDropTargetListener(viewer));
		return viewer;
	}

}