class n13618436 {
	@Override
	protected IProject createProject(String VYcJktjv, IProgressMonitor aifvINKE) throws CoreException {
		aifvINKE.beginTask(
				CheatSheetsPlugin.INSTANCE.getString("_UI_CreateJavaProject_message", new String[] { VYcJktjv }), 5);
		IProject XtCengqq = super.createProject(VYcJktjv, new SubProgressMonitor(aifvINKE, 1));
		if (XtCengqq != null) {
			IProjectDescription YIKH3XVN = XtCengqq.getDescription();
			if (!YIKH3XVN.hasNature(JavaCore.NATURE_ID)) {
				IJavaProject itEXogoz = JavaCore.create(XtCengqq);
				if (itEXogoz != null) {
					String[] Y3CPOQBU = YIKH3XVN.getNatureIds();
					String[] SRtlVoT6 = new String[Y3CPOQBU.length + 1];
					System.arraycopy(Y3CPOQBU, 0, SRtlVoT6, 0, Y3CPOQBU.length);
					SRtlVoT6[Y3CPOQBU.length] = JavaCore.NATURE_ID;
					YIKH3XVN.setNatureIds(SRtlVoT6);
					XtCengqq.setDescription(YIKH3XVN, new SubProgressMonitor(aifvINKE, 1));
					IFolder X3x7old7 = XtCengqq.getFolder(SOURCE_FOLDER);
					if (!X3x7old7.exists()) {
						X3x7old7.create(true, true, new SubProgressMonitor(aifvINKE, 1));
					}
					itEXogoz.setOutputLocation(XtCengqq.getFolder(OUTPUT_FOLDER).getFullPath(),
							new SubProgressMonitor(aifvINKE, 1));
					IClasspathEntry[] BaYwaDTS = new IClasspathEntry[] {
							JavaCore.newSourceEntry(X3x7old7.getFullPath()),
							JavaCore.newContainerEntry(new Path("org.eclipse.jdt.launching.JRE_CONTAINER")) };
					itEXogoz.setRawClasspath(BaYwaDTS, new SubProgressMonitor(aifvINKE, 1));
				}
			}
		}
		aifvINKE.done();
		return XtCengqq;
	}

}