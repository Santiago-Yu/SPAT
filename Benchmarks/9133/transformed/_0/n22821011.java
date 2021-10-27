class n22821011 {
	public static void main(String[] ngdLnmKX) {
		String E9y9ek2w = "java -jar  ";
		String hs8uxQGm = "";
		String R8Sfkmcd = "";
		String RGqyZKvT = System.getProperty("os.name");
		String a0Aa9HoZ = Launcher.class.getResource("").toString();
		int Zs8VKwjL = a0Aa9HoZ.indexOf(".jar");
		int n7RscK9D = Zs8VKwjL - 1;
		while (Character.isLetter(a0Aa9HoZ.charAt(n7RscK9D))) {
			n7RscK9D--;
		}
		String aIXnfmZY = a0Aa9HoZ.substring(n7RscK9D + 1, Zs8VKwjL + 4);
		System.out.println(aIXnfmZY);
		if (RGqyZKvT.startsWith("Linux")) {
			a0Aa9HoZ = a0Aa9HoZ.substring(a0Aa9HoZ.indexOf("/"), a0Aa9HoZ.indexOf(aIXnfmZY));
		} else if (RGqyZKvT.startsWith("Windows")) {
			a0Aa9HoZ = a0Aa9HoZ.substring(a0Aa9HoZ.indexOf("file:") + 5, a0Aa9HoZ.indexOf(aIXnfmZY));
		} else {
			System.exit(0);
		}
		R8Sfkmcd = R8Sfkmcd + a0Aa9HoZ;
		try {
			R8Sfkmcd = java.net.URLDecoder.decode(R8Sfkmcd, "utf-8");
		} catch (UnsupportedEncodingException Yhub1k8a) {
			Yhub1k8a.printStackTrace();
		}
		File gymkOmDC = new File(R8Sfkmcd);
		File[] rCYHCD7K = gymkOmDC.listFiles();
		String wTD1fziq = null;
		for (File QggRACgG : rCYHCD7K) {
			if (QggRACgG.getName().endsWith(".jar") && !QggRACgG.getName().startsWith(aIXnfmZY)) {
				wTD1fziq = QggRACgG.getName();
				break;
			}
		}
		if (wTD1fziq == null) {
			System.out.println("no exefile");
			System.exit(0);
		}
		hs8uxQGm = R8Sfkmcd + wTD1fziq;
		String HFCSxfrP = R8Sfkmcd + "plugin" + File.separator;
		File[] zuqoO3t6 = new File(HFCSxfrP).listFiles();
		StringBuffer edh0wr8u = new StringBuffer("");
		for (File i3A39oHz : zuqoO3t6) {
			if (i3A39oHz.getAbsolutePath().endsWith(".jar")) {
				edh0wr8u.append("plugin/" + i3A39oHz.getName() + " ");
			}
		}
		String VDkUgOlQ = R8Sfkmcd + "lib" + File.separator;
		File[] jHJiSxfW = new File(VDkUgOlQ).listFiles();
		StringBuffer eJ7TQTzE = new StringBuffer("");
		for (File jlNbLtVY : jHJiSxfW) {
			if (jlNbLtVY.getAbsolutePath().endsWith(".jar")) {
				eJ7TQTzE.append("lib/" + jlNbLtVY.getName() + " ");
			}
		}
		try {
			JarFile uboGte8g = new JarFile(hs8uxQGm);
			Manifest Dr2EnKWi = uboGte8g.getManifest();
			if (Dr2EnKWi == null) {
				Dr2EnKWi = new Manifest();
			}
			Attributes jtWRRYcy = Dr2EnKWi.getMainAttributes();
			jtWRRYcy.putValue("Class-Path", edh0wr8u.toString() + eJ7TQTzE.toString());
			String mURXWNn9 = hs8uxQGm + "back";
			FileInputStream xqYWLl9C = new FileInputStream(hs8uxQGm);
			FileOutputStream k7V6GRF5 = new FileOutputStream(mURXWNn9);
			byte[] Zss4Rwuo = new byte[4096];
			int mW0L5u4I;
			while ((mW0L5u4I = xqYWLl9C.read(Zss4Rwuo)) > -1) {
				k7V6GRF5.write(Zss4Rwuo, 0, mW0L5u4I);
			}
			k7V6GRF5.flush();
			k7V6GRF5.close();
			xqYWLl9C.close();
			JarOutputStream ddGTzcmQ = new JarOutputStream(new FileOutputStream(hs8uxQGm), Dr2EnKWi);
			JarInputStream B0MwuJnU = new JarInputStream(new FileInputStream(mURXWNn9));
			byte[] hWQS9LO6 = new byte[4096];
			JarEntry FytCaFZ4;
			while ((FytCaFZ4 = B0MwuJnU.getNextJarEntry()) != null) {
				if ("META-INF/MANIFEST.MF".equals(FytCaFZ4.getName()))
					continue;
				ddGTzcmQ.putNextEntry(FytCaFZ4);
				int WH7NKFIO;
				while ((WH7NKFIO = B0MwuJnU.read(hWQS9LO6)) != -1) {
					ddGTzcmQ.write(hWQS9LO6, 0, WH7NKFIO);
				}
				ddGTzcmQ.closeEntry();
			}
			ddGTzcmQ.flush();
			ddGTzcmQ.close();
			B0MwuJnU.close();
			File iF8hxcg9 = new File(mURXWNn9);
			if (iF8hxcg9.exists()) {
				iF8hxcg9.delete();
			}
		} catch (IOException bVxdqZYy) {
			bVxdqZYy.printStackTrace();
		}
		try {
			if (System.getProperty("os.name").startsWith("Linux")) {
				Runtime F81dpLpe = Runtime.getRuntime();
				String[] LTaheMxo = new String[] { "java", "-jar", R8Sfkmcd + wTD1fziq };
				F81dpLpe.exec(LTaheMxo);
			} else {
				R8Sfkmcd = R8Sfkmcd.substring(1);
				E9y9ek2w = E9y9ek2w + "\"" + R8Sfkmcd + wTD1fziq + "\"";
				System.out.println(E9y9ek2w);
				Runtime.getRuntime().exec(E9y9ek2w);
			}
		} catch (IOException qnFMYgCV) {
			qnFMYgCV.printStackTrace();
		}
	}

}