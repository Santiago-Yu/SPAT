class n11980725 {
	public void run(IProgressMonitor w1AE1WMg) throws InvocationTargetException, InterruptedException {
		int Ea7v1OXh = 10;
		w1AE1WMg.beginTask("New Modulo Project Creation", Ea7v1OXh);
		IWorkspace ucDfHLpj = ResourcesPlugin.getWorkspace();
		newProject = fMainPage.getProjectHandle();
		IProjectDescription heIvUzH8 = ucDfHLpj.newProjectDescription(newProject.getName());
		String[] Elrlaafv = { JavaCore.NATURE_ID, ModuloLauncherPlugin.NATURE_ID };
		heIvUzH8.setNatureIds(Elrlaafv);
		ICommand rNLPI34d = heIvUzH8.newCommand();
		rNLPI34d.setBuilderName(JavaCore.BUILDER_ID);
		ICommand[] Kmpnv47F = { rNLPI34d };
		heIvUzH8.setBuildSpec(Kmpnv47F);
		IJavaProject d0dbIEXj = JavaCore.create(newProject);
		ModuloProject fxKt2sWF = new ModuloProject();
		fxKt2sWF.setJavaProject(d0dbIEXj);
		try {
			newProject.create(heIvUzH8, new SubProgressMonitor(w1AE1WMg, 1));
			newProject.open(new SubProgressMonitor(w1AE1WMg, 1));
			IFolder IxZZSRkl = newProject.getFolder("src");
			IFolder dfok0xlM = IxZZSRkl.getFolder("java");
			IFolder u7LGasKX = newProject.getFolder("build");
			IFolder qS2p8Meh = u7LGasKX.getFolder("classes");
			fxKt2sWF.createFolder(IxZZSRkl);
			fxKt2sWF.createFolder(dfok0xlM);
			fxKt2sWF.createFolder(u7LGasKX);
			fxKt2sWF.createFolder(qS2p8Meh);
			IPath Wu84RvV4 = newProject.getFolder("build/classes").getFullPath();
			d0dbIEXj.setOutputLocation(Wu84RvV4, new SubProgressMonitor(w1AE1WMg, 1));
			IClasspathEntry[] q3HXbHeT = new IClasspathEntry[] {
					JavaCore.newSourceEntry(newProject.getFolder("src/java").getFullPath()),
					JavaCore.newContainerEntry(new Path(JavaRuntime.JRE_CONTAINER)),
					JavaCore.newContainerEntry(new Path(ModuloClasspathContainer.CONTAINER_ID)) };
			d0dbIEXj.setRawClasspath(q3HXbHeT, new SubProgressMonitor(w1AE1WMg, 1));
			ModuleDefinition e6DdpuAN = new ModuleDefinition();
			e6DdpuAN.setId(fModuloPage.getPackageName());
			e6DdpuAN.setVersion(new VersionNumber(1, 0, 0));
			e6DdpuAN.setMetaName(fModuloPage.getModuleName());
			e6DdpuAN.setMetaDescription("The " + fModuloPage.getModuleName() + " Module.");
			e6DdpuAN.setModuleClassName(fModuloPage.getPackageName() + "." + fModuloPage.getModuleClassName());
			if (fModuloPage.isConfigSelectioned())
				e6DdpuAN.setConfigurationClassName(
						fModuloPage.getPackageName() + "." + fModuloPage.getConfigClassName());
			if (fModuloPage.isStatSelectioned())
				e6DdpuAN.setStatisticsClassName(fModuloPage.getPackageName() + "." + fModuloPage.getStatClassName());
			fxKt2sWF.setDefinition(e6DdpuAN);
			fxKt2sWF.createPackage();
			fxKt2sWF.createModuleXML();
			fxKt2sWF.createMainClass();
			if (fModuloPage.isConfigSelectioned())
				fxKt2sWF.createConfigClass();
			if (fModuloPage.isStatSelectioned())
				fxKt2sWF.createStatClass();
			fxKt2sWF.createModuleProperties();
			fxKt2sWF.createMessagesProperties();
			IFolder VGevOcII = newProject.getFolder("bin");
			VGevOcII.delete(true, new SubProgressMonitor(w1AE1WMg, 1));
		} catch (CoreException ue9fGMUW) {
			ue9fGMUW.printStackTrace();
		} finally {
			w1AE1WMg.done();
		}
	}

}