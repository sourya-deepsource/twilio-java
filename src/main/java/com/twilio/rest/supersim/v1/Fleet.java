/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.supersim.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Objects;

/**
 * PLEASE NOTE that this class contains beta products that are subject to
 * change. Use them with caution.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class Fleet extends Resource {
    private static final long serialVersionUID = 130716130909044L;

    public enum DataMetering {
        PAYG("payg");

        private final String value;

        private DataMetering(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a DataMetering from a string.
         * @param value string value
         * @return generated DataMetering
         */
        @JsonCreator
        public static DataMetering forValue(final String value) {
            return Promoter.enumFromString(value, DataMetering.values());
        }
    }

    /**
     * Create a FleetCreator to execute create.
     *
     * @param networkAccessProfile The SID or unique name of the Network Access
     *                             Profile of the Fleet
     * @return FleetCreator capable of executing the create
     */
    public static FleetCreator creator(final String networkAccessProfile) {
        return new FleetCreator(networkAccessProfile);
    }

    /**
     * Create a FleetFetcher to execute fetch.
     *
     * @param pathSid The SID that identifies the resource to fetch
     * @return FleetFetcher capable of executing the fetch
     */
    public static FleetFetcher fetcher(final String pathSid) {
        return new FleetFetcher(pathSid);
    }

    /**
     * Create a FleetReader to execute read.
     *
     * @return FleetReader capable of executing the read
     */
    public static FleetReader reader() {
        return new FleetReader();
    }

    /**
     * Create a FleetUpdater to execute update.
     *
     * @param pathSid The SID that identifies the resource to update
     * @return FleetUpdater capable of executing the update
     */
    public static FleetUpdater updater(final String pathSid) {
        return new FleetUpdater(pathSid);
    }

    /**
     * Converts a JSON String into a Fleet object using the provided ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Fleet object represented by the provided JSON
     */
    public static Fleet fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Fleet.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Fleet object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Fleet object represented by the provided JSON
     */
    public static Fleet fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Fleet.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String sid;
    private final String uniqueName;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final URI url;
    private final Boolean dataEnabled;
    private final Integer dataLimit;
    private final Fleet.DataMetering dataMetering;
    private final Boolean commandsEnabled;
    private final URI commandsUrl;
    private final HttpMethod commandsMethod;
    private final String networkAccessProfileSid;

    @JsonCreator
    private Fleet(@JsonProperty("account_sid")
                  final String accountSid,
                  @JsonProperty("sid")
                  final String sid,
                  @JsonProperty("unique_name")
                  final String uniqueName,
                  @JsonProperty("date_created")
                  final String dateCreated,
                  @JsonProperty("date_updated")
                  final String dateUpdated,
                  @JsonProperty("url")
                  final URI url,
                  @JsonProperty("data_enabled")
                  final Boolean dataEnabled,
                  @JsonProperty("data_limit")
                  final Integer dataLimit,
                  @JsonProperty("data_metering")
                  final Fleet.DataMetering dataMetering,
                  @JsonProperty("commands_enabled")
                  final Boolean commandsEnabled,
                  @JsonProperty("commands_url")
                  final URI commandsUrl,
                  @JsonProperty("commands_method")
                  final HttpMethod commandsMethod,
                  @JsonProperty("network_access_profile_sid")
                  final String networkAccessProfileSid) {
        this.accountSid = accountSid;
        this.sid = sid;
        this.uniqueName = uniqueName;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.url = url;
        this.dataEnabled = dataEnabled;
        this.dataLimit = dataLimit;
        this.dataMetering = dataMetering;
        this.commandsEnabled = commandsEnabled;
        this.commandsUrl = commandsUrl;
        this.commandsMethod = commandsMethod;
        this.networkAccessProfileSid = networkAccessProfileSid;
    }

    /**
     * Returns The SID of the Account that created the resource.
     *
     * @return The SID of the Account that created the resource
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The unique string that identifies the resource.
     *
     * @return The unique string that identifies the resource
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns An application-defined string that uniquely identifies the resource.
     *
     * @return An application-defined string that uniquely identifies the resource
     */
    public final String getUniqueName() {
        return this.uniqueName;
    }

    /**
     * Returns The ISO 8601 date and time in GMT when the resource was created.
     *
     * @return The ISO 8601 date and time in GMT when the resource was created
     */
    public final ZonedDateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The ISO 8601 date and time in GMT when the resource was last updated.
     *
     * @return The ISO 8601 date and time in GMT when the resource was last updated
     */
    public final ZonedDateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The absolute URL of the Fleet resource.
     *
     * @return The absolute URL of the Fleet resource
     */
    public final URI getUrl() {
        return this.url;
    }

    /**
     * Returns Defines whether SIMs in the Fleet are capable of using data
     * connectivity.
     *
     * @return Defines whether SIMs in the Fleet are capable of using data
     *         connectivity
     */
    public final Boolean getDataEnabled() {
        return this.dataEnabled;
    }

    /**
     * Returns The total data usage (download and upload combined) in Megabytes that
     * each Sim resource assigned to the Fleet resource can consume.
     *
     * @return The total data usage (download and upload combined) in Megabytes
     *         that each Sim resource assigned to the Fleet resource can consume
     */
    public final Integer getDataLimit() {
        return this.dataLimit;
    }

    /**
     * Returns The model by which a SIM is metered and billed.
     *
     * @return The model by which a SIM is metered and billed
     */
    public final Fleet.DataMetering getDataMetering() {
        return this.dataMetering;
    }

    /**
     * Returns Defines whether SIMs in the Fleet are capable of sending and
     * receiving machine-to-machine SMS via Commands.
     *
     * @return Defines whether SIMs in the Fleet are capable of sending and
     *         receiving machine-to-machine SMS via Commands
     */
    public final Boolean getCommandsEnabled() {
        return this.commandsEnabled;
    }

    /**
     * Returns The URL that will receive a webhook when a Super SIM in the Fleet is
     * used to send an SMS from your device to the Commands number.
     *
     * @return The URL that will receive a webhook when a Super SIM in the Fleet is
     *         used to send an SMS from your device to the Commands number
     */
    public final URI getCommandsUrl() {
        return this.commandsUrl;
    }

    /**
     * Returns A string representing the HTTP method to use when making a request to
     * `commands_url`.
     *
     * @return A string representing the HTTP method to use when making a request
     *         to `commands_url`
     */
    public final HttpMethod getCommandsMethod() {
        return this.commandsMethod;
    }

    /**
     * Returns The SID of the Network Access Profile of the Fleet.
     *
     * @return The SID of the Network Access Profile of the Fleet
     */
    public final String getNetworkAccessProfileSid() {
        return this.networkAccessProfileSid;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Fleet other = (Fleet) o;

        return Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(sid, other.sid) &&
               Objects.equals(uniqueName, other.uniqueName) &&
               Objects.equals(dateCreated, other.dateCreated) &&
               Objects.equals(dateUpdated, other.dateUpdated) &&
               Objects.equals(url, other.url) &&
               Objects.equals(dataEnabled, other.dataEnabled) &&
               Objects.equals(dataLimit, other.dataLimit) &&
               Objects.equals(dataMetering, other.dataMetering) &&
               Objects.equals(commandsEnabled, other.commandsEnabled) &&
               Objects.equals(commandsUrl, other.commandsUrl) &&
               Objects.equals(commandsMethod, other.commandsMethod) &&
               Objects.equals(networkAccessProfileSid, other.networkAccessProfileSid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            sid,
                            uniqueName,
                            dateCreated,
                            dateUpdated,
                            url,
                            dataEnabled,
                            dataLimit,
                            dataMetering,
                            commandsEnabled,
                            commandsUrl,
                            commandsMethod,
                            networkAccessProfileSid);
    }
}