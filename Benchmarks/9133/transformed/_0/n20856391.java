class n20856391 {
	public void launchJob(final String NfMYKySa, final AppConfigType e9cI6h1N) throws FaultType {
		logger.info("called for job: " + jobID);
		MessageContext CUAn83KA = MessageContext.getCurrentContext();
		HttpServletRequest VCbZv1Nk = (HttpServletRequest) CUAn83KA.getProperty(HTTPConstants.MC_HTTP_SERVLETREQUEST);
		String RtajwXzd = (String) VCbZv1Nk.getAttribute(GSIConstants.GSI_USER_DN);
		if (RtajwXzd != null) {
			logger.info("Client's DN: " + RtajwXzd);
		} else {
			RtajwXzd = "Unknown client";
		}
		String XM8PMyAB = VCbZv1Nk.getRemoteAddr();
		SOAPService QzbRonq1 = CUAn83KA.getService();
		String ahWfxnjC = QzbRonq1.getName();
		if (ahWfxnjC == null) {
			ahWfxnjC = "Unknown service";
		}
		if (e9cI6h1N.isParallel()) {
			if (AppServiceImpl.drmaaInUse) {
				if (AppServiceImpl.drmaaPE == null) {
					logger.error("drmaa.pe property must be specified in opal.properties "
							+ "for parallel execution using DRMAA");
					throw new FaultType("drmaa.pe property must be specified in opal.properties "
							+ "for parallel execution using DRMAA");
				}
				if (AppServiceImpl.mpiRun == null) {
					logger.error("mpi.run property must be specified in opal.properties "
							+ "for parallel execution using DRMAA");
					throw new FaultType("mpi.run property must be specified in "
							+ "opal.properties for parallel execution " + "using DRMAA");
				}
			} else if (!AppServiceImpl.globusInUse) {
				if (AppServiceImpl.mpiRun == null) {
					logger.error("mpi.run property must be specified in opal.properties "
							+ "for parallel execution without using Globus");
					throw new FaultType("mpi.run property must be specified in "
							+ "opal.properties for parallel execution " + "without using Globus");
				}
			}
			if (jobIn.getNumProcs() == null) {
				logger.error("Number of processes unspecified for parallel job");
				throw new FaultType("Number of processes unspecified for parallel job");
			} else if (jobIn.getNumProcs().intValue() > AppServiceImpl.numProcs) {
				logger.error(
						"Processors required - " + jobIn.getNumProcs() + ", available - " + AppServiceImpl.numProcs);
				throw new FaultType(
						"Processors required - " + jobIn.getNumProcs() + ", available - " + AppServiceImpl.numProcs);
			}
		}
		try {
			status.setCode(GramJob.STATUS_PENDING);
			status.setMessage("Launching executable");
			status.setBaseURL(new URI(AppServiceImpl.tomcatURL + jobID));
		} catch (MalformedURIException TIdqlv7v) {
			logger.error("Cannot convert base_url string to URI - " + TIdqlv7v.getMessage());
			throw new FaultType("Cannot convert base_url string to URI - " + TIdqlv7v.getMessage());
		}
		if (!AppServiceImpl.dbInUse) {
			AppServiceImpl.statusTable.put(jobID, status);
		} else {
			Connection LfDWRCYs = null;
			try {
				LfDWRCYs = DriverManager.getConnection(AppServiceImpl.dbUrl, AppServiceImpl.dbUser,
						AppServiceImpl.dbPasswd);
			} catch (SQLException OSOgwxVj) {
				logger.error("Cannot connect to database - " + OSOgwxVj.getMessage());
				throw new FaultType("Cannot connect to database - " + OSOgwxVj.getMessage());
			}
			String pXaL7noA = new SimpleDateFormat("MMM d, yyyy h:mm:ss a", Locale.US).format(new Date());
			String POFlr7cO = "insert into job_status(job_id, code, message, base_url, "
					+ "client_dn, client_ip, service_name, start_time, last_update) " + "values ('" + jobID + "', "
					+ status.getCode() + ", " + "'" + status.getMessage() + "', " + "'" + status.getBaseURL() + "', "
					+ "'" + RtajwXzd + "', " + "'" + XM8PMyAB + "', " + "'" + ahWfxnjC + "', " + "'" + pXaL7noA + "', "
					+ "'" + pXaL7noA + "');";
			try {
				Statement JYEfDV1m = LfDWRCYs.createStatement();
				JYEfDV1m.executeUpdate(POFlr7cO);
				LfDWRCYs.close();
			} catch (SQLException WWTFnaRc) {
				logger.error("Cannot insert job status into database - " + WWTFnaRc.getMessage());
				throw new FaultType("Cannot insert job status into database - " + WWTFnaRc.getMessage());
			}
		}
		String KfLTy9Zb = e9cI6h1N.getDefaultArgs();
		if (KfLTy9Zb == null) {
			KfLTy9Zb = jobIn.getArgList();
		} else {
			String Oas79Zyc = jobIn.getArgList();
			if (Oas79Zyc != null)
				KfLTy9Zb += " " + Oas79Zyc;
		}
		if (KfLTy9Zb != null) {
			KfLTy9Zb = KfLTy9Zb.trim();
		}
		logger.debug("Argument list: " + KfLTy9Zb);
		if (AppServiceImpl.drmaaInUse) {
			String wVMHtq8v = null;
			String[] mcYLEvUB = null;
			if (e9cI6h1N.isParallel()) {
				wVMHtq8v = "/bin/sh";
				String Z2TeBcgT = AppServiceImpl.mpiRun + " -machinefile $TMPDIR/machines" + " -np "
						+ jobIn.getNumProcs() + " " + e9cI6h1N.getBinaryLocation();
				if (KfLTy9Zb != null) {
					KfLTy9Zb = Z2TeBcgT + " " + KfLTy9Zb;
				} else {
					KfLTy9Zb = Z2TeBcgT;
				}
				logger.debug("CMD: " + KfLTy9Zb);
				mcYLEvUB = new String[] { "-c", KfLTy9Zb };
			} else {
				wVMHtq8v = e9cI6h1N.getBinaryLocation();
				if (KfLTy9Zb == null)
					KfLTy9Zb = "";
				logger.debug("CMD: " + wVMHtq8v + " " + KfLTy9Zb);
				mcYLEvUB = KfLTy9Zb.split(" ");
			}
			try {
				logger.debug("Working directory: " + NfMYKySa);
				JobTemplate FhUNAy6D = session.createJobTemplate();
				if (e9cI6h1N.isParallel())
					FhUNAy6D.setNativeSpecification("-pe " + AppServiceImpl.drmaaPE + " " + jobIn.getNumProcs());
				FhUNAy6D.setRemoteCommand(wVMHtq8v);
				FhUNAy6D.setArgs(mcYLEvUB);
				FhUNAy6D.setJobName(jobID);
				FhUNAy6D.setWorkingDirectory(NfMYKySa);
				FhUNAy6D.setErrorPath(":" + NfMYKySa + "/stderr.txt");
				FhUNAy6D.setOutputPath(":" + NfMYKySa + "/stdout.txt");
				drmaaJobID = session.runJob(FhUNAy6D);
				logger.info("DRMAA job has been submitted with id " + drmaaJobID);
				session.deleteJobTemplate(FhUNAy6D);
			} catch (Exception I1RBmsT1) {
				logger.error(I1RBmsT1);
				status.setCode(GramJob.STATUS_FAILED);
				status.setMessage("Error while running executable via DRMAA - " + I1RBmsT1.getMessage());
				if (AppServiceImpl.dbInUse) {
					try {
						updateStatusInDatabase(jobID, status);
					} catch (SQLException iKRMp7nN) {
						logger.error(iKRMp7nN);
						throw new FaultType("Cannot update status into database - " + iKRMp7nN.getMessage());
					}
				}
				return;
			}
			status.setCode(GramJob.STATUS_ACTIVE);
			status.setMessage("Execution in progress");
			if (AppServiceImpl.dbInUse) {
				try {
					updateStatusInDatabase(jobID, status);
				} catch (SQLException CyOlhttW) {
					logger.error(CyOlhttW);
					throw new FaultType("Cannot update status into database - " + CyOlhttW.getMessage());
				}
			}
		} else if (AppServiceImpl.globusInUse) {
			String yWhsPmFy = null;
			if (e9cI6h1N.isParallel()) {
				yWhsPmFy = "&(directory=" + NfMYKySa + ")" + "(executable=" + e9cI6h1N.getBinaryLocation() + ")"
						+ "(count=" + jobIn.getNumProcs() + ")" + "(jobtype=mpi)" + "(stdout=stdout.txt)"
						+ "(stderr=stderr.txt)";
			} else {
				yWhsPmFy = "&(directory=" + NfMYKySa + ")" + "(executable=" + e9cI6h1N.getBinaryLocation() + ")"
						+ "(stdout=stdout.txt)" + "(stderr=stderr.txt)";
			}
			if (KfLTy9Zb != null) {
				KfLTy9Zb = "\"" + KfLTy9Zb + "\"";
				KfLTy9Zb = KfLTy9Zb.replaceAll("[\\s]+", "\" \"");
				yWhsPmFy += "(arguments=" + KfLTy9Zb + ")";
			}
			logger.debug("RSL: " + yWhsPmFy);
			try {
				job = new GramJob(yWhsPmFy);
				GlobusCredential iDnkn9tj = new GlobusCredential(AppServiceImpl.serviceCertPath,
						AppServiceImpl.serviceKeyPath);
				GSSCredential Kz4lYieD = new GlobusGSSCredentialImpl(iDnkn9tj, GSSCredential.INITIATE_AND_ACCEPT);
				job.setCredentials(Kz4lYieD);
				job.addListener(this);
				job.request(AppServiceImpl.gatekeeperContact);
			} catch (Exception SmYyx10Z) {
				logger.error(SmYyx10Z);
				status.setCode(GramJob.STATUS_FAILED);
				status.setMessage("Error while running executable via Globus - " + SmYyx10Z.getMessage());
				if (AppServiceImpl.dbInUse) {
					try {
						updateStatusInDatabase(jobID, status);
					} catch (SQLException mtU9JKt8) {
						logger.error(mtU9JKt8);
						throw new FaultType("Cannot update status into database - " + mtU9JKt8.getMessage());
					}
				}
				return;
			}
		} else {
			String s05GrU7a = null;
			if (e9cI6h1N.isParallel()) {
				s05GrU7a = new String(AppServiceImpl.mpiRun + " " + "-np " + jobIn.getNumProcs() + " "
						+ e9cI6h1N.getBinaryLocation());
			} else {
				s05GrU7a = new String(e9cI6h1N.getBinaryLocation());
			}
			if (KfLTy9Zb != null) {
				s05GrU7a += " " + KfLTy9Zb;
			}
			logger.debug("CMD: " + s05GrU7a);
			try {
				logger.debug("Working directory: " + NfMYKySa);
				proc = Runtime.getRuntime().exec(s05GrU7a, null, new File(NfMYKySa));
				stdoutThread = writeStdOut(proc, NfMYKySa);
				stderrThread = writeStdErr(proc, NfMYKySa);
			} catch (IOException PNM2nPw3) {
				logger.error(PNM2nPw3);
				status.setCode(GramJob.STATUS_FAILED);
				status.setMessage("Error while running executable via fork - " + PNM2nPw3.getMessage());
				if (AppServiceImpl.dbInUse) {
					try {
						updateStatusInDatabase(jobID, status);
					} catch (SQLException AcAHmaU0) {
						logger.error(AcAHmaU0);
						throw new FaultType("Cannot update status into database - " + AcAHmaU0.getMessage());
					}
				}
				return;
			}
			status.setCode(GramJob.STATUS_ACTIVE);
			status.setMessage("Execution in progress");
			if (AppServiceImpl.dbInUse) {
				try {
					updateStatusInDatabase(jobID, status);
				} catch (SQLException X95SdbmL) {
					logger.error(X95SdbmL);
					throw new FaultType("Cannot update status into database - " + X95SdbmL.getMessage());
				}
			}
		}
		new Thread() {

			public void run() {
				try {
					waitForCompletion();
				} catch (FaultType J4nosPMz) {
					logger.error(J4nosPMz);
					synchronized (status) {
						status.notifyAll();
					}
					return;
				}
				if (AppServiceImpl.drmaaInUse || !AppServiceImpl.globusInUse) {
					done = true;
					status.setCode(GramJob.STATUS_STAGE_OUT);
					status.setMessage("Writing output metadata");
					if (AppServiceImpl.dbInUse) {
						try {
							updateStatusInDatabase(jobID, status);
						} catch (SQLException hCq2RmyU) {
							status.setCode(GramJob.STATUS_FAILED);
							status.setMessage("Cannot update status database after finish - " + hCq2RmyU.getMessage());
							logger.error(hCq2RmyU);
							synchronized (status) {
								status.notifyAll();
							}
							return;
						}
					}
				}
				try {
					if (!AppServiceImpl.drmaaInUse && !AppServiceImpl.globusInUse) {
						try {
							logger.debug("Waiting for all outputs to be written out");
							stdoutThread.join();
							stderrThread.join();
							logger.debug("All outputs successfully written out");
						} catch (InterruptedException KuOLTozT) {
						}
					}
					File gddyi3WD = new File(NfMYKySa + File.separator + "stdout.txt");
					if (!gddyi3WD.exists()) {
						throw new IOException("Standard output missing for execution");
					}
					File c0snZs9m = new File(NfMYKySa + File.separator + "stderr.txt");
					if (!c0snZs9m.exists()) {
						throw new IOException("Standard error missing for execution");
					}
					if (AppServiceImpl.archiveData) {
						logger.debug("Archiving output files");
						File eAM3pRgP = new File(NfMYKySa);
						File[] wVc41O6M = eAM3pRgP.listFiles();
						ZipOutputStream oHfSqwmy = new ZipOutputStream(
								new FileOutputStream(NfMYKySa + File.separator + jobID + ".zip"));
						byte[] zgnWSkp9 = new byte[1024];
						try {
							for (int Re1ToNeE = 0; Re1ToNeE < wVc41O6M.length; Re1ToNeE++) {
								FileInputStream DW5Ujfpx = new FileInputStream(wVc41O6M[Re1ToNeE]);
								oHfSqwmy.putNextEntry(new ZipEntry(wVc41O6M[Re1ToNeE].getName()));
								int wi3M6RPm;
								while ((wi3M6RPm = DW5Ujfpx.read(zgnWSkp9)) > 0) {
									oHfSqwmy.write(zgnWSkp9, 0, wi3M6RPm);
								}
								oHfSqwmy.closeEntry();
								DW5Ujfpx.close();
							}
							oHfSqwmy.close();
						} catch (IOException lrSCd04G) {
							logger.error(lrSCd04G);
							logger.error("Error not fatal - moving on");
						}
					}
					File WJ4JGUBo = new File(NfMYKySa);
					File[] pHauXXD7 = WJ4JGUBo.listFiles();
					OutputFileType[] gWAY2xFn = new OutputFileType[pHauXXD7.length - 2];
					int y2pfYzWk = 0;
					for (int VT2v7WD7 = 0; VT2v7WD7 < pHauXXD7.length; VT2v7WD7++) {
						if (pHauXXD7[VT2v7WD7].getName().equals("stdout.txt")) {
							outputs.setStdOut(new URI(AppServiceImpl.tomcatURL + jobID + "/stdout.txt"));
						} else if (pHauXXD7[VT2v7WD7].getName().equals("stderr.txt")) {
							outputs.setStdErr(new URI(AppServiceImpl.tomcatURL + jobID + "/stderr.txt"));
						} else {
							OutputFileType pY0Xj75s = new OutputFileType();
							pY0Xj75s.setName(pHauXXD7[VT2v7WD7].getName());
							pY0Xj75s.setUrl(
									new URI(AppServiceImpl.tomcatURL + jobID + "/" + pHauXXD7[VT2v7WD7].getName()));
							gWAY2xFn[y2pfYzWk++] = pY0Xj75s;
						}
					}
					outputs.setOutputFile(gWAY2xFn);
				} catch (IOException n7aK2Nvg) {
					status.setCode(GramJob.STATUS_FAILED);
					status.setMessage("Cannot retrieve outputs after finish - " + n7aK2Nvg.getMessage());
					logger.error(n7aK2Nvg);
					if (AppServiceImpl.dbInUse) {
						try {
							updateStatusInDatabase(jobID, status);
						} catch (SQLException zfShYv5m) {
							logger.error(zfShYv5m);
						}
					}
					synchronized (status) {
						status.notifyAll();
					}
					return;
				}
				if (!AppServiceImpl.dbInUse) {
					AppServiceImpl.outputTable.put(jobID, outputs);
				} else {
					Connection sM7DthIv = null;
					try {
						sM7DthIv = DriverManager.getConnection(AppServiceImpl.dbUrl, AppServiceImpl.dbUser,
								AppServiceImpl.dbPasswd);
					} catch (SQLException FIKyw7CL) {
						status.setCode(GramJob.STATUS_FAILED);
						status.setMessage("Cannot connect to database after finish - " + FIKyw7CL.getMessage());
						logger.error(FIKyw7CL);
						synchronized (status) {
							status.notifyAll();
						}
						return;
					}
					String Y7yAA9c3 = "insert into job_output(job_id, std_out, std_err) " + "values ('" + jobID + "', "
							+ "'" + outputs.getStdOut().toString() + "', " + "'" + outputs.getStdErr().toString()
							+ "');";
					Statement IMjkfFQY = null;
					try {
						IMjkfFQY = sM7DthIv.createStatement();
						IMjkfFQY.executeUpdate(Y7yAA9c3);
					} catch (SQLException B9UT3Bmu) {
						status.setCode(GramJob.STATUS_FAILED);
						status.setMessage("Cannot update job output database after finish - " + B9UT3Bmu.getMessage());
						logger.error(B9UT3Bmu);
						try {
							updateStatusInDatabase(jobID, status);
						} catch (SQLException ZEY38hJ1) {
							logger.error(ZEY38hJ1);
						}
						synchronized (status) {
							status.notifyAll();
						}
						return;
					}
					OutputFileType[] STPLXIuV = outputs.getOutputFile();
					for (int ZhtEmeNw = 0; ZhtEmeNw < STPLXIuV.length; ZhtEmeNw++) {
						Y7yAA9c3 = "insert into output_file(job_id, name, url) " + "values ('" + jobID + "', " + "'"
								+ STPLXIuV[ZhtEmeNw].getName() + "', " + "'" + STPLXIuV[ZhtEmeNw].getUrl().toString()
								+ "');";
						try {
							IMjkfFQY = sM7DthIv.createStatement();
							IMjkfFQY.executeUpdate(Y7yAA9c3);
						} catch (SQLException C5E0XyiE) {
							status.setCode(GramJob.STATUS_FAILED);
							status.setMessage("Cannot update output_file DB after finish - " + C5E0XyiE.getMessage());
							logger.error(C5E0XyiE);
							try {
								updateStatusInDatabase(jobID, status);
							} catch (SQLException ePXocqPw) {
								logger.error(ePXocqPw);
							}
							synchronized (status) {
								status.notifyAll();
							}
							return;
						}
					}
				}
				if (terminatedOK()) {
					status.setCode(GramJob.STATUS_DONE);
					status.setMessage("Execution complete - " + "check outputs to verify successful execution");
				} else {
					status.setCode(GramJob.STATUS_FAILED);
					status.setMessage("Execution failed");
				}
				if (AppServiceImpl.dbInUse) {
					try {
						updateStatusInDatabase(jobID, status);
					} catch (SQLException di15E5xQ) {
						status.setCode(GramJob.STATUS_FAILED);
						status.setMessage("Cannot update status database after finish - " + di15E5xQ.getMessage());
						logger.error(di15E5xQ);
						synchronized (status) {
							status.notifyAll();
						}
						return;
					}
				}
				AppServiceImpl.jobTable.remove(jobID);
				synchronized (status) {
					status.notifyAll();
				}
				logger.info("Execution complete for job: " + jobID);
			}
		}.start();
	}

}