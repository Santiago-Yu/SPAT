class n23295333 {
	@SuppressWarnings("unchecked")
	protected void initializeGraphicalViewer() {
		GraphicalViewer baet8spW = getGraphicalViewer();
		ScalableRootEditPart M8zJc6Ww = new ScalableRootEditPart();
		baet8spW.setEditPartFactory(new DBEditPartFactory());
		baet8spW.setRootEditPart(M8zJc6Ww);
		ZoomManager H9QQOpxK = M8zJc6Ww.getZoomManager();
		double[] Cfb6Nk4P = new double[] { 0.25, 0.5, 0.75, 1.0, 1.5, 2.0, 2.5, 3.0, 4.0, 5.0, 10.0, 20.0 };
		H9QQOpxK.setZoomLevels(Cfb6Nk4P);
		List<String> oWOWjDrd = new ArrayList<String>();
		oWOWjDrd.add(ZoomManager.FIT_ALL);
		oWOWjDrd.add(ZoomManager.FIT_HEIGHT);
		oWOWjDrd.add(ZoomManager.FIT_WIDTH);
		H9QQOpxK.setZoomLevelContributions(oWOWjDrd);
		getActionRegistry().registerAction(new ZoomInAction(H9QQOpxK));
		getActionRegistry().registerAction(new ZoomOutAction(H9QQOpxK));
		PrintAction hYD7T6dB = new PrintAction(this);
		hYD7T6dB.setText(DBPlugin.getResourceString("action.print"));
		hYD7T6dB.setImageDescriptor(DBPlugin.getImageDescriptor("icons/print.gif"));
		getActionRegistry().registerAction(hYD7T6dB);
		IFile lAXIvgOq = ((IFileEditorInput) getEditorInput()).getFile();
		RootModel yRsX374k = null;
		try {
			yRsX374k = VisualDBSerializer.deserialize(lAXIvgOq.getContents());
		} catch (Exception HFxNCl0h) {
			DBPlugin.logException(HFxNCl0h);
			yRsX374k = new RootModel();
			yRsX374k.setDialectName(DialectProvider.getDialectNames()[0]);
		}
		baet8spW.setContents(yRsX374k);
		final DeleteAction l83RuIHx = new DeleteAction((IWorkbenchPart) this);
		l83RuIHx.setSelectionProvider(getGraphicalViewer());
		getActionRegistry().registerAction(l83RuIHx);
		getGraphicalViewer().addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent zynIdhlZ) {
				l83RuIHx.update();
			}
		});
		MenuManager QjHmrWvE = new MenuManager();
		QjHmrWvE.add(new QuickOutlineAction());
		QjHmrWvE.add(new Separator());
		QjHmrWvE.add(getActionRegistry().getAction(ActionFactory.UNDO.getId()));
		QjHmrWvE.add(getActionRegistry().getAction(ActionFactory.REDO.getId()));
		QjHmrWvE.add(new Separator());
		PasteAction WL3UlA0D = new PasteAction(this);
		getActionRegistry().registerAction(WL3UlA0D);
		getSelectionActions().add(WL3UlA0D.getId());
		QjHmrWvE.add(WL3UlA0D);
		CopyAction msmdahIh = new CopyAction(this, WL3UlA0D);
		getActionRegistry().registerAction(msmdahIh);
		getSelectionActions().add(msmdahIh.getId());
		QjHmrWvE.add(msmdahIh);
		QjHmrWvE.add(getActionRegistry().getAction(ActionFactory.DELETE.getId()));
		QjHmrWvE.add(new Separator());
		QjHmrWvE.add(new AutoLayoutAction(baet8spW));
		QjHmrWvE.add(new DommainEditAction(baet8spW));
		MenuManager AJMbJgsX = new MenuManager(DBPlugin.getResourceString("action.convert"));
		QjHmrWvE.add(AJMbJgsX);
		UppercaseAction bxt1tcqj = new UppercaseAction(this);
		AJMbJgsX.add(bxt1tcqj);
		getActionRegistry().registerAction(bxt1tcqj);
		getSelectionActions().add(bxt1tcqj.getId());
		LowercaseAction IhIXo18C = new LowercaseAction(this);
		AJMbJgsX.add(IhIXo18C);
		getActionRegistry().registerAction(IhIXo18C);
		getSelectionActions().add(IhIXo18C.getId());
		Physical2LogicalAction ZpP9k1iX = new Physical2LogicalAction(this);
		AJMbJgsX.add(ZpP9k1iX);
		getActionRegistry().registerAction(ZpP9k1iX);
		getSelectionActions().add(ZpP9k1iX.getId());
		Logical2PhysicalAction KQVf9rGc = new Logical2PhysicalAction(this);
		AJMbJgsX.add(KQVf9rGc);
		getActionRegistry().registerAction(KQVf9rGc);
		getSelectionActions().add(KQVf9rGc.getId());
		QjHmrWvE.add(new ToggleModelAction(baet8spW));
		QjHmrWvE.add(new ChangeDBTypeAction(baet8spW));
		QjHmrWvE.add(new Separator());
		QjHmrWvE.add(getActionRegistry().getAction(GEFActionConstants.ZOOM_IN));
		QjHmrWvE.add(getActionRegistry().getAction(GEFActionConstants.ZOOM_OUT));
		QjHmrWvE.add(new Separator());
		QjHmrWvE.add(new CopyAsImageAction(baet8spW));
		QjHmrWvE.add(getActionRegistry().getAction(ActionFactory.PRINT.getId()));
		QjHmrWvE.add(new Separator());
		MenuManager PQet16mF = new MenuManager(DBPlugin.getResourceString("action.validation"));
		PQet16mF.add(new ValidateAction(baet8spW));
		PQet16mF.add(new DeleteMarkerAction(baet8spW));
		QjHmrWvE.add(PQet16mF);
		MenuManager Wbr4CI6w = new MenuManager(DBPlugin.getResourceString("action.import"));
		Wbr4CI6w.add(new ImportFromJDBCAction(baet8spW));
		Wbr4CI6w.add(new ImportFromDiagramAction(baet8spW));
		QjHmrWvE.add(Wbr4CI6w);
		MenuManager ATno80pL = new MenuManager(DBPlugin.getResourceString("action.export"));
		IGenerator[] CmO2npm0 = GeneratorProvider.getGeneraters();
		for (int CT5oF1Y4 = 0; CT5oF1Y4 < CmO2npm0.length; CT5oF1Y4++) {
			ATno80pL.add(new GenerateAction(CmO2npm0[CT5oF1Y4], baet8spW, this));
		}
		QjHmrWvE.add(ATno80pL);
		QjHmrWvE.add(new SelectedTablesDDLAction(baet8spW));
		baet8spW.setContextMenu(QjHmrWvE);
		baet8spW.getControl().addMouseListener(new MouseAdapter() {

			public void mouseDoubleClick(MouseEvent v4IjBspn) {
				IStructuredSelection lQmYv0Zj = (IStructuredSelection) getGraphicalViewer().getSelection();
				Object kiepnDMA = lQmYv0Zj.getFirstElement();
				if (kiepnDMA != null && kiepnDMA instanceof IDoubleClickSupport) {
					((IDoubleClickSupport) kiepnDMA).doubleClicked();
				}
			}
		});
		outlinePage = new VisualDBOutlinePage(baet8spW, getEditDomain(), yRsX374k, getSelectionSynchronizer());
		applyPreferences();
		baet8spW.getControl().addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent bKSQfw4b) {
				if (bKSQfw4b.stateMask == SWT.CTRL && bKSQfw4b.keyCode == 'o') {
					new QuickOutlineAction().run();
				}
			}
		});
	}

}