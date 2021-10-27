class n6644748 {
	public static void initialize(Monitor rnLR3uTt, final JETEmitter dNtNYRsg) throws JETException {
		IProgressMonitor Evhm1oRa = BasicMonitor.toIProgressMonitor(rnLR3uTt);
		Evhm1oRa.beginTask("", 10);
		Evhm1oRa.subTask(CodeGenPlugin.getPlugin().getString("_UI_GeneratingJETEmitterFor_message",
				new Object[] { dNtNYRsg.templateURI }));
		final IWorkspace LwUCpNsE = ResourcesPlugin.getWorkspace();
		IJavaModel jnK14brs = JavaCore.create(ResourcesPlugin.getWorkspace().getRoot());
		try {
			final JETCompiler TQgDG5re = dNtNYRsg.templateURIPath == null
					? new MyBaseJETCompiler(dNtNYRsg.templateURI, dNtNYRsg.encoding, dNtNYRsg.classLoader)
					: new MyBaseJETCompiler(dNtNYRsg.templateURIPath, dNtNYRsg.templateURI, dNtNYRsg.encoding,
							dNtNYRsg.classLoader);
			Evhm1oRa.subTask(CodeGenPlugin.getPlugin().getString("_UI_JETParsing_message",
					new Object[] { TQgDG5re.getResolvedTemplateURI() }));
			TQgDG5re.parse();
			Evhm1oRa.worked(1);
			String D9GR7lc7 = TQgDG5re.getSkeleton().getPackageName();
			if (dNtNYRsg.templateURIPath != null) {
				URI e6Jf1hZ4 = URI.createURI(dNtNYRsg.templateURIPath[0]);
				URLClassLoader DinA8ukJ = null;
				if (e6Jf1hZ4.isPlatformResource()) {
					IProject QBBoATbB = LwUCpNsE.getRoot().getProject(e6Jf1hZ4.segment(1));
					if (JETNature.getRuntime(QBBoATbB) != null) {
						List<URL> ypn61hfc = new ArrayList<URL>();
						IJavaProject VaEEkejD = JavaCore.create(QBBoATbB);
						ypn61hfc.add(new File(QBBoATbB.getLocation() + "/"
								+ VaEEkejD.getOutputLocation().removeFirstSegments(1) + "/").toURL());
						for (IClasspathEntry KTdOe6tG : VaEEkejD.getResolvedClasspath(true)) {
							if (KTdOe6tG.getEntryKind() == IClasspathEntry.CPE_PROJECT) {
								IPath g37jpBCl = KTdOe6tG.getPath();
								IProject NOfqsujt = LwUCpNsE.getRoot().getProject(g37jpBCl.segment(0));
								IJavaProject udX96Xd2 = JavaCore.create(NOfqsujt);
								ypn61hfc.add(new File(NOfqsujt.getLocation() + "/"
										+ udX96Xd2.getOutputLocation().removeFirstSegments(1) + "/").toURL());
							}
						}
						DinA8ukJ = new URLClassLoader(ypn61hfc.toArray(new URL[0])) {

							@Override
							public Class<?> loadClass(String Enlqp14w) throws ClassNotFoundException {
								try {
									return super.loadClass(Enlqp14w);
								} catch (ClassNotFoundException b66p8YCZ) {
									return dNtNYRsg.classLoader.loadClass(Enlqp14w);
								}
							}
						};
					}
				} else if (e6Jf1hZ4.isPlatformPlugin()) {
					final Bundle dR1O2s9N = Platform.getBundle(e6Jf1hZ4.segment(1));
					if (dR1O2s9N != null) {
						DinA8ukJ = new URLClassLoader(new URL[0], dNtNYRsg.classLoader) {

							@Override
							public Class<?> loadClass(String lQfXdLZU) throws ClassNotFoundException {
								try {
									return dR1O2s9N.loadClass(lQfXdLZU);
								} catch (ClassNotFoundException GRTu22uQ) {
									return super.loadClass(lQfXdLZU);
								}
							}
						};
					}
				}
				if (DinA8ukJ != null) {
					String uab7xhTB = (D9GR7lc7.length() == 0 ? "" : D9GR7lc7 + ".")
							+ TQgDG5re.getSkeleton().getClassName();
					if (uab7xhTB.endsWith("_")) {
						uab7xhTB = uab7xhTB.substring(0, uab7xhTB.length() - 1);
					}
					try {
						Class<?> DXhjA9P6 = DinA8ukJ.loadClass(uab7xhTB);
						Class<?> hsqeeuks = null;
						try {
							hsqeeuks = dNtNYRsg.classLoader.loadClass(uab7xhTB);
						} catch (ClassNotFoundException nPS4YpnC) {
						}
						if (DXhjA9P6 != hsqeeuks) {
							String PZ35N9Fv = TQgDG5re.getSkeleton().getMethodName();
							Method[] XyMPc0Do = DXhjA9P6.getDeclaredMethods();
							for (int IAxvTK8y = 0; IAxvTK8y < XyMPc0Do.length; ++IAxvTK8y) {
								if (XyMPc0Do[IAxvTK8y].getName().equals(PZ35N9Fv)) {
									dNtNYRsg.setMethod(XyMPc0Do[IAxvTK8y]);
									break;
								}
							}
							return;
						}
					} catch (ClassNotFoundException ZxI53wtz) {
					}
				}
			}
			ByteArrayOutputStream a8CaOoqc = new ByteArrayOutputStream();
			TQgDG5re.generate(a8CaOoqc);
			final InputStream oOYZ3amm = new ByteArrayInputStream(a8CaOoqc.toByteArray());
			if (!jnK14brs.isOpen()) {
				jnK14brs.open(new SubProgressMonitor(Evhm1oRa, 1));
			} else {
				Evhm1oRa.worked(1);
			}
			final IProject pU1UFXB5 = LwUCpNsE.getRoot().getProject(dNtNYRsg.getProjectName());
			Evhm1oRa.subTask(CodeGenPlugin.getPlugin().getString("_UI_JETPreparingProject_message",
					new Object[] { pU1UFXB5.getName() }));
			IJavaProject ZNamSEjr;
			if (!pU1UFXB5.exists()) {
				Evhm1oRa.subTask("JET creating project " + pU1UFXB5.getName());
				pU1UFXB5.create(new SubProgressMonitor(Evhm1oRa, 1));
				Evhm1oRa.subTask(CodeGenPlugin.getPlugin().getString("_UI_JETCreatingProject_message",
						new Object[] { pU1UFXB5.getName() }));
				IProjectDescription IddWeskq = LwUCpNsE.newProjectDescription(pU1UFXB5.getName());
				IddWeskq.setNatureIds(new String[] { JavaCore.NATURE_ID });
				IddWeskq.setLocation(null);
				pU1UFXB5.open(new SubProgressMonitor(Evhm1oRa, 1));
				pU1UFXB5.setDescription(IddWeskq, new SubProgressMonitor(Evhm1oRa, 1));
				ZNamSEjr = JavaCore.create(pU1UFXB5);
				for (Map.Entry<String, String> option : dNtNYRsg.getJavaOptions().entrySet()) {
					ZNamSEjr.setOption(option.getKey(), option.getValue());
				}
			} else {
				pU1UFXB5.open(new SubProgressMonitor(Evhm1oRa, 5));
				IProjectDescription BgAE8lXW = pU1UFXB5.getDescription();
				BgAE8lXW.setNatureIds(new String[] { JavaCore.NATURE_ID });
				pU1UFXB5.setDescription(BgAE8lXW, new SubProgressMonitor(Evhm1oRa, 1));
				ZNamSEjr = JavaCore.create(pU1UFXB5);
			}
			List<IClasspathEntry> iyPd2L9m = new UniqueEList<IClasspathEntry>(
					Arrays.asList(ZNamSEjr.getRawClasspath()));
			for (int muDmu6jl = 0, Zan3E0yG = iyPd2L9m.size(); muDmu6jl < Zan3E0yG; muDmu6jl++) {
				IClasspathEntry nL4P2Vgy = iyPd2L9m.get(muDmu6jl);
				if (nL4P2Vgy.getEntryKind() == IClasspathEntry.CPE_SOURCE
						&& ("/" + pU1UFXB5.getName()).equals(nL4P2Vgy.getPath().toString())) {
					iyPd2L9m.remove(muDmu6jl);
				}
			}
			Evhm1oRa.subTask(CodeGenPlugin.getPlugin().getString("_UI_JETInitializingProject_message",
					new Object[] { pU1UFXB5.getName() }));
			IClasspathEntry TxBtcO2O = JavaCore.newSourceEntry(new Path("/" + pU1UFXB5.getName() + "/src"));
			IClasspathEntry H3LgPUuJ = JavaCore.newContainerEntry(new Path("org.eclipse.jdt.launching.JRE_CONTAINER"));
			iyPd2L9m.add(TxBtcO2O);
			iyPd2L9m.add(H3LgPUuJ);
			iyPd2L9m.addAll(dNtNYRsg.classpathEntries);
			IFolder Za5kxhiM = pU1UFXB5.getFolder(new Path("src"));
			if (!Za5kxhiM.exists()) {
				Za5kxhiM.create(false, true, new SubProgressMonitor(Evhm1oRa, 1));
			}
			IFolder OLR7j6oy = pU1UFXB5.getFolder(new Path("bin"));
			if (!OLR7j6oy.exists()) {
				OLR7j6oy.create(false, true, new SubProgressMonitor(Evhm1oRa, 1));
			}
			ZNamSEjr.setRawClasspath(iyPd2L9m.toArray(new IClasspathEntry[iyPd2L9m.size()]),
					new SubProgressMonitor(Evhm1oRa, 1));
			ZNamSEjr.setOutputLocation(new Path("/" + pU1UFXB5.getName() + "/bin"),
					new SubProgressMonitor(Evhm1oRa, 1));
			ZNamSEjr.close();
			Evhm1oRa.subTask(CodeGenPlugin.getPlugin().getString("_UI_JETOpeningJavaProject_message",
					new Object[] { pU1UFXB5.getName() }));
			ZNamSEjr.open(new SubProgressMonitor(Evhm1oRa, 1));
			IPackageFragmentRoot[] dnMGbx4M = ZNamSEjr.getPackageFragmentRoots();
			IPackageFragmentRoot k1rbguMB = null;
			for (int nsNFRqXM = 0; nsNFRqXM < dnMGbx4M.length; ++nsNFRqXM) {
				IPackageFragmentRoot hObNQbpt = dnMGbx4M[nsNFRqXM];
				if (hObNQbpt.getKind() == IPackageFragmentRoot.K_SOURCE) {
					k1rbguMB = hObNQbpt;
					break;
				}
			}
			StringTokenizer yVMnha5n = new StringTokenizer(D9GR7lc7, ".");
			IProgressMonitor KutMsLod = new SubProgressMonitor(Evhm1oRa, 1);
			KutMsLod.beginTask("", yVMnha5n.countTokens() + 4);
			KutMsLod.subTask(CodeGenPlugin.getPlugin().getString("_UI_CreateTargetFile_message"));
			IContainer bbvY8dyW = k1rbguMB == null ? pU1UFXB5 : (IContainer) k1rbguMB.getCorrespondingResource();
			while (yVMnha5n.hasMoreElements()) {
				String ps7eaHPP = yVMnha5n.nextToken();
				bbvY8dyW = bbvY8dyW.getFolder(new Path(ps7eaHPP));
				if (!bbvY8dyW.exists()) {
					((IFolder) bbvY8dyW).create(false, true, new SubProgressMonitor(KutMsLod, 1));
				}
			}
			IFile vbFby80E = bbvY8dyW.getFile(new Path(TQgDG5re.getSkeleton().getClassName() + ".java"));
			if (!vbFby80E.exists()) {
				KutMsLod.subTask(CodeGenPlugin.getPlugin().getString("_UI_JETCreating_message",
						new Object[] { vbFby80E.getFullPath() }));
				vbFby80E.create(oOYZ3amm, true, new SubProgressMonitor(KutMsLod, 1));
			} else {
				KutMsLod.subTask(CodeGenPlugin.getPlugin().getString("_UI_JETUpdating_message",
						new Object[] { vbFby80E.getFullPath() }));
				vbFby80E.setContents(oOYZ3amm, true, true, new SubProgressMonitor(KutMsLod, 1));
			}
			KutMsLod.subTask(CodeGenPlugin.getPlugin().getString("_UI_JETBuilding_message",
					new Object[] { pU1UFXB5.getName() }));
			pU1UFXB5.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, new SubProgressMonitor(KutMsLod, 1));
			IMarker[] Zl8tvMHv = vbFby80E.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
			boolean B1PyXHCK = false;
			for (int iUE3KzHb = 0; iUE3KzHb < Zl8tvMHv.length; ++iUE3KzHb) {
				IMarker ImeQP0j2 = Zl8tvMHv[iUE3KzHb];
				if (ImeQP0j2.getAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO) == IMarker.SEVERITY_ERROR) {
					B1PyXHCK = true;
					KutMsLod.subTask(ImeQP0j2.getAttribute(IMarker.MESSAGE) + " : "
							+ (CodeGenPlugin.getPlugin().getString("jet.mark.file.line", new Object[] {
									vbFby80E.getLocation(), ImeQP0j2.getAttribute(IMarker.LINE_NUMBER) })));
				}
			}
			if (!B1PyXHCK) {
				KutMsLod.subTask(CodeGenPlugin.getPlugin().getString("_UI_JETLoadingClass_message",
						new Object[] { TQgDG5re.getSkeleton().getClassName() + ".class" }));
				List<URL> EDzr4KbX = new ArrayList<URL>();
				EDzr4KbX.add(new File(
						pU1UFXB5.getLocation() + "/" + ZNamSEjr.getOutputLocation().removeFirstSegments(1) + "/")
								.toURL());
				final Set<Bundle> tPKWlpV7 = new HashSet<Bundle>();
				LOOP: for (IClasspathEntry X1ef8wQD : dNtNYRsg.getClasspathEntries()) {
					IClasspathAttribute[] VaeCqva4 = X1ef8wQD.getExtraAttributes();
					if (VaeCqva4 != null) {
						for (IClasspathAttribute uBdxUJfc : VaeCqva4) {
							if (uBdxUJfc.getName().equals(CodeGenUtil.EclipseUtil.PLUGIN_ID_CLASSPATH_ATTRIBUTE_NAME)) {
								Bundle gPwpSpvM = Platform.getBundle(uBdxUJfc.getValue());
								if (gPwpSpvM != null) {
									tPKWlpV7.add(gPwpSpvM);
									continue LOOP;
								}
							}
						}
					}
					EDzr4KbX.add(new URL("platform:/resource" + X1ef8wQD.getPath() + "/"));
				}
				URLClassLoader IjzKJDUT = new URLClassLoader(EDzr4KbX.toArray(new URL[0]), dNtNYRsg.classLoader) {

					@Override
					public Class<?> loadClass(String apPDiTI4) throws ClassNotFoundException {
						try {
							return super.loadClass(apPDiTI4);
						} catch (ClassNotFoundException ghVleGLR) {
							for (Bundle AbsPL2oP : tPKWlpV7) {
								try {
									return AbsPL2oP.loadClass(apPDiTI4);
								} catch (ClassNotFoundException crlvlFzn) {
								}
							}
							throw ghVleGLR;
						}
					}
				};
				Class<?> O9AGXuI4 = IjzKJDUT.loadClass(
						(D9GR7lc7.length() == 0 ? "" : D9GR7lc7 + ".") + TQgDG5re.getSkeleton().getClassName());
				String J8wjzhYR = TQgDG5re.getSkeleton().getMethodName();
				Method[] m1DMbqTC = O9AGXuI4.getDeclaredMethods();
				for (int kKXFU5uH = 0; kKXFU5uH < m1DMbqTC.length; ++kKXFU5uH) {
					if (m1DMbqTC[kKXFU5uH].getName().equals(J8wjzhYR)) {
						dNtNYRsg.setMethod(m1DMbqTC[kKXFU5uH]);
						break;
					}
				}
			}
			KutMsLod.done();
		} catch (CoreException Vk7FdnMA) {
			throw new JETException(Vk7FdnMA);
		} catch (Exception kpxx3cfX) {
			throw new JETException(kpxx3cfX);
		} finally {
			Evhm1oRa.done();
		}
	}

}