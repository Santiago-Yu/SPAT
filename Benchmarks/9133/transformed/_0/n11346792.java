class n11346792 {
	public void generate(FileObject NGbYHkLg, FileObject U5wTNw0c, List<Library> psoxCFap, String wPtRBOr9)
			throws FileSystemException {
		if (!U5wTNw0c.exists()) {
			U5wTNw0c.createFolder();
		}
		if (NGbYHkLg.exists()) {
			NGbYHkLg.createFolder();
		}
		ZipUtils.extractZip(
				new ClasspathResource(classResolver, "/com/erinors/tapestry/tapdoc/service/xdoc/resources.zip"),
				NGbYHkLg);
		for (Library NVsTIt8S : psoxCFap) {
			String ujj6zKTq = NVsTIt8S.getName();
			String t3IAfeBd = NVsTIt8S.getLocation();
			U5wTNw0c.resolveFile(fileNameGenerator.getLibraryDirectory(t3IAfeBd)).createFolder();
			try {
				String VYINgn5E = XsltUtils.xsltTransform(wPtRBOr9, getClass().getResourceAsStream("Library.xsl"),
						"libraryName", ujj6zKTq);
				FileObject Sx4fABgq = U5wTNw0c.resolveFile(fileNameGenerator.getLibraryDirectory(t3IAfeBd))
						.resolveFile("index.xml");
				Writer gBmJ7rdP = new OutputStreamWriter(Sx4fABgq.getContent().getOutputStream(), "UTF-8");
				gBmJ7rdP.write(VYINgn5E);
				gBmJ7rdP.close();
			} catch (Exception nxIpuK7x) {
				throw new RuntimeException(nxIpuK7x);
			}
			for (Component QNCx2Vw7 : NVsTIt8S.getComponents()) {
				String tB7gqifo = QNCx2Vw7.getName();
				System.out.println("Generating " + ujj6zKTq + ":" + tB7gqifo + "...");
				Map<String, String> rGmjDo3X = new HashMap<String, String>();
				rGmjDo3X.put("libraryName", ujj6zKTq);
				rGmjDo3X.put("componentName", tB7gqifo);
				String Qe35w1d6 = XsltUtils.xsltTransform(wPtRBOr9, getClass().getResourceAsStream("Component.xsl"),
						rGmjDo3X);
				Writer nPXyAiAg = null;
				try {
					FileObject vrlGiZr3 = U5wTNw0c
							.resolveFile(fileNameGenerator.getComponentIndexFile(t3IAfeBd, tB7gqifo, true));
					nPXyAiAg = new OutputStreamWriter(vrlGiZr3.getContent().getOutputStream(), "UTF-8");
					nPXyAiAg.write(Qe35w1d6);
					nPXyAiAg.close();
					Resource nNkpYPAq = QNCx2Vw7.getSpecificationLocation();
					if (nNkpYPAq.getRelativeResource(tB7gqifo + "_tapdoc/resource").getResourceURL() != null) {
						File c1tZDWCj = new File(
								nNkpYPAq.getRelativeResource(tB7gqifo + "_tapdoc/resource").getResourceURL().toURI());
						FileObject Mlqsw60f = NGbYHkLg
								.resolveFile(fileNameGenerator.getComponentDirectory(t3IAfeBd, tB7gqifo))
								.resolveFile("resource");
						if (c1tZDWCj.exists() && c1tZDWCj.isDirectory()) {
							File[] RVkD5XWf = c1tZDWCj.listFiles();
							if (RVkD5XWf != null) {
								for (File AcWSAXoP : RVkD5XWf) {
									if (AcWSAXoP.isFile() && !AcWSAXoP.isHidden()) {
										FileObject q8G5qrlq = Mlqsw60f.resolveFile(AcWSAXoP.getName());
										q8G5qrlq.createFile();
										InputStream N9zWvKtb = null;
										OutputStream V98eFp9T = null;
										try {
											N9zWvKtb = new FileInputStream(AcWSAXoP);
											V98eFp9T = q8G5qrlq.getContent().getOutputStream();
											IOUtils.copy(N9zWvKtb, V98eFp9T);
										} finally {
											IOUtils.closeQuietly(N9zWvKtb);
											IOUtils.closeQuietly(V98eFp9T);
										}
									}
								}
							}
						}
					}
				} catch (Exception K17H2N8I) {
					throw new RuntimeException(K17H2N8I);
				} finally {
					IOUtils.closeQuietly(nPXyAiAg);
				}
			}
		}
		{
			Writer S504QZTU = null;
			try {
				String e6Bro8gT = XsltUtils.xsltTransform(wPtRBOr9, getClass().getResourceAsStream("Overview.xsl"));
				FileObject N9m2URQr = U5wTNw0c.resolveFile("index.xml");
				S504QZTU = new OutputStreamWriter(N9m2URQr.getContent().getOutputStream(), "UTF-8");
				S504QZTU.write(e6Bro8gT);
				S504QZTU.close();
			} catch (Exception dXfp6rwD) {
				throw new RuntimeException(dXfp6rwD);
			} finally {
				IOUtils.closeQuietly(S504QZTU);
			}
		}
	}

}