class n18574455 {
	protected boolean process(final TranscodeJobImpl m0xfqunw) {
		TranscodePipe ezrOnmt7 = null;
		current_job = m0xfqunw;
		DeviceImpl doOLpDv4 = m0xfqunw.getDevice();
		doOLpDv4.setTranscoding(true);
		try {
			m0xfqunw.starts();
			TranscodeProvider HgXs0b3p = m0xfqunw.getProfile().getProvider();
			final TranscodeException[] rOi5gLnY = { null };
			TranscodeProfile UWZxsPju = m0xfqunw.getProfile();
			final TranscodeFileImpl EQnyAsDo = m0xfqunw.getTranscodeFile();
			TranscodeProviderAnalysis QTwuyr1E;
			boolean SVQkLcvv;
			if (HgXs0b3p == null) {
				SVQkLcvv = false;
				QTwuyr1E = null;
			} else {
				QTwuyr1E = analyse(m0xfqunw);
				SVQkLcvv = QTwuyr1E.getBooleanProperty(TranscodeProviderAnalysis.PT_TRANSCODE_REQUIRED);
				int ZlGsE3F8;
				if (m0xfqunw.isStream()) {
					ZlGsE3F8 = TranscodeTarget.TRANSCODE_ALWAYS;
				} else {
					ZlGsE3F8 = m0xfqunw.getTranscodeRequirement();
					if (doOLpDv4 instanceof TranscodeTarget) {
						if (QTwuyr1E.getLongProperty(TranscodeProviderAnalysis.PT_VIDEO_HEIGHT) == 0) {
							if (((TranscodeTarget) doOLpDv4).isAudioCompatible(EQnyAsDo)) {
								ZlGsE3F8 = TranscodeTarget.TRANSCODE_NEVER;
							}
						}
					}
				}
				if (ZlGsE3F8 == TranscodeTarget.TRANSCODE_NEVER) {
					SVQkLcvv = false;
				} else if (ZlGsE3F8 == TranscodeTarget.TRANSCODE_ALWAYS) {
					SVQkLcvv = true;
					QTwuyr1E.setBooleanProperty(TranscodeProviderAnalysis.PT_FORCE_TRANSCODE, true);
				}
			}
			if (SVQkLcvv) {
				final AESemaphore tWA0zq27 = new AESemaphore("xcode:proc");
				final TranscodeProviderJob[] gCM9weC3 = { null };
				TranscodeProviderAdapter k8JsNipQ = new TranscodeProviderAdapter() {

					private boolean xSpkegxv;

					private final int hByWlqg9 = 10;

					private int uIpJIabv;

					private int IFvI9Tf8;

					private Average rbX77bLz = AverageFactory.MovingAverage(hByWlqg9);

					private int scqWXIp5;

					public void updateProgress(int HPOfcVHr, int xscjeOeZ, int iPPr4VFq, int p0wsLbD8) {
						uIpJIabv = xscjeOeZ;
						scqWXIp5 = HPOfcVHr;
						TranscodeProviderJob L13x3R8J = gCM9weC3[0];
						if (L13x3R8J == null) {
							return;
						}
						int D6MmZnOe = m0xfqunw.getState();
						if (D6MmZnOe == TranscodeJob.ST_CANCELLED || D6MmZnOe == TranscodeJob.ST_REMOVED) {
							L13x3R8J.cancel();
						} else if (paused || D6MmZnOe == TranscodeJob.ST_PAUSED) {
							L13x3R8J.pause();
						} else {
							if (D6MmZnOe == TranscodeJob.ST_RUNNING) {
								L13x3R8J.resume();
							}
							m0xfqunw.updateProgress(HPOfcVHr, xscjeOeZ);
							L13x3R8J.setMaxBytesPerSecond(max_bytes_per_sec);
							if (!xSpkegxv) {
								if (iPPr4VFq > 0 && p0wsLbD8 > 0) {
									EQnyAsDo.setResolution(iPPr4VFq, p0wsLbD8);
									xSpkegxv = true;
								}
							}
						}
					}

					public void streamStats(long IjOzw4Jh, long mNir3zwm) {
						if (Constants.isOSX && m0xfqunw.getEnableAutoRetry() && m0xfqunw.canUseDirectInput()
								&& m0xfqunw.getAutoRetryCount() == 0) {
							if (IjOzw4Jh > 5 && scqWXIp5 < 100) {
								long lcB0Plei = (long) rbX77bLz.update(uIpJIabv);
								IFvI9Tf8++;
								if (IFvI9Tf8 >= hByWlqg9) {
									long Lj7YLHn7 = (lcB0Plei * 100) / (100 - scqWXIp5);
									long TByPElyL = Lj7YLHn7 * mNir3zwm;
									DiskManagerFileInfo KL2kDqz4 = m0xfqunw.getFile();
									long rbxMSHOq = KL2kDqz4.getLength();
									if (rbxMSHOq > 0) {
										double RSFzOzF8 = ((double) TByPElyL) / rbxMSHOq;
										if (RSFzOzF8 > 5.0) {
											failed(new TranscodeException(
													"Overwrite limit exceeded, abandoning transcode"));
											gCM9weC3[0].cancel();
										}
									}
								}
							} else {
								IFvI9Tf8 = 0;
							}
						}
					}

					public void failed(TranscodeException IAZTrRIz) {
						if (rOi5gLnY[0] == null) {
							rOi5gLnY[0] = IAZTrRIz;
						}
						tWA0zq27.release();
					}

					public void complete() {
						tWA0zq27.release();
					}
				};
				boolean RRz8K8q1 = m0xfqunw.useDirectInput();
				if (m0xfqunw.isStream()) {
					ezrOnmt7 = new TranscodePipeStreamSource2(new TranscodePipeStreamSource2.streamListener() {

						public void gotStream(InputStream zgm0uEa6) {
							m0xfqunw.setStream(zgm0uEa6);
						}
					});
					gCM9weC3[0] = HgXs0b3p.transcode(k8JsNipQ, QTwuyr1E, RRz8K8q1, m0xfqunw.getFile(), UWZxsPju,
							new URL("tcp://127.0.0.1:" + ezrOnmt7.getPort()));
				} else {
					File WuewTV0D = EQnyAsDo.getCacheFile();
					gCM9weC3[0] = HgXs0b3p.transcode(k8JsNipQ, QTwuyr1E, RRz8K8q1, m0xfqunw.getFile(), UWZxsPju,
							WuewTV0D.toURI().toURL());
				}
				gCM9weC3[0].setMaxBytesPerSecond(max_bytes_per_sec);
				TranscodeQueueListener Vp8YOYUE = new TranscodeQueueListener() {

					public void jobAdded(TranscodeJob PDRlNxks) {
					}

					public void jobChanged(TranscodeJob vQ8lgFAI) {
						if (vQ8lgFAI == m0xfqunw) {
							int l26f7Xd7 = m0xfqunw.getState();
							if (l26f7Xd7 == TranscodeJob.ST_PAUSED) {
								gCM9weC3[0].pause();
							} else if (l26f7Xd7 == TranscodeJob.ST_RUNNING) {
								gCM9weC3[0].resume();
							} else if (l26f7Xd7 == TranscodeJob.ST_CANCELLED || l26f7Xd7 == TranscodeJob.ST_STOPPED) {
								gCM9weC3[0].cancel();
							}
						}
					}

					public void jobRemoved(TranscodeJob oYWsEicN) {
						if (oYWsEicN == m0xfqunw) {
							gCM9weC3[0].cancel();
						}
					}
				};
				try {
					addListener(Vp8YOYUE);
					tWA0zq27.reserve();
				} finally {
					removeListener(Vp8YOYUE);
				}
				if (rOi5gLnY[0] != null) {
					throw (rOi5gLnY[0]);
				}
			} else {
				DiskManagerFileInfo uCn788uJ = m0xfqunw.getFile();
				EQnyAsDo.setTranscodeRequired(false);
				if (m0xfqunw.isStream()) {
					PluginInterface QoG496zq = PluginInitializer.getDefaultInterface().getPluginManager()
							.getPluginInterfaceByID("azupnpav");
					if (QoG496zq == null) {
						throw (new TranscodeException("Media Server plugin not found"));
					}
					IPCInterface ieXtYzNJ = QoG496zq.getIPC();
					String VLxRg37U = (String) ieXtYzNJ.invoke("getContentURL", new Object[] { uCn788uJ });
					if (VLxRg37U == null || VLxRg37U.length() == 0) {
						File bICWOu05 = uCn788uJ.getFile();
						if (bICWOu05.exists()) {
							m0xfqunw.setStream(new BufferedInputStream(new FileInputStream(bICWOu05)));
						} else {
							throw (new TranscodeException("No UPnPAV URL and file doesn't exist"));
						}
					} else {
						URL EkMmpntl = new URL(VLxRg37U);
						m0xfqunw.setStream(EkMmpntl.openConnection().getInputStream());
					}
				} else {
					if (doOLpDv4.getAlwaysCacheFiles()) {
						PluginInterface oMFXzFxJ = PluginInitializer.getDefaultInterface().getPluginManager()
								.getPluginInterfaceByID("azupnpav");
						if (oMFXzFxJ == null) {
							throw (new TranscodeException("Media Server plugin not found"));
						}
						IPCInterface nF0mEFpa = oMFXzFxJ.getIPC();
						String BIBgE5Wc = (String) nF0mEFpa.invoke("getContentURL", new Object[] { uCn788uJ });
						InputStream DJpzoMK2;
						long S9Pzk3AN;
						if (BIBgE5Wc == null || BIBgE5Wc.length() == 0) {
							File wojKCtFh = uCn788uJ.getFile();
							if (wojKCtFh.exists()) {
								DJpzoMK2 = new BufferedInputStream(new FileInputStream(wojKCtFh));
								S9Pzk3AN = wojKCtFh.length();
							} else {
								throw (new TranscodeException("No UPnPAV URL and file doesn't exist"));
							}
						} else {
							URL XymHgUjy = new URL(BIBgE5Wc);
							URLConnection piwcy7Wa = XymHgUjy.openConnection();
							DJpzoMK2 = XymHgUjy.openConnection().getInputStream();
							String DwMSoUt5 = piwcy7Wa.getHeaderField("content-length");
							if (DwMSoUt5 != null) {
								S9Pzk3AN = Long.parseLong(DwMSoUt5);
							} else {
								S9Pzk3AN = -1;
							}
						}
						OutputStream MwAj2EU1 = null;
						final boolean[] y4zxHErD = { false };
						TranscodeQueueListener SucIwNIM = new TranscodeQueueListener() {

							public void jobAdded(TranscodeJob hwcGWyBV) {
							}

							public void jobChanged(TranscodeJob dUlaizPF) {
								if (dUlaizPF == m0xfqunw) {
									int pnmfqfZq = m0xfqunw.getState();
									if (pnmfqfZq == TranscodeJob.ST_PAUSED) {
									} else if (pnmfqfZq == TranscodeJob.ST_RUNNING) {
									} else if (pnmfqfZq == TranscodeJob.ST_CANCELLED
											|| pnmfqfZq == TranscodeJob.ST_STOPPED) {
										y4zxHErD[0] = true;
									}
								}
							}

							public void jobRemoved(TranscodeJob x1iSyayd) {
								if (x1iSyayd == m0xfqunw) {
									y4zxHErD[0] = true;
								}
							}
						};
						try {
							addListener(SucIwNIM);
							MwAj2EU1 = new FileOutputStream(EQnyAsDo.getCacheFile());
							long a288EI7G = 0;
							byte[] MR3R7F1h = new byte[128 * 1024];
							while (true) {
								if (y4zxHErD[0]) {
									throw (new TranscodeException("Copy cancelled"));
								}
								int WOnAfAYC = DJpzoMK2.read(MR3R7F1h);
								if (WOnAfAYC <= 0) {
									break;
								}
								MwAj2EU1.write(MR3R7F1h, 0, WOnAfAYC);
								a288EI7G += WOnAfAYC;
								if (S9Pzk3AN > 0) {
									m0xfqunw.updateProgress((int) (a288EI7G * 100 / S9Pzk3AN), -1);
								}
								a288EI7G += WOnAfAYC;
							}
						} finally {
							try {
								DJpzoMK2.close();
							} catch (Throwable jxcKUryD) {
								Debug.out(jxcKUryD);
							}
							try {
								if (MwAj2EU1 != null) {
									MwAj2EU1.close();
								}
							} catch (Throwable TabPl40P) {
								Debug.out(TabPl40P);
							}
							removeListener(SucIwNIM);
						}
					}
				}
			}
			m0xfqunw.complete();
			return (true);
		} catch (Throwable Hk3EAzNf) {
			m0xfqunw.failed(Hk3EAzNf);
			Hk3EAzNf.printStackTrace();
			if (!m0xfqunw.isStream() && m0xfqunw.getEnableAutoRetry() && m0xfqunw.getAutoRetryCount() == 0
					&& m0xfqunw.canUseDirectInput() && !m0xfqunw.useDirectInput()) {
				log("Auto-retrying transcode with direct input");
				m0xfqunw.setUseDirectInput();
				m0xfqunw.setAutoRetry(true);
				queue_sem.release();
			}
			return (false);
		} finally {
			if (ezrOnmt7 != null) {
				ezrOnmt7.destroy();
			}
			doOLpDv4.setTranscoding(false);
			current_job = null;
		}
	}

}