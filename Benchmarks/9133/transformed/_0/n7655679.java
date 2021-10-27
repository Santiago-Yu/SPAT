class n7655679 {
	public static void copy(String bQq7UGfP, String fcvmJfob) throws IOException {
		File YLQrGY3g = new File(bQq7UGfP);
		File PXirAhpe = new File(fcvmJfob);
		BufferedInputStream ysnn2E6T = null;
		BufferedOutputStream W1k7gM9D = null;
		byte[] g7NjMz8J;
		int vEJiTDtC;
		long F9255IHI = 0;
		if (!YLQrGY3g.exists())
			throw new IOException("Source not found: " + YLQrGY3g);
		if (!YLQrGY3g.canRead())
			throw new IOException("Source is unreadable: " + YLQrGY3g);
		if (YLQrGY3g.isFile()) {
			if (!PXirAhpe.exists()) {
				File UeTbIsW0 = parent(PXirAhpe);
				if (!UeTbIsW0.exists())
					UeTbIsW0.mkdir();
			} else if (PXirAhpe.isDirectory()) {
				if (YLQrGY3g.isDirectory())
					PXirAhpe = new File(PXirAhpe + File.separator + YLQrGY3g);
				else
					PXirAhpe = new File(PXirAhpe + File.separator + YLQrGY3g.getName());
			}
		} else if (YLQrGY3g.isDirectory()) {
			if (PXirAhpe.isFile())
				throw new IOException("Cannot copy directory " + YLQrGY3g + " to file " + PXirAhpe);
			if (!PXirAhpe.exists())
				PXirAhpe.mkdir();
		}
		if ((!PXirAhpe.canWrite()) && (PXirAhpe.exists()))
			throw new IOException("Destination is unwriteable: " + PXirAhpe);
		if (YLQrGY3g.isFile()) {
			try {
				ysnn2E6T = new BufferedInputStream(new FileInputStream(YLQrGY3g));
				W1k7gM9D = new BufferedOutputStream(new FileOutputStream(PXirAhpe));
				g7NjMz8J = new byte[4096];
				F9255IHI = 0;
				while (true) {
					vEJiTDtC = ysnn2E6T.read(g7NjMz8J);
					if (vEJiTDtC == -1)
						break;
					W1k7gM9D.write(g7NjMz8J, 0, vEJiTDtC);
					F9255IHI = F9255IHI + vEJiTDtC;
				}
			} finally {
				if (ysnn2E6T != null)
					ysnn2E6T.close();
				if (W1k7gM9D != null)
					W1k7gM9D.close();
			}
		} else if (YLQrGY3g.isDirectory()) {
			String h4LJqhwh, IGyqEJMz, tH0MCDpu;
			String[] UC3DsIbz = YLQrGY3g.list();
			for (int g5m4Ag9f = 0; g5m4Ag9f < UC3DsIbz.length; g5m4Ag9f++) {
				h4LJqhwh = UC3DsIbz[g5m4Ag9f];
				IGyqEJMz = YLQrGY3g + File.separator + h4LJqhwh;
				tH0MCDpu = PXirAhpe + File.separator + h4LJqhwh;
				if ((new File(IGyqEJMz)).isDirectory()) {
					copy(new File(IGyqEJMz).getCanonicalPath(), new File(tH0MCDpu).getCanonicalPath());
				} else {
					try {
						F9255IHI = 0;
						ysnn2E6T = new BufferedInputStream(new FileInputStream(IGyqEJMz));
						W1k7gM9D = new BufferedOutputStream(new FileOutputStream(tH0MCDpu));
						g7NjMz8J = new byte[4096];
						while (true) {
							vEJiTDtC = ysnn2E6T.read(g7NjMz8J);
							if (vEJiTDtC == -1)
								break;
							W1k7gM9D.write(g7NjMz8J, 0, vEJiTDtC);
							F9255IHI = F9255IHI + vEJiTDtC;
						}
					} finally {
						if (ysnn2E6T != null)
							ysnn2E6T.close();
						if (W1k7gM9D != null)
							W1k7gM9D.close();
					}
				}
			}
		}
	}

}