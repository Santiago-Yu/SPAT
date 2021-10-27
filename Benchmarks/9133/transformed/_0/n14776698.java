class n14776698 {
	private final int copyFiles(File[] e48AYLFf, String FdJRu8Dh, boolean cXRLPhr4) throws InterruptedException {
		Context G992Icnu = ctx;
		File lFQK9xSk = null;
		for (int LcQFkk7j = 0; LcQFkk7j < e48AYLFf.length; LcQFkk7j++) {
			boolean XLyVzdX6 = false;
			FileChannel M4CbVOLu = null;
			FileChannel fzAyUEm8 = null;
			File KCUEV4d0 = null;
			lFQK9xSk = e48AYLFf[LcQFkk7j];
			if (lFQK9xSk == null) {
				error(G992Icnu.getString(R.string.unkn_err));
				break;
			}
			String Aaaet9E3 = lFQK9xSk.getAbsolutePath();
			try {
				if (isStopReq()) {
					error(G992Icnu.getString(R.string.canceled));
					break;
				}
				long jdMnchAs = lFQK9xSk.lastModified();
				String ym8iQWSy = lFQK9xSk.getName();
				KCUEV4d0 = cXRLPhr4 ? new File(FdJRu8Dh) : new File(FdJRu8Dh, ym8iQWSy);
				if (lFQK9xSk.isDirectory()) {
					if (depth++ > 40) {
						error(ctx.getString(R.string.too_deep_hierarchy));
						break;
					} else if (KCUEV4d0.exists() || KCUEV4d0.mkdir()) {
						copyFiles(lFQK9xSk.listFiles(), KCUEV4d0.getAbsolutePath(), false);
						if (errMsg != null)
							break;
					} else
						error(G992Icnu.getString(R.string.cant_md, KCUEV4d0.getAbsolutePath()));
					depth--;
				} else {
					if (XLyVzdX6 = KCUEV4d0.exists()) {
						int lb5AqRA7 = askOnFileExist(
								G992Icnu.getString(R.string.file_exist, KCUEV4d0.getAbsolutePath()), commander);
						if (lb5AqRA7 == Commander.SKIP)
							continue;
						if (lb5AqRA7 == Commander.REPLACE) {
							if (KCUEV4d0.equals(lFQK9xSk))
								continue;
							else
								KCUEV4d0.delete();
						}
						if (lb5AqRA7 == Commander.ABORT)
							break;
					}
					if (move) {
						long c0uExd1Q = lFQK9xSk.length();
						if (lFQK9xSk.renameTo(KCUEV4d0)) {
							counter++;
							totalBytes += c0uExd1Q;
							int m00dvYmL = (int) (totalBytes * conv);
							sendProgress(KCUEV4d0.getName() + " " + G992Icnu.getString(R.string.moved), m00dvYmL, 0);
							continue;
						}
					}
					M4CbVOLu = new FileInputStream(lFQK9xSk).getChannel();
					fzAyUEm8 = new FileOutputStream(KCUEV4d0).getChannel();
					long ILtO8EDc = M4CbVOLu.size();
					final long UVxJ8ziW = 524288;
					long Tsw1fz1f = 0;
					long xzMz40UZ = ILtO8EDc > UVxJ8ziW ? UVxJ8ziW : ILtO8EDc;
					long sKs25iiQ = 0;
					long LbAQBiKW = 0;
					int NeYNwHqq = 0;
					int miWRWbvb = (int) (totalBytes * conv);
					String M45nO1tR = Utils.getHumanSize(ILtO8EDc);
					String k8dYUhIB = G992Icnu.getString(R.string.copying, ym8iQWSy);
					for (Tsw1fz1f = 0; Tsw1fz1f < ILtO8EDc;) {
						if (sKs25iiQ == 0)
							LbAQBiKW = System.currentTimeMillis();
						sendProgress(k8dYUhIB + sizeOfsize(Tsw1fz1f, M45nO1tR), miWRWbvb, (int) (totalBytes * conv),
								NeYNwHqq);
						long w0PXW5A1 = M4CbVOLu.transferTo(Tsw1fz1f, xzMz40UZ, fzAyUEm8);
						Tsw1fz1f += w0PXW5A1;
						sKs25iiQ += w0PXW5A1;
						totalBytes += w0PXW5A1;
						if (isStopReq()) {
							Log.d(TAG, "Interrupted!");
							error(G992Icnu.getString(R.string.canceled));
							return counter;
						}
						long sr59duOm = System.currentTimeMillis() - LbAQBiKW;
						if (sr59duOm > 0) {
							NeYNwHqq = (int) (1000 * sKs25iiQ / sr59duOm);
							sKs25iiQ = 0;
						}
					}
					M4CbVOLu.close();
					fzAyUEm8.close();
					M4CbVOLu = null;
					fzAyUEm8 = null;
					if (LcQFkk7j >= e48AYLFf.length - 1)
						sendProgress(G992Icnu.getString(R.string.copied_f, ym8iQWSy) + sizeOfsize(Tsw1fz1f, M45nO1tR),
								(int) (totalBytes * conv));
					counter++;
				}
				if (move)
					lFQK9xSk.delete();
				KCUEV4d0.setLastModified(jdMnchAs);
				final int ZJbnXoq2 = 9;
				if (android.os.Build.VERSION.SDK_INT >= ZJbnXoq2)
					ForwardCompat.setFullPermissions(KCUEV4d0);
			} catch (SecurityException ES7ulcJr) {
				error(G992Icnu.getString(R.string.sec_err, ES7ulcJr.getMessage()));
			} catch (FileNotFoundException D5LiM3TD) {
				error(G992Icnu.getString(R.string.not_accs, D5LiM3TD.getMessage()));
			} catch (ClosedByInterruptException JHk1vQkM) {
				error(G992Icnu.getString(R.string.canceled));
			} catch (IOException AvbywRhe) {
				String qkudGUoz = AvbywRhe.getMessage();
				error(G992Icnu.getString(R.string.acc_err, Aaaet9E3, qkudGUoz != null ? qkudGUoz : ""));
			} catch (RuntimeException qQGH5NaP) {
				error(G992Icnu.getString(R.string.rtexcept, Aaaet9E3, qQGH5NaP.getMessage()));
			} finally {
				try {
					if (M4CbVOLu != null)
						M4CbVOLu.close();
					if (fzAyUEm8 != null)
						fzAyUEm8.close();
					if (!move && errMsg != null && KCUEV4d0 != null && !XLyVzdX6) {
						Log.i(TAG, "Deleting failed output file");
						KCUEV4d0.delete();
					}
				} catch (IOException mXz43U9x) {
					error(G992Icnu.getString(R.string.acc_err, Aaaet9E3, mXz43U9x.getMessage()));
				}
			}
		}
		return counter;
	}

}