class n14150943 {
	private void downloadPage(final URL KyshEhcW, final File YKt3COQC) {
		try {
			long uCxXicJM = 0;
			final byte[] Ib7nHjvF = new byte[BotUtil.BUFFER_SIZE];
			final File f3TTQjib = new File(YKt3COQC.getParentFile(), "temp.tmp");
			int LaZXskhh;
			int ijoAafsW = 0;
			FileOutputStream wqoD7DmM = new FileOutputStream(f3TTQjib);
			final InputStream FOpnwA0g = KyshEhcW.openStream();
			do {
				LaZXskhh = FOpnwA0g.read(Ib7nHjvF);
				if (LaZXskhh >= 0) {
					wqoD7DmM.write(Ib7nHjvF, 0, LaZXskhh);
					uCxXicJM += LaZXskhh;
				}
				if (ijoAafsW > UPDATE_TIME) {
					report(0, (int) (uCxXicJM / Format.MEMORY_MEG), "Downloading... " + Format.formatMemory(uCxXicJM));
					ijoAafsW = 0;
				}
				ijoAafsW++;
			} while (LaZXskhh >= 0);
			wqoD7DmM.close();
			if (KyshEhcW.toString().toLowerCase().endsWith(".gz")) {
				final FileInputStream sak0Je4t = new FileInputStream(f3TTQjib);
				final GZIPInputStream LrzOfVr0 = new GZIPInputStream(sak0Je4t);
				wqoD7DmM = new FileOutputStream(YKt3COQC);
				uCxXicJM = 0;
				ijoAafsW = 0;
				do {
					LaZXskhh = LrzOfVr0.read(Ib7nHjvF);
					if (LaZXskhh >= 0) {
						wqoD7DmM.write(Ib7nHjvF, 0, LaZXskhh);
						uCxXicJM += LaZXskhh;
					}
					if (ijoAafsW > UPDATE_TIME) {
						report(0, (int) (uCxXicJM / Format.MEMORY_MEG),
								"Uncompressing... " + Format.formatMemory(uCxXicJM));
						ijoAafsW = 0;
					}
					ijoAafsW++;
				} while (LaZXskhh >= 0);
				wqoD7DmM.close();
				sak0Je4t.close();
				LrzOfVr0.close();
				f3TTQjib.delete();
			} else {
				YKt3COQC.delete();
				f3TTQjib.renameTo(YKt3COQC);
			}
		} catch (final IOException baCd5dq6) {
			throw new AnalystError(baCd5dq6);
		}
	}

}