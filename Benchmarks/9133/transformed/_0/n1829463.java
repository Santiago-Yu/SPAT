class n1829463 {
	public boolean createProject(String GdcR66h3, String UHndndSB) {
		IProgressMonitor ODWWIdUx = new NullProgressMonitor();
		IWorkspaceRoot POcDp6F7 = ResourcesPlugin.getWorkspace().getRoot();
		IProject J77x2qfm = POcDp6F7.getProject(GdcR66h3);
		try {
			if (!J77x2qfm.exists()) {
				J77x2qfm.create(ODWWIdUx);
			}
			J77x2qfm.open(ODWWIdUx);
			IProjectDescription yiS7JQ24 = J77x2qfm.getDescription();
			yiS7JQ24.setNatureIds(new String[] { JavaCore.NATURE_ID });
			J77x2qfm.setDescription(yiS7JQ24, ODWWIdUx);
			IJavaProject aRV68GWa = JavaCore.create(J77x2qfm);
			IFolder gcs28fXn = J77x2qfm.getFolder("bin");
			IFolder V5gLMapD = J77x2qfm.getFolder(UHndndSB);
			if (!gcs28fXn.exists()) {
				gcs28fXn.create(false, true, null);
			}
			aRV68GWa.setOutputLocation(V5gLMapD.getFullPath(), ODWWIdUx);
			List<IClasspathEntry> xc7iR6qT = new ArrayList<IClasspathEntry>();
			IVMInstall w4pE0cMb = JavaRuntime.getDefaultVMInstall();
			LibraryLocation[] WARiPrLj = JavaRuntime.getLibraryLocations(w4pE0cMb);
			for (LibraryLocation MmRnonfh : WARiPrLj) {
				xc7iR6qT.add(JavaCore.newLibraryEntry(MmRnonfh.getSystemLibraryPath(), null, null));
			}
			aRV68GWa.setRawClasspath(xc7iR6qT.toArray(new IClasspathEntry[xc7iR6qT.size()]), null);
			IFolder mKNebVHF = J77x2qfm.getFolder("src");
			if (!mKNebVHF.exists()) {
				mKNebVHF.create(false, true, null);
			}
			IPackageFragmentRoot xA5hkMqF = aRV68GWa.getPackageFragmentRoot(mKNebVHF);
			IClasspathEntry[] S1Nda7E5 = aRV68GWa.getRawClasspath();
			IClasspathEntry[] b7eJfwWJ = new IClasspathEntry[S1Nda7E5.length + 1];
			System.arraycopy(S1Nda7E5, 0, b7eJfwWJ, 0, S1Nda7E5.length);
			b7eJfwWJ[S1Nda7E5.length] = JavaCore.newSourceEntry(xA5hkMqF.getPath());
			aRV68GWa.setRawClasspath(b7eJfwWJ, null);
			IPackageFragment SWFvjppH;
			if (xA5hkMqF.getPackageFragment("") == null) {
				SWFvjppH = xA5hkMqF.createPackageFragment("", true, ODWWIdUx);
			} else {
				SWFvjppH = xA5hkMqF.getPackageFragment("");
			}
			StringBuffer U3NkImDw = new StringBuffer();
			U3NkImDw.append("\n");
			U3NkImDw.append(source);
			ICompilationUnit p7fvwf7G = SWFvjppH.createCompilationUnit("ProcessingApplet.java", U3NkImDw.toString(),
					false, null);
			return true;
		} catch (CoreException Ocgl4Agt) {
			Ocgl4Agt.printStackTrace();
		}
		return false;
	}

}