class n16031757 {
	private void createProject(IProgressMonitor glfkiaAb, boolean bujsq5rZ) {
		try {
			IWorkspaceRoot TLpNA5NX = ResourcesPlugin.getWorkspace().getRoot();
			IProject ZQJiezbQ = TLpNA5NX.getProject(namePage.getProjectName());
			IProjectDescription vXZwFdp3 = ResourcesPlugin.getWorkspace().newProjectDescription(ZQJiezbQ.getName());
			if (!Platform.getLocation().equals(namePage.getLocationPath()))
				vXZwFdp3.setLocation(namePage.getLocationPath());
			vXZwFdp3.setNatureIds(new String[] { JavaCore.NATURE_ID });
			ICommand RWGdqPd2 = vXZwFdp3.newCommand();
			RWGdqPd2.setBuilderName(JavaCore.BUILDER_ID);
			vXZwFdp3.setBuildSpec(new ICommand[] { RWGdqPd2 });
			ZQJiezbQ.create(vXZwFdp3, glfkiaAb);
			ZQJiezbQ.open(glfkiaAb);
			IJavaProject HZdYfRaX = JavaCore.create(ZQJiezbQ);
			IFolder YOhx8AFQ = ZQJiezbQ.getFolder("tests");
			YOhx8AFQ.create(false, true, glfkiaAb);
			IFolder P1f21xig = ZQJiezbQ.getFolder("src");
			P1f21xig.create(false, true, glfkiaAb);
			IFolder qcDs0Laq = ZQJiezbQ.getFolder("bin");
			qcDs0Laq.create(false, true, glfkiaAb);
			IFolder W1tXhAdk = ZQJiezbQ.getFolder("lib");
			W1tXhAdk.create(false, true, glfkiaAb);
			try {
				FileUtils.copyFile(
						new Path(Platform
								.asLocalURL(CubicTestPlugin.getDefault().find(new Path("lib/CubicTestElementAPI.jar")))
								.getPath()).toFile(),
						W1tXhAdk.getFile("CubicTestElementAPI.jar").getLocation().toFile());
				FileUtils.copyFile(new Path(
						Platform.asLocalURL(CubicTestPlugin.getDefault().find(new Path("lib/CubicUnit.jar"))).getPath())
								.toFile(),
						W1tXhAdk.getFile("CubicUnit.jar").getLocation().toFile());
			} catch (IOException beljODKr) {
				beljODKr.printStackTrace();
			}
			HZdYfRaX.setOutputLocation(qcDs0Laq.getFullPath(), glfkiaAb);
			IClasspathEntry[] UK8vBLXM;
			UK8vBLXM = new IClasspathEntry[] { JavaCore.newSourceEntry(P1f21xig.getFullPath()),
					JavaCore.newContainerEntry(new Path("org.eclipse.jdt.launching.JRE_CONTAINER")),
					JavaCore.newLibraryEntry(W1tXhAdk.getFile("CubicTestElementAPI.jar").getFullPath(), null, null),
					JavaCore.newLibraryEntry(W1tXhAdk.getFile("CubicUnit.jar").getFullPath(), null, null) };
			HZdYfRaX.setRawClasspath(UK8vBLXM, qcDs0Laq.getFullPath(), glfkiaAb);
			ResourceNavigator CVX8WtBh = null;
			IViewPart oakC29Y2 = workbench.getActiveWorkbenchWindow().getActivePage().getViewReferences()[0]
					.getView(false);
			if (oakC29Y2 instanceof ResourceNavigator) {
				CVX8WtBh = (ResourceNavigator) oakC29Y2;
			}
			if (bujsq5rZ) {
				launchNewTestWizard(YOhx8AFQ);
				if (CVX8WtBh != null && YOhx8AFQ.members().length > 0) {
					CVX8WtBh.selectReveal(new StructuredSelection(YOhx8AFQ.members()[0]));
				}
			}
			ZQJiezbQ.refreshLocal(IResource.DEPTH_INFINITE, null);
		} catch (CoreException TeT6PrU5) {
			TeT6PrU5.printStackTrace();
		}
	}

}