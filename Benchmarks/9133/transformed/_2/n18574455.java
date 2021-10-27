class n18574455 {
	protected boolean process(final TranscodeJobImpl job) {
		TranscodePipe pipe = null;
		current_job = job;
		DeviceImpl device = job.getDevice();
		device.setTranscoding(true);
		try {
			job.starts();
			TranscodeProvider provider = job.getProfile().getProvider();
			final TranscodeException[] error = { null };
			TranscodeProfile profile = job.getProfile();
			final TranscodeFileImpl transcode_file = job.getTranscodeFile();
			TranscodeProviderAnalysis provider_analysis;
			boolean xcode_required;
			if (provider == null) {
				xcode_required = false;
				provider_analysis = null;
			} else {
				provider_analysis = analyse(job);
				xcode_required = provider_analysis.getBooleanProperty(TranscodeProviderAnalysis.PT_TRANSCODE_REQUIRED);
				int tt_req;
				if (job.isStream()) {
					tt_req = TranscodeTarget.TRANSCODE_ALWAYS;
				} else {
					tt_req = job.getTranscodeRequirement();
					if (device instanceof TranscodeTarget) {
						if (provider_analysis.getLongProperty(TranscodeProviderAnalysis.PT_VIDEO_HEIGHT) == 0) {
							if (((TranscodeTarget) device).isAudioCompatible(transcode_file)) {
								tt_req = TranscodeTarget.TRANSCODE_NEVER;
							}
						}
					}
				}
				if (tt_req == TranscodeTarget.TRANSCODE_NEVER) {
					xcode_required = false;
				} else if (tt_req == TranscodeTarget.TRANSCODE_ALWAYS) {
					xcode_required = true;
					provider_analysis.setBooleanProperty(TranscodeProviderAnalysis.PT_FORCE_TRANSCODE, true);
				}
			}
			if (xcode_required) {
				final AESemaphore xcode_sem = new AESemaphore("xcode:proc");
				final TranscodeProviderJob[] provider_job = { null };
				TranscodeProviderAdapter xcode_adapter = new TranscodeProviderAdapter() {

					private boolean resolution_updated;

					private final int ETA_AVERAGE_SIZE = 10;

					private int last_eta;

					private int eta_samples;

					private Average eta_average = AverageFactory.MovingAverage(ETA_AVERAGE_SIZE);

					private int last_percent;

					public void updateProgress(int percent, int eta_secs, int new_width, int new_height) {
						last_eta = eta_secs;
						last_percent = percent;
						TranscodeProviderJob prov_job = provider_job[0];
						if (prov_job == null) {
							return;
						}
						int job_state = job.getState();
						if (job_state == TranscodeJob.ST_CANCELLED || job_state == TranscodeJob.ST_REMOVED) {
							prov_job.cancel();
						} else if (paused || job_state == TranscodeJob.ST_PAUSED) {
							prov_job.pause();
						} else {
							if (job_state == TranscodeJob.ST_RUNNING) {
								prov_job.resume();
							}
							job.updateProgress(percent, eta_secs);
							prov_job.setMaxBytesPerSecond(max_bytes_per_sec);
							if (!resolution_updated) {
								if (new_width > 0 && new_height > 0) {
									transcode_file.setResolution(new_width, new_height);
									resolution_updated = true;
								}
							}
						}
					}

					public void streamStats(long connect_rate, long write_speed) {
						if (Constants.isOSX && job.getEnableAutoRetry() && job.canUseDirectInput()
								&& job.getAutoRetryCount() == 0) {
							if (connect_rate > 5 && last_percent < 100) {
								long eta = (long) eta_average.update(last_eta);
								eta_samples++;
								if (eta_samples >= ETA_AVERAGE_SIZE) {
									long total_time = (eta * 100) / (100 - last_percent);
									long total_write = total_time * write_speed;
									DiskManagerFileInfo file = job.getFile();
									long length = file.getLength();
									if (length > 0) {
										double over_write = ((double) total_write) / length;
										if (over_write > 5.0) {
											failed(new TranscodeException(
													"Overwrite limit exceeded, abandoning transcode"));
											provider_job[0].cancel();
										}
									}
								}
							} else {
								eta_samples = 0;
							}
						}
					}

					public void failed(TranscodeException e) {
						if (error[0] == null) {
							error[0] = e;
						}
						xcode_sem.release();
					}

					public void complete() {
						xcode_sem.release();
					}
				};
				boolean direct_input = job.useDirectInput();
				if (job.isStream()) {
					pipe = new TranscodePipeStreamSource2(new TranscodePipeStreamSource2.streamListener() {

						public void gotStream(InputStream is) {
							job.setStream(is);
						}
					});
					provider_job[0] = provider.transcode(xcode_adapter, provider_analysis, direct_input, job.getFile(),
							profile, new URL("tcp://127.0.0.1:" + pipe.getPort()));
				} else {
					File output_file = transcode_file.getCacheFile();
					provider_job[0] = provider.transcode(xcode_adapter, provider_analysis, direct_input, job.getFile(),
							profile, output_file.toURI().toURL());
				}
				provider_job[0].setMaxBytesPerSecond(max_bytes_per_sec);
				TranscodeQueueListener listener = new TranscodeQueueListener() {

					public void jobAdded(TranscodeJob job) {
					}

					public void jobChanged(TranscodeJob changed_job) {
						if (changed_job == job) {
							int state = job.getState();
							if (state == TranscodeJob.ST_PAUSED) {
								provider_job[0].pause();
							} else if (state == TranscodeJob.ST_RUNNING) {
								provider_job[0].resume();
							} else if (state == TranscodeJob.ST_CANCELLED || state == TranscodeJob.ST_STOPPED) {
								provider_job[0].cancel();
							}
						}
					}

					public void jobRemoved(TranscodeJob removed_job) {
						if (removed_job == job) {
							provider_job[0].cancel();
						}
					}
				};
				try {
					addListener(listener);
					xcode_sem.reserve();
				} finally {
					removeListener(listener);
				}
				if (error[0] != null) {
					throw (error[0]);
				}
			} else {
				DiskManagerFileInfo source = job.getFile();
				transcode_file.setTranscodeRequired(false);
				if (job.isStream()) {
					PluginInterface av_pi = PluginInitializer.getDefaultInterface().getPluginManager()
							.getPluginInterfaceByID("azupnpav");
					if (av_pi == null) {
						throw (new TranscodeException("Media Server plugin not found"));
					}
					IPCInterface av_ipc = av_pi.getIPC();
					String url_str = (String) av_ipc.invoke("getContentURL", new Object[] { source });
					if (url_str == null || url_str.length() == 0) {
						File source_file = source.getFile();
						if (source_file.exists()) {
							job.setStream(new BufferedInputStream(new FileInputStream(source_file)));
						} else {
							throw (new TranscodeException("No UPnPAV URL and file doesn't exist"));
						}
					} else {
						URL source_url = new URL(url_str);
						job.setStream(source_url.openConnection().getInputStream());
					}
				} else {
					if (device.getAlwaysCacheFiles()) {
						PluginInterface av_pi = PluginInitializer.getDefaultInterface().getPluginManager()
								.getPluginInterfaceByID("azupnpav");
						if (av_pi == null) {
							throw (new TranscodeException("Media Server plugin not found"));
						}
						IPCInterface av_ipc = av_pi.getIPC();
						String url_str = (String) av_ipc.invoke("getContentURL", new Object[] { source });
						InputStream is;
						long length;
						if (url_str == null || url_str.length() == 0) {
							File source_file = source.getFile();
							if (source_file.exists()) {
								is = new BufferedInputStream(new FileInputStream(source_file));
								length = source_file.length();
							} else {
								throw (new TranscodeException("No UPnPAV URL and file doesn't exist"));
							}
						} else {
							URL source_url = new URL(url_str);
							URLConnection connection = source_url.openConnection();
							is = source_url.openConnection().getInputStream();
							String s = connection.getHeaderField("content-length");
							if (s != null) {
								length = Long.parseLong(s);
							} else {
								length = -1;
							}
						}
						OutputStream os = null;
						final boolean[] cancel_copy = { false };
						TranscodeQueueListener copy_listener = new TranscodeQueueListener() {

							public void jobAdded(TranscodeJob job) {
							}

							public void jobChanged(TranscodeJob changed_job) {
								if (changed_job == job) {
									int state = job.getState();
									if (state == TranscodeJob.ST_PAUSED) {
									} else if (state == TranscodeJob.ST_RUNNING) {
									} else if (state == TranscodeJob.ST_CANCELLED || state == TranscodeJob.ST_STOPPED) {
										cancel_copy[0] = true;
									}
								}
							}

							public void jobRemoved(TranscodeJob removed_job) {
								if (removed_job == job) {
									cancel_copy[0] = true;
								}
							}
						};
						try {
							addListener(copy_listener);
							os = new FileOutputStream(transcode_file.getCacheFile());
							long total_copied = 0;
							byte[] buffer = new byte[128 * 1024];
							for (; true;) {
								if (cancel_copy[0]) {
									throw (new TranscodeException("Copy cancelled"));
								}
								int len = is.read(buffer);
								if (len <= 0) {
									break;
								}
								os.write(buffer, 0, len);
								total_copied += len;
								if (length > 0) {
									job.updateProgress((int) (total_copied * 100 / length), -1);
								}
								total_copied += len;
							}
						} finally {
							try {
								is.close();
							} catch (Throwable e) {
								Debug.out(e);
							}
							try {
								if (os != null) {
									os.close();
								}
							} catch (Throwable e) {
								Debug.out(e);
							}
							removeListener(copy_listener);
						}
					}
				}
			}
			job.complete();
			return (true);
		} catch (Throwable e) {
			job.failed(e);
			e.printStackTrace();
			if (!job.isStream() && job.getEnableAutoRetry() && job.getAutoRetryCount() == 0 && job.canUseDirectInput()
					&& !job.useDirectInput()) {
				log("Auto-retrying transcode with direct input");
				job.setUseDirectInput();
				job.setAutoRetry(true);
				queue_sem.release();
			}
			return (false);
		} finally {
			if (pipe != null) {
				pipe.destroy();
			}
			device.setTranscoding(false);
			current_job = null;
		}
	}

}