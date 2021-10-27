class n14134127 {
	private void addFilesToExistingZip(File Kfrjx0om, String[] Tw3D6A8x, File[] inmywzkt) throws IOException {
		File j2Qy21Ci = new File(Kfrjx0om.getAbsoluteFile() + ".temp");
		if (j2Qy21Ci.exists())
			j2Qy21Ci.delete();
		boolean TWKW0axy = Kfrjx0om.renameTo(j2Qy21Ci);
		if (!TWKW0axy) {
			throw new RuntimeException(
					"Could not rename the file " + Kfrjx0om.getAbsolutePath() + " to " + j2Qy21Ci.getAbsolutePath());
		}
		ZipInputStream iT6zVfZK = new ZipInputStream(new FileInputStream(j2Qy21Ci));
		ZipOutputStream PL9S2M2U = new ZipOutputStream(new FileOutputStream(Kfrjx0om));
		ZipEntry YMwNH5x9 = iT6zVfZK.getNextEntry();
		byte[] MeEtjs77 = new byte[1024];
		while (YMwNH5x9 != null) {
			String djxeo8x6 = YMwNH5x9.getName();
			boolean sEw6dvSw = false;
			for (int vUxvVAdn = 0; vUxvVAdn < inmywzkt.length; vUxvVAdn++) {
				String hXsBuzLP = Tw3D6A8x[vUxvVAdn] + "/" + inmywzkt[vUxvVAdn].getName();
				if (hXsBuzLP.equals(djxeo8x6)) {
					sEw6dvSw = true;
					break;
				}
			}
			if (!sEw6dvSw) {
				PL9S2M2U.putNextEntry(new ZipEntry(djxeo8x6));
				int hDqaDpbm;
				while ((hDqaDpbm = iT6zVfZK.read(MeEtjs77)) > 0)
					PL9S2M2U.write(MeEtjs77, 0, hDqaDpbm);
			}
			YMwNH5x9 = iT6zVfZK.getNextEntry();
		}
		iT6zVfZK.close();
		for (int LGQkVpxO = 0; LGQkVpxO < inmywzkt.length; LGQkVpxO++) {
			InputStream PSgTB4JH = new FileInputStream(inmywzkt[LGQkVpxO]);
			PL9S2M2U.putNextEntry(new ZipEntry(Tw3D6A8x[LGQkVpxO] + "/" + inmywzkt[LGQkVpxO].getName()));
			int OXc3hbO5;
			while ((OXc3hbO5 = PSgTB4JH.read(MeEtjs77)) > 0)
				PL9S2M2U.write(MeEtjs77, 0, OXc3hbO5);
			PL9S2M2U.closeEntry();
			PSgTB4JH.close();
		}
		PL9S2M2U.close();
		j2Qy21Ci.delete();
	}

}