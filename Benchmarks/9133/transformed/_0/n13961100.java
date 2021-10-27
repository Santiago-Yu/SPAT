class n13961100 {
	public void initialize(IProgressMonitor srFwpqwb) throws JETException {
		IProgressMonitor jjzEKLZg = srFwpqwb;
		jjzEKLZg.beginTask("", 10);
		jjzEKLZg.subTask(CodeGenPlugin.getPlugin().getString("_UI_GeneratingJETEmitterFor_message",
				new Object[] { getTemplateURI() }));
		final IWorkspace DuGyP9WV = ResourcesPlugin.getWorkspace();
		IJavaModel V02HCm9G = JavaCore.create(ResourcesPlugin.getWorkspace().getRoot());
		try {
			final JETCompiler TQbsi027 = getTemplateURIPath() == null
					? new MyBaseJETCompiler(getTemplateURI(), getEncoding(), getClassLoader())
					: new MyBaseJETCompiler(getTemplateURIPath(), getTemplateURI(), getEncoding(), getClassLoader());
			jjzEKLZg.subTask(CodeGenPlugin.getPlugin().getString("_UI_JETParsing_message",
					new Object[] { TQbsi027.getResolvedTemplateURI() }));
			TQbsi027.parse();
			jjzEKLZg.worked(1);
			String NxVBtdSr = TQbsi027.getSkeleton().getPackageName();
			if (getTemplateURIPath() != null) {
				URI neOvJsc8 = URI.createURI(getTemplateURIPath()[0]);
				URLClassLoader VPXCQmJs = null;
				if (neOvJsc8.isPlatformResource()) {
					IProject npn0QNEn = DuGyP9WV.getRoot().getProject(neOvJsc8.segment(1));
					if (JETNature.getRuntime(npn0QNEn) != null) {
						List<URL> oUYrESL0 = new ArrayList<URL>();
						IJavaProject YzwbIeJf = JavaCore.create(npn0QNEn);
						oUYrESL0.add(new File(npn0QNEn.getLocation() + "/"
								+ YzwbIeJf.getOutputLocation().removeFirstSegments(1) + "/").toURI().toURL());
						for (IClasspathEntry b8k2aVpl : YzwbIeJf.getResolvedClasspath(true)) {
							if (b8k2aVpl.getEntryKind() == IClasspathEntry.CPE_PROJECT) {
								IPath cOUfKeaQ = b8k2aVpl.getPath();
								IProject AB5yTjPB = DuGyP9WV.getRoot().getProject(cOUfKeaQ.segment(0));
								IJavaProject GtSyORUH = JavaCore.create(AB5yTjPB);
								oUYrESL0.add(new File(AB5yTjPB.getLocation() + "/"
										+ GtSyORUH.getOutputLocation().removeFirstSegments(1) + "/").toURI().toURL());
							}
						}
						VPXCQmJs = AccessController.doPrivileged(new GetURLClassLoaderSuperAction(oUYrESL0));
					}
				} else if (neOvJsc8.isPlatformPlugin()) {
					final Bundle Two875Pu = Platform.getBundle(neOvJsc8.segment(1));
					if (Two875Pu != null) {
						VPXCQmJs = AccessController.doPrivileged(new GetURLClassLoaderBundleAction(Two875Pu));
					}
				}
				if (VPXCQmJs != null) {
					String RAQ7jCcv = (NxVBtdSr.length() == 0 ? "" : NxVBtdSr + ".")
							+ TQbsi027.getSkeleton().getClassName();
					if (RAQ7jCcv.endsWith("_")) {
						RAQ7jCcv = RAQ7jCcv.substring(0, RAQ7jCcv.length() - 1);
					}
					try {
						Class<?> dq9IQWoJ = VPXCQmJs.loadClass(RAQ7jCcv);
						Class<?> LnHrx0og = null;
						try {
							LnHrx0og = getClassLoader().loadClass(RAQ7jCcv);
						} catch (ClassNotFoundException vYO3NVPL) {
						}
						if (dq9IQWoJ != LnHrx0og) {
							String aOUW5ICU = TQbsi027.getSkeleton().getMethodName();
							Method[] NVbXqq92 = dq9IQWoJ.getDeclaredMethods();
							for (int MZHQx7Eh = 0; MZHQx7Eh < NVbXqq92.length; ++MZHQx7Eh) {
								if (NVbXqq92[MZHQx7Eh].getName().equals(aOUW5ICU)) {
									jetEmitter.setMethod(NVbXqq92[MZHQx7Eh]);
									break;
								}
							}
							return;
						}
					} catch (ClassNotFoundException FC3QsPEY) {
					}
				}
			}
			ByteArrayOutputStream FYhpy6QB = new ByteArrayOutputStream();
			TQbsi027.generate(FYhpy6QB);
			final InputStream aIEN2VfH = new ByteArrayInputStream(FYhpy6QB.toByteArray());
			if (!V02HCm9G.isOpen()) {
				V02HCm9G.open(new SubProgressMonitor(jjzEKLZg, 1));
			} else {
				jjzEKLZg.worked(1);
			}
			final IProject Go7l6Bd0 = DuGyP9WV.getRoot().getProject(jetEmitter.getProjectName());
			jjzEKLZg.subTask(CodeGenPlugin.getPlugin().getString("_UI_JETPreparingProject_message",
					new Object[] { Go7l6Bd0.getName() }));
			IJavaProject aMIvDX7p;
			if (!Go7l6Bd0.exists()) {
				jjzEKLZg.subTask("JET creating project " + Go7l6Bd0.getName());
				Go7l6Bd0.create(new SubProgressMonitor(jjzEKLZg, 1));
				jjzEKLZg.subTask(CodeGenPlugin.getPlugin().getString("_UI_JETCreatingProject_message",
						new Object[] { Go7l6Bd0.getName() }));
				IProjectDescription PvKb5RFo = DuGyP9WV.newProjectDescription(Go7l6Bd0.getName());
				PvKb5RFo.setNatureIds(new String[] { JavaCore.NATURE_ID });
				PvKb5RFo.setLocation(null);
				Go7l6Bd0.open(new SubProgressMonitor(jjzEKLZg, 1));
				Go7l6Bd0.setDescription(PvKb5RFo, new SubProgressMonitor(jjzEKLZg, 1));
			} else {
				Go7l6Bd0.open(new SubProgressMonitor(jjzEKLZg, 5));
				IProjectDescription AqZ8weOJ = Go7l6Bd0.getDescription();
				AqZ8weOJ.setNatureIds(new String[] { JavaCore.NATURE_ID });
				Go7l6Bd0.setDescription(AqZ8weOJ, new SubProgressMonitor(jjzEKLZg, 1));
			}
			aMIvDX7p = JavaCore.create(Go7l6Bd0);
			List<IClasspathEntry> Hr8EgGXL = new UniqueEList<IClasspathEntry>(
					Arrays.asList(aMIvDX7p.getRawClasspath()));
			for (int MNpyduFi = 0, XV9PaHxr = Hr8EgGXL.size(); MNpyduFi < XV9PaHxr; MNpyduFi++) {
				IClasspathEntry mO5GZjtA = Hr8EgGXL.get(MNpyduFi);
				if (mO5GZjtA.getEntryKind() == IClasspathEntry.CPE_SOURCE
						&& ("/" + Go7l6Bd0.getName()).equals(mO5GZjtA.getPath().toString())) {
					Hr8EgGXL.remove(MNpyduFi);
				}
			}
			jjzEKLZg.subTask(CodeGenPlugin.getPlugin().getString("_UI_JETInitializingProject_message",
					new Object[] { Go7l6Bd0.getName() }));
			IClasspathEntry EDsQv6G5 = JavaCore.newSourceEntry(new Path("/" + Go7l6Bd0.getName() + "/src"));
			IClasspathEntry XZCP3qCL = JavaCore.newContainerEntry(new Path("org.eclipse.jdt.launching.JRE_CONTAINER"));
			Hr8EgGXL.add(EDsQv6G5);
			Hr8EgGXL.add(XZCP3qCL);
			Hr8EgGXL.addAll(getClassPathEntries());
			IFolder Sll5xH6H = Go7l6Bd0.getFolder(new Path("src"));
			if (!Sll5xH6H.exists()) {
				Sll5xH6H.create(false, true, new SubProgressMonitor(jjzEKLZg, 1));
			}
			IFolder zL76x7rH = Go7l6Bd0.getFolder(new Path("bin"));
			if (!zL76x7rH.exists()) {
				zL76x7rH.create(false, true, new SubProgressMonitor(jjzEKLZg, 1));
			}
			aMIvDX7p.setRawClasspath(Hr8EgGXL.toArray(new IClasspathEntry[Hr8EgGXL.size()]),
					new SubProgressMonitor(jjzEKLZg, 1));
			aMIvDX7p.setOutputLocation(new Path("/" + Go7l6Bd0.getName() + "/bin"),
					new SubProgressMonitor(jjzEKLZg, 1));
			aMIvDX7p.close();
			jjzEKLZg.subTask(CodeGenPlugin.getPlugin().getString("_UI_JETOpeningJavaProject_message",
					new Object[] { Go7l6Bd0.getName() }));
			aMIvDX7p.open(new SubProgressMonitor(jjzEKLZg, 1));
			IPackageFragmentRoot[] rlguROdC = aMIvDX7p.getPackageFragmentRoots();
			IPackageFragmentRoot kZHr4ERT = null;
			for (int kWvokNa2 = 0; kWvokNa2 < rlguROdC.length; ++kWvokNa2) {
				IPackageFragmentRoot d1uRPfbW = rlguROdC[kWvokNa2];
				if (d1uRPfbW.getKind() == IPackageFragmentRoot.K_SOURCE) {
					kZHr4ERT = d1uRPfbW;
					break;
				}
			}
			StringTokenizer ofM32yGR = new StringTokenizer(NxVBtdSr, ".");
			IProgressMonitor tVuGTMr1 = new SubProgressMonitor(jjzEKLZg, 1);
			tVuGTMr1.beginTask("", ofM32yGR.countTokens() + 4);
			tVuGTMr1.subTask(CodeGenPlugin.getPlugin().getString("_UI_CreateTargetFile_message"));
			IContainer Owy85ZyV = kZHr4ERT == null ? Go7l6Bd0 : (IContainer) kZHr4ERT.getCorrespondingResource();
			while (ofM32yGR.hasMoreElements()) {
				String zdpuCMBV = ofM32yGR.nextToken();
				Owy85ZyV = Owy85ZyV.getFolder(new Path(zdpuCMBV));
				if (!Owy85ZyV.exists()) {
					((IFolder) Owy85ZyV).create(false, true, new SubProgressMonitor(tVuGTMr1, 1));
				}
			}
			IFile OFdb63GN = Owy85ZyV.getFile(new Path(TQbsi027.getSkeleton().getClassName() + ".java"));
			if (!OFdb63GN.exists()) {
				tVuGTMr1.subTask(CodeGenPlugin.getPlugin().getString("_UI_JETCreating_message",
						new Object[] { OFdb63GN.getFullPath() }));
				OFdb63GN.create(aIEN2VfH, true, new SubProgressMonitor(tVuGTMr1, 1));
			} else {
				tVuGTMr1.subTask(CodeGenPlugin.getPlugin().getString("_UI_JETUpdating_message",
						new Object[] { OFdb63GN.getFullPath() }));
				OFdb63GN.setContents(aIEN2VfH, true, true, new SubProgressMonitor(tVuGTMr1, 1));
			}
			tVuGTMr1.subTask(CodeGenPlugin.getPlugin().getString("_UI_JETBuilding_message",
					new Object[] { Go7l6Bd0.getName() }));
			Go7l6Bd0.build(IncrementalProjectBuilder.INCREMENTAL_BUILD, new SubProgressMonitor(tVuGTMr1, 1));
			boolean qhdLsZnz = hasErrors(tVuGTMr1, OFdb63GN);
			if (!qhdLsZnz) {
				tVuGTMr1.subTask(CodeGenPlugin.getPlugin().getString("_UI_JETLoadingClass_message",
						new Object[] { TQbsi027.getSkeleton().getClassName() + ".class" }));
				List<URL> tTC6Bu8B = new ArrayList<URL>();
				tTC6Bu8B.add(new File(
						Go7l6Bd0.getLocation() + "/" + aMIvDX7p.getOutputLocation().removeFirstSegments(1) + "/")
								.toURI().toURL());
				final Set<Bundle> nsJN9SVt = new HashSet<Bundle>();
				LOOP: for (IClasspathEntry noCve9Aq : jetEmitter.getClasspathEntries()) {
					IClasspathAttribute[] uC4HoxGX = noCve9Aq.getExtraAttributes();
					if (uC4HoxGX != null) {
						for (IClasspathAttribute QOOEVJh2 : uC4HoxGX) {
							if (QOOEVJh2.getName().equals(CodeGenUtil.EclipseUtil.PLUGIN_ID_CLASSPATH_ATTRIBUTE_NAME)) {
								Bundle SbdHLlvQ = Platform.getBundle(QOOEVJh2.getValue());
								if (SbdHLlvQ != null) {
									nsJN9SVt.add(SbdHLlvQ);
									continue LOOP;
								}
							}
						}
					}
					tTC6Bu8B.add(new URL("platform:/resource" + noCve9Aq.getPath() + "/"));
				}
				URLClassLoader BeAFLsp9 = AccessController
						.doPrivileged(new GetURLClassLoaderSuperBundlesAction(nsJN9SVt, tTC6Bu8B));
				Class<?> puGniGu3 = BeAFLsp9.loadClass(
						(NxVBtdSr.length() == 0 ? "" : NxVBtdSr + ".") + TQbsi027.getSkeleton().getClassName());
				String HwcZDgi7 = TQbsi027.getSkeleton().getMethodName();
				Method[] etEHcQ7z = puGniGu3.getDeclaredMethods();
				for (int A5i70l51 = 0; A5i70l51 < etEHcQ7z.length; ++A5i70l51) {
					if (etEHcQ7z[A5i70l51].getName().equals(HwcZDgi7)) {
						jetEmitter.setMethod(etEHcQ7z[A5i70l51]);
						break;
					}
				}
			}
			tVuGTMr1.done();
		} catch (CoreException SZWyziTf) {
			throw new JETException(SZWyziTf);
		} catch (Exception ysEfVXu6) {
			throw new JETException(ysEfVXu6);
		} finally {
			jjzEKLZg.done();
		}
	}

}