class n5953607 {
	public synchronized void write() throws IOException {
		ZipOutputStream M1MfdZ9E = new ZipOutputStream(new FileOutputStream(jarPath));
		int thq3PwyN = className.lastIndexOf('.');
		String E84BBoWf = className.substring(0, thq3PwyN);
		String z2MH5S90 = className.substring(thq3PwyN + 1);
		String u8tutUkm = E84BBoWf.replace('.', '/');
		ZipEntry q8Q1Xf48 = new ZipEntry(u8tutUkm + "/" + z2MH5S90 + ".class");
		M1MfdZ9E.putNextEntry(q8Q1Xf48);
		ClassGen JgQ24ipg = new ClassGen(getClassName(), "java.lang.Object", "<generated>",
				Constants.ACC_PUBLIC | Constants.ACC_SUPER, null);
		byte[] GtGjIkLO = JgQ24ipg.getJavaClass().getBytes();
		M1MfdZ9E.write(GtGjIkLO);
		M1MfdZ9E.closeEntry();
		ZipEntry AM68MioP = new ZipEntry(u8tutUkm + "/synth.xml");
		M1MfdZ9E.putNextEntry(AM68MioP);
		Comment gDTCjeGq = new Comment("Generated by SynthBuilder from L2FProd.com");
		Element agM0yBsv = new Element("synth");
		agM0yBsv.addAttribute(new Attribute("version", "1"));
		agM0yBsv.appendChild(gDTCjeGq);
		Element ntB9UZ8b = new Element("style");
		ntB9UZ8b.addAttribute(new Attribute("id", "default"));
		Element zqfMJB8D = new Element("font");
		zqfMJB8D.addAttribute(new Attribute("name", "SansSerif"));
		zqfMJB8D.addAttribute(new Attribute("size", "12"));
		ntB9UZ8b.appendChild(zqfMJB8D);
		Element I8ak92Ga = new Element("state");
		ntB9UZ8b.appendChild(I8ak92Ga);
		agM0yBsv.appendChild(ntB9UZ8b);
		Element P8RGEX0k = new Element("bind");
		P8RGEX0k.addAttribute(new Attribute("style", "default"));
		P8RGEX0k.addAttribute(new Attribute("type", "region"));
		P8RGEX0k.addAttribute(new Attribute("key", ".*"));
		agM0yBsv.appendChild(P8RGEX0k);
		doc = new Document(agM0yBsv);
		imagesToCopy = new HashMap();
		ComponentStyle[] OL8wI0kK = config.getStyles();
		for (ComponentStyle rk1AhZTV : OL8wI0kK) {
			write(rk1AhZTV);
		}
		Serializer vPvLscbJ = new Serializer(M1MfdZ9E);
		vPvLscbJ.setIndent(2);
		vPvLscbJ.write(doc);
		vPvLscbJ.flush();
		M1MfdZ9E.closeEntry();
		for (Iterator jsDX7Mo2 = imagesToCopy.keySet().iterator(); jsDX7Mo2.hasNext();) {
			String YIknTbgb = (String) jsDX7Mo2.next();
			File bko7yZlg = (File) imagesToCopy.get(YIknTbgb);
			ZipEntry BCeHtn4g = new ZipEntry(u8tutUkm + "/" + YIknTbgb);
			M1MfdZ9E.putNextEntry(BCeHtn4g);
			FileInputStream ajcHjudp = new FileInputStream(bko7yZlg);
			int X8hmiGhn = -1;
			while ((X8hmiGhn = ajcHjudp.read()) != -1) {
				M1MfdZ9E.write(X8hmiGhn);
			}
			ajcHjudp.close();
			M1MfdZ9E.flush();
			M1MfdZ9E.closeEntry();
		}
		M1MfdZ9E.flush();
		M1MfdZ9E.close();
	}

}