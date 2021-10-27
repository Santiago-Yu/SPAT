                public void run() {
                    BufferedReader reader = null;
                    String message = null;
                    int messageStyle = SWT.ICON_WARNING;
                    try {
                        URL url = new URL(Version.LATEST_VERSION_URL);
                        URLConnection conn = url.openConnection();
                        reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        String latestVersion = reader.readLine();
                        latestVersion = latestVersion.substring(latestVersion.indexOf(' ') + 1);
                        if (!Version.getVersion().equals(latestVersion)) {
                            message = Labels.getLabel("text.version.old");
                            message = message.replaceFirst("%LATEST", latestVersion);
                            message = message.replaceFirst("%VERSION", Version.getVersion());
                            messageStyle = SWT.ICON_QUESTION | SWT.YES | SWT.NO;
                        } else {
                            message = Labels.getLabel("text.version.latest");
                            messageStyle = SWT.ICON_INFORMATION;
                        }
                    } catch (Exception e) {
                        message = Labels.getLabel("exception.UserErrorException.version.latestFailed");
                        Logger.getLogger(getClass().getName()).log(Level.WARNING, message, e);
                    } finally {
                        try {
                            if (reader != null) reader.close();
                        } catch (IOException e) {
                        }
                        final String messageToShow = message;
                        final int messageStyleToShow = messageStyle;
                        Display.getDefault().asyncExec(new Runnable() {

                            public void run() {
                                statusBar.setStatusText(null);
                                MessageBox messageBox = new MessageBox(statusBar.getShell(), messageStyleToShow);
                                messageBox.setText(Version.getFullName());
                                messageBox.setMessage(messageToShow);
                                if (messageBox.open() == SWT.YES) {
                                    BrowserLauncher.openURL(Version.DOWNLOAD_URL);
                                }
                            }
                        });
                    }
                }
