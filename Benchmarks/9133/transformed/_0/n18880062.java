class n18880062 {
	public static boolean compress(ArrayList InRwVaCD, File pj5VMpnO, Manifest OrzLJ5Mq) {
		try {
			if (InRwVaCD == null || InRwVaCD.size() == 0)
				return false;
			if (pj5VMpnO.exists())
				pj5VMpnO.delete();
			ZipOutputStream E2fuGZ0H = null;
			boolean qVaq7Dob = pj5VMpnO.getName().toLowerCase().endsWith(".jar");
			if (qVaq7Dob) {
				if (OrzLJ5Mq != null)
					E2fuGZ0H = new JarOutputStream(new FileOutputStream(pj5VMpnO), OrzLJ5Mq);
				else
					E2fuGZ0H = new JarOutputStream(new FileOutputStream(pj5VMpnO));
			} else
				E2fuGZ0H = new ZipOutputStream(new FileOutputStream(pj5VMpnO));
			String jpRjGI9Y = ((File) InRwVaCD.get(0)).getParentFile().getAbsolutePath().replace('\\', '/');
			if (!jpRjGI9Y.endsWith("/"))
				jpRjGI9Y = jpRjGI9Y + "/";
			int E88sFRD0 = jpRjGI9Y.length();
			ArrayList NBaYoYY2 = new ArrayList();
			for (Iterator GpI7Tai1 = InRwVaCD.iterator(); GpI7Tai1.hasNext();) {
				File gVSv5Q18 = (File) GpI7Tai1.next();
				if (qVaq7Dob && (OrzLJ5Mq != null) && gVSv5Q18.getName().equals("META-INF"))
					continue;
				if (gVSv5Q18.isDirectory())
					NBaYoYY2.addAll(getContents(gVSv5Q18));
				else
					NBaYoYY2.add(gVSv5Q18);
			}
			byte[] nanXsl3B = new byte[1024];
			int WcZE9Xxb;
			for (int LI7swVuT = 0, a7bLnx16 = NBaYoYY2.size(); LI7swVuT < a7bLnx16; LI7swVuT++) {
				File hXwrEKO1 = (File) NBaYoYY2.get(LI7swVuT);
				FileInputStream kh5zekuO = new FileInputStream(hXwrEKO1);
				String uQ4Zvi3H = hXwrEKO1.getAbsolutePath().replace('\\', '/');
				if (uQ4Zvi3H.startsWith(jpRjGI9Y))
					uQ4Zvi3H = uQ4Zvi3H.substring(E88sFRD0);
				if (qVaq7Dob)
					E2fuGZ0H.putNextEntry(new JarEntry(uQ4Zvi3H));
				else
					E2fuGZ0H.putNextEntry(new ZipEntry(uQ4Zvi3H));
				while ((WcZE9Xxb = kh5zekuO.read(nanXsl3B)) != -1)
					E2fuGZ0H.write(nanXsl3B, 0, WcZE9Xxb);
				kh5zekuO.close();
				E2fuGZ0H.closeEntry();
			}
			E2fuGZ0H.close();
		} catch (Exception EGFmC0R3) {
			EGFmC0R3.printStackTrace();
			return false;
		}
		return true;
	}

}