package com.joulebug.readability;

import com.google.gson.Gson;
import org.apache.http.*;
import org.apache.http.client.*;
import org.apache.http.client.methods.*;
import org.apache.http.client.params.AllClientPNames;
import org.apache.http.conn.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: josephelliott
 * Date: 12/19/13
 * Time: 10:22
 * To change this template use File | Settings | File Templates.
 */

/**
 *  Readability Parser API Client.
 *
 *  https://www.readability.com/developers/api/parser
 */
public class ReadabilityParserClient {

    private static final String CHARSET = "UTF-8";
    private static final int DEFAULT_CONNECTION_TIMEOUT = (10 * 1000); // milliseconds
    private static final int DEFAULT_SOCKET_TIMEOUT = (30 * 1000); // milliseconds

    private String parserToken;
    private HttpClient httpClient;
    private ClientConnectionManager connMgr;

    public ReadabilityParserClient(String parserToken) {
        this.parserToken = parserToken;

        setSocketTimeout(DEFAULT_SOCKET_TIMEOUT);
        setConnectionTimeout(DEFAULT_CONNECTION_TIMEOUT);
    }

    public Parser parse(String url, Integer pages, String id) {
        ArrayList<RequestParameter> parameterList = new ArrayList<RequestParameter>();
        parameterList.add( new RequestParameter("url",url));
        parameterList.add(new RequestParameter("max_pages",pages.toString()));
        parameterList.add( new RequestParameter("id",id));
        return get(Parser.class,"parser",parameterList);
    }

    public Parser parse(String url) {
        ArrayList<RequestParameter> parameterList = new ArrayList<RequestParameter>();
        parameterList.add( new RequestParameter("url",url));
        return get(Parser.class,"parser",parameterList);
    }


    public Confidence confidence(String url, String callback) {
        ArrayList<RequestParameter> parameterList = new ArrayList<RequestParameter>();
        parameterList.add(new RequestParameter("url", url));
        parameterList.add(new RequestParameter("callback", callback));
       return get(Confidence.class,"confidence",parameterList);
    }

    public Confidence confidence(String url) {
        ArrayList<RequestParameter> parameterList = new ArrayList<RequestParameter>();
        parameterList.add( new RequestParameter("url", url));
        return get(Confidence.class, "confidence", parameterList);
    }


    /*
    *  Boilerplate for making get HTTP request, mostly borrowed from  https://bitbucket.org/sullis/urbanairship-java.
    *
    */
    protected HttpGet createHttpGet(String path) {
        HttpGet get = new HttpGet(this.getUrlForPath(path));
        return get;
    }

    protected HttpEntity toJsonEntity(final Object obj) {
        String json = toJson(obj);

        try {
            return new JsonEntity(json);
        }
        catch (Exception ex) {
            Class clazz = null;
            if (obj != null) {
                clazz = obj.getClass();
            }
            throw new RuntimeException("failure, obj class=" + clazz, ex);
        }
    }

    //todo: better error checking.
    /*
    typical error output:
    {
        messages: "An 'id' or 'url' parameter must be passed to return content for.",
        error: true
    }
     */
    protected void checkResponse(HttpRequest request, HttpResponse response) {
        boolean hasError = false;

        try {
            StatusLine status = response.getStatusLine();
            int statusCode = status.getStatusCode();

            if (statusCode == 404) {
                hasError = true;
                throw new RuntimeException(status.getReasonPhrase());
            }
            else if (statusCode < 200 || statusCode > 299) {
                hasError = true;
                StringBuilder msg = new StringBuilder();
                msg.append("statusCode=" + statusCode);
                msg.append("\n");
                msg.append("method=" + request.getRequestLine().getMethod());
                msg.append("\n");
                msg.append(request.getRequestLine().getUri());

                HttpEntity responseEntity = response.getEntity();

                try {
                    String responseBody = EntityUtils.toString(responseEntity);
                    msg.append("\n");
                    msg.append("responseBody=" + responseBody);
                }
                catch (Exception ignored) {}

                throw new RuntimeException("unexpected response\n" + msg);
            }
        }
        finally {
            if (hasError) {
                close(response);
            }
        }
    }

    private void close(final HttpResponse resp) {
        if (resp != null) {
            try {
                close(resp.getEntity());
            }
            catch (Exception ignored) {}
        }
    }

    private void close(final HttpEntity responseEntity) {
        if (responseEntity != null) {
            try {
                responseEntity.consumeContent();
            }
            catch (Exception ignored) {}
        }
    }

    protected <T> T fromJson(HttpResponse rsp, Class<T> clazz) {
        if (clazz == null) {
            return null;
        }

        if (rsp.getEntity() == null) {
            return null;
        }

        try {
            String responseBody = EntityUtils.toString(rsp.getEntity());
            return fromJson(responseBody, clazz);
        }
        catch (RuntimeException rtex) {
            throw rtex;
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            close(rsp);
        }
    }


    protected HttpResponse execute(HttpRequestBase method) {
        try {
            method.setHeader(new BasicHeader("Accept", "application/json"));
            HttpResponse rsp = getHttpClient().execute(method);
            checkResponse(method, rsp);
            return rsp;
        }
        catch (RuntimeException rtex) {
            throw rtex;
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    protected HttpClient getHttpClient() {
        if (this.httpClient == null) {
            this.httpClient = createHttpClient();
        }
        return this.httpClient;
    }

    protected HttpClient createHttpClient() {
        DefaultHttpClient client = new DefaultHttpClient(this.connMgr);
        client.getParams().setParameter(AllClientPNames.USER_AGENT, "readability-java library");

        return client;
    }

    protected String getParserToken() {
        return this.parserToken;
    }

    protected String getUrlForPath(final String path) {
        if (path.startsWith("http://") || (path.startsWith("https://"))) {
            return path;
        }
        else {
            return "https://" + getHostname() + path;
        }
    }

    protected String getHostname() {
        return "readability.com/api/content/v1/";
    }

    protected String includeRequestParameters(final String path, final ArrayList<RequestParameter> parameterList)
    {
       String pathWithParameters = path;
       Integer count = 0;
       for(RequestParameter parameter : parameterList){

           String separator = "&";

           if(count == 0){
              separator = "?";
           }
           pathWithParameters = pathWithParameters + separator + parameter.key+"="+parameter.value;
           count++;
       }
       return pathWithParameters;
    }

    protected String getString(final String path, final String... parameters) {
        HttpGet get = createHttpGet(path);
        HttpResponse rsp = this.execute(get);
        return toString(rsp);
    }

    protected String toString(HttpResponse rsp) {
        try {
            return EntityUtils.toString(rsp.getEntity());
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        finally {
            close(rsp);
        }
    }

    protected <T> T get(final Class<T> clazz, final String path, final ArrayList<RequestParameter> parameterList) {

        ArrayList<RequestParameter> parameterWithToken = new ArrayList<RequestParameter>();
        parameterWithToken.add(new RequestParameter("token",this.parserToken));
        parameterWithToken.addAll(parameterList);
        String pathWithParameters = includeRequestParameters(path,parameterWithToken);
        HttpGet get = createHttpGet(pathWithParameters);
        HttpResponse rsp = this.execute(get);
        return fromJson(rsp, clazz);
    }

    protected <T> String toJson(final T object) {
        if (object == null) {
            throw new IllegalArgumentException("object parameter is null");
        }
        System.out.println(object.toString());
        Gson gson = new Gson();
        return gson.toJson(object);
    }

    protected <T> T fromJson(final String json, final Class<T> clazz) {
        Gson gson = new Gson();
        return gson.fromJson(json, clazz);
    }

    protected String encode(String s) {
        try {
            return URLEncoder.encode(s, CHARSET);
        }
        catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    static private class JsonEntity extends StringEntity {

        public JsonEntity(String jsonString) throws UnsupportedEncodingException {
            super(jsonString, CHARSET);
        }

        @Override
        public Header getContentType() {
            Header h = new BasicHeader("Content-Type", "application/json");
            return h;
        }

    }

    public void shutdown() {
        if (this.getHttpClient() != null) {
            try {
                this.getHttpClient().getConnectionManager().shutdown();
            }
            catch (Exception ignored) {}
        }
    }

    public void setConnectionTimeout(int milliseconds) {
        getHttpClient().getParams().setIntParameter(AllClientPNames.CONNECTION_TIMEOUT, milliseconds);
    }

    public void setSocketTimeout(int milliseconds) {
        getHttpClient().getParams().setIntParameter(AllClientPNames.SO_TIMEOUT, milliseconds);
    }

}
