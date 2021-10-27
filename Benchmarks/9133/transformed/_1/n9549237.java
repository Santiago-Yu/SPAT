class n9549237 {
	public void testResolveURL() throws Exception {
		System.out.println("resolveURL");
		File bigFile = new File("./src/test/java/big.json");
		File smallFile = new File("./src/test/java/sample1.json");
		Object[] urls = new Object[] { "http://json-schema.org/schema", "http://json-schema.org/hyper-schema",
				"http://json-schema.org/json-ref", "http://json-schema.org/interfaces", "http://json-schema.org/geo",
				"http://json-schema.org/card", "http://json-schema.org/calendar", "http://json-schema.org/address",
				bigFile };
		JSONSchemaURIResolverImpl uriResolver = new JSONSchemaURIResolverImpl();
		JSONSchemaURIResolverImpl uriResolver2 = new JSONSchemaURIResolverImpl();
		try {
			InputStream is = new URL((String) urls[0]).openStream();
			is.close();
		} catch (ConnectException cex) {
			int yZuxz = 2;
			while (yZuxz < urls.length) {
				if (urls[yZuxz] instanceof String) {
					String url = (String) urls[yZuxz];
					uriResolver.register(new URL(url),
							new File("./src/test/java/" + url.replace(":", "_").replace("/", "_") + ".schema.json"));
				} else if (urls[yZuxz] instanceof File) {
					uriResolver.register(((File) urls[yZuxz]).toURI().toURL(), urls[yZuxz]);
				}
				yZuxz++;
			}
		} catch (Exception ex) {
		}
		int zJcw0 = 2;
		while (zJcw0 < urls.length) {
			if (urls[zJcw0] instanceof String) {
				String url = (String) urls[zJcw0];
				uriResolver2.register(new URL(url),
						new File("./src/test/java/" + url.replace(":", "_").replace("/", "_") + ".schema.json"));
			} else if (urls[zJcw0] instanceof File) {
				uriResolver2.register(((File) urls[zJcw0]).toURI().toURL(), urls[zJcw0]);
			}
			zJcw0++;
		}
		for (Object source : urls) {
			try {
				if (source instanceof String) {
					StreamSource ss = uriResolver.resolveURI(new URI((String) source), null);
					assertNotNull(ss.getReader());
					assertNull(ss.getInputStream());
					ss.getReader().close();
				}
			} catch (Throwable th) {
				fail("Unexpected problem: " + source + ". Error: " + th);
			}
		}
		for (Object source : urls) {
			try {
				if (source instanceof String) {
					StreamSource ss = uriResolver.resolveURL(new URL((String) source), null);
					assertNotNull(ss.getReader());
					assertNull(ss.getInputStream());
					ss.getReader().close();
				}
			} catch (Throwable th) {
				fail("Unexpected problem: " + source + ". Error: " + th);
			}
		}
		for (Object source : urls) {
			try {
				if (source instanceof String) {
					StreamSource ss = uriResolver2.resolveURI(new URI((String) source), null);
					assertNotNull(ss.getReader());
					assertNull(ss.getInputStream());
					ss.getReader().close();
					assertTrue((new URL((String) source)).equals(uriResolver2.lastURL));
					assertFalse((new URL((String) source)).equals(uriResolver2.lastMapped));
				}
			} catch (Throwable th) {
				fail("Unexpected problem: " + source + ". Error: " + th);
			}
		}
		for (Object source : urls) {
			try {
				if (source instanceof String) {
					StreamSource ss = uriResolver2.resolveURL(new URL((String) source), null);
					assertNotNull(ss.getReader());
					assertNull(ss.getInputStream());
					ss.getReader().close();
					assertTrue((new URL((String) source)).equals(uriResolver2.lastURL));
					assertFalse((new URL((String) source)).equals(uriResolver2.lastMapped));
				}
			} catch (Throwable th) {
				fail("Unexpected problem: " + source + ". Error: " + th);
			}
		}
		uriResolver2.register(new URL("ftp://localhost/1"), bigFile);
		uriResolver2.register(new URL("ftp://localhost/2"), smallFile);
		uriResolver2.register(new URL("ftp://localhost/2#2"), smallFile);
		try {
			Reader r1 = uriResolver2.resolveURL(new URL("ftp://localhost/2"), null).getReader();
			Reader r2 = uriResolver2.resolveURL(new URL("ftp://localhost/2#2"), null).getReader();
			int ch = 0;
			while ((ch = r1.read()) != -1) {
				assertEquals(ch, r2.read());
			}
			assertEquals(-1, r2.read());
		} catch (Throwable th) {
			fail("Failed while testing identity of same mapped files. Error: " + th);
		}
		uriResolver2.register(new URL("ftp://localhost/1"), null);
		uriResolver2.register(new URL("ftp://localhost/2"), null);
		uriResolver2.register(new URL("ftp://localhost/2#2"), null);
		uriResolver2.register(new URL("ftp://localhost/1"), bigFile, true);
		uriResolver2.register(new URL("ftp://localhost/2"), smallFile, true);
		uriResolver2.register(new URL("ftp://localhost/2#2"), smallFile, true);
		uriResolver2.unregister(new URL("ftp://localhost/1"), true);
		uriResolver2.unregister(new URL("ftp://localhost/2"), true);
		uriResolver2.unregister(new URL("ftp://localhost/2#2"), true);
	}

}