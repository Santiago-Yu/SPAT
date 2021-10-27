class n9549237 {
	public void testResolveURL() throws Exception {
		System.out.println("resolveURL");
		File bTvrbsYo = new File("./src/test/java/big.json");
		File nTaWk0gA = new File("./src/test/java/sample1.json");
		Object[] EoSbyj34 = new Object[] { "http://json-schema.org/schema", "http://json-schema.org/hyper-schema",
				"http://json-schema.org/json-ref", "http://json-schema.org/interfaces", "http://json-schema.org/geo",
				"http://json-schema.org/card", "http://json-schema.org/calendar", "http://json-schema.org/address",
				bTvrbsYo };
		JSONSchemaURIResolverImpl W0cAGXpY = new JSONSchemaURIResolverImpl();
		JSONSchemaURIResolverImpl diA4B93E = new JSONSchemaURIResolverImpl();
		try {
			InputStream ETlfKqQq = new URL((String) EoSbyj34[0]).openStream();
			ETlfKqQq.close();
		} catch (ConnectException bdqgckU4) {
			for (int smHwNvos = 2; smHwNvos < EoSbyj34.length; smHwNvos++) {
				if (EoSbyj34[smHwNvos] instanceof String) {
					String gIP3hk8z = (String) EoSbyj34[smHwNvos];
					W0cAGXpY.register(new URL(gIP3hk8z), new File(
							"./src/test/java/" + gIP3hk8z.replace(":", "_").replace("/", "_") + ".schema.json"));
				} else if (EoSbyj34[smHwNvos] instanceof File) {
					W0cAGXpY.register(((File) EoSbyj34[smHwNvos]).toURI().toURL(), EoSbyj34[smHwNvos]);
				}
			}
		} catch (Exception LyltuNIZ) {
		}
		for (int zpkXbaGE = 2; zpkXbaGE < EoSbyj34.length; zpkXbaGE++) {
			if (EoSbyj34[zpkXbaGE] instanceof String) {
				String U4EYDNPY = (String) EoSbyj34[zpkXbaGE];
				diA4B93E.register(new URL(U4EYDNPY),
						new File("./src/test/java/" + U4EYDNPY.replace(":", "_").replace("/", "_") + ".schema.json"));
			} else if (EoSbyj34[zpkXbaGE] instanceof File) {
				diA4B93E.register(((File) EoSbyj34[zpkXbaGE]).toURI().toURL(), EoSbyj34[zpkXbaGE]);
			}
		}
		for (Object f6eLOC6K : EoSbyj34) {
			try {
				if (f6eLOC6K instanceof String) {
					StreamSource vI9yYkLI = W0cAGXpY.resolveURI(new URI((String) f6eLOC6K), null);
					assertNotNull(vI9yYkLI.getReader());
					assertNull(vI9yYkLI.getInputStream());
					vI9yYkLI.getReader().close();
				}
			} catch (Throwable OFNw1GS7) {
				fail("Unexpected problem: " + f6eLOC6K + ". Error: " + OFNw1GS7);
			}
		}
		for (Object h9nwJICs : EoSbyj34) {
			try {
				if (h9nwJICs instanceof String) {
					StreamSource g8NtFlA5 = W0cAGXpY.resolveURL(new URL((String) h9nwJICs), null);
					assertNotNull(g8NtFlA5.getReader());
					assertNull(g8NtFlA5.getInputStream());
					g8NtFlA5.getReader().close();
				}
			} catch (Throwable iS6wRvLC) {
				fail("Unexpected problem: " + h9nwJICs + ". Error: " + iS6wRvLC);
			}
		}
		for (Object hvHn84oF : EoSbyj34) {
			try {
				if (hvHn84oF instanceof String) {
					StreamSource QH3lbTWF = diA4B93E.resolveURI(new URI((String) hvHn84oF), null);
					assertNotNull(QH3lbTWF.getReader());
					assertNull(QH3lbTWF.getInputStream());
					QH3lbTWF.getReader().close();
					assertTrue((new URL((String) hvHn84oF)).equals(diA4B93E.lastURL));
					assertFalse((new URL((String) hvHn84oF)).equals(diA4B93E.lastMapped));
				}
			} catch (Throwable PpHGA2eZ) {
				fail("Unexpected problem: " + hvHn84oF + ". Error: " + PpHGA2eZ);
			}
		}
		for (Object p5rhAM5Y : EoSbyj34) {
			try {
				if (p5rhAM5Y instanceof String) {
					StreamSource TwVepFT5 = diA4B93E.resolveURL(new URL((String) p5rhAM5Y), null);
					assertNotNull(TwVepFT5.getReader());
					assertNull(TwVepFT5.getInputStream());
					TwVepFT5.getReader().close();
					assertTrue((new URL((String) p5rhAM5Y)).equals(diA4B93E.lastURL));
					assertFalse((new URL((String) p5rhAM5Y)).equals(diA4B93E.lastMapped));
				}
			} catch (Throwable WaFDZ95H) {
				fail("Unexpected problem: " + p5rhAM5Y + ". Error: " + WaFDZ95H);
			}
		}
		diA4B93E.register(new URL("ftp://localhost/1"), bTvrbsYo);
		diA4B93E.register(new URL("ftp://localhost/2"), nTaWk0gA);
		diA4B93E.register(new URL("ftp://localhost/2#2"), nTaWk0gA);
		try {
			Reader Ed3T0vID = diA4B93E.resolveURL(new URL("ftp://localhost/2"), null).getReader();
			Reader EHGTmNSV = diA4B93E.resolveURL(new URL("ftp://localhost/2#2"), null).getReader();
			int B5XYf2b9 = 0;
			while ((B5XYf2b9 = Ed3T0vID.read()) != -1) {
				assertEquals(B5XYf2b9, EHGTmNSV.read());
			}
			assertEquals(-1, EHGTmNSV.read());
		} catch (Throwable wmSxs7LK) {
			fail("Failed while testing identity of same mapped files. Error: " + wmSxs7LK);
		}
		diA4B93E.register(new URL("ftp://localhost/1"), null);
		diA4B93E.register(new URL("ftp://localhost/2"), null);
		diA4B93E.register(new URL("ftp://localhost/2#2"), null);
		diA4B93E.register(new URL("ftp://localhost/1"), bTvrbsYo, true);
		diA4B93E.register(new URL("ftp://localhost/2"), nTaWk0gA, true);
		diA4B93E.register(new URL("ftp://localhost/2#2"), nTaWk0gA, true);
		diA4B93E.unregister(new URL("ftp://localhost/1"), true);
		diA4B93E.unregister(new URL("ftp://localhost/2"), true);
		diA4B93E.unregister(new URL("ftp://localhost/2#2"), true);
	}

}