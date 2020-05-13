/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.voice.v1.connectionpolicy;

import com.twilio.base.Updater;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.net.URI;

public class ConnectionPolicyTargetUpdater extends Updater<ConnectionPolicyTarget> {
    private final String pathConnectionPolicySid;
    private final String pathSid;
    private String friendlyName;
    private URI target;
    private Integer priority;
    private Integer weight;
    private Boolean enabled;

    /**
     * Construct a new ConnectionPolicyTargetUpdater.
     *
     * @param pathConnectionPolicySid The SID of the Connection Policy that owns
     *                                the Target
     * @param pathSid The unique string that identifies the resource
     */
    public ConnectionPolicyTargetUpdater(final String pathConnectionPolicySid,
                                         final String pathSid) {
        this.pathConnectionPolicySid = pathConnectionPolicySid;
        this.pathSid = pathSid;
    }

    /**
     * A descriptive string that you create to describe the resource. It is not
     * unique and can be up to 255 characters long..
     *
     * @param friendlyName A string to describe the resource
     * @return this
     */
    public ConnectionPolicyTargetUpdater setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * The SIP address you want Twilio to route your calls to. This must be a `sip:`
     * schema. `sips` is NOT supported..
     *
     * @param target The SIP address you want Twilio to route your calls to
     * @return this
     */
    public ConnectionPolicyTargetUpdater setTarget(final URI target) {
        this.target = target;
        return this;
    }

    /**
     * The SIP address you want Twilio to route your calls to. This must be a `sip:`
     * schema. `sips` is NOT supported..
     *
     * @param target The SIP address you want Twilio to route your calls to
     * @return this
     */
    public ConnectionPolicyTargetUpdater setTarget(final String target) {
        return setTarget(Promoter.uriFromString(target));
    }

    /**
     * The relative importance of the target. Can be an integer from 0 to 65535,
     * inclusive. The lowest number represents the most important target..
     *
     * @param priority The relative importance of the target
     * @return this
     */
    public ConnectionPolicyTargetUpdater setPriority(final Integer priority) {
        this.priority = priority;
        return this;
    }

    /**
     * The value that determines the relative share of the load the Target should
     * receive compared to other Targets with the same priority. Can be an integer
     * from 1 to 65535, inclusive. Targets with higher values receive more load than
     * those with lower ones with the same priority..
     *
     * @param weight The value that determines the relative load the Target should
     *               receive compared to others with the same priority
     * @return this
     */
    public ConnectionPolicyTargetUpdater setWeight(final Integer weight) {
        this.weight = weight;
        return this;
    }

    /**
     * Whether the Target is enabled..
     *
     * @param enabled Whether the Target is enabled
     * @return this
     */
    public ConnectionPolicyTargetUpdater setEnabled(final Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the update.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Updated ConnectionPolicyTarget
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public ConnectionPolicyTarget update(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.VOICE.toString(),
            "/v1/ConnectionPolicies/" + this.pathConnectionPolicySid + "/Targets/" + this.pathSid + "",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("ConnectionPolicyTarget update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return ConnectionPolicyTarget.fromJson(response.getStream(), client.getObjectMapper());
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

        if (target != null) {
            request.addPostParam("Target", target.toString());
        }

        if (priority != null) {
            request.addPostParam("Priority", priority.toString());
        }

        if (weight != null) {
            request.addPostParam("Weight", weight.toString());
        }

        if (enabled != null) {
            request.addPostParam("Enabled", enabled.toString());
        }
    }
}