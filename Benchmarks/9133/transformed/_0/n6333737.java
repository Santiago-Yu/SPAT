class n6333737 {
	public static IProject createEMFProject(IPath R1JmH2zy, URI jtOVfthm, List<IProject> l4xcebk0, Monitor fEUeNK6K,
			int OvdH9Vtm, List<?> naZIH0BS) {
		IProgressMonitor JMVmDfLI = BasicMonitor.toIProgressMonitor(fEUeNK6K);
		String ARepCeTH = R1JmH2zy.segment(0);
		IProject v0Q9C4nE = null;
		try {
			List<IClasspathEntry> Bl0B7P8M = new UniqueEList<IClasspathEntry>();
			JMVmDfLI.beginTask("", 10);
			JMVmDfLI.subTask(CodeGenEcorePlugin.INSTANCE.getString("_UI_CreatingEMFProject_message",
					new Object[] { ARepCeTH, jtOVfthm != null ? jtOVfthm.toString() : ARepCeTH }));
			IWorkspace H213x1Bo = ResourcesPlugin.getWorkspace();
			v0Q9C4nE = H213x1Bo.getRoot().getProject(ARepCeTH);
			if (!v0Q9C4nE.exists()) {
				URI XfOIQ2s4 = jtOVfthm;
				if (XfOIQ2s4 == null) {
					XfOIQ2s4 = URI.createFileURI(H213x1Bo.getRoot().getLocation().append(ARepCeTH).toOSString());
				}
				XfOIQ2s4 = XfOIQ2s4.appendSegment(".project");
				File dTLeYgGe = new File(XfOIQ2s4.toString());
				if (dTLeYgGe.exists()) {
					dTLeYgGe.renameTo(new File(XfOIQ2s4.toString() + ".old"));
				}
			}
			IJavaProject NwcJ2wzd = JavaCore.create(v0Q9C4nE);
			IProjectDescription qPdFIg0x = null;
			if (!v0Q9C4nE.exists()) {
				qPdFIg0x = ResourcesPlugin.getWorkspace().newProjectDescription(ARepCeTH);
				if (jtOVfthm != null) {
					qPdFIg0x.setLocationURI(new java.net.URI(jtOVfthm.toString()));
				}
				v0Q9C4nE.create(qPdFIg0x, new SubProgressMonitor(JMVmDfLI, 1));
				v0Q9C4nE.open(new SubProgressMonitor(JMVmDfLI, 1));
			} else {
				qPdFIg0x = v0Q9C4nE.getDescription();
				v0Q9C4nE.open(new SubProgressMonitor(JMVmDfLI, 1));
				if (v0Q9C4nE.hasNature(JavaCore.NATURE_ID)) {
					Bl0B7P8M.addAll(Arrays.asList(NwcJ2wzd.getRawClasspath()));
				}
			}
			boolean mkuAoW2S = Bl0B7P8M.isEmpty();
			{
				if (l4xcebk0.size() != 0 && (OvdH9Vtm & (EMF_PLUGIN_PROJECT_STYLE | EMF_EMPTY_PROJECT_STYLE)) == 0) {
					qPdFIg0x.setReferencedProjects(l4xcebk0.toArray(new IProject[l4xcebk0.size()]));
					for (IProject Dor4ODdl : l4xcebk0) {
						IClasspathEntry fIhL0RLX = JavaCore.newProjectEntry(Dor4ODdl.getFullPath());
						Bl0B7P8M.add(fIhL0RLX);
					}
				}
				String[] i80AVbe3 = qPdFIg0x.getNatureIds();
				if (i80AVbe3 == null) {
					i80AVbe3 = new String[] { JavaCore.NATURE_ID, "org.eclipse.pde.PluginNature" };
				} else {
					if (!v0Q9C4nE.hasNature(JavaCore.NATURE_ID)) {
						String[] wPvsJ93X = i80AVbe3;
						i80AVbe3 = new String[wPvsJ93X.length + 1];
						System.arraycopy(wPvsJ93X, 0, i80AVbe3, 0, wPvsJ93X.length);
						i80AVbe3[wPvsJ93X.length] = JavaCore.NATURE_ID;
					}
					if (!v0Q9C4nE.hasNature("org.eclipse.pde.PluginNature")) {
						String[] T8XthJGr = i80AVbe3;
						i80AVbe3 = new String[T8XthJGr.length + 1];
						System.arraycopy(T8XthJGr, 0, i80AVbe3, 0, T8XthJGr.length);
						i80AVbe3[T8XthJGr.length] = "org.eclipse.pde.PluginNature";
					}
				}
				qPdFIg0x.setNatureIds(i80AVbe3);
				ICommand[] VMoykVKn = qPdFIg0x.getBuildSpec();
				if (VMoykVKn == null) {
					VMoykVKn = new ICommand[0];
				}
				boolean F5xpFU28 = false;
				boolean gpZMtiEs = false;
				for (int fl9OCOIq = 0; fl9OCOIq < VMoykVKn.length; ++fl9OCOIq) {
					if ("org.eclipse.pde.ManifestBuilder".equals(VMoykVKn[fl9OCOIq].getBuilderName())) {
						F5xpFU28 = true;
					}
					if ("org.eclipse.pde.SchemaBuilder".equals(VMoykVKn[fl9OCOIq].getBuilderName())) {
						gpZMtiEs = true;
					}
				}
				if (!F5xpFU28) {
					ICommand[] pjFDbaQn = VMoykVKn;
					VMoykVKn = new ICommand[pjFDbaQn.length + 1];
					System.arraycopy(pjFDbaQn, 0, VMoykVKn, 0, pjFDbaQn.length);
					VMoykVKn[pjFDbaQn.length] = qPdFIg0x.newCommand();
					VMoykVKn[pjFDbaQn.length].setBuilderName("org.eclipse.pde.ManifestBuilder");
				}
				if (!gpZMtiEs) {
					ICommand[] HFLA1xIM = VMoykVKn;
					VMoykVKn = new ICommand[HFLA1xIM.length + 1];
					System.arraycopy(HFLA1xIM, 0, VMoykVKn, 0, HFLA1xIM.length);
					VMoykVKn[HFLA1xIM.length] = qPdFIg0x.newCommand();
					VMoykVKn[HFLA1xIM.length].setBuilderName("org.eclipse.pde.SchemaBuilder");
				}
				qPdFIg0x.setBuildSpec(VMoykVKn);
				v0Q9C4nE.setDescription(qPdFIg0x, new SubProgressMonitor(JMVmDfLI, 1));
				IContainer iEC3s59T = v0Q9C4nE;
				if (R1JmH2zy.segmentCount() > 1) {
					IPath ehXo55oO = R1JmH2zy.removeFirstSegments(1).makeAbsolute();
					iEC3s59T = v0Q9C4nE.getFolder(ehXo55oO);
					if (!iEC3s59T.exists()) {
						for (int z0LgN47c = ehXo55oO.segmentCount() - 1; z0LgN47c >= 0; z0LgN47c--) {
							iEC3s59T = v0Q9C4nE.getFolder(ehXo55oO.removeLastSegments(z0LgN47c));
							if (!iEC3s59T.exists()) {
								((IFolder) iEC3s59T).create(false, true, new SubProgressMonitor(JMVmDfLI, 1));
							}
						}
					}
					IClasspathEntry iy6QXid5 = JavaCore.newSourceEntry(R1JmH2zy);
					for (Iterator<IClasspathEntry> KZcDB6Ai = Bl0B7P8M.iterator(); KZcDB6Ai.hasNext();) {
						IClasspathEntry EVlRQtp7 = KZcDB6Ai.next();
						if (EVlRQtp7.getPath().isPrefixOf(R1JmH2zy)) {
							KZcDB6Ai.remove();
						}
					}
					Bl0B7P8M.add(0, iy6QXid5);
				}
				if (mkuAoW2S) {
					IClasspathEntry lvxrTcJQ = JavaCore.newVariableEntry(new Path(JavaRuntime.JRELIB_VARIABLE),
							new Path(JavaRuntime.JRESRC_VARIABLE), new Path(JavaRuntime.JRESRCROOT_VARIABLE));
					for (Iterator<IClasspathEntry> GxxxDNjR = Bl0B7P8M.iterator(); GxxxDNjR.hasNext();) {
						IClasspathEntry gGfamgxH = GxxxDNjR.next();
						if (gGfamgxH.getPath().isPrefixOf(lvxrTcJQ.getPath())) {
							GxxxDNjR.remove();
						}
					}
					String PjNha27S = JavaRuntime.JRE_CONTAINER;
					String RSdmRfYA = CodeGenUtil.EclipseUtil.getJavaComplianceLevel(v0Q9C4nE);
					if ("1.5".equals(RSdmRfYA)) {
						PjNha27S += "/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/J2SE-1.5";
					} else if ("1.6".equals(RSdmRfYA)) {
						PjNha27S += "/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.6";
					}
					Bl0B7P8M.add(JavaCore.newContainerEntry(new Path(PjNha27S)));
				}
				if ((OvdH9Vtm & EMF_EMPTY_PROJECT_STYLE) == 0) {
					if ((OvdH9Vtm & EMF_PLUGIN_PROJECT_STYLE) != 0) {
						Bl0B7P8M.add(JavaCore.newContainerEntry(new Path("org.eclipse.pde.core.requiredPlugins")));
						for (Iterator<IClasspathEntry> GL3tZbdl = Bl0B7P8M.iterator(); GL3tZbdl.hasNext();) {
							IClasspathEntry IWsZu2ip = GL3tZbdl.next();
							if (IWsZu2ip.getEntryKind() == IClasspathEntry.CPE_VARIABLE
									&& !JavaRuntime.JRELIB_VARIABLE.equals(IWsZu2ip.getPath().toString())
									|| IWsZu2ip.getEntryKind() == IClasspathEntry.CPE_PROJECT) {
								GL3tZbdl.remove();
							}
						}
					} else {
						CodeGenUtil.EclipseUtil.addClasspathEntries(Bl0B7P8M, "ECLIPSE_CORE_RUNTIME",
								"org.eclipse.core.runtime");
						CodeGenUtil.EclipseUtil.addClasspathEntries(Bl0B7P8M, "ECLIPSE_CORE_RESOURCES",
								"org.eclipse.core.resources");
						CodeGenUtil.EclipseUtil.addClasspathEntries(Bl0B7P8M, "EMF_COMMON", "org.eclipse.emf.common");
						CodeGenUtil.EclipseUtil.addClasspathEntries(Bl0B7P8M, "EMF_ECORE", "org.eclipse.emf.ecore");
						if ((OvdH9Vtm & EMF_XML_PROJECT_STYLE) != 0) {
							CodeGenUtil.EclipseUtil.addClasspathEntries(Bl0B7P8M, "EMF_ECORE_XMI",
									"org.eclipse.emf.ecore.xmi");
						}
						if ((OvdH9Vtm & EMF_MODEL_PROJECT_STYLE) == 0) {
							CodeGenUtil.EclipseUtil.addClasspathEntries(Bl0B7P8M, "EMF_EDIT", "org.eclipse.emf.edit");
							if ((OvdH9Vtm & EMF_EDIT_PROJECT_STYLE) == 0) {
								CodeGenUtil.EclipseUtil.addClasspathEntries(Bl0B7P8M, "ECLIPSE_SWT", "org.eclipse.swt");
								CodeGenUtil.EclipseUtil.addClasspathEntries(Bl0B7P8M, "ECLIPSE_JFACE",
										"org.eclipse.jface");
								CodeGenUtil.EclipseUtil.addClasspathEntries(Bl0B7P8M, "ECLIPSE_UI_VIEWS",
										"org.eclipse.ui.views");
								CodeGenUtil.EclipseUtil.addClasspathEntries(Bl0B7P8M, "ECLIPSE_UI_EDITORS",
										"org.eclipse.ui.editors");
								CodeGenUtil.EclipseUtil.addClasspathEntries(Bl0B7P8M, "ECLIPSE_UI_IDE",
										"org.eclipse.ui.ide");
								CodeGenUtil.EclipseUtil.addClasspathEntries(Bl0B7P8M, "ECLIPSE_UI_WORKBENCH",
										"org.eclipse.ui.workbench");
								CodeGenUtil.EclipseUtil.addClasspathEntries(Bl0B7P8M, "EMF_COMMON_UI",
										"org.eclipse.emf.common.ui");
								CodeGenUtil.EclipseUtil.addClasspathEntries(Bl0B7P8M, "EMF_EDIT_UI",
										"org.eclipse.emf.edit.ui");
								if ((OvdH9Vtm & EMF_XML_PROJECT_STYLE) == 0) {
									CodeGenUtil.EclipseUtil.addClasspathEntries(Bl0B7P8M, "EMF_ECORE_XMI",
											"org.eclipse.emf.ecore.xmi");
								}
							}
						}
						if ((OvdH9Vtm & EMF_TESTS_PROJECT_STYLE) != 0) {
							CodeGenUtil.EclipseUtil.addClasspathEntries(Bl0B7P8M, "JUNIT", "org.junit");
						}
						if (naZIH0BS != null) {
							for (Iterator<?> Oh8TQsl5 = naZIH0BS.iterator(); Oh8TQsl5.hasNext();) {
								Object D1xWJQe7 = Oh8TQsl5.next();
								if (D1xWJQe7 instanceof IClasspathEntry) {
									Bl0B7P8M.add((IClasspathEntry) D1xWJQe7);
								} else if (D1xWJQe7 instanceof String) {
									String VUXKpfAh = (String) D1xWJQe7;
									String LhLsmRyv;
									String yBoAXx14;
									int Mw4XrXVt = VUXKpfAh.indexOf("=");
									if (Mw4XrXVt == -1) {
										LhLsmRyv = VUXKpfAh.replace('.', '_').toUpperCase();
										yBoAXx14 = VUXKpfAh;
									} else {
										LhLsmRyv = VUXKpfAh.substring(0, Mw4XrXVt);
										yBoAXx14 = VUXKpfAh.substring(Mw4XrXVt + 1);
									}
									CodeGenUtil.EclipseUtil.addClasspathEntries(Bl0B7P8M, LhLsmRyv, yBoAXx14);
								}
							}
						}
					}
				}
				NwcJ2wzd.setRawClasspath(Bl0B7P8M.toArray(new IClasspathEntry[Bl0B7P8M.size()]),
						new SubProgressMonitor(JMVmDfLI, 1));
			}
			if (mkuAoW2S) {
				NwcJ2wzd.setOutputLocation(new Path("/" + R1JmH2zy.segment(0) + "/bin"),
						new SubProgressMonitor(JMVmDfLI, 1));
			}
		} catch (Exception tkM1zn5y) {
			tkM1zn5y.printStackTrace();
			CodeGenEcorePlugin.INSTANCE.log(tkM1zn5y);
		} finally {
			JMVmDfLI.done();
		}
		return v0Q9C4nE;
	}

}