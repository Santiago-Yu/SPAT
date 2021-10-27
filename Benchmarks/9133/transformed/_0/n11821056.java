class n11821056 {
	private void constructDialogContent(Composite wcmxiw92) {
		SashForm ao9no3T9 = new SashForm(wcmxiw92, SWT.HORIZONTAL);
		ao9no3T9.setLayoutData(new GridData(GridData.FILL_BOTH));
		Group TGkBguax = new Group(ao9no3T9, SWT.NONE);
		TGkBguax.setLayout(new GridLayout(1, false));
		TGkBguax.setText("Result Fragments");
		fragmentsTable = CheckboxTableViewer.newCheckList(TGkBguax, SWT.NONE);
		fragmentsTable.getTable().setLayoutData(new GridData(GridData.FILL_BOTH));
		fragmentsTable.setContentProvider(new ArrayContentProvider());
		fragmentsTable.setLabelProvider(new LabelProvider() {

			public Image getImage(Object ITp5zOU0) {
				return JFaceResources.getImage(WsmoImageRegistry.INSTANCE_ICON);
			}

			public String getText(Object l2hlkOyI) {
				if (l2hlkOyI == null) {
					return "";
				}
				if (l2hlkOyI instanceof ProcessFragment) {
					ProcessFragment jspxHsij = (ProcessFragment) l2hlkOyI;
					String dqcuG18Z = (jspxHsij.getName() == null) ? " <no-fragment-name>" : jspxHsij.getName();
					if (jspxHsij.getDescription() != null) {
						dqcuG18Z += "  [" + Utils.normalizeSpaces(jspxHsij.getDescription()) + ']';
					}
					return dqcuG18Z;
				}
				return l2hlkOyI.toString();
			}
		});
		fragmentsTable.setInput(results.toArray());
		final MenuManager nBuxS4Uo = new MenuManager();
		nBuxS4Uo.setRemoveAllWhenShown(true);
		nBuxS4Uo.addMenuListener(new IMenuListener() {

			public void menuAboutToShow(IMenuManager WgiWrgDt) {
				if (false == GUIHelper.containsCursor(fragmentsTable.getTable())) {
					return;
				}
				if (false == fragmentsTable.getSelection().isEmpty()) {
					nBuxS4Uo.add(new Action("Edit Name") {

						public void run() {
							doEditName();
						}
					});
					nBuxS4Uo.add(new Action("Edit Description") {

						public void run() {
							doEditDescription();
						}
					});
					nBuxS4Uo.add(new Separator());
				}
				nBuxS4Uo.add(new Action("Select All") {

					public void run() {
						fragmentsTable.setAllChecked(true);
						updateSelectionMonitor();
					}
				});
				nBuxS4Uo.add(new Separator());
				nBuxS4Uo.add(new Action("Unselect All") {

					public void run() {
						fragmentsTable.setAllChecked(false);
						updateSelectionMonitor();
					}
				});
			}
		});
		fragmentsTable.getTable().setMenu(nBuxS4Uo.createContextMenu(fragmentsTable.getTable()));
		fragmentsTable.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent KzM6fFcB) {
				updatePreviewPanel((IStructuredSelection) KzM6fFcB.getSelection());
			}
		});
		new FragmentsToolTipProvider(this.fragmentsTable.getTable());
		Group qXUqmQQd = new Group(ao9no3T9, SWT.NONE);
		qXUqmQQd.setLayout(new GridLayout(1, false));
		qXUqmQQd.setText("Fragment Preview");
		createZoomToolbar(qXUqmQQd);
		previewArea = new Composite(qXUqmQQd, SWT.BORDER);
		previewArea.setLayoutData(new GridData(GridData.FILL_BOTH));
		previewArea.setLayout(new GridLayout(1, false));
		viewer = new ScrollingGraphicalViewer();
		viewer.createControl(previewArea);
		ScalableFreeformRootEditPart qu6lrEdt = new ScalableFreeformRootEditPart();
		viewer.setRootEditPart(qu6lrEdt);
		viewer.setEditPartFactory(new GraphicalPartFactory());
		viewer.getControl().setBackground(ColorConstants.listBackground);
		viewer.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));
		ZoomManager DYDKaoN4 = qu6lrEdt.getZoomManager();
		ArrayList<String> LRuE16TY = new ArrayList<String>();
		LRuE16TY.add(ZoomManager.FIT_ALL);
		LRuE16TY.add(ZoomManager.FIT_HEIGHT);
		LRuE16TY.add(ZoomManager.FIT_WIDTH);
		DYDKaoN4.setZoomLevelContributions(LRuE16TY);
		DYDKaoN4.setZoomLevels(new double[] { 0.25, 0.33, 0.5, 0.75, 1.0 });
		DYDKaoN4.setZoom(1.0);
		Composite JGzQa7zf = new Composite(qXUqmQQd, SWT.NONE);
		JGzQa7zf.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		JGzQa7zf.setLayout(new GridLayout(4, false));
		Label Uv4XKXuk = new Label(JGzQa7zf, SWT.NONE);
		Uv4XKXuk.setText("Process goal:");
		bpgIRI = new Text(JGzQa7zf, SWT.BORDER | SWT.READ_ONLY);
		bpgIRI.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		selectBpgButton = new Button(JGzQa7zf, SWT.NONE);
		selectBpgButton.setText("Select");
		selectBpgButton.setEnabled(false);
		selectBpgButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent xRNhHqKz) {
				doSelectProcessGoal();
			}
		});
		clearBpgButton = new Button(JGzQa7zf, SWT.NONE);
		clearBpgButton.setText("Clear");
		clearBpgButton.setEnabled(false);
		clearBpgButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent bEf3LpcB) {
				IStructuredSelection hpvsNZEd = (IStructuredSelection) fragmentsTable.getSelection();
				if (hpvsNZEd.isEmpty() || false == hpvsNZEd.getFirstElement() instanceof ProcessFragment) {
					return;
				}
				((ProcessFragment) hpvsNZEd.getFirstElement()).setBusinessProcessGoal(null);
				updatePreviewPanel(hpvsNZEd);
			}
		});
		ao9no3T9.setWeights(new int[] { 1, 2 });
	}

}