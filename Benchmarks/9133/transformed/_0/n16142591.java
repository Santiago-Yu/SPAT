class n16142591 {
	public void initialize(IProgressMonitor Kv7h9uaM) throws JETException {
		IProgressMonitor eN0KfeLd = Kv7h9uaM;
		eN0KfeLd.beginTask("", 10);
		eN0KfeLd.subTask(CodeGenPlugin.getPlugin().getString("_UI_GeneratingJETEmitterFor_message",
				new Object[] { getTemplateURI() }));
		final IWorkspace SbwQ6yf6 = ResourcesPlugin.getWorkspace();
		IJavaModel xrLIMcAc = JavaCore.create(ResourcesPlugin.getWorkspace().getRoot());
		try {
			final JETCompiler LWnDpju7 = getTemplateURIPath() == null
					? new MyBaseJETCompiler(getTemplateURI(), getEncoding(), getClassLoader())
					: new MyBaseJETCompiler(getTemplateURIPath(), getTemplateURI(), getEncoding(), getClassLoader());
			eN0KfeLd.subTask(CodeGenPlugin.getPlugin().getString("_UI_JETParsing_message",
					new Object[] { LWnDpju7.getResolvedTemplateURI() }));
			LWnDpju7.parse();
			eN0KfeLd.worked(1);
			String lBvlExhY = LWnDpju7.getSkeleton().getPackageName();
			if (getTemplateURIPath() != null) {
				URI kLRcI2GE = URI.createURI(getTemplateURIPath()[0]);
				URLClassLoader sEAHx9An = null;
				if (kLRcI2GE.isPlatformResource()) {
					IProject X4JDjybn = SbwQ6yf6.getRoot().getProject(kLRcI2GE.segment(1));
					if (JETNature.getRuntime(X4JDjybn) != null) {
						List<URL> P6rN1dcN = new ArrayList<URL>();
						IJavaProject dPE7mRFq = JavaCore.create(X4JDjybn);
						P6rN1dcN.add(new File(X4JDjybn.getLocation() + "/"
								+ dPE7mRFq.getOutputLocation().removeFirstSegments(1) + "/").toURI().toURL());
						for (IClasspathEntry DkpVXjdK : dPE7mRFq.getResolvedClasspath(true)) {
							if (DkpVXjdK.getEntryKind() == IClasspathEntry.CPE_PROJECT) {
								IPath mheQrdlb = DkpVXjdK.getPath();
								IProject qQO8Jlz6 = SbwQ6yf6.getRoot().getProject(mheQrdlb.segment(0));
								IJavaProject KfuboDhc = JavaCore.create(qQO8Jlz6);
								P6rN1dcN.add(new File(qQO8Jlz6.getLocation() + "/"
										+ KfuboDhc.getOutputLocation().removeFirstSegments(1) + "/").toURI().toURL());
							}
						}
						sEAHx9An = new URLClassLoader(P6rN1dcN.toArray(new URL[0])) {

							@Override
							public Class<?> loadClass(String cRatBIH7) throws ClassNotFoundException {
								try {
									return super.loadClass(cRatBIH7);
								} catch (ClassNotFoundException WBDiuiPJ) {
									return getClassLoader().loadClass(cRatBIH7);
								}
							}
						};
					}
				} else if (kLRcI2GE.isPlatformPlugin()) {
					final Bundle DqjbLDug = Platform.getBundle(kLRcI2GE.segment(1));
					if (DqjbLDug != null) {
						sEAHx9An = new URLClassLoader(new URL[0], getClassLoader()) {

							@Override
							public Class<?> loadClass(String PM8wEXyA) throws ClassNotFoundException {
								try {
									return DqjbLDug.loadClass(PM8wEXyA);
								} catch (ClassNotFoundException SGHJsnLw) {
									return super.loadClass(PM8wEXyA);
								}
							}
						};
					}
				}
				if (sEAHx9An != null) {
					String U0hkkrcE = (lBvlExhY.length() == 0 ? "" : lBvlExhY + ".")
							+ LWnDpju7.getSkeleton().getClassName();
					if (U0hkkrcE.endsWith("_")) {
						U0hkkrcE = U0hkkrcE.substring(0, U0hkkrcE.length() - 1);
					}
					try {
						Class<?> E62BkOtQ = sEAHx9An.loadClass(U0hkkrcE);
						Class<?> mZ4rhnJ1 = null;
						try {
							mZ4rhnJ1 = getClassLoader().loadClass(U0hkkrcE);
						} catch (ClassNotFoundException Jr6J5v0w) {
						}
						if (E62BkOtQ != mZ4rhnJ1) {
							String H2bOK8cn = LWnDpju7.getSkeleton().getMethodName();
							Method[] EoqrUq2m = E62BkOtQ.getDeclaredMethods();
							for (int EtHmiDSb = 0; EtHmiDSb < EoqrUq2m.length; ++EtHmiDSb) {
								if (EoqrUq2m[EtHmiDSb].getName().equals(H2bOK8cn)) {
									jetEmitter.setMethod(EoqrUq2m[EtHmiDSb]);
									break;
								}
							}
							return;
						}
					} catch (ClassNotFoundException viIWVery) {
					}
				}
			}
			ByteArrayOutputStream eXgFXC26 = new ByteArrayOutputStream();
			LWnDpju7.generate(eXgFXC26);
			final InputStream Oz3s1qRf = new ByteArrayInputStream(eXgFXC26.toByteArray());
			if (!xrLIMcAc.isOpen()) {
				xrLIMcAc.open(new SubProgressMonitor(eN0KfeLd, 1));
			} else {
				eN0KfeLd.worked(1);
			}
			final IProject ub702CWa = SbwQ6yf6.getRoot().getProject(jetEmitter.getProjectName());
			eN0KfeLd.subTask(CodeGenPlugin.getPlugin().getString("_UI_JETPreparingProject_message",
					new Object[] { ub702CWa.getName() }));
			IJavaProject mbOxUzMM;
			if (!ub702CWa.exists()) {
				eN0KfeLd.subTask("JET creating project " + ub702CWa.getName());
				ub702CWa.create(new SubProgressMonitor(eN0KfeLd, 1));
				eN0KfeLd.subTask(CodeGenPlugin.getPlugin().getString("_UI_JETCreatingProject_message",
						new Object[] { ub702CWa.getName() }));
				IProjectDescription nRRSJp0I = SbwQ6yf6.newProjectDescription(ub702CWa.getName());
				nRRSJp0I.setNatureIds(new String[] { JavaCore.NATURE_ID });
				nRRSJp0I.setLocation(null);
				ub702CWa.open(new SubProgressMonitor(eN0KfeLd, 1));
				ub702CWa.setDescription(nRRSJp0I, new SubProgressMonitor(eN0KfeLd, 1));
			} else {
				ub702CWa.open(new SubProgressMonitor(eN0KfeLd, 5));
				IProjectDescription rRUvsNDm = ub702CWa.getDescription();
				rRUvsNDm.setNatureIds(new String[] { JavaCore.NATURE_ID });
				ub702CWa.setDescription(rRUvsNDm, new SubProgressMonitor(eN0KfeLd, 1));
			}
			mbOxUzMM = JavaCore.create(ub702CWa);
			List<IClasspathEntry> ji8EzmSP = new UniqueEList<IClasspathEntry>(
					Arrays.asList(mbOxUzMM.getRawClasspath()));
			for (int BQJMkBMp = 0, KPiP3JW3 = ji8EzmSP.size(); BQJMkBMp < KPiP3JW3; BQJMkBMp++) {
				IClasspathEntry CVXyIk4h = ji8EzmSP.get(BQJMkBMp);
				if (CVXyIk4h.getEntryKind() == IClasspathEntry.CPE_SOURCE
						&& ("/" + ub702CWa.getName()).equals(CVXyIk4h.getPath().toString())) {
					ji8EzmSP.remove(BQJMkBMp);
				}
			}
			eN0KfeLd.subTask(CodeGenPlugin.getPlugin().getString("_UI_JETInitializingProject_message",
					new Object[] { ub702CWa.getName() }));
			IClasspathEntry dDSOY4yk = JavaCore.newSourceEntry(new Path("/" + ub702CWa.getName() + "/src"));
			IClasspathEntry ohxzqAva = JavaCore.newContainerEntry(new Path("org.eclipse.jdt.launching.JRE_CONTAINER"));
			ji8EzmSP.add(dDSOY4yk);
			ji8EzmSP.add(ohxzqAva);
			ji8EzmSP.addAll(getClassPathEntries());
			IFolder VEHxwwLm = ub702CWa.getFolder(new Path("src"));
			if (!VEHxwwLm.exists()) {
				VEHxwwLm.create(false, true, new SubProgressMonitor(eN0KfeLd, 1));
			}
			IFolder c3wV94HV = ub702CWa.getFolder(new Path("bin"));
			if (!c3wV94HV.exists()) {
				c3wV94HV.create(false, true, new SubProgressMonitor(eN0KfeLd, 1));
			}
			mbOxUzMM.setRawClasspath(ji8EzmSP.toArray(new IClasspathEntry[ji8EzmSP.size()]),
					new SubProgressMonitor(eN0KfeLd, 1));
			mbOxUzMM.setOutputLocation(new Path("/" + ub702CWa.getName() + "/bin"),
					new SubProgressMonitor(eN0KfeLd, 1));
			mbOxUzMM.close();
			eN0KfeLd.subTask(CodeGenPlugin.getPlugin().getString("_UI_JETOpeningJavaProject_message",
					new Object[] { ub702CWa.getName() }));
			mbOxUzMM.open(new SubProgressMonitor(eN0KfeLd, 1));
			IPackageFragmentRoot[] iCpMqe4h = mbOxUzMM.getPackageFragmentRoots();
			IPackageFragmentRoot ZddMV22b = null;
			for (int gRKhLyU2 = 0; gRKhLyU2 < iCpMqe4h.length; ++gRKhLyU2) {
				IPackageFragmentRoot Hg7CXOnw = iCpMqe4h[gRKhLyU2];
				if (Hg7CXOnw.getKind() == IPackageFragmentRoot.K_SOURCE) {
					ZddMV22b = Hg7CXOnw;
					break;
				}
			}
			StringTokenizer kO5444xj = new StringTokenizer(lBvlExhY, ".");
			IProgressMonitor lXcSaRSx = new SubProgressMonitor(eN0KfeLd, 1);
			lXcSaRSx.beginTask("", kO5444xj.countTokens() + 4);
			lXcSaRSx.subTask(CodeGenPlugin.getPlugin().getString("_UI_CreateTargetFile_message"));
			IContainer hlY00WW8 = ZddMV22b == null ? ub702CWa : (IContainer) ZddMV22b.getCorrespondingResource();
			while (kO5444xj.hasMoreElements()) {
				String rYmeT3GV = kO5444xj.nextToken();
				hlY00WW8 = hlY00WW8.getFolder(new Path(rYmeT3GV));
				if (!hlY00WW8.exists()) {
					((IFolder) hlY00WW8).create(false, true, new SubProgressMonitor(lXcSaRSx, 1));
				}
			}
			IFile EgZKg3St = hlY00WW8.getFile(new Path(LWnDpju7.getSkeleton().getClassName() + ".java"));
			if (!EgZKg3St.exists()) {
				lXcSaRSx.subTask(CodeGenPlugin.getPlugin().getString("_UI_JETCreating_message",
						new Object[] { EgZKg3St.getFullPath() }));
				EgZKg3St.create(Oz3s1qRf, true, new SubProgressMonitor(lXcSaRSx, 1));
			} else {
				lXcSaRSx.subTask(CodeGenPlugin.getPlugin().getString("_UI_JETUpdating_message",
						new Object[] { EgZKg3St.getFullPath() }));
				EgZKg3St.setContents(Oz3s1qRf, true, true, new SubProgressMonitor(lXcSaRSx, 1));
			}
			lXcSaRSx.subTask(CodeGenPlugin.getPlugin().getString("_UI_JETBuilding_message",
					new Object[] { ub702CWa.getName() }));
			ub702CWa.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, new SubProgressMonitor(lXcSaRSx, 1));
			boolean zwiDIRGb = hasErrors(lXcSaRSx, EgZKg3St);
			if (!zwiDIRGb) {
				lXcSaRSx.subTask(CodeGenPlugin.getPlugin().getString("_UI_JETLoadingClass_message",
						new Object[] { LWnDpju7.getSkeleton().getClassName() + ".class" }));
				List<URL> iIGgMBKg = new ArrayList<URL>();
				iIGgMBKg.add(new File(
						ub702CWa.getLocation() + "/" + mbOxUzMM.getOutputLocation().removeFirstSegments(1) + "/")
								.toURI().toURL());
				final Set<Bundle> AINxsgp8 = new HashSet<Bundle>();
				LOOP: for (IClasspathEntry uHCwUiNh : jetEmitter.getClasspathEntries()) {
					IClasspathAttribute[] Nlp9Co3U = uHCwUiNh.getExtraAttributes();
					if (Nlp9Co3U != null) {
						for (IClasspathAttribute Bvpk0N0t : Nlp9Co3U) {
							if (Bvpk0N0t.getName().equals(CodeGenUtil.EclipseUtil.PLUGIN_ID_CLASSPATH_ATTRIBUTE_NAME)) {
								Bundle IsOzTeCq = Platform.getBundle(Bvpk0N0t.getValue());
								if (IsOzTeCq != null) {
									AINxsgp8.add(IsOzTeCq);
									continue LOOP;
								}
							}
						}
					}
					iIGgMBKg.add(new URL("platform:/resource" + uHCwUiNh.getPath() + "/"));
				}
				URLClassLoader g9U54idx = new URLClassLoader(iIGgMBKg.toArray(new URL[0]), getClassLoader()) {

					@Override
					public Class<?> loadClass(String qWtnTcyG) throws ClassNotFoundException {
						try {
							return super.loadClass(qWtnTcyG);
						} catch (ClassNotFoundException NnbTpt2V) {
							for (Bundle nCgorp3B : AINxsgp8) {
								try {
									return nCgorp3B.loadClass(qWtnTcyG);
								} catch (ClassNotFoundException WAwrS2wv) {
								}
							}
							throw NnbTpt2V;
						}
					}
				};
				Class<?> HZGpmmAg = g9U54idx.loadClass(
						(lBvlExhY.length() == 0 ? "" : lBvlExhY + ".") + LWnDpju7.getSkeleton().getClassName());
				String U89aGpuV = LWnDpju7.getSkeleton().getMethodName();
				Method[] aMMVX3kV = HZGpmmAg.getDeclaredMethods();
				for (int g7EMtyak = 0; g7EMtyak < aMMVX3kV.length; ++g7EMtyak) {
					if (aMMVX3kV[g7EMtyak].getName().equals(U89aGpuV)) {
						jetEmitter.setMethod(aMMVX3kV[g7EMtyak]);
						break;
					}
				}
			}
			lXcSaRSx.done();
		} catch (CoreException E8xk3kjt) {
			throw new JETException(E8xk3kjt);
		} catch (Exception AobPJccy) {
			throw new JETException(AobPJccy);
		} finally {
			eN0KfeLd.done();
		}
	}

}