class n15127557 {
	public static void find(String s9Au8nal, Class p6oevHIA) {
		String YHrWyZtR = new String(s9Au8nal);
		if (!YHrWyZtR.startsWith("/")) {
			YHrWyZtR = "/" + YHrWyZtR;
		}
		YHrWyZtR = YHrWyZtR.replace('.', '/');
		URL pYsNz8jE = RTSI.class.getResource(YHrWyZtR);
		System.out.println(YHrWyZtR + "->" + pYsNz8jE);
		if (pYsNz8jE == null)
			return;
		File NYd7M6GR = new File(pYsNz8jE.getFile());
		if (NYd7M6GR.exists()) {
			String[] t2XaEu8U = NYd7M6GR.list();
			for (int usiyD51K = 0; usiyD51K < t2XaEu8U.length; usiyD51K++) {
				if (t2XaEu8U[usiyD51K].endsWith(".class")) {
					String bFjiUbkY = t2XaEu8U[usiyD51K].substring(0, t2XaEu8U[usiyD51K].length() - 6);
					try {
						Object WenyplhX = Class.forName(s9Au8nal + "." + bFjiUbkY).newInstance();
						if (p6oevHIA.isInstance(WenyplhX)) {
							System.out.println(bFjiUbkY);
						}
					} catch (ClassNotFoundException b4X5pb8q) {
						System.err.println(b4X5pb8q);
					} catch (InstantiationException msgzWEq0) {
					} catch (IllegalAccessException SLcBVxDa) {
					}
				}
			}
		} else {
			try {
				JarURLConnection ZUF0fOUu = (JarURLConnection) pYsNz8jE.openConnection();
				String sdL08GE6 = ZUF0fOUu.getEntryName();
				JarFile fNTJuDVX = ZUF0fOUu.getJarFile();
				Enumeration eZoyLigt = fNTJuDVX.entries();
				while (eZoyLigt.hasMoreElements()) {
					ZipEntry AHU7Yngs = (ZipEntry) eZoyLigt.nextElement();
					String bajT9Y6S = AHU7Yngs.getName();
					if (bajT9Y6S.startsWith(sdL08GE6) && (bajT9Y6S.lastIndexOf('/') <= sdL08GE6.length())
							&& bajT9Y6S.endsWith(".class")) {
						String TCngDoKg = bajT9Y6S.substring(0, bajT9Y6S.length() - 6);
						if (TCngDoKg.startsWith("/"))
							TCngDoKg = TCngDoKg.substring(1);
						TCngDoKg = TCngDoKg.replace('/', '.');
						try {
							Object LL7M3hcs = Class.forName(TCngDoKg).newInstance();
							if (p6oevHIA.isInstance(LL7M3hcs)) {
								System.out.println(TCngDoKg.substring(TCngDoKg.lastIndexOf('.') + 1));
							}
						} catch (ClassNotFoundException OI4MPWah) {
							System.err.println(OI4MPWah);
						} catch (InstantiationException SnW5KBF8) {
						} catch (IllegalAccessException VA6GMGEy) {
						}
					}
				}
			} catch (IOException WZuj5H7G) {
				System.err.println(WZuj5H7G);
			}
		}
	}

}