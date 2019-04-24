/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.notify.v1;

import com.twilio.base.Updater;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

/**
 * PLEASE NOTE that this class contains beta products that are subject to
 * change. Use them with caution.
 */
public class CredentialUpdater extends Updater<Credential> {
    private final String pathSid;
    private String friendlyName;
    private String certificate;
    private String privateKey;
    private Boolean sandbox;
    private String apiKey;
    private String secret;

    /**
     * Construct a new CredentialUpdater.
     * 
     * @param pathSid The unique string that identifies the resource
     */
    public CredentialUpdater(final String pathSid) {
        this.pathSid = pathSid;
    }

    /**
     * A descriptive string that you create to describe the resource. It can be up
     * to 64 characters long..
     * 
     * @param friendlyName A string to describe the resource
     * @return this
     */
    public CredentialUpdater setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * [APN only] The URL-encoded representation of the certificate. Strip
     * everything outside of the headers, e.g. `-----BEGIN
     * CERTIFICATE-----MIIFnTCCBIWgAwIBAgIIAjy9H849+E8wDQYJKoZIhvcNAQEFBQAwgZYxCzAJBgNV.....A==-----END CERTIFICATE-----`.
     * 
     * @param certificate [APN only] The URL-encoded representation of the
     *                    certificate
     * @return this
     */
    public CredentialUpdater setCertificate(final String certificate) {
        this.certificate = certificate;
        return this;
    }

    /**
     * [APN only] The URL-encoded representation of the private key. Strip
     * everything outside of the headers, e.g. `-----BEGIN RSA PRIVATE
     * KEY-----MIIEpQIBAAKCAQEAuyf/lNrH9ck8DmNyo3fGgvCI1l9s+cmBY3WIz+cUDqmxiieR\n.-----END RSA PRIVATE KEY-----`.
     * 
     * @param privateKey [APN only] URL-encoded representation of the private key
     * @return this
     */
    public CredentialUpdater setPrivateKey(final String privateKey) {
        this.privateKey = privateKey;
        return this;
    }

    /**
     * [APN only] Whether to send the credential to sandbox APNs. Can be `true` to
     * send to sandbox APNs or `false` to send to production..
     * 
     * @param sandbox [APN only] Whether to send the credential to sandbox APNs
     * @return this
     */
    public CredentialUpdater setSandbox(final Boolean sandbox) {
        this.sandbox = sandbox;
        return this;
    }

    /**
     * [GCM only] The `Server key` of your project from Firebase console under
     * Settings / Cloud messaging..
     * 
     * @param apiKey [GCM only] The `Server key` of your project from Firebase
     *               console under Settings / Cloud messaging
     * @return this
     */
    public CredentialUpdater setApiKey(final String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    /**
     * [FCM only] The `Server key` of your project from Firebase console under
     * Settings / Cloud messaging..
     * 
     * @param secret [FCM only] The `Server key` of your project from Firebase
     *               console under Settings / Cloud messaging
     * @return this
     */
    public CredentialUpdater setSecret(final String secret) {
        this.secret = secret;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the update.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Updated Credential
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Credential update(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.NOTIFY.toString(),
            "/v1/Credentials/" + this.pathSid + "",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Credential update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }

            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }

        return Credential.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }

        if (certificate != null) {
            request.addPostParam("Certificate", certificate);
        }

        if (privateKey != null) {
            request.addPostParam("PrivateKey", privateKey);
        }

        if (sandbox != null) {
            request.addPostParam("Sandbox", sandbox.toString());
        }

        if (apiKey != null) {
            request.addPostParam("ApiKey", apiKey);
        }

        if (secret != null) {
            request.addPostParam("Secret", secret);
        }
    }
}