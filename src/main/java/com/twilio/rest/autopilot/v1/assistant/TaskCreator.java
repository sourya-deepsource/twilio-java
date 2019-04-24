/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.autopilot.v1.assistant;

import com.twilio.base.Creator;
import com.twilio.converter.Converter;
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
import java.util.Map;

/**
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
public class TaskCreator extends Creator<Task> {
    private final String pathAssistantSid;
    private final String uniqueName;
    private String friendlyName;
    private Map<String, Object> actions;
    private URI actionsUrl;

    /**
     * Construct a new TaskCreator.
     * 
     * @param pathAssistantSid The SID of the Assistant that is the parent of the
     *                         new resource
     * @param uniqueName An application-defined string that uniquely identifies the
     *                   resource
     */
    public TaskCreator(final String pathAssistantSid, 
                       final String uniqueName) {
        this.pathAssistantSid = pathAssistantSid;
        this.uniqueName = uniqueName;
    }

    /**
     * A descriptive string that you create to describe the new resource. It is not
     * unique and can be up to 255 characters long..
     * 
     * @param friendlyName  descriptive string that you create to describe the new
     *                     resource
     * @return this
     */
    public TaskCreator setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * The JSON string that specifies the
     * [actions](https://www.twilio.com/docs/autopilot/actions) that instruct the
     * Assistant on how to perform the task. It is optional and not unique..
     * 
     * @param actions The JSON string that specifies the actions that instruct the
     *                Assistant on how to perform the task
     * @return this
     */
    public TaskCreator setActions(final Map<String, Object> actions) {
        this.actions = actions;
        return this;
    }

    /**
     * The URL from which the Assistant can fetch actions..
     * 
     * @param actionsUrl The URL from which the Assistant can fetch actions
     * @return this
     */
    public TaskCreator setActionsUrl(final URI actionsUrl) {
        this.actionsUrl = actionsUrl;
        return this;
    }

    /**
     * The URL from which the Assistant can fetch actions..
     * 
     * @param actionsUrl The URL from which the Assistant can fetch actions
     * @return this
     */
    public TaskCreator setActionsUrl(final String actionsUrl) {
        return setActionsUrl(Promoter.uriFromString(actionsUrl));
    }

    /**
     * Make the request to the Twilio API to perform the create.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Created Task
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Task create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.AUTOPILOT.toString(),
            "/v1/Assistants/" + this.pathAssistantSid + "/Tasks",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Task creation failed: Unable to connect to server");
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

        return Task.fromJson(response.getStream(), client.getObjectMapper());
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

        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }

        if (actions != null) {
            request.addPostParam("Actions", Converter.mapToJson(actions));
        }

        if (actionsUrl != null) {
            request.addPostParam("ActionsUrl", actionsUrl.toString());
        }
    }
}