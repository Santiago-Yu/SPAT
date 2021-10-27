class n5422086 {
	public void writeOutput(String u9881N8U) throws IOException {
		File OfVa3mJn = new File(u9881N8U);
		int yjFiqd9u = 0;
		if (OfVa3mJn.isDirectory()) {
			for (AppInventorScreen n0Qe0KfJ : screens.values()) {
				File bepkH4Zt = new File(getScreenFilePath(OfVa3mJn.getAbsolutePath(), n0Qe0KfJ));
				bepkH4Zt.getParentFile().mkdirs();
				bepkH4Zt.createNewFile();
				FileWriter FuE1z9xR = new FileWriter(bepkH4Zt);
				String RDR04Ddk = files.get(yjFiqd9u).toString();
				Map<String, String> nxd8ofbf = n0Qe0KfJ.getTypes();
				String[] I1Q9TJxD = RDR04Ddk.split("\n");
				for (String JzDjhHy5 : nxd8ofbf.keySet()) {
					if (!JzDjhHy5.trim().equals(n0Qe0KfJ.getName().trim())) {
						String jO4Mbf3h = nxd8ofbf.get(JzDjhHy5);
						boolean vh53SDkl = false;
						boolean NKbpN8fB = false;
						for (String jfUh7Y18 : I1Q9TJxD) {
							if (jfUh7Y18
									.matches("^\\s*(public|private)\\s+" + jO4Mbf3h + "\\s+" + JzDjhHy5 + "\\s*=.*;$"))
								vh53SDkl = true;
							if (jfUh7Y18.matches("^\\s*(public|private)\\s+" + jO4Mbf3h + "\\s+" + JzDjhHy5 + "\\s*;$"))
								vh53SDkl = true;
							if (jfUh7Y18.matches("^\\s*import\\s+.*" + jO4Mbf3h + "\\s*;$"))
								NKbpN8fB = true;
						}
						if (!vh53SDkl)
							RDR04Ddk = RDR04Ddk.replaceFirst("(?s)(?<=\\{\n)",
									"\tprivate " + jO4Mbf3h + " " + JzDjhHy5 + ";\n");
						if (!NKbpN8fB)
							RDR04Ddk = RDR04Ddk.replaceFirst("(?=import)",
									"import com.google.devtools.simple.runtime.components.android." + jO4Mbf3h + ";\n");
					}
				}
				FuE1z9xR.write(RDR04Ddk);
				FuE1z9xR.close();
				yjFiqd9u++;
			}
			File qs3vQtuk = new File(getManifestFilePath(OfVa3mJn.getAbsolutePath(), manifest));
			qs3vQtuk.getParentFile().mkdirs();
			qs3vQtuk.createNewFile();
			FileWriter nzLfubCw = new FileWriter(qs3vQtuk);
			nzLfubCw.write(manifest.toString());
			nzLfubCw.close();
			File FiYCFtrn = new File(getProjectFilePath(OfVa3mJn.getAbsolutePath(), project));
			FiYCFtrn.getParentFile().mkdirs();
			FiYCFtrn.createNewFile();
			nzLfubCw = new FileWriter(FiYCFtrn);
			nzLfubCw.write(project.toString());
			nzLfubCw.close();
			String[] XUeIKsuW = { "proguard.cfg", "project.properties", "libSimpleAndroidRuntime.jar", "\\.classpath",
					"res/drawable/icon.png", "\\.settings/org.eclipse.jdt.core.prefs" };
			for (String LQGAcmXG : XUeIKsuW) {
				InputStream deVTK53e = getClass().getResourceAsStream("/resources/" + LQGAcmXG.replace("\\.", ""));
				File uUA6RASI = new File(OfVa3mJn.getAbsoluteFile() + File.separator + LQGAcmXG.replace("\\.", "."));
				uUA6RASI.getParentFile().mkdirs();
				OutputStream tbficx6H = new FileOutputStream(uUA6RASI);
				byte[] Lez115te = new byte[1024];
				int Xo5Y8eWu;
				if (deVTK53e == null)
					System.out.println("/resources/" + LQGAcmXG.replace("\\.", ""));
				if (tbficx6H == null)
					System.out.println(OfVa3mJn.getAbsolutePath() + File.separator + LQGAcmXG.replace("\\.", "."));
				while ((Xo5Y8eWu = deVTK53e.read(Lez115te)) > 0) {
					tbficx6H.write(Lez115te, 0, Xo5Y8eWu);
				}
			}
			for (String Ck3emKBO : assets) {
				InputStream loOjFVL0 = new FileInputStream(
						new File(assetsDir.getAbsolutePath() + File.separator + Ck3emKBO));
				File uuvhPxc6 = new File(OfVa3mJn.getAbsoluteFile() + File.separator + Ck3emKBO);
				uuvhPxc6.getParentFile().mkdirs();
				OutputStream Ijoer4PO = new FileOutputStream(uuvhPxc6);
				byte[] klbVB48Z = new byte[1024];
				int IOolE8sJ;
				while ((IOolE8sJ = loOjFVL0.read(klbVB48Z)) > 0) {
					Ijoer4PO.write(klbVB48Z, 0, IOolE8sJ);
				}
			}
			File LStWPOki = new File(getAssetsFilePath(OfVa3mJn.getAbsolutePath()));
			new File(assetsDir.getAbsoluteFile() + File.separator + "assets").renameTo(LStWPOki);
		}
	}

}