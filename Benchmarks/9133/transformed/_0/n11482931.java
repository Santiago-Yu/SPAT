class n11482931 {
	public void generate(FileObject AFPvggSN, FileObject etdFFrWD, List<Library> fIFtU87e, String f6Lma4xo)
			throws FileSystemException {
		if (!AFPvggSN.exists()) {
			AFPvggSN.createFolder();
		}
		ZipUtils.extractZip(
				new ClasspathResource(classResolver, "/com/erinors/tapestry/tapdoc/standalone/resources.zip"),
				AFPvggSN);
		for (Library nf3cg5PZ : fIFtU87e) {
			String RDkfGieO = nf3cg5PZ.getName();
			String l962zj8B = nf3cg5PZ.getLocation();
			AFPvggSN.resolveFile(fileNameGenerator.getLibraryDirectory(l962zj8B)).createFolder();
			try {
				{
					String AgmO6W8E = XsltUtils.xsltTransform(f6Lma4xo, getClass().getResourceAsStream("Library.xsl"),
							"libraryName", RDkfGieO);
					FileObject X4xobmdp = AFPvggSN.resolveFile(fileNameGenerator.getLibraryDirectory(l962zj8B))
							.resolveFile("index.html");
					Writer Aea09ozE = new OutputStreamWriter(X4xobmdp.getContent().getOutputStream(), "UTF-8");
					Aea09ozE.write(AgmO6W8E);
					Aea09ozE.close();
				}
				{
					String Z0bgFYcG = XsltUtils.xsltTransform(f6Lma4xo,
							getClass().getResourceAsStream("ComponentIndex.xsl"), "libraryName", RDkfGieO);
					FileObject xnpSdpkK = AFPvggSN.resolveFile(fileNameGenerator.getLibraryDirectory(l962zj8B))
							.resolveFile("components.html");
					Writer VnyxmGtZ = new OutputStreamWriter(xnpSdpkK.getContent().getOutputStream(), "UTF-8");
					VnyxmGtZ.write(Z0bgFYcG);
					VnyxmGtZ.close();
				}
			} catch (Exception jqlHqFe4) {
				throw new RuntimeException(jqlHqFe4);
			}
			for (Component a6LGeirD : nf3cg5PZ.getComponents()) {
				String t7pFfS2c = a6LGeirD.getName();
				System.out.println("Generating " + RDkfGieO + ":" + t7pFfS2c + "...");
				Map<String, String> xzacs1NF = new HashMap<String, String>();
				xzacs1NF.put("libraryName", RDkfGieO);
				xzacs1NF.put("componentName", t7pFfS2c);
				String J4lWZQLF = XsltUtils.xsltTransform(f6Lma4xo, getClass().getResourceAsStream("Component.xsl"),
						xzacs1NF);
				Writer b8t2Fqwc = null;
				try {
					FileObject yM5ZmMce = AFPvggSN
							.resolveFile(fileNameGenerator.getComponentIndexFile(l962zj8B, t7pFfS2c, true));
					b8t2Fqwc = new OutputStreamWriter(yM5ZmMce.getContent().getOutputStream(), "UTF-8");
					b8t2Fqwc.write(J4lWZQLF);
					b8t2Fqwc.close();
					Resource COJcdnsR = a6LGeirD.getSpecificationLocation();
					if (COJcdnsR.getRelativeResource(t7pFfS2c + "_tapdoc/resource").getResourceURL() != null) {
						File N9FhG60u = new File(
								COJcdnsR.getRelativeResource(t7pFfS2c + "_tapdoc/resource").getResourceURL().toURI());
						FileObject yFcUKEap = AFPvggSN
								.resolveFile(fileNameGenerator.getComponentDirectory(l962zj8B, t7pFfS2c))
								.resolveFile("resource");
						if (N9FhG60u.exists() && N9FhG60u.isDirectory()) {
							File[] QZD1VBMZ = N9FhG60u.listFiles();
							if (QZD1VBMZ != null) {
								for (File UVWJlpZU : QZD1VBMZ) {
									if (UVWJlpZU.isFile() && !UVWJlpZU.isHidden()) {
										FileObject JPJZe7Z6 = yFcUKEap.resolveFile(UVWJlpZU.getName());
										JPJZe7Z6.createFile();
										InputStream AWngUKGq = null;
										OutputStream IBV7xB5D = null;
										try {
											AWngUKGq = new FileInputStream(UVWJlpZU);
											IBV7xB5D = JPJZe7Z6.getContent().getOutputStream();
											IOUtils.copy(AWngUKGq, IBV7xB5D);
										} finally {
											IOUtils.closeQuietly(AWngUKGq);
											IOUtils.closeQuietly(IBV7xB5D);
										}
									}
								}
							}
						}
					}
				} catch (Exception rwB0hMg5) {
					throw new RuntimeException(rwB0hMg5);
				} finally {
					if (b8t2Fqwc != null) {
						try {
							b8t2Fqwc.close();
						} catch (IOException NULceb5n) {
							NULceb5n.printStackTrace();
						}
					}
				}
			}
		}
		{
			Writer CYbB6ek8 = null;
			try {
				{
					String SCBRpj1O = XsltUtils.xsltTransform(f6Lma4xo,
							getClass().getResourceAsStream("LibraryIndex.xsl"));
					FileObject M5DlHBq2 = AFPvggSN.resolveFile("libraries.html");
					CYbB6ek8 = new OutputStreamWriter(M5DlHBq2.getContent().getOutputStream(), "UTF-8");
					CYbB6ek8.write(SCBRpj1O);
					CYbB6ek8.close();
				}
				{
					String jqbguUnK = XsltUtils.xsltTransform(f6Lma4xo, getClass().getResourceAsStream("Overview.xsl"));
					FileObject kqH5WX2x = AFPvggSN.resolveFile("overview.html");
					CYbB6ek8 = new OutputStreamWriter(kqH5WX2x.getContent().getOutputStream(), "UTF-8");
					CYbB6ek8.write(jqbguUnK);
					CYbB6ek8.close();
				}
				{
					String mnC30SgB = XsltUtils.xsltTransform(f6Lma4xo,
							getClass().getResourceAsStream("AllComponents.xsl"));
					FileObject QBitgcLq = AFPvggSN.resolveFile("allcomponents.html");
					CYbB6ek8 = new OutputStreamWriter(QBitgcLq.getContent().getOutputStream(), "UTF-8");
					CYbB6ek8.write(mnC30SgB);
					CYbB6ek8.close();
				}
			} catch (Exception NpVONsBK) {
				throw new RuntimeException(NpVONsBK);
			} finally {
				IOUtils.closeQuietly(CYbB6ek8);
			}
		}
	}

}