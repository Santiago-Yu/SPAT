class n2771574{
                protected IStatus run(IProgressMonitor monitor) {
                    try {
                        updateRunning = true;
                        distributor = getFromFile("[SERVER]", "csz", getAppPath() + "/server.ini");
                        MAC = getFromFile("[SPECIFICINFO]", "MAC", getAppPath() + "/register.ini");
                        serial = getFromFile("[SPECIFICINFO]", "serial", getAppPath() + "/register.ini");
                        if (MAC.equals("not_found") || serial.equals("not_found") || !serial.startsWith(distributor)) {
                            try {
                                MAC = getFromFile("[SPECIFICINFO]", "MAC", getAppPath() + "/register.ini");
                                serial = getFromFile("[SPECIFICINFO]", "serial", getAppPath() + "/register.ini");
                            } catch (Exception e) {
                                System.out.println(e);
                            }
                        } else {
                            try {
                                url = new URL("http://" + getFromFile("[SERVER]", "url", getAppPath() + "/server.ini"));
                            } catch (MalformedURLException e) {
                                System.out.println(e);
                            }
                            download = "/download2.php?distributor=" + distributor + "&&mac=" + MAC + "&&serial=" + serial;
                            readXML();
                            if (htmlMessage.contains("error")) {
                                try {
                                    PrintWriter pw = new PrintWriter(getAppPath() + "/register.ini");
                                    pw.write("");
                                    pw.close();
                                } catch (IOException e) {
                                    System.out.println(e);
                                }
                                setProperty(IProgressConstants.ICON_PROPERTY, IconImg.liveUpIco);
                                if (isModal(this)) {
                                    showResults2();
                                } else {
                                    setProperty(IProgressConstants.KEEP_PROPERTY, Boolean.TRUE);
                                    setProperty(IProgressConstants.ACTION_PROPERTY, getUpdateCompletedAction2());
                                }
                            } else {
                                if (!getDBVersion().equals(latestVersion)) {
                                    try {
                                        OutputStream out = null;
                                        HttpURLConnection conn = null;
                                        InputStream in = null;
                                        int size;
                                        try {
                                            URL url = new URL(fileLoc);
                                            String outFile = getAppPath() + "/temp/" + getFileName(url);
                                            File oFile = new File(outFile);
                                            oFile.delete();
                                            out = new BufferedOutputStream(new FileOutputStream(outFile));
                                            monitor.beginTask("Connecting to NWD Server", 100);
                                            conn = (HttpURLConnection) url.openConnection();
                                            conn.setConnectTimeout(20000);
                                            conn.connect();
                                            if (conn.getResponseCode() / 100 != 2) {
                                                System.out.println("Error: " + conn.getResponseCode());
                                                return null;
                                            }
                                            monitor.worked(100);
                                            monitor.done();
                                            size = conn.getContentLength();
                                            monitor.beginTask("Download Worm Definition", size);
                                            in = conn.getInputStream();
                                            byte[] buffer;
                                            String downloadedSize;
                                            long numWritten = 0;
                                            boolean status = true;
                                            while (status) {
                                                if (size - numWritten > 1024) {
                                                    buffer = new byte[1024];
                                                } else {
                                                    buffer = new byte[(int) (size - numWritten)];
                                                }
                                                int read = in.read(buffer);
                                                if (read == -1) {
                                                    break;
                                                }
                                                out.write(buffer, 0, read);
                                                numWritten += read;
                                                downloadedSize = Long.toString(numWritten / 1024) + " KB";
                                                monitor.worked(read);
                                                monitor.subTask(downloadedSize + " of " + Integer.toString(size / 1024) + " KB");
                                                if (size == numWritten) {
                                                    status = false;
                                                }
                                                if (monitor.isCanceled()) return Status.CANCEL_STATUS;
                                            }
                                            if (in != null) {
                                                in.close();
                                            }
                                            if (out != null) {
                                                out.close();
                                            }
                                            try {
                                                ZipFile zFile = new ZipFile(outFile);
                                                Enumeration all = zFile.entries();
                                                while (all.hasMoreElements()) {
                                                    ZipEntry zEntry = (ZipEntry) all.nextElement();
                                                    long zSize = zEntry.getSize();
                                                    if (zSize > 0) {
                                                        if (zEntry.getName().endsWith("script")) {
                                                            InputStream instream = zFile.getInputStream(zEntry);
                                                            FileOutputStream fos = new FileOutputStream(oldLoc[0]);
                                                            int ch;
                                                            while ((ch = instream.read()) != -1) {
                                                                fos.write(ch);
                                                            }
                                                            instream.close();
                                                            fos.close();
                                                        } else if (zEntry.getName().endsWith("data")) {
                                                            InputStream instream = zFile.getInputStream(zEntry);
                                                            FileOutputStream fos = new FileOutputStream(oldLoc[1]);
                                                            int ch;
                                                            while ((ch = instream.read()) != -1) {
                                                                fos.write(ch);
                                                            }
                                                            instream.close();
                                                            fos.close();
                                                        }
                                                    }
                                                }
                                                File xFile = new File(outFile);
                                                xFile.deleteOnExit();
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                            try {
                                                monitor.done();
                                                monitor.beginTask("Install Worm Definition", 10000);
                                                monitor.worked(2500);
                                                CorePlugin.getDefault().getRawPacketHandler().removeRawPacketListener(p);
                                                p = null;
                                                if (!wormDB.getConn().isClosed()) {
                                                    shutdownDB();
                                                }
                                                System.out.println(wormDB.getConn().isClosed());
                                                for (int i = 0; i < 2; i++) {
                                                    try {
                                                        Process pid = Runtime.getRuntime().exec("cmd /c copy \"" + oldLoc[i].replace("/", "\\") + "\" \"" + newLoc[i].replace("/", "\\") + "\"/y");
                                                    } catch (Exception e) {
                                                        e.printStackTrace();
                                                    }
                                                    new File(oldLoc[i]).deleteOnExit();
                                                }
                                                monitor.worked(2500);
                                                initialArray();
                                                p = new PacketPrinter();
                                                CorePlugin.getDefault().getRawPacketHandler().addRawPacketListener(p);
                                                monitor.worked(2500);
                                                monitor.done();
                                                setProperty(IProgressConstants.ICON_PROPERTY, IconImg.liveUpIco);
                                                if (isModal(this)) {
                                                    showResults();
                                                } else {
                                                    setProperty(IProgressConstants.KEEP_PROPERTY, Boolean.TRUE);
                                                    setProperty(IProgressConstants.ACTION_PROPERTY, getUpdateCompletedAction());
                                                }
                                            } catch (Exception e) {
                                                setProperty(IProgressConstants.ICON_PROPERTY, IconImg.liveUpIco);
                                                if (isModal(this)) {
                                                    showResults2();
                                                } else {
                                                    setProperty(IProgressConstants.KEEP_PROPERTY, Boolean.TRUE);
                                                    setProperty(IProgressConstants.ACTION_PROPERTY, getUpdateCompletedAction2());
                                                }
                                                System.out.println(e);
                                            } finally {
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    } catch (Exception e) {
                                        setProperty(IProgressConstants.ICON_PROPERTY, IconImg.liveUpIco);
                                        if (isModal(this)) {
                                            showResults2();
                                        } else {
                                            setProperty(IProgressConstants.KEEP_PROPERTY, Boolean.TRUE);
                                            setProperty(IProgressConstants.ACTION_PROPERTY, getUpdateCompletedAction2());
                                        }
                                        e.printStackTrace();
                                    }
                                } else {
                                    cancel();
                                    setProperty(IProgressConstants.ICON_PROPERTY, IconImg.liveUpIco);
                                    if (isModal(this)) {
                                        showResults1();
                                    } else {
                                        setProperty(IProgressConstants.KEEP_PROPERTY, Boolean.TRUE);
                                        setProperty(IProgressConstants.ACTION_PROPERTY, getUpdateCompletedAction1());
                                    }
                                }
                            }
                        }
                        return Status.OK_STATUS;
                    } catch (Exception e) {
                        showResults2();
                        return Status.OK_STATUS;
                    } finally {
                        lock.release();
                        updateRunning = false;
                        if (getValue("AUTO_UPDATE")) schedule(10800000);
                    }
                }

}