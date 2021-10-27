class n19434890 {
	public RequestLogger() {
        Server.getScheduler().register("Request Log Rotator", new SchedulerInterface() {

            public int getScheduleRate() {
                return 0;
            }

            public void handle() {
                if (requestCounter == 0) {
                    requestCounter++;
                    return;
                }
                requestCounter++;
                Iterator nhNP84ky = loggerTimeouts.keySet().iterator();
                while (nhNP84ky.hasNext()) {
                    String jVAPRLlE = (String) nhNP84ky.next();
                    String hGnSH9hU = (String) loggerTimeouts.get(jVAPRLlE);
                    int bqhovz7l = Integer.parseInt(hGnSH9hU);
                    if (bqhovz7l > 0) {
                        bqhovz7l /= 10;
                    }
                    int TpDmp87y = (requestCounter % bqhovz7l);
                    if (TpDmp87y == 0) {
                        Object Q6czPK7O = loggerFiles.get(jVAPRLlE);
                        Object ierEp9lt = loggerFilenames.get(jVAPRLlE);
                        Object JBWaU5ho = loggerDests.get(jVAPRLlE);
                        Object yYlJ3ByO = loggerCompresses.get(jVAPRLlE);
                        Object F4Nxm9iY = loggerDays.get(jVAPRLlE);
                        Object aDO9BU2b = loggerArchives.get(jVAPRLlE);
                        Object lHQckQD3 = loggerDeletes.get(jVAPRLlE);
                        boolean GNSY0tEV = false;
                        boolean MfBEEEC6 = false;
                        String Se4uO9Rp = null;
                        String fMG8Zpuf = null;
                        String qriSrDsW = null;
                        int dwuoVWth = 0;
                        if (yYlJ3ByO != null && ((String) yYlJ3ByO).equalsIgnoreCase("true")) {
                            GNSY0tEV = true;
                        }
                        if (lHQckQD3 != null && ((String) lHQckQD3).equalsIgnoreCase("true")) {
                            MfBEEEC6 = true;
                        }
                        if (JBWaU5ho != null) {
                            Se4uO9Rp = (String) JBWaU5ho;
                        }
                        if (ierEp9lt != null) {
                            fMG8Zpuf = (String) ierEp9lt;
                        }
                        if (aDO9BU2b != null) {
                            qriSrDsW = (String) aDO9BU2b;
                        }
                        if (F4Nxm9iY != null) {
                            dwuoVWth = Integer.parseInt((String) F4Nxm9iY);
                        }
                        FileChannel SAc4Gdef, tkNfMMX3;
                        String LCUWq6YE = fMG8Zpuf + "." + System.currentTimeMillis();
                        String DWV41GZ5 = fMG8Zpuf + "." + System.currentTimeMillis() + ".gz";
                        if (Se4uO9Rp != null) {
                            (new File(Se4uO9Rp)).mkdirs();
                            if (LCUWq6YE.indexOf("/") != -1) {
                                LCUWq6YE = Se4uO9Rp + "/" + LCUWq6YE.substring(LCUWq6YE.lastIndexOf("/") + 1);
                            }
                            if (DWV41GZ5.indexOf("/") != -1) {
                                DWV41GZ5 = Se4uO9Rp + "/" + DWV41GZ5.substring(DWV41GZ5.lastIndexOf("/") + 1);
                            }
                        }
                        if (GNSY0tEV) {
                            try {
                                GZIPOutputStream SDtq64hE = new GZIPOutputStream(new FileOutputStream(DWV41GZ5));
                                FileInputStream IFnydPQk = new FileInputStream(fMG8Zpuf);
                                byte VobER36o[] = new byte[1024];
                                int PmxiG2P1;
                                while ((PmxiG2P1 = IFnydPQk.read(VobER36o)) > 0) {
                                    SDtq64hE.write(VobER36o, 0, PmxiG2P1);
                                }
                                IFnydPQk.close();
                                SDtq64hE.finish();
                                SDtq64hE.close();
                                Debug.debug("Rotated log file '" + fMG8Zpuf + "' to '" + DWV41GZ5 + "'");
                                VobER36o = null;
                                SDtq64hE = null;
                                IFnydPQk = null;
                            } catch (Exception fm7IoYsi) {
                                Debug.debug("Unable to rotate log file '" + fMG8Zpuf + "': " + fm7IoYsi);
                            }
                        } else {
                            try {
                                SAc4Gdef = new FileInputStream(fMG8Zpuf).getChannel();
                            } catch (IOException q5s9nFCk) {
                                Debug.debug("Unable to read log file '" + fMG8Zpuf + "': " + q5s9nFCk.getMessage());
                                return;
                            }
                            try {
                                tkNfMMX3 = new FileOutputStream(LCUWq6YE).getChannel();
                            } catch (IOException HfabutiH) {
                                Debug.debug("Unable to rotate log file '" + fMG8Zpuf + "' to '" + LCUWq6YE + "': " + HfabutiH.getMessage());
                                return;
                            }
                            try {
                                tkNfMMX3.transferFrom(SAc4Gdef, 0, SAc4Gdef.size());
                                SAc4Gdef.close();
                                tkNfMMX3.close();
                                tkNfMMX3 = null;
                                SAc4Gdef = null;
                            } catch (IOException T87BrfB0) {
                                Debug.debug("Unable to copy data from file '" + fMG8Zpuf + "' to '" + LCUWq6YE + "' for file rotation: " + T87BrfB0.getMessage());
                                return;
                            }
                            Debug.debug("Rotated log file '" + fMG8Zpuf + "' to '" + LCUWq6YE + "'");
                        }
                        if (MfBEEEC6) {
                            try {
                                ((PrintStream) Q6czPK7O).close();
                            } catch (Exception qMcOQQP7) {
                            }
                            (new File(fMG8Zpuf)).delete();
                            loggerFiles.remove(jVAPRLlE);
                            addLogger(jVAPRLlE, fMG8Zpuf);
                        }
                        if (Se4uO9Rp != null) {
                            long hEjqXjLQ = dwuoVWth * (60 * 60 * 24 * 1000);
                            long TEeDEIbL = System.currentTimeMillis();
                            File y77h5St8[] = (new File(Se4uO9Rp)).listFiles();
                            DateFormat VAzWCnni = new SimpleDateFormat("yyyy-MM-dd");
                            java.util.Date fDC4WdE1 = new java.util.Date(TEeDEIbL);
                            String GbX65Yr4 = VAzWCnni.format(fDC4WdE1).toString() + ".zip";
                            if (qriSrDsW != null) {
                                GbX65Yr4 = qriSrDsW + "/" + GbX65Yr4;
                                (new File(qriSrDsW)).mkdirs();
                            }
                            Archive kTv9shZR = new Archive(GbX65Yr4);
                            for (int kPrUR1rV = 0; kPrUR1rV < y77h5St8.length; kPrUR1rV++) {
                                String N2L3urCI = y77h5St8[kPrUR1rV].getName();
                                long xJ4sWt52 = (TEeDEIbL - y77h5St8[kPrUR1rV].lastModified());
                                if ((GNSY0tEV && N2L3urCI.endsWith(".gz")) || (!GNSY0tEV && N2L3urCI.indexOf(fMG8Zpuf + ".") != -1)) {
                                    if (Se4uO9Rp != null) {
                                        N2L3urCI = Se4uO9Rp + "/" + N2L3urCI;
                                    }
                                    if (xJ4sWt52 > hEjqXjLQ) {
                                        kTv9shZR.addFile(y77h5St8[kPrUR1rV].getName(), N2L3urCI);
                                        y77h5St8[kPrUR1rV].delete();
                                    }
                                }
                            }
                            y77h5St8 = null;
                            VAzWCnni = null;
                            kTv9shZR = null;
                        }
                    }
                }
                nhNP84ky = null;
            }

            public String identString() {
                return "Request Log Rotator";
            }
        });
    }

}