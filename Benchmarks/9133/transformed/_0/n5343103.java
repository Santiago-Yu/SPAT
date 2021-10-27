class n5343103 {
	public static void main(String bCcHTjLB[]) {
		if (bCcHTjLB.length < 1) {
			System.err.println("usage: java copyURL URL [LocalFile]");
			System.exit(1);
		}
		try {
			URL IpvqMhta = new URL(bCcHTjLB[0]);
			System.out.println("Opening connection to " + bCcHTjLB[0] + "...");
			URLConnection Nv2dHQbB = IpvqMhta.openConnection();
			InputStream UkoXT52g = IpvqMhta.openStream();
			System.out.print("Copying resource (type: " + Nv2dHQbB.getContentType());
			Date S7cZc66w = new Date(Nv2dHQbB.getLastModified());
			System.out.flush();
			FileOutputStream rYM37SPN = null;
			if (bCcHTjLB.length < 2) {
				String fIOzTdre = null;
				StringTokenizer lr26baE5 = new StringTokenizer(IpvqMhta.getFile(), "/");
				while (lr26baE5.hasMoreTokens())
					fIOzTdre = lr26baE5.nextToken();
				rYM37SPN = new FileOutputStream(fIOzTdre);
			} else
				rYM37SPN = new FileOutputStream(bCcHTjLB[1]);
			int j51Ki3kz, pxdtpRpv = 0;
			while ((j51Ki3kz = UkoXT52g.read()) != -1) {
				rYM37SPN.write(j51Ki3kz);
				pxdtpRpv++;
			}
			UkoXT52g.close();
			rYM37SPN.close();
			System.out.println(pxdtpRpv + " byte(s) copied");
		} catch (MalformedURLException ZBMz33tk) {
			System.err.println(ZBMz33tk.toString());
		} catch (IOException nZsFy9p6) {
			System.err.println(nZsFy9p6.toString());
		}
	}

}