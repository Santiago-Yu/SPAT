class n18397102 {
	protected void extractArchive(File RkaOj3Dq) {
		ZipInputStream g1s8BpV0 = null;
		FileOutputStream zpzHtRnu;
		ZipEntry czoD4yn1;
		File u0wXsYld;
		int p2IHjqU1;
		try {
			g1s8BpV0 = new ZipInputStream(new FileInputStream(RkaOj3Dq));
			while ((czoD4yn1 = g1s8BpV0.getNextEntry()) != null) {
				u0wXsYld = new File(workingDir, czoD4yn1.getName());
				if (czoD4yn1.isDirectory()) {
					System.out.println("skip directory: " + czoD4yn1.getName());
					continue;
				}
				System.out.print("zip-entry (file): " + czoD4yn1.getName());
				System.out.println(" ==> real path: " + u0wXsYld.getAbsolutePath());
				if (!u0wXsYld.getParentFile().exists())
					u0wXsYld.getParentFile().mkdirs();
				zpzHtRnu = new FileOutputStream(u0wXsYld);
				while ((p2IHjqU1 = g1s8BpV0.read(buf, 0, buf.length)) > -1)
					zpzHtRnu.write(buf, 0, p2IHjqU1);
				zpzHtRnu.close();
				g1s8BpV0.closeEntry();
			}
		} catch (Throwable FG8K78Jd) {
			FG8K78Jd.printStackTrace();
		} finally {
			try {
				if (g1s8BpV0 != null)
					g1s8BpV0.close();
			} catch (Throwable Wz0r0iro) {
			}
		}
	}

}