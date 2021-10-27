class n991473{
    private void doUpdate(final boolean notifyOnChange) {
        if (!validServerUrl) {
            return;
        }
        boolean tempBuildClean = true;
        List failedBuilds = new ArrayList();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                Matcher matcher = ROW_PARSER_PATTERN.matcher(line);
                if (matcher.matches() && checkAllProjects) {
                    String project = matcher.group(GROUP_PROJECT);
                    String status = matcher.group(GROUP_STATUS);
                    if (status.equals(MessageUtils.getString("ccOutput.status.failed"))) {
                        tempBuildClean = false;
                        failedBuilds.add(project);
                    }
                }
            }
        } catch (IOException e) {
            serverReachable = false;
            if (notifyOnChange) {
                monitor.notifyServerUnreachable(MessageUtils.getString("error.readError", new String[] { url.toString() }));
            }
            return;
        }
        if (notifyOnChange && buildClean && !tempBuildClean) {
            monitor.notifyBuildFailure(MessageUtils.getString("message.buildFailed", new Object[] { failedBuilds.get(0) }));
        }
        if (notifyOnChange && !buildClean && tempBuildClean) {
            monitor.notifyBuildFixed(MessageUtils.getString("message.allBuildsClean"));
        }
        buildClean = tempBuildClean;
        monitor.setStatus(buildClean);
        serverReachable = true;
    }

}