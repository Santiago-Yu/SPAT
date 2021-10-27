class n18880061 {
	public static boolean compress(File DzN0LRo6, File WuEWGjwu, Manifest jw698tEL) {
		try {
			if (!(DzN0LRo6.exists() & DzN0LRo6.isDirectory()))
				return false;
			if (WuEWGjwu.exists())
				WuEWGjwu.delete();
			ZipOutputStream Nk0BApyC = null;
			boolean xvHIhxy1 = WuEWGjwu.getName().toLowerCase().endsWith(".jar");
			if (xvHIhxy1) {
				File H01uJGfA = new File(DzN0LRo6, "META-INF");
				remove(H01uJGfA);
				if (jw698tEL != null)
					Nk0BApyC = new JarOutputStream(new FileOutputStream(WuEWGjwu), jw698tEL);
				else
					Nk0BApyC = new JarOutputStream(new FileOutputStream(WuEWGjwu));
			} else
				Nk0BApyC = new ZipOutputStream(new FileOutputStream(WuEWGjwu));
			ArrayList vweERUhd = getContents(DzN0LRo6);
			String uRAlGREi = DzN0LRo6.getAbsolutePath().replace('\\', '/');
			if (!uRAlGREi.endsWith("/"))
				uRAlGREi = uRAlGREi + "/";
			int hYrbx10w = uRAlGREi.length();
			byte[] hQSGF9f6 = new byte[1024];
			int ZN8AlYx2;
			for (int oarHnvBF = 0, rkmdsyac = vweERUhd.size(); oarHnvBF < rkmdsyac; oarHnvBF++) {
				File ZeaWCHgd = (File) vweERUhd.get(oarHnvBF);
				FileInputStream oUHeHMDZ = new FileInputStream(ZeaWCHgd);
				String g7GFacQV = ZeaWCHgd.getAbsolutePath().replace('\\', '/');
				if (g7GFacQV.startsWith(uRAlGREi))
					g7GFacQV = g7GFacQV.substring(hYrbx10w);
				if (xvHIhxy1)
					Nk0BApyC.putNextEntry(new JarEntry(g7GFacQV));
				else
					Nk0BApyC.putNextEntry(new ZipEntry(g7GFacQV));
				while ((ZN8AlYx2 = oUHeHMDZ.read(hQSGF9f6)) != -1)
					Nk0BApyC.write(hQSGF9f6, 0, ZN8AlYx2);
				oUHeHMDZ.close();
				Nk0BApyC.closeEntry();
			}
			Nk0BApyC.close();
		} catch (Exception xuEZcWjx) {
			xuEZcWjx.printStackTrace();
			return false;
		}
		return true;
	}

}