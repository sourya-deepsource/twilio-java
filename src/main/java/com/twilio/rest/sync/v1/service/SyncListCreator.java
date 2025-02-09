/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.sync.v1.service;

import com.twilio.base.Creator;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class SyncListCreator extends Creator<SyncList> {
    private final String pathServiceSid;
    private String uniqueName;
    private Integer ttl;
    private Integer collectionTtl;

    /**
     * Construct a new SyncListCreator.
     *
     * @param pathServiceSid The SID of the Sync Service  to create the new Sync
     *                       List in
     */
    public SyncListCreator(final String pathServiceSid) {
        this.pathServiceSid = pathServiceSid;
    }

    /**
     * An application-defined string that uniquely identifies the resource. This
     * value must be unique within its Service and it can be up to 320 characters
     * long. The `unique_name` value can be used as an alternative to the `sid` in
     * the URL path to address the resource..
     *
     * @param uniqueName An application-defined string that uniquely identifies the
     *                   resource
     * @return this
     */
    public SyncListCreator setUniqueName(final String uniqueName) {
        this.uniqueName = uniqueName;
        return this;
    }

    /**
     * Alias for collection_ttl. If both are provided, this value is ignored..
     *
     * @param ttl Alias for collection_ttl
     * @return this
     */
    public SyncListCreator setTtl(final Integer ttl) {
        this.ttl = ttl;
        return this;
    }

    /**
     * How long, in seconds, before the Sync List expires (time-to-live) and is
     * deleted.  Can be an integer from 0 to 31,536,000 (1 year). The default value
     * is `0`, which means the Sync List does not expire. The Sync List will be
     * deleted automatically after it expires, but there can be a delay between the
     * expiration time and the resources's deletion..
     *
     * @param collectionTtl How long, in seconds, before the Sync List expires and
     *                      is deleted
     * @return this
     */
    public SyncListCreator setCollectionTtl(final Integer collectionTtl) {
        this.collectionTtl = collectionTtl;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Created SyncList
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public SyncList create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.SYNC.toString(),
            "/v1/Services/" + this.pathServiceSid + "/Lists"
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("SyncList creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return SyncList.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (uniqueName != null) {
            request.addPostParam("UniqueName", uniqueName);
        }

        if (ttl != null) {
            request.addPostParam("Ttl", ttl.toString());
        }

        if (collectionTtl != null) {
            request.addPostParam("CollectionTtl", collectionTtl.toString());
        }
    }
}