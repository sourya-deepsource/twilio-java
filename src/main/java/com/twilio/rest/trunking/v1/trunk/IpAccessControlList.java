/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.trunking.v1.trunk;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IpAccessControlList extends Resource {
    private static final long serialVersionUID = 45032598628398L;

    /**
     * Create a IpAccessControlListFetcher to execute fetch.
     * 
     * @param pathTrunkSid The SID of the Trunk from which to fetch the IP Access
     *                     Control List
     * @param pathSid The unique string that identifies the resource
     * @return IpAccessControlListFetcher capable of executing the fetch
     */
    public static IpAccessControlListFetcher fetcher(final String pathTrunkSid, 
                                                     final String pathSid) {
        return new IpAccessControlListFetcher(pathTrunkSid, pathSid);
    }

    /**
     * Create a IpAccessControlListDeleter to execute delete.
     * 
     * @param pathTrunkSid The SID of the Trunk from which to delete the IP Access
     *                     Control List
     * @param pathSid The unique string that identifies the resource
     * @return IpAccessControlListDeleter capable of executing the delete
     */
    public static IpAccessControlListDeleter deleter(final String pathTrunkSid, 
                                                     final String pathSid) {
        return new IpAccessControlListDeleter(pathTrunkSid, pathSid);
    }

    /**
     * Create a IpAccessControlListCreator to execute create.
     * 
     * @param pathTrunkSid The SID of the Trunk to associate the IP Access Control
     *                     List with
     * @param ipAccessControlListSid The SID of the IP Access Control List that you
     *                               want to associate with the trunk
     * @return IpAccessControlListCreator capable of executing the create
     */
    public static IpAccessControlListCreator creator(final String pathTrunkSid, 
                                                     final String ipAccessControlListSid) {
        return new IpAccessControlListCreator(pathTrunkSid, ipAccessControlListSid);
    }

    /**
     * Create a IpAccessControlListReader to execute read.
     * 
     * @param pathTrunkSid The SID of the Trunk from which to read the IP Access
     *                     Control Lists
     * @return IpAccessControlListReader capable of executing the read
     */
    public static IpAccessControlListReader reader(final String pathTrunkSid) {
        return new IpAccessControlListReader(pathTrunkSid);
    }

    /**
     * Converts a JSON String into a IpAccessControlList object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return IpAccessControlList object represented by the provided JSON
     */
    public static IpAccessControlList fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, IpAccessControlList.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a IpAccessControlList object using the
     * provided ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return IpAccessControlList object represented by the provided JSON
     */
    public static IpAccessControlList fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, IpAccessControlList.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String sid;
    private final String trunkSid;
    private final String friendlyName;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final URI url;

    @JsonCreator
    private IpAccessControlList(@JsonProperty("account_sid")
                                final String accountSid, 
                                @JsonProperty("sid")
                                final String sid, 
                                @JsonProperty("trunk_sid")
                                final String trunkSid, 
                                @JsonProperty("friendly_name")
                                final String friendlyName, 
                                @JsonProperty("date_created")
                                final String dateCreated, 
                                @JsonProperty("date_updated")
                                final String dateUpdated, 
                                @JsonProperty("url")
                                final URI url) {
        this.accountSid = accountSid;
        this.sid = sid;
        this.trunkSid = trunkSid;
        this.friendlyName = friendlyName;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.url = url;
    }

    /**
     * Returns The The SID of the Account that created the resource.
     * 
     * @return The SID of the Account that created the resource
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The unique string that identifies the resource.
     * 
     * @return The unique string that identifies the resource
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The The SID of the Trunk the resource is associated with.
     * 
     * @return The SID of the Trunk the resource is associated with
     */
    public final String getTrunkSid() {
        return this.trunkSid;
    }

    /**
     * Returns The The string that you assigned to describe the resource.
     * 
     * @return The string that you assigned to describe the resource
     */
    public final String getFriendlyName() {
        return this.friendlyName;
    }

    /**
     * Returns The The RFC 2822 date and time in GMT when the resource was created.
     * 
     * @return The RFC 2822 date and time in GMT when the resource was created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The RFC 2822 date and time in GMT when the resource was last
     * updated.
     * 
     * @return The RFC 2822 date and time in GMT when the resource was last updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The The absolute URL of the resource.
     * 
     * @return The absolute URL of the resource
     */
    public final URI getUrl() {
        return this.url;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        IpAccessControlList other = (IpAccessControlList) o;

        return Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(sid, other.sid) && 
               Objects.equals(trunkSid, other.trunkSid) && 
               Objects.equals(friendlyName, other.friendlyName) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateUpdated, other.dateUpdated) && 
               Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            sid,
                            trunkSid,
                            friendlyName,
                            dateCreated,
                            dateUpdated,
                            url);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("sid", sid)
                          .add("trunkSid", trunkSid)
                          .add("friendlyName", friendlyName)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("url", url)
                          .toString();
    }
}