class n18410603{
    private void performUpdateCheck() {
        URL url;
        DPhex dPhex;
        try {
            byte[] data = buildXMLUpdateRequest();
            if (data == null) {
                throw new IOException("Missing XML update data");
            }
            if (logger.isDebugEnabled()) {
                logger.debug(new String(data));
            }
            url = new URL(UPDATE_CHECK_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setUseCaches(false);
            connection.setRequestProperty("User-Agent", Phex.getFullPhexVendor());
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
            OutputStream outStream = connection.getOutputStream();
            outStream.write(data);
            UpdatePrefs.LastUpdateCheckTime.set(Long.valueOf(System.currentTimeMillis()));
            InputStream inStream = connection.getInputStream();
            UpdateResponseParts parts = createResponseParts(inStream);
            verifySignature(parts);
            dPhex = XMLBuilder.readDPhexFromStream(new ByteArrayInputStream(parts.xml.getBytes("UTF-8")));
        } catch (MalformedURLException exp) {
            updateCheckError = exp;
            logger.error(exp.toString(), exp);
            assert false;
            throw new RuntimeException();
        } catch (UnknownHostException exp) {
            updateCheckError = exp;
            logger.warn(exp.toString(), exp);
            return;
        } catch (SocketException exp) {
            updateCheckError = exp;
            logger.warn(exp.toString(), exp);
            return;
        } catch (IOException exp) {
            updateCheckError = exp;
            logger.warn(exp.toString(), exp);
            return;
        } finally {
            PhexCorePrefs.save(false);
        }
        DUpdateResponse response = dPhex.getUpdateResponse();
        List<VersionType> versionList = response.getVersionList();
        VersionType latestReleaseVersion = null;
        VersionType latestBetaVersion = null;
        for (VersionType currentVersion : versionList) {
            if (currentVersion.isBeta()) {
                if (latestBetaVersion == null || VersionUtils.compare(currentVersion.getId(), latestBetaVersion.getId()) > 0) {
                    latestBetaVersion = currentVersion;
                }
            } else {
                if (latestReleaseVersion == null || VersionUtils.compare(currentVersion.getId(), latestReleaseVersion.getId()) > 0) {
                    latestReleaseVersion = currentVersion;
                }
            }
        }
        betaVersion = "0";
        releaseVersion = "0";
        if (latestBetaVersion != null) {
            betaVersion = latestBetaVersion.getId();
        }
        if (latestReleaseVersion != null) {
            releaseVersion = latestReleaseVersion.getId();
        }
        int releaseCompare = 0;
        int betaCompare = 0;
        betaCompare = VersionUtils.compare(betaVersion, PhexVersion.getFullVersion());
        releaseCompare = VersionUtils.compare(releaseVersion, PhexVersion.getFullVersion());
        if (releaseCompare <= 0 && betaCompare <= 0) {
            return;
        }
        betaCompare = VersionUtils.compare(betaVersion, UpdatePrefs.LastBetaUpdateCheckVersion.get());
        releaseCompare = VersionUtils.compare(releaseVersion, UpdatePrefs.LastUpdateCheckVersion.get());
        int verDiff = VersionUtils.compare(betaVersion, releaseVersion);
        boolean triggerUpdateNotification = false;
        if (releaseCompare > 0) {
            UpdatePrefs.LastUpdateCheckVersion.set(releaseVersion);
            triggerUpdateNotification = true;
        }
        if (betaCompare > 0) {
            UpdatePrefs.LastBetaUpdateCheckVersion.set(betaVersion);
            triggerUpdateNotification = true;
        }
        if (verDiff > 0) {
            releaseVersion = null;
        } else {
            betaVersion = null;
        }
        if (triggerUpdateNotification) {
            PhexCorePrefs.save(false);
            fireUpdateNotification();
        }
    }

}