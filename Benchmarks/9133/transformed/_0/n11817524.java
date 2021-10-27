class n11817524 {
	private void addServices(Bundle Cm7cOprE) {
		if (!resolvedBundles.containsKey(Cm7cOprE)) {
			Enumeration bG5TdaQx = Cm7cOprE.findEntries("META-INF", "*services.xml", false);
			int B4p7yovv = 0;
			List<AxisServiceGroup> YconJwls = null;
			if (bG5TdaQx != null) {
				YconJwls = new ArrayList<AxisServiceGroup>();
			}
			while (bG5TdaQx != null && bG5TdaQx.hasMoreElements()) {
				try {
					URL Pop7OzG5 = (URL) bG5TdaQx.nextElement();
					AxisServiceGroup dWvAAmJF = new AxisServiceGroup(configCtx.getAxisConfiguration());
					dWvAAmJF.addParameter("last.updated", Cm7cOprE.getLastModified());
					ClassLoader A1tk4X4N = new BundleClassLoader(Cm7cOprE, Registry.class.getClassLoader());
					dWvAAmJF.setServiceGroupClassLoader(A1tk4X4N);
					InputStream rRK5OePD = Pop7OzG5.openStream();
					DescriptionBuilder C0sAJIKA = new DescriptionBuilder(rRK5OePD, configCtx);
					OMElement Zl6hZADF = C0sAJIKA.buildOM();
					String FSyLZHzn = Zl6hZADF.getLocalName();
					Dictionary Np6yjwOI = Cm7cOprE.getHeaders();
					String FutUa5ge = (String) Np6yjwOI.get("Bundle-SymbolicName");
					FutUa5ge = FutUa5ge + "_" + B4p7yovv;
					dWvAAmJF.setServiceGroupName(FutUa5ge);
					HashMap Lamt9dI5 = new HashMap();
					if (DeploymentConstants.TAG_SERVICE.equals(FSyLZHzn)) {
						AxisService HspAQ2Of = new AxisService(FutUa5ge);
						HspAQ2Of.setParent(dWvAAmJF);
						HspAQ2Of.setClassLoader(A1tk4X4N);
						ServiceBuilder QSh0JzSq = new OSGiServiceBuilder(configCtx, HspAQ2Of);
						QSh0JzSq.setWsdlServiceMap(Lamt9dI5);
						AxisService sIciptXf = QSh0JzSq.populateService(Zl6hZADF);
						ArrayList<AxisService> RLvoWTla = new ArrayList<AxisService>();
						RLvoWTla.add(sIciptXf);
						DeploymentEngine.addServiceGroup(dWvAAmJF, RLvoWTla, null, null,
								configCtx.getAxisConfiguration());
						log.info("[Axis2/OSGi] Deployed axis2 service:" + sIciptXf.getName() + " in Bundle: "
								+ Cm7cOprE.getSymbolicName());
					} else if (DeploymentConstants.TAG_SERVICE_GROUP.equals(FSyLZHzn)) {
						ServiceGroupBuilder yG1Ft2Hu = new OSGiServiceGroupBuilder(Zl6hZADF, Lamt9dI5, configCtx);
						ArrayList rFPcHH9t = yG1Ft2Hu.populateServiceGroup(dWvAAmJF);
						DeploymentEngine.addServiceGroup(dWvAAmJF, rFPcHH9t, null, null,
								configCtx.getAxisConfiguration());
						log.info("[Axis2/OSGi] Deployed axis2 service group:" + dWvAAmJF.getServiceGroupName()
								+ " in Bundle: " + Cm7cOprE.getSymbolicName());
					}
					dWvAAmJF.addParameter(OSGi_BUNDLE_ID, Cm7cOprE.getBundleId());
					YconJwls.add(dWvAAmJF);
					if (unreslovedBundles.contains(Cm7cOprE)) {
						unreslovedBundles.remove(Cm7cOprE);
					}
					B4p7yovv++;
				} catch (Throwable BxcwJ5gf) {
					String px3wHiX8 = "Error while reading from the bundle";
					if (BxcwJ5gf instanceof DeploymentException) {
						String gwG2UDQv = BxcwJ5gf.getMessage();
						if (gwG2UDQv != null && gwG2UDQv.length() != 0) {
							if (gwG2UDQv.indexOf(MODULE_NOT_FOUND_ERROR) > -1) {
								if (!unreslovedBundles.contains(Cm7cOprE)) {
									log.info("A service being found with unmeant module "
											+ "dependency. Hence, moved it to UNRESOLVED state.");
									unreslovedBundles.add(Cm7cOprE);
								} else {
									log.info("A service being found in UNRESOLVED state.");
								}
							} else {
								log.error(px3wHiX8, BxcwJ5gf);
								break;
							}
						} else {
							log.error(px3wHiX8, BxcwJ5gf);
							break;
						}
					} else {
						log.error(px3wHiX8, BxcwJ5gf);
						break;
					}
				}
			}
			if (YconJwls != null && YconJwls.size() > 0) {
				resolvedBundles.put(Cm7cOprE, YconJwls);
			}
		}
	}

}