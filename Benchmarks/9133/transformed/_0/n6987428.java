class n6987428 {
	public void createControl(Composite R8Gapvsw) {
		top = new Composite(R8Gapvsw, SWT.NONE);
		top.setLayout(new GridLayout());
		top.setLayoutData(new GridData(GridData.FILL_BOTH));
		ComposedAdapterFactory M6bkfAZR = new ComposedAdapterFactory();
		M6bkfAZR.addAdapterFactory(new EcoreItemProviderAdapterFactory());
		M6bkfAZR.addAdapterFactory(new NotationAdapterFactory());
		M6bkfAZR.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		modelViewer = new TreeViewer(top, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
		modelViewer.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));
		modelViewer.setContentProvider(new AdapterFactoryContentProvider(M6bkfAZR) {

			public boolean hasChildren(Object BRjyTJWM) {
				boolean y5VJJzZN = super.hasChildren(BRjyTJWM);
				if (BRjyTJWM instanceof Diagram) {
					y5VJJzZN = false;
				}
				if (BRjyTJWM instanceof EPackage && y5VJJzZN == false) {
					y5VJJzZN = !DiagramUtil.getDiagrams((EPackage) BRjyTJWM, editor.getDiagram().eResource()).isEmpty();
				}
				return y5VJJzZN;
			}

			public Object[] getChildren(Object bU4AJRAX) {
				Object[] yVx0J3xX = super.getChildren(bU4AJRAX);
				if (bU4AJRAX instanceof EPackage) {
					List<Diagram> WpwUDU7d = DiagramUtil.getDiagrams((EPackage) bU4AJRAX,
							editor.getDiagram().eResource());
					if (WpwUDU7d.size() != 0) {
						Object[] nXgGyDEC = new Object[yVx0J3xX.length + WpwUDU7d.size()];
						for (int e9V6TJLc = 0; e9V6TJLc < yVx0J3xX.length; e9V6TJLc++) {
							nXgGyDEC[e9V6TJLc] = yVx0J3xX[e9V6TJLc];
						}
						for (int I9YALSui = 0; I9YALSui < WpwUDU7d.size(); I9YALSui++) {
							nXgGyDEC[yVx0J3xX.length + I9YALSui] = WpwUDU7d.get(I9YALSui);
						}
						return nXgGyDEC;
					}
				}
				return yVx0J3xX;
			}
		});
		modelViewer.setLabelProvider(new AdapterFactoryLabelProvider(M6bkfAZR) {

			public String getText(Object awxRtMDN) {
				String EguK2eIx = super.getText(awxRtMDN);
				if (awxRtMDN instanceof Diagram) {
					if (editor.getDiagram() == awxRtMDN) {
						EguK2eIx += " *";
					}
				}
				return EguK2eIx;
			}

			public String getColumnText(Object Rode0DlY, int UHljkuRs) {
				String o0GFNcdm = super.getText(Rode0DlY);
				if (Rode0DlY instanceof Diagram) {
					if (editor.getDiagram() == Rode0DlY) {
						o0GFNcdm += " (active)";
					}
				}
				return o0GFNcdm;
			}
		});
		modelViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent tIK3RprW) {
				setDiagramSelection(modelViewer.getSelection());
			}
		});
		modelViewer.addDragSupport(DND.DROP_COPY, new Transfer[] { LocalTransfer.getInstance() },
				new TreeDragListener());
		modelViewer.addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent wxSKVum9) {
				IStructuredSelection Vohbarez = (IStructuredSelection) wxSKVum9.getSelection();
				Object qodAR96l = Vohbarez.getFirstElement();
				if (qodAR96l instanceof Diagram) {
					openDiagram((Diagram) qodAR96l);
				}
			}
		});
		createContextMenuFor(modelViewer);
		editor.getDiagramGraphicalViewer().addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent G6sxApET) {
				selectionInDiagramChange(G6sxApET);
			}
		});
		this.getSite().setSelectionProvider(modelViewer);
		setInput();
	}

}