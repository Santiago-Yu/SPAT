class n740874 {
	public static void main(String[] XE991UjV) {
		if (1 < XE991UjV.length) {
			File[] JKHnDlyw = Source(XE991UjV[0]);
			if (null != JKHnDlyw) {
				for (File T0EK1OV9 : JKHnDlyw) {
					File[] RZCyhoSQ = Target(T0EK1OV9, XE991UjV);
					if (null != RZCyhoSQ) {
						final long NZUeCn3G = T0EK1OV9.length();
						try {
							FileChannel iXSTTpEp = new FileInputStream(T0EK1OV9).getChannel();
							try {
								for (File MwppU4uH : RZCyhoSQ) {
									FileChannel souDYnqD = new FileOutputStream(MwppU4uH).getChannel();
									try {
										iXSTTpEp.transferTo(0L, NZUeCn3G, souDYnqD);
									} finally {
										souDYnqD.close();
									}
									System.out.printf("Updated %s\n", MwppU4uH.getPath());
									File[] FkdanweR = Delete(T0EK1OV9, MwppU4uH);
									if (null != FkdanweR) {
										for (File iBYv9wb0 : FkdanweR) {
											if (SVN) {
												if (SvnDelete(iBYv9wb0))
													System.out.printf("Deleted %s\n", iBYv9wb0.getPath());
												else
													System.out.printf("Failed to delete %s\n", iBYv9wb0.getPath());
											} else if (iBYv9wb0.delete())
												System.out.printf("Deleted %s\n", iBYv9wb0.getPath());
											else
												System.out.printf("Failed to delete %s\n", iBYv9wb0.getPath());
										}
									}
									if (SVN)
										SvnAdd(MwppU4uH);
								}
							} finally {
								iXSTTpEp.close();
							}
						} catch (Exception KpXT2ICK) {
							KpXT2ICK.printStackTrace();
							System.exit(1);
						}
					}
				}
				System.exit(0);
			} else {
				System.err.printf("Source file(s) not found in '%s'\n", XE991UjV[0]);
				System.exit(1);
			}
		} else {
			usage();
			System.exit(1);
		}
	}

}