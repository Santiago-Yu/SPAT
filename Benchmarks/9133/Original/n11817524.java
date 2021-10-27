class n11817524{
    private void addServices(Bundle bundle) {
        if (!resolvedBundles.containsKey(bundle)) {
            Enumeration enumeration = bundle.findEntries("META-INF", "*services.xml", false);
            int i = 0;
            List<AxisServiceGroup> axisServiceGroupList = null;
            if (enumeration != null) {
                axisServiceGroupList = new ArrayList<AxisServiceGroup>();
            }
            while (enumeration != null && enumeration.hasMoreElements()) {
                try {
                    URL url = (URL) enumeration.nextElement();
                    AxisServiceGroup serviceGroup = new AxisServiceGroup(configCtx.getAxisConfiguration());
                    serviceGroup.addParameter("last.updated", bundle.getLastModified());
                    ClassLoader loader = new BundleClassLoader(bundle, Registry.class.getClassLoader());
                    serviceGroup.setServiceGroupClassLoader(loader);
                    InputStream inputStream = url.openStream();
                    DescriptionBuilder builder = new DescriptionBuilder(inputStream, configCtx);
                    OMElement rootElement = builder.buildOM();
                    String elementName = rootElement.getLocalName();
                    Dictionary headers = bundle.getHeaders();
                    String bundleSymbolicName = (String) headers.get("Bundle-SymbolicName");
                    bundleSymbolicName = bundleSymbolicName + "_" + i;
                    serviceGroup.setServiceGroupName(bundleSymbolicName);
                    HashMap wsdlServicesMap = new HashMap();
                    if (DeploymentConstants.TAG_SERVICE.equals(elementName)) {
                        AxisService axisService = new AxisService(bundleSymbolicName);
                        axisService.setParent(serviceGroup);
                        axisService.setClassLoader(loader);
                        ServiceBuilder serviceBuilder = new OSGiServiceBuilder(configCtx, axisService);
                        serviceBuilder.setWsdlServiceMap(wsdlServicesMap);
                        AxisService service = serviceBuilder.populateService(rootElement);
                        ArrayList<AxisService> serviceList = new ArrayList<AxisService>();
                        serviceList.add(service);
                        DeploymentEngine.addServiceGroup(serviceGroup, serviceList, null, null, configCtx.getAxisConfiguration());
                        log.info("[Axis2/OSGi] Deployed axis2 service:" + service.getName() + " in Bundle: " + bundle.getSymbolicName());
                    } else if (DeploymentConstants.TAG_SERVICE_GROUP.equals(elementName)) {
                        ServiceGroupBuilder groupBuilder = new OSGiServiceGroupBuilder(rootElement, wsdlServicesMap, configCtx);
                        ArrayList serviceList = groupBuilder.populateServiceGroup(serviceGroup);
                        DeploymentEngine.addServiceGroup(serviceGroup, serviceList, null, null, configCtx.getAxisConfiguration());
                        log.info("[Axis2/OSGi] Deployed axis2 service group:" + serviceGroup.getServiceGroupName() + " in Bundle: " + bundle.getSymbolicName());
                    }
                    serviceGroup.addParameter(OSGi_BUNDLE_ID, bundle.getBundleId());
                    axisServiceGroupList.add(serviceGroup);
                    if (unreslovedBundles.contains(bundle)) {
                        unreslovedBundles.remove(bundle);
                    }
                    i++;
                } catch (Throwable e) {
                    String msg = "Error while reading from the bundle";
                    if (e instanceof DeploymentException) {
                        String message = e.getMessage();
                        if (message != null && message.length() != 0) {
                            if (message.indexOf(MODULE_NOT_FOUND_ERROR) > -1) {
                                if (!unreslovedBundles.contains(bundle)) {
                                    log.info("A service being found with unmeant module " + "dependency. Hence, moved it to UNRESOLVED state.");
                                    unreslovedBundles.add(bundle);
                                } else {
                                    log.info("A service being found in UNRESOLVED state.");
                                }
                            } else {
                                log.error(msg, e);
                                break;
                            }
                        } else {
                            log.error(msg, e);
                            break;
                        }
                    } else {
                        log.error(msg, e);
                        break;
                    }
                }
            }
            if (axisServiceGroupList != null && axisServiceGroupList.size() > 0) {
                resolvedBundles.put(bundle, axisServiceGroupList);
            }
        }
    }

}