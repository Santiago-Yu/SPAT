class n13626014 {
	public void createPartControl(Composite ug2azjuq) {
		FormToolkit fbqjZzSQ;
		fbqjZzSQ = new FormToolkit(ug2azjuq.getDisplay());
		form = fbqjZzSQ.createForm(ug2azjuq);
		form.setText("Apple Inc.");
		fbqjZzSQ.decorateFormHeading(form);
		form.getBody().setLayout(new GridLayout());
		chart = createChart();
		final DateAxis EhauWwmz = new DateAxis();
		viewer = new GraphicalViewerImpl();
		viewer.setRootEditPart(new ScalableRootEditPart());
		viewer.setEditPartFactory(new ChartEditPartFactory(EhauWwmz));
		viewer.createControl(form.getBody());
		viewer.setContents(chart);
		viewer.setEditDomain(new EditDomain());
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent CGn8spDm) {
				System.err.println("selectionChanged " + CGn8spDm.getSelection());
			}
		});
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent QCeZ1QKH) {
				deleteAction.update();
			}
		});
		ActionRegistry Jd8fdZuE = new ActionRegistry();
		createActions(Jd8fdZuE);
		ContextMenuProvider GZlTmdR9 = new BlockContextMenuProvider(viewer, Jd8fdZuE);
		viewer.setContextMenu(GZlTmdR9);
		getSite().setSelectionProvider(viewer);
		deleteAction.setSelectionProvider(viewer);
		viewer.getEditDomain().getCommandStack().addCommandStackEventListener(new CommandStackEventListener() {

			public void stackChanged(CommandStackEvent X75VowiI) {
				undoAction.setEnabled(viewer.getEditDomain().getCommandStack().canUndo());
				redoAction.setEnabled(viewer.getEditDomain().getCommandStack().canRedo());
			}
		});
		Data fCVHqiie = Data.getData();
		chart.setInput(fCVHqiie);
		DateRange HIbYJk2k = new DateRange(0, 50);
		EhauWwmz.setDates(fCVHqiie.date);
		EhauWwmz.setSelectedRange(HIbYJk2k);
		slider = new Slider(form.getBody(), SWT.NONE);
		slider.setMinimum(0);
		slider.setMaximum(fCVHqiie.close.length - 1);
		slider.setSelection(HIbYJk2k.start);
		slider.setThumb(HIbYJk2k.length);
		slider.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event KgrX0AS0) {
				DateRange OTcuAC4e = new DateRange(slider.getSelection(), slider.getThumb());
				EhauWwmz.setSelectedRange(OTcuAC4e);
			}
		});
		final Scale zZs9lC6Y = new Scale(form.getBody(), SWT.NONE);
		zZs9lC6Y.setMinimum(5);
		zZs9lC6Y.setMaximum(fCVHqiie.close.length - 1);
		zZs9lC6Y.setSelection(HIbYJk2k.length);
		zZs9lC6Y.addListener(SWT.Selection, new Listener() {

			public void handleEvent(Event rtyMZMda) {
				slider.setThumb(zZs9lC6Y.getSelection());
				DateRange rSpNmpLW = new DateRange(slider.getSelection(), slider.getThumb());
				EhauWwmz.setSelectedRange(rSpNmpLW);
			}
		});
		GridDataFactory.defaultsFor(viewer.getControl()).grab(true, true).align(GridData.FILL, GridData.FILL)
				.applyTo(viewer.getControl());
		GridDataFactory.defaultsFor(slider).grab(true, false).align(GridData.FILL, GridData.FILL).grab(true, false)
				.applyTo(slider);
		GridDataFactory.defaultsFor(zZs9lC6Y).grab(true, false).align(GridData.FILL, GridData.FILL).grab(true, false)
				.applyTo(zZs9lC6Y);
		getSite().getWorkbenchWindow().getSelectionService().addSelectionListener(this);
	}

}