class n6841522 {
	public void createCodeLocation() {
		List<IClasspathEntry> cKpSQp8M = new UniqueEList<IClasspathEntry>();
		project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectname);
		try {
			IProjectDescription tewbAaeZ = null;
			IJavaProject Oij8RHbv = JavaCore.create(project);
			if (project.exists()) {
				project.delete(true, null);
			}
			tewbAaeZ = ResourcesPlugin.getWorkspace().newProjectDescription(projectname);
			project.create(tewbAaeZ, new NullProgressMonitor());
			String[] WVad9u4c = tewbAaeZ.getNatureIds();
			if (WVad9u4c == null) {
				WVad9u4c = new String[] { JavaCore.NATURE_ID };
			} else {
				boolean qyzbSktf = false;
				boolean Tfuk7kO5 = false;
				for (int wtyv84Pm = 0; wtyv84Pm < WVad9u4c.length; ++wtyv84Pm) {
					if (JavaCore.NATURE_ID.equals(WVad9u4c[wtyv84Pm])) {
						qyzbSktf = true;
					}
					if ("org.eclipse.pde.PluginNature".equals(WVad9u4c[wtyv84Pm])) {
						Tfuk7kO5 = true;
					}
				}
				if (!qyzbSktf) {
					String[] j9o3dGy4 = WVad9u4c;
					WVad9u4c = new String[j9o3dGy4.length + 1];
					System.arraycopy(j9o3dGy4, 0, WVad9u4c, 0, j9o3dGy4.length);
					WVad9u4c[j9o3dGy4.length] = JavaCore.NATURE_ID;
				}
				if (!Tfuk7kO5) {
					String[] GvC42FhY = WVad9u4c;
					WVad9u4c = new String[GvC42FhY.length + 1];
					System.arraycopy(GvC42FhY, 0, WVad9u4c, 0, GvC42FhY.length);
					WVad9u4c[GvC42FhY.length] = "org.eclipse.pde.PluginNature";
				}
			}
			tewbAaeZ.setNatureIds(WVad9u4c);
			ICommand[] XL4E8L9L = tewbAaeZ.getBuildSpec();
			if (XL4E8L9L == null) {
				XL4E8L9L = new ICommand[0];
			}
			boolean fxWmtSEX = false;
			boolean FaMhUWVw = false;
			for (int vzdM58DX = 0; vzdM58DX < XL4E8L9L.length; ++vzdM58DX) {
				if ("org.eclipse.pde.ManifestBuilder".equals(XL4E8L9L[vzdM58DX].getBuilderName())) {
					fxWmtSEX = true;
				}
				if ("org.eclipse.pde.SchemaBuilder".equals(XL4E8L9L[vzdM58DX].getBuilderName())) {
					FaMhUWVw = true;
				}
			}
			if (!fxWmtSEX) {
				ICommand[] LEoO4XPu = XL4E8L9L;
				XL4E8L9L = new ICommand[LEoO4XPu.length + 1];
				System.arraycopy(LEoO4XPu, 0, XL4E8L9L, 0, LEoO4XPu.length);
				XL4E8L9L[LEoO4XPu.length] = tewbAaeZ.newCommand();
				XL4E8L9L[LEoO4XPu.length].setBuilderName("org.eclipse.pde.ManifestBuilder");
			}
			if (!FaMhUWVw) {
				ICommand[] tvMzWnQ1 = XL4E8L9L;
				XL4E8L9L = new ICommand[tvMzWnQ1.length + 1];
				System.arraycopy(tvMzWnQ1, 0, XL4E8L9L, 0, tvMzWnQ1.length);
				XL4E8L9L[tvMzWnQ1.length] = tewbAaeZ.newCommand();
				XL4E8L9L[tvMzWnQ1.length].setBuilderName("org.eclipse.pde.SchemaBuilder");
			}
			tewbAaeZ.setBuildSpec(XL4E8L9L);
			project.open(new NullProgressMonitor());
			project.setDescription(tewbAaeZ, new NullProgressMonitor());
			sourceContainer = project.getFolder("src");
			sourceContainer.create(false, true, new NullProgressMonitor());
			IClasspathEntry pB2MY2Tg = JavaCore.newSourceEntry(new Path("/" + projectname + "/src"));
			cKpSQp8M.add(0, pB2MY2Tg);
			String S0Ws6L4L = JavaRuntime.JRE_CONTAINER;
			String jFBt5fZo = CodeGenUtil.EclipseUtil.getJavaComplianceLevel(project);
			if ("1.5".equals(jFBt5fZo)) {
				S0Ws6L4L += "/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/J2SE-1.5";
			} else if ("1.6".equals(jFBt5fZo)) {
				S0Ws6L4L += "/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.6";
			}
			cKpSQp8M.add(JavaCore.newContainerEntry(new Path(S0Ws6L4L)));
			cKpSQp8M.add(JavaCore.newContainerEntry(new Path("org.eclipse.pde.core.requiredPlugins")));
			Oij8RHbv.setOutputLocation(new Path("/" + projectname + "/bin"), new NullProgressMonitor());
			Oij8RHbv.setRawClasspath(cKpSQp8M.toArray(new IClasspathEntry[cKpSQp8M.size()]), new NullProgressMonitor());
		} catch (CoreException apbGwldq) {
			apbGwldq.printStackTrace();
			CodeGenEcorePlugin.INSTANCE.log(apbGwldq);
		}
	}

}