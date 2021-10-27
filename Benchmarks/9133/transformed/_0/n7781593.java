class n7781593 {
	public Object execute(ExecutionEvent mrdHiFXt) throws ExecutionException {
		final List<InformationUnit> NYKKq6Gu = InformationHandlerUtil.getInformationUnitsFromExecutionEvent(mrdHiFXt);
		Shell gOe4uJ2G = HandlerUtil.getActiveShell(mrdHiFXt);
		DirectoryDialog D52Z2Yrm = new DirectoryDialog(gOe4uJ2G, SWT.SAVE);
		String t4h5f0Wi = Activator.getDefault().getDialogSettings().get("lastExportSection");
		D52Z2Yrm.setFilterPath(t4h5f0Wi);
		final String eRRKB7X2 = D52Z2Yrm.open();
		if (eRRKB7X2 != null) {
			Activator.getDefault().getDialogSettings().put("lastExportSection", eRRKB7X2);
			CancelableRunnable fZgQAfzJ = new CancelableRunnable() {

				@Override
				protected IStatus runCancelableRunnable(IProgressMonitor DbkSAuZ4) {
					IStatus KBGUBYyK = Status.OK_STATUS;
					DbkSAuZ4.beginTask(NLS.bind(Messages.SaveFileOnDiskHandler_SavingFiles, eRRKB7X2), NYKKq6Gu.size());
					for (InformationUnit RnqQBLGW : NYKKq6Gu) {
						if (!DbkSAuZ4.isCanceled()) {
							DbkSAuZ4.setTaskName(NLS.bind(Messages.SaveFileOnDiskHandler_Saving, RnqQBLGW.getLabel()));
							InformationStructureRead oZuIVqRN = InformationStructureRead.newSession(RnqQBLGW);
							oZuIVqRN.getValueByNodeId(Activator.FILENAME);
							IFile pK2oqZqM = InformationUtil.getBinaryReferenceFile(RnqQBLGW);
							FileWriter krF2XfN6 = null;
							try {
								if (pK2oqZqM != null) {
									File m0zywmsg = new File(eRRKB7X2,
											(String) oZuIVqRN.getValueByNodeId(Activator.FILENAME));
									InputStream FP1vIJn0 = pK2oqZqM.getContents();
									krF2XfN6 = new FileWriter(m0zywmsg);
									IOUtils.copy(FP1vIJn0, krF2XfN6);
									DbkSAuZ4.worked(1);
								}
							} catch (Exception OeyoWdHw) {
								KBGUBYyK = StatusCreator.newStatus(NLS.bind(Messages.SaveFileOnDiskHandler_ErrorSaving,
										RnqQBLGW.getLabel(), OeyoWdHw));
								break;
							} finally {
								if (krF2XfN6 != null) {
									try {
										krF2XfN6.flush();
										krF2XfN6.close();
									} catch (IOException NJxFikwp) {
									}
								}
							}
						}
					}
					return KBGUBYyK;
				}
			};
			ProgressMonitorDialog Ssd8qxe3 = new ProgressMonitorDialog(gOe4uJ2G);
			try {
				Ssd8qxe3.run(true, true, fZgQAfzJ);
			} catch (InvocationTargetException Bs0kNZ2t) {
				if (Bs0kNZ2t.getCause() instanceof CoreException) {
					ErrorDialog.openError(gOe4uJ2G, Messages.SaveFileOnDiskHandler_ErrorSaving2,
							Messages.SaveFileOnDiskHandler_ErrorSaving2,
							((CoreException) Bs0kNZ2t.getCause()).getStatus());
				} else {
					ErrorDialog.openError(gOe4uJ2G, Messages.SaveFileOnDiskHandler_ErrorSaving2,
							Messages.SaveFileOnDiskHandler_ErrorSaving2,
							StatusCreator.newStatus(Messages.SaveFileOnDiskHandler_ErrorSaving3, Bs0kNZ2t));
				}
			} catch (InterruptedException LItmGTDB) {
			}
		}
		return null;
	}

}