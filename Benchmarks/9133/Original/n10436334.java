class n10436334{
    Bundle install(String location, InputStream is) throws BundleException {
        synchronized (bundlesLock) {
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                securityManager.checkPermission(new AdminPermission(new StringBuilder("(location=").append(location).append(")").toString(), org.osgi.framework.AdminPermission.EXTENSIONLIFECYCLE));
            }
            long bundleId = getNextBundleId();
            AbstractBundle bundle = null;
            try {
                if (is == null) {
                    URL url = new URL(location);
                    is = url.openStream();
                }
                File temp = new File(getTempFolder(), Long.toString(System.currentTimeMillis()));
                OutputStream os;
                os = new FileOutputStream(temp);
                IOUtil.copy(is, os);
                os.close();
                is.close();
                Manifest manifest = ManifestUtil.getJarManifest(new FileInputStream(temp));
                Dictionary headers = ManifestUtil.toDictionary(manifest);
                Version version = Version.parseVersion((String) headers.get(Constants.BUNDLE_VERSION));
                File cache = createNewCache(bundleId, version);
                File manifestFile = new File(cache, BUNDLE_MANIFEST_FILE);
                os = new FileOutputStream(manifestFile);
                ManifestUtil.storeManifest(headers, os);
                os.close();
                if (isBundleInstalled((String) headers.get(Constants.BUNDLE_SYMBOLICNAME))) {
                    throw new BundleException(new StringBuilder("Bundle(location=").append(location).append(") already installed.").toString());
                }
                ManifestEntry[] entries = ManifestEntry.parse(headers.get(Constants.FRAGMENT_HOST));
                if (entries != null) {
                    if (entries[0].hasAttribute("extension")) {
                        String extension = entries[0].getAttributeValue("extension");
                        if (extension.equals("bootclasspath")) {
                            String symbolicName = entries[0].getName();
                            if (!symbolicName.equals(framework.getSymbolicName()) && !symbolicName.equals(Constants.SYSTEM_BUNDLE_SYMBOLICNAME)) {
                                throw new BundleException(new StringBuilder("Trying to install a fragment Bundle(location=").append(location).append(") with extension 'bootclasspath' but host is not System Bundle.").toString(), new UnsupportedOperationException());
                            }
                        }
                    }
                }
                String requiredEE = (String) headers.get(Constants.BUNDLE_REQUIREDEXECUTIONENVIRONMENT);
                if (requiredEE != null) {
                    BundleContext context = framework.getBundleContext();
                    String ee = context.getProperty(Constants.FRAMEWORK_EXECUTIONENVIRONMENT);
                    if (!ee.contains(requiredEE)) {
                        throw new BundleException(new StringBuilder("Bundle(location=").append(location).append(")  requires an unsopperted execution environment (=").append(requiredEE).append(").").toString());
                    }
                }
                if (FrameworkUtil.isFragmentHost(headers)) {
                    bundle = new FragmentBundle(framework);
                } else {
                    bundle = new HostBundle(framework);
                }
                File bundlefile = new File(cache, Storage.BUNDLE_FILE);
                temp.renameTo(bundlefile);
                long lastModified = bundlefile.lastModified();
                BundleInfo info = new BundleInfo(bundleId, location, lastModified, framework.getInitialBundleStartLevel());
                info.setHeaders(headers);
                info.setCache(cache);
                storeBundleInfo(info);
                bundleInfosByBundle.put(bundle, info);
                BundleURLClassPath classPath = createBundleURLClassPath(bundle, version, bundlefile, cache, false);
                classPathsByBundle.put(bundle, new BundleURLClassPath[] { classPath });
                synchronized (bundlesLock) {
                    bundles = (Bundle[]) ArrayUtil.add(bundles, bundle);
                }
                return bundle;
            } catch (Exception e) {
                if (bundle != null) {
                    File bundleFolder = getBundleFolder(bundleId);
                    try {
                        IOUtil.delete(bundleFolder);
                    } catch (IOException e1) {
                    }
                }
                e.printStackTrace();
                throw new BundleException(e.getMessage(), e);
            }
        }
    }

}