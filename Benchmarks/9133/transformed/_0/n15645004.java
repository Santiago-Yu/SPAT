class n15645004 {
	private void unzip(File qc7nr0AW) throws ZipException, IOException {
		ZipInputStream xlIN3VPJ = new ZipInputStream(new BufferedInputStream(new FileInputStream(qc7nr0AW)));
		ZipEntry oU7HGPVf = null;
		boolean oLasLVF0 = true;
		while ((oU7HGPVf = xlIN3VPJ.getNextEntry()) != null) {
			if (oLasLVF0) {
				if (!oU7HGPVf.isDirectory()) {
					File NknbwCc0 = new File(dir + File.separator
							+ qc7nr0AW.getName().substring(0, qc7nr0AW.getName().length() - SUFFIX_ZIP.length()));
					if (!NknbwCc0.exists()) {
						NknbwCc0.mkdir();
						dir = NknbwCc0;
					}
				}
				oLasLVF0 = false;
			}
			if (oU7HGPVf.isDirectory()) {
				FileUtils.forceMkdir(new File(dir + File.separator + oU7HGPVf.getName()));
			} else {
				File TfarxW1x = new File(dir + File.separator + oU7HGPVf.getName());
				File JwGJjHKu = new File(TfarxW1x.getAbsolutePath().substring(0,
						TfarxW1x.getAbsolutePath().length() - TfarxW1x.getName().length()));
				if (!JwGJjHKu.exists())
					FileUtils.forceMkdir(JwGJjHKu);
				FileOutputStream c0l0Dz0T = new FileOutputStream(TfarxW1x);
				BufferedOutputStream VmSpYx2o = new BufferedOutputStream(c0l0Dz0T, BUFFER);
				int kv9kdI1d;
				byte SvVNWKZn[] = new byte[BUFFER];
				while ((kv9kdI1d = xlIN3VPJ.read(SvVNWKZn, 0, BUFFER)) != -1) {
					read_position++;
					VmSpYx2o.write(SvVNWKZn, 0, kv9kdI1d);
				}
				VmSpYx2o.flush();
				VmSpYx2o.close();
			}
		}
		xlIN3VPJ.close();
	}

}