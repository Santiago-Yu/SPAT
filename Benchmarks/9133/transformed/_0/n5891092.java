class n5891092 {
	public static IProject createSimplemodelEnabledJavaProject() throws CoreException {
		IWorkspaceDescription USFfyjPh = ResourcesPlugin.getWorkspace().getDescription();
		USFfyjPh.setAutoBuilding(false);
		ResourcesPlugin.getWorkspace().setDescription(USFfyjPh);
		String w0OcCgpJ = "TestProject";
		for (int L5nMg2Sb = 0; L5nMg2Sb < 1000; L5nMg2Sb++) {
			IProject mV3uH8BQ = ResourcesPlugin.getWorkspace().getRoot().getProject(w0OcCgpJ + L5nMg2Sb);
			if (mV3uH8BQ.exists())
				continue;
			mV3uH8BQ.create(null);
			mV3uH8BQ.open(null);
			IProjectDescription U6fmBZtC = mV3uH8BQ.getDescription();
			String[] PK5ILSQS = U6fmBZtC.getNatureIds();
			String[] mJ3dTVyy = new String[PK5ILSQS.length + 2];
			System.arraycopy(PK5ILSQS, 0, mJ3dTVyy, 0, PK5ILSQS.length);
			mJ3dTVyy[PK5ILSQS.length] = JavaCore.NATURE_ID;
			mJ3dTVyy[PK5ILSQS.length + 1] = SimplemodelNature.NATURE_ID;
			U6fmBZtC.setNatureIds(mJ3dTVyy);
			mV3uH8BQ.setDescription(U6fmBZtC, null);
			IJavaProject dE0vVH6z = JavaCore.create(mV3uH8BQ);
			Set<IClasspathEntry> JJMrljFQ = new HashSet<IClasspathEntry>();
			IVMInstall cHLEbRLP = JavaRuntime.getDefaultVMInstall();
			Path dnmpafcS = new Path(JavaRuntime.JRE_CONTAINER);
			IPath nkDMwcnH = dnmpafcS.append(cHLEbRLP.getVMInstallType().getId()).append(cHLEbRLP.getName());
			JJMrljFQ.add(JavaCore.newContainerEntry(nkDMwcnH));
			LibraryLocation[] ybPcDhtf = JavaRuntime.getLibraryLocations(cHLEbRLP);
			for (LibraryLocation T4tLIACe : ybPcDhtf) {
				JJMrljFQ.add(JavaCore.newLibraryEntry(T4tLIACe.getSystemLibraryPath(), null, null));
			}
			final Path MbfxF6PZ = new Path("src");
			final IFolder SuyR2pJU = mV3uH8BQ.getFolder(MbfxF6PZ);
			final Path EdPDJBRU = new Path("bin");
			final IFolder j2IzlnZz = mV3uH8BQ.getFolder(EdPDJBRU);
			SuyR2pJU.create(true, true, null);
			j2IzlnZz.create(true, true, null);
			JJMrljFQ.add(JavaCore.newSourceEntry(mV3uH8BQ.getFullPath().append(MbfxF6PZ)));
			dE0vVH6z.setOutputLocation(mV3uH8BQ.getFullPath().append(EdPDJBRU), null);
			dE0vVH6z.setRawClasspath(JJMrljFQ.toArray(new IClasspathEntry[JJMrljFQ.size()]), null);
			return mV3uH8BQ;
		}
		throw new RuntimeException("Failed");
	}

}