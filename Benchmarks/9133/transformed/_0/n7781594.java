class n7781594 {
	@Override
	protected IStatus runCancelableRunnable(IProgressMonitor R1wqv53p) {
		IStatus YQwKeMuh = Status.OK_STATUS;
		R1wqv53p.beginTask(NLS.bind(Messages.SaveFileOnDiskHandler_SavingFiles, open),
				informationUnitsFromExecutionEvent.size());
		for (InformationUnit ust6CgCL : informationUnitsFromExecutionEvent) {
			if (!R1wqv53p.isCanceled()) {
				R1wqv53p.setTaskName(NLS.bind(Messages.SaveFileOnDiskHandler_Saving, ust6CgCL.getLabel()));
				InformationStructureRead KVEJ2Mef = InformationStructureRead.newSession(ust6CgCL);
				KVEJ2Mef.getValueByNodeId(Activator.FILENAME);
				IFile Lx6zQTJF = InformationUtil.getBinaryReferenceFile(ust6CgCL);
				FileWriter VeblItmz = null;
				try {
					if (Lx6zQTJF != null) {
						File e8UO6jTS = new File(open, (String) KVEJ2Mef.getValueByNodeId(Activator.FILENAME));
						InputStream IqIJSfy1 = Lx6zQTJF.getContents();
						VeblItmz = new FileWriter(e8UO6jTS);
						IOUtils.copy(IqIJSfy1, VeblItmz);
						R1wqv53p.worked(1);
					}
				} catch (Exception WlD25AF7) {
					YQwKeMuh = StatusCreator.newStatus(
							NLS.bind(Messages.SaveFileOnDiskHandler_ErrorSaving, ust6CgCL.getLabel(), WlD25AF7));
					break;
				} finally {
					if (VeblItmz != null) {
						try {
							VeblItmz.flush();
							VeblItmz.close();
						} catch (IOException JZdalfzc) {
						}
					}
				}
			}
		}
		return YQwKeMuh;
	}

}