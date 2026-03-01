package java112.project3;

/**
 * 
 * 
 */
public class HttpRequestData {
    String remoteComp;
    String remoteCompAddress;
    String httpMethod;
    String requestURI;
    String requestURL;
    String requestProtocol;
    String serverName;
    String serverPort;
    String serverLocale;
    String queryString;
    String queryParameter;
    String userAgent;

    /**
     * constructor for the class in case setters don't load. I don't actually think this works lol
     */
    public HttpRequestData() {
        remoteComp = "remote Computer";
        remoteCompAddress = "remote computer address";
        httpMethod = "http method";
        requestURI = "request URI";
        requestURL = "request URL";
        requestProtocol = "request Protocol";
        serverName = "server name";
        serverPort = "server port";
        serverLocale = "Server Locale";
        queryString = "query String";
        queryParameter = "query parameter";
        userAgent = "user agent";
    }

    /**
     * standard setter for a bean
     * @param value setter value
     */
    public void setRemoteComp(String value) {
        remoteComp = value;
    }
    /**
     * standard getter for a bean
     * @return remoteComp
     */
    public String getRemoteComp() {
        return remoteComp;
    }
    /**
     * standard setter for a bean
     * @param value setter value
     */
    public void setRemoteCompAddress(String value) {
        remoteCompAddress = value;
    }
    /**
     * standard getter for a bean
     * @return remoteCompAddress
     */
    public String getRemoteCompAddress() {
        return remoteCompAddress;
    }
    /**
     * standard setter for a bean
     * @param value setter value
     */
    public void setRequestURI(String value) {
        requestURI = value;
    }
    /**
     * standard getter for a bean
     * @return requestURI
     */
    public String getRequestURI() {
        return requestURI;
    }
    /**
     * standard setter for a bean
     * @param value setter value
     */
    public void setRequestURL(String value) {
        requestURL = value;
    }
    /**
     * standard getter for a bean
     * @return requestURL
     */
    public String getRequestURL() {
        return requestURL;
    }
    /**
     * standard setter for a bean
     * @param value setter value
     */ 
    public void setRequestProtocol(String value) {
        requestProtocol = value;
    }
    /**
     * standard getter for a bean
     * @return requestProtocol
     */
    public String getRequestProtocol() {
        return requestProtocol;
    }
    /**
     * standard setter for a bean
     * @param value setter value
     */
    public void setServerName(String value) {
        serverName = value;
    }
    /**
     * standard getter for a bean
     * @return serverName
     */
    public String getServerName() {
        return serverName;
    }
    /**
     * standard setter for a bean
     * @param value setter value
     */
    public void setServerPort(String value) {
        serverPort = value;
    }
    /**
     * standard getter for a bean
     * @return serverPort
     */
    public String getServerPort() {
        return serverPort;
    }
    /**
     * standard setter for a bean
     * @param value setter value
     */
    public void setServerLocale(String value) {
        serverLocale = value;
    }
    /**
     * standard getter for a bean
     * @return serverLocale
     */
    public String getServerLocale() {
        return serverLocale;
    }
    /**
     * standard setter for a bean
     * @param value setter value
     */
    public void setQueryString(String value) {
        queryString = value;
    }
    /**
     * standard getter for a bean
     * @return queryString
     */
    public String getQueryString() {
        return queryString;
    }
    /**
     * standard setter for a bean
     * @param value setter value
     */
    public void setQueryParameter(String value) {
        queryParameter = value;
    }
    /**
     * standard getter for a bean
     * @return queryParameter
     */
    public String getQueryParameter() {
        return queryParameter;
    }
    /**
     * standard setter for a bean
     * @param value setter value
     */
    public void setUserAgent(String value) {
        userAgent = value;
    }
    /**
     * standard getter for a bean
     * @return userAgent
     */
    public String getUserAgent() {
        return userAgent;
    }
    /**
     * standard setter for a bean
     * @param value setter value
     */
    public void setHttpMethod(String value) {
        httpMethod = value;
    }
    /**
     * standard getter for a bean
     * @return httpMethod
     */
    public String getHttpMethod() {
        return httpMethod;
    }
}