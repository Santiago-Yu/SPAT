class n11980724 {
	protected IRunnableWithProgress getProjectCreationRunnable() {
		return new IRunnableWithProgress() {

			public void run(IProgressMonitor emeKL15I) throws InvocationTargetException, InterruptedException {
				int kZtC6zch = 10;
				emeKL15I.beginTask("New Modulo Project Creation", kZtC6zch);
				IWorkspace O5fsAec3 = ResourcesPlugin.getWorkspace();
				newProject = fMainPage.getProjectHandle();
				IProjectDescription h7thDShB = O5fsAec3.newProjectDescription(newProject.getName());
				String[] FALZHXD5 = { JavaCore.NATURE_ID, ModuloLauncherPlugin.NATURE_ID };
				h7thDShB.setNatureIds(FALZHXD5);
				ICommand irTtf1mk = h7thDShB.newCommand();
				irTtf1mk.setBuilderName(JavaCore.BUILDER_ID);
				ICommand[] lnZQSDRq = { irTtf1mk };
				h7thDShB.setBuildSpec(lnZQSDRq);
				IJavaProject XKMg0Koy = JavaCore.create(newProject);
				ModuloProject gkWXQxMq = new ModuloProject();
				gkWXQxMq.setJavaProject(XKMg0Koy);
				try {
					newProject.create(h7thDShB, new SubProgressMonitor(emeKL15I, 1));
					newProject.open(new SubProgressMonitor(emeKL15I, 1));
					IFolder BwaBkUuv = newProject.getFolder("src");
					IFolder jFIR74V9 = BwaBkUuv.getFolder("java");
					IFolder TfwjX1wK = newProject.getFolder("build");
					IFolder whAklpAC = TfwjX1wK.getFolder("classes");
					gkWXQxMq.createFolder(BwaBkUuv);
					gkWXQxMq.createFolder(jFIR74V9);
					gkWXQxMq.createFolder(TfwjX1wK);
					gkWXQxMq.createFolder(whAklpAC);
					IPath SahzL36H = newProject.getFolder("build/classes").getFullPath();
					XKMg0Koy.setOutputLocation(SahzL36H, new SubProgressMonitor(emeKL15I, 1));
					IClasspathEntry[] v29UIDgb = new IClasspathEntry[] {
							JavaCore.newSourceEntry(newProject.getFolder("src/java").getFullPath()),
							JavaCore.newContainerEntry(new Path(JavaRuntime.JRE_CONTAINER)),
							JavaCore.newContainerEntry(new Path(ModuloClasspathContainer.CONTAINER_ID)) };
					XKMg0Koy.setRawClasspath(v29UIDgb, new SubProgressMonitor(emeKL15I, 1));
					ModuleDefinition R5q6ePJm = new ModuleDefinition();
					R5q6ePJm.setId(fModuloPage.getPackageName());
					R5q6ePJm.setVersion(new VersionNumber(1, 0, 0));
					R5q6ePJm.setMetaName(fModuloPage.getModuleName());
					R5q6ePJm.setMetaDescription("The " + fModuloPage.getModuleName() + " Module.");
					R5q6ePJm.setModuleClassName(fModuloPage.getPackageName() + "." + fModuloPage.getModuleClassName());
					if (fModuloPage.isConfigSelectioned())
						R5q6ePJm.setConfigurationClassName(
								fModuloPage.getPackageName() + "." + fModuloPage.getConfigClassName());
					if (fModuloPage.isStatSelectioned())
						R5q6ePJm.setStatisticsClassName(
								fModuloPage.getPackageName() + "." + fModuloPage.getStatClassName());
					gkWXQxMq.setDefinition(R5q6ePJm);
					gkWXQxMq.createPackage();
					gkWXQxMq.createModuleXML();
					gkWXQxMq.createMainClass();
					if (fModuloPage.isConfigSelectioned())
						gkWXQxMq.createConfigClass();
					if (fModuloPage.isStatSelectioned())
						gkWXQxMq.createStatClass();
					gkWXQxMq.createModuleProperties();
					gkWXQxMq.createMessagesProperties();
					IFolder zPcchsKu = newProject.getFolder("bin");
					zPcchsKu.delete(true, new SubProgressMonitor(emeKL15I, 1));
				} catch (CoreException GnIiS8Hc) {
					GnIiS8Hc.printStackTrace();
				} finally {
					emeKL15I.done();
				}
			}
		};
	}

}