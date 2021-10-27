class n15047558 {
	protected void ensureProjectExists(String projectName) {
		List<IClasspathEntry> classpathEntries = new UniqueEList<IClasspathEntry>();
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		try {
			boolean isEmptyProject = true;
			IProjectDescription projectDescription = null;
			IJavaProject javaProject = JavaCore.create(project);
			if (!project.exists()) {
				projectDescription = ResourcesPlugin.getWorkspace().newProjectDescription(projectName);
				project.create(new NullProgressMonitor());
			} else {
				isEmptyProject = false;
				projectDescription = project.getDescription();
				classpathEntries.addAll(Arrays.asList(javaProject.getRawClasspath()));
			}
			String[] natureIds = projectDescription.getNatureIds();
			if (natureIds == null) {
				natureIds = new String[] { JavaCore.NATURE_ID };
			} else {
				boolean hasJavaNature = false;
				boolean hasPDENature = false;
				for (int i = 0; i < natureIds.length; ++i) {
					hasJavaNature = (JavaCore.NATURE_ID.equals(natureIds[i])) ? true : hasJavaNature;
					hasPDENature = ("org.eclipse.pde.PluginNature".equals(natureIds[i])) ? true : hasPDENature;
				}
				if (!hasJavaNature) {
					String[] oldNatureIds = natureIds;
					natureIds = new String[oldNatureIds.length + 1];
					System.arraycopy(oldNatureIds, 0, natureIds, 0, oldNatureIds.length);
					natureIds[oldNatureIds.length] = JavaCore.NATURE_ID;
				}
				if (!hasPDENature) {
					String[] oldNatureIds = natureIds;
					natureIds = new String[oldNatureIds.length + 1];
					System.arraycopy(oldNatureIds, 0, natureIds, 0, oldNatureIds.length);
					natureIds[oldNatureIds.length] = "org.eclipse.pde.PluginNature";
				}
			}
			projectDescription.setNatureIds(natureIds);
			ICommand[] builders = projectDescription.getBuildSpec();
			builders = (builders == null) ? new ICommand[0] : builders;
			boolean hasManifestBuilder = false;
			boolean hasSchemaBuilder = false;
			for (int i = 0; i < builders.length; ++i) {
				hasManifestBuilder = ("org.eclipse.pde.ManifestBuilder".equals(builders[i].getBuilderName())) ? true
						: hasManifestBuilder;
				hasSchemaBuilder = ("org.eclipse.pde.SchemaBuilder".equals(builders[i].getBuilderName())) ? true
						: hasSchemaBuilder;
			}
			if (!hasManifestBuilder) {
				ICommand[] oldBuilders = builders;
				builders = new ICommand[oldBuilders.length + 1];
				System.arraycopy(oldBuilders, 0, builders, 0, oldBuilders.length);
				builders[oldBuilders.length] = projectDescription.newCommand();
				builders[oldBuilders.length].setBuilderName("org.eclipse.pde.ManifestBuilder");
			}
			if (!hasSchemaBuilder) {
				ICommand[] oldBuilders = builders;
				builders = new ICommand[oldBuilders.length + 1];
				System.arraycopy(oldBuilders, 0, builders, 0, oldBuilders.length);
				builders[oldBuilders.length] = projectDescription.newCommand();
				builders[oldBuilders.length].setBuilderName("org.eclipse.pde.SchemaBuilder");
			}
			projectDescription.setBuildSpec(builders);
			project.open(new NullProgressMonitor());
			project.setDescription(projectDescription, new NullProgressMonitor());
			if (isEmptyProject) {
				IFolder sourceContainer = project.getFolder("src");
				sourceContainer.create(false, true, new NullProgressMonitor());
				IClasspathEntry sourceClasspathEntry = JavaCore.newSourceEntry(new Path("/" + projectName + "/src"));
				classpathEntries.add(0, sourceClasspathEntry);
				String jreContainer = JavaRuntime.JRE_CONTAINER;
				String complianceLevel = CodeGenUtil.EclipseUtil.getJavaComplianceLevel(project);
				if ("1.5".equals(complianceLevel)) {
					jreContainer += "/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/J2SE-1.5";
				} else
					jreContainer = ("1.6".equals(complianceLevel))
							? "/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.6"
							: jreContainer;
				classpathEntries.add(JavaCore.newContainerEntry(new Path(jreContainer)));
				classpathEntries.add(JavaCore.newContainerEntry(new Path("org.eclipse.pde.core.requiredPlugins")));
				javaProject.setOutputLocation(new Path("/" + projectName + "/bin"), new NullProgressMonitor());
			}
			javaProject.setRawClasspath(classpathEntries.toArray(new IClasspathEntry[classpathEntries.size()]),
					new NullProgressMonitor());
		} catch (CoreException e) {
			e.printStackTrace();
			CodeGenEcorePlugin.INSTANCE.log(e);
		}
	}

}