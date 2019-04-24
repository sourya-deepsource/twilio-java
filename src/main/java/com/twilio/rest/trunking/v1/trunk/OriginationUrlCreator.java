/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.trunking.v1.trunk;

import com.twilio.base.Creator;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.net.URI;

public class OriginationUrlCreator extends Creator<OriginationUrl> {
    private final String pathTrunkSid;
    private final Integer weight;
    private final Integer priority;
    private final Boolean enabled;
    private final String friendlyName;
    private final URI sipUrl;

    /**
     * Construct a new OriginationUrlCreator.
     * 
     * @param pathTrunkSid The SID of the Trunk to associate the resource with
     * @param weight The value that determines the relative load the URI should
     *               receive compared to others with the same priority
     * @param priority The relative importance of the URI
     * @param enabled Whether the URL is enabled
     * @param friendlyName A string to describe the resource
     * @param sipUrl The SIP address you want Twilio to route your Origination
     *               calls to
     */
    public OriginationUrlCreator(final String pathTrunkSid, 
                                 final Integer weight, 
                                 final Integer priority, 
                                 final Boolean enabled, 
                                 final String friendlyName, 
                                 final URI sipUrl) {
        this.pathTrunkSid = pathTrunkSid;
        this.weight = weight;
        this.priority = priority;
        this.enabled = enabled;
        this.friendlyName = friendlyName;
        this.sipUrl = sipUrl;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Created OriginationUrl
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public OriginationUrl create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.TRUNKING.toString(),
            "/v1/Trunks/" + this.pathTrunkSid + "/OriginationUrls",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("OriginationUrl creation failed: Unable to connect to server");
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

        return OriginationUrl.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (weight != null) {
            request.addPostParam("Weight", weight.toString());
        }

        if (priority != null) {
            request.addPostParam("Priority", priority.toString());
        }

        if (enabled != null) {
            request.addPostParam("Enabled", enabled.toString());
        }

        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }

        if (sipUrl != null) {
            request.addPostParam("SipUrl", sipUrl.toString());
        }
    }
}