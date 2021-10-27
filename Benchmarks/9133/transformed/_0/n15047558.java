class n15047558 {
	protected void ensureProjectExists(String BMq9fiMu) {
		List<IClasspathEntry> pzxeCkVB = new UniqueEList<IClasspathEntry>();
		IProject HgiXHmSz = ResourcesPlugin.getWorkspace().getRoot().getProject(BMq9fiMu);
		try {
			boolean h2PAIQfx = true;
			IProjectDescription s2ux6fp4 = null;
			IJavaProject K9LSVZok = JavaCore.create(HgiXHmSz);
			if (!HgiXHmSz.exists()) {
				s2ux6fp4 = ResourcesPlugin.getWorkspace().newProjectDescription(BMq9fiMu);
				HgiXHmSz.create(new NullProgressMonitor());
			} else {
				h2PAIQfx = false;
				s2ux6fp4 = HgiXHmSz.getDescription();
				pzxeCkVB.addAll(Arrays.asList(K9LSVZok.getRawClasspath()));
			}
			String[] PoiU3mMB = s2ux6fp4.getNatureIds();
			if (PoiU3mMB == null) {
				PoiU3mMB = new String[] { JavaCore.NATURE_ID };
			} else {
				boolean vSQITMIX = false;
				boolean nf0XaF2Y = false;
				for (int zjSpHfs7 = 0; zjSpHfs7 < PoiU3mMB.length; ++zjSpHfs7) {
					if (JavaCore.NATURE_ID.equals(PoiU3mMB[zjSpHfs7])) {
						vSQITMIX = true;
					}
					if ("org.eclipse.pde.PluginNature".equals(PoiU3mMB[zjSpHfs7])) {
						nf0XaF2Y = true;
					}
				}
				if (!vSQITMIX) {
					String[] u32yokt5 = PoiU3mMB;
					PoiU3mMB = new String[u32yokt5.length + 1];
					System.arraycopy(u32yokt5, 0, PoiU3mMB, 0, u32yokt5.length);
					PoiU3mMB[u32yokt5.length] = JavaCore.NATURE_ID;
				}
				if (!nf0XaF2Y) {
					String[] zxNiGnOI = PoiU3mMB;
					PoiU3mMB = new String[zxNiGnOI.length + 1];
					System.arraycopy(zxNiGnOI, 0, PoiU3mMB, 0, zxNiGnOI.length);
					PoiU3mMB[zxNiGnOI.length] = "org.eclipse.pde.PluginNature";
				}
			}
			s2ux6fp4.setNatureIds(PoiU3mMB);
			ICommand[] rugrg4Ud = s2ux6fp4.getBuildSpec();
			if (rugrg4Ud == null) {
				rugrg4Ud = new ICommand[0];
			}
			boolean Zrj0AYcr = false;
			boolean ntOIIK76 = false;
			for (int Mi1pxfkx = 0; Mi1pxfkx < rugrg4Ud.length; ++Mi1pxfkx) {
				if ("org.eclipse.pde.ManifestBuilder".equals(rugrg4Ud[Mi1pxfkx].getBuilderName())) {
					Zrj0AYcr = true;
				}
				if ("org.eclipse.pde.SchemaBuilder".equals(rugrg4Ud[Mi1pxfkx].getBuilderName())) {
					ntOIIK76 = true;
				}
			}
			if (!Zrj0AYcr) {
				ICommand[] Gr8aKmyb = rugrg4Ud;
				rugrg4Ud = new ICommand[Gr8aKmyb.length + 1];
				System.arraycopy(Gr8aKmyb, 0, rugrg4Ud, 0, Gr8aKmyb.length);
				rugrg4Ud[Gr8aKmyb.length] = s2ux6fp4.newCommand();
				rugrg4Ud[Gr8aKmyb.length].setBuilderName("org.eclipse.pde.ManifestBuilder");
			}
			if (!ntOIIK76) {
				ICommand[] ruMVGZBM = rugrg4Ud;
				rugrg4Ud = new ICommand[ruMVGZBM.length + 1];
				System.arraycopy(ruMVGZBM, 0, rugrg4Ud, 0, ruMVGZBM.length);
				rugrg4Ud[ruMVGZBM.length] = s2ux6fp4.newCommand();
				rugrg4Ud[ruMVGZBM.length].setBuilderName("org.eclipse.pde.SchemaBuilder");
			}
			s2ux6fp4.setBuildSpec(rugrg4Ud);
			HgiXHmSz.open(new NullProgressMonitor());
			HgiXHmSz.setDescription(s2ux6fp4, new NullProgressMonitor());
			if (h2PAIQfx) {
				IFolder heUoNUCX = HgiXHmSz.getFolder("src");
				heUoNUCX.create(false, true, new NullProgressMonitor());
				IClasspathEntry G3r79BVk = JavaCore.newSourceEntry(new Path("/" + BMq9fiMu + "/src"));
				pzxeCkVB.add(0, G3r79BVk);
				String VWsq3dJ0 = JavaRuntime.JRE_CONTAINER;
				String jVnwK9Vl = CodeGenUtil.EclipseUtil.getJavaComplianceLevel(HgiXHmSz);
				if ("1.5".equals(jVnwK9Vl)) {
					VWsq3dJ0 += "/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/J2SE-1.5";
				} else if ("1.6".equals(jVnwK9Vl)) {
					VWsq3dJ0 += "/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.6";
				}
				pzxeCkVB.add(JavaCore.newContainerEntry(new Path(VWsq3dJ0)));
				pzxeCkVB.add(JavaCore.newContainerEntry(new Path("org.eclipse.pde.core.requiredPlugins")));
				K9LSVZok.setOutputLocation(new Path("/" + BMq9fiMu + "/bin"), new NullProgressMonitor());
			}
			K9LSVZok.setRawClasspath(pzxeCkVB.toArray(new IClasspathEntry[pzxeCkVB.size()]), new NullProgressMonitor());
		} catch (CoreException NeQ7U7Q1) {
			NeQ7U7Q1.printStackTrace();
			CodeGenEcorePlugin.INSTANCE.log(NeQ7U7Q1);
		}
	}

}