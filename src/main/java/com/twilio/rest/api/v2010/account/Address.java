/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account;

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
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Address extends Resource {
    private static final long serialVersionUID = 59858064655653L;

    /**
     * Create a AddressCreator to execute create.
     * 
     * @param pathAccountSid The SID of the Account that will be responsible for
     *                       the new Address resource
     * @param customerName The name to associate with the new address
     * @param street The number and street address of the new address
     * @param city The city of the new address
     * @param region The state or region of the new address
     * @param postalCode The postal code of the new address
     * @param isoCountry The ISO country code of the new address
     * @return AddressCreator capable of executing the create
     */
    public static AddressCreator creator(final String pathAccountSid, 
                                         final String customerName, 
                                         final String street, 
                                         final String city, 
                                         final String region, 
                                         final String postalCode, 
                                         final String isoCountry) {
        return new AddressCreator(pathAccountSid, customerName, street, city, region, postalCode, isoCountry);
    }

    /**
     * Create a AddressCreator to execute create.
     * 
     * @param customerName The name to associate with the new address
     * @param street The number and street address of the new address
     * @param city The city of the new address
     * @param region The state or region of the new address
     * @param postalCode The postal code of the new address
     * @param isoCountry The ISO country code of the new address
     * @return AddressCreator capable of executing the create
     */
    public static AddressCreator creator(final String customerName, 
                                         final String street, 
                                         final String city, 
                                         final String region, 
                                         final String postalCode, 
                                         final String isoCountry) {
        return new AddressCreator(customerName, street, city, region, postalCode, isoCountry);
    }

    /**
     * Create a AddressDeleter to execute delete.
     * 
     * @param pathAccountSid The SID of the Account that is responsible for the
     *                       resources to delete
     * @param pathSid The unique string that identifies the resource
     * @return AddressDeleter capable of executing the delete
     */
    public static AddressDeleter deleter(final String pathAccountSid, 
                                         final String pathSid) {
        return new AddressDeleter(pathAccountSid, pathSid);
    }

    /**
     * Create a AddressDeleter to execute delete.
     * 
     * @param pathSid The unique string that identifies the resource
     * @return AddressDeleter capable of executing the delete
     */
    public static AddressDeleter deleter(final String pathSid) {
        return new AddressDeleter(pathSid);
    }

    /**
     * Create a AddressFetcher to execute fetch.
     * 
     * @param pathAccountSid The SID of the Account that is responsible for this
     *                       address
     * @param pathSid The unique string that identifies the resource
     * @return AddressFetcher capable of executing the fetch
     */
    public static AddressFetcher fetcher(final String pathAccountSid, 
                                         final String pathSid) {
        return new AddressFetcher(pathAccountSid, pathSid);
    }

    /**
     * Create a AddressFetcher to execute fetch.
     * 
     * @param pathSid The unique string that identifies the resource
     * @return AddressFetcher capable of executing the fetch
     */
    public static AddressFetcher fetcher(final String pathSid) {
        return new AddressFetcher(pathSid);
    }

    /**
     * Create a AddressUpdater to execute update.
     * 
     * @param pathAccountSid The SID of the Account that is responsible for the
     *                       resource to update
     * @param pathSid The unique string that identifies the resource
     * @return AddressUpdater capable of executing the update
     */
    public static AddressUpdater updater(final String pathAccountSid, 
                                         final String pathSid) {
        return new AddressUpdater(pathAccountSid, pathSid);
    }

    /**
     * Create a AddressUpdater to execute update.
     * 
     * @param pathSid The unique string that identifies the resource
     * @return AddressUpdater capable of executing the update
     */
    public static AddressUpdater updater(final String pathSid) {
        return new AddressUpdater(pathSid);
    }

    /**
     * Create a AddressReader to execute read.
     * 
     * @param pathAccountSid The SID of the Account that is responsible for this
     *                       address
     * @return AddressReader capable of executing the read
     */
    public static AddressReader reader(final String pathAccountSid) {
        return new AddressReader(pathAccountSid);
    }

    /**
     * Create a AddressReader to execute read.
     * 
     * @return AddressReader capable of executing the read
     */
    public static AddressReader reader() {
        return new AddressReader();
    }

    /**
     * Converts a JSON String into a Address object using the provided ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Address object represented by the provided JSON
     */
    public static Address fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Address.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Address object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Address object represented by the provided JSON
     */
    public static Address fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Address.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String city;
    private final String customerName;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final String friendlyName;
    private final String isoCountry;
    private final String postalCode;
    private final String region;
    private final String sid;
    private final String street;
    private final String uri;
    private final Boolean emergencyEnabled;
    private final Boolean validated;
    private final Boolean verified;

    @JsonCreator
    private Address(@JsonProperty("account_sid")
                    final String accountSid, 
                    @JsonProperty("city")
                    final String city, 
                    @JsonProperty("customer_name")
                    final String customerName, 
                    @JsonProperty("date_created")
                    final String dateCreated, 
                    @JsonProperty("date_updated")
                    final String dateUpdated, 
                    @JsonProperty("friendly_name")
                    final String friendlyName, 
                    @JsonProperty("iso_country")
                    final String isoCountry, 
                    @JsonProperty("postal_code")
                    final String postalCode, 
                    @JsonProperty("region")
                    final String region, 
                    @JsonProperty("sid")
                    final String sid, 
                    @JsonProperty("street")
                    final String street, 
                    @JsonProperty("uri")
                    final String uri, 
                    @JsonProperty("emergency_enabled")
                    final Boolean emergencyEnabled, 
                    @JsonProperty("validated")
                    final Boolean validated, 
                    @JsonProperty("verified")
                    final Boolean verified) {
        this.accountSid = accountSid;
        this.city = city;
        this.customerName = customerName;
        this.dateCreated = DateConverter.rfc2822DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.rfc2822DateTimeFromString(dateUpdated);
        this.friendlyName = friendlyName;
        this.isoCountry = isoCountry;
        this.postalCode = postalCode;
        this.region = region;
        this.sid = sid;
        this.street = street;
        this.uri = uri;
        this.emergencyEnabled = emergencyEnabled;
        this.validated = validated;
        this.verified = verified;
    }

    /**
     * Returns The The SID of the Account that is responsible for the resource.
     * 
     * @return The SID of the Account that is responsible for the resource
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The city in which the address is located.
     * 
     * @return The city in which the address is located
     */
    public final String getCity() {
        return this.city;
    }

    /**
     * Returns The The name associated with the address.
     * 
     * @return The name associated with the address
     */
    public final String getCustomerName() {
        return this.customerName;
    }

    /**
     * Returns The The RFC 2822 date and time in GMT that the resource was created.
     * 
     * @return The RFC 2822 date and time in GMT that the resource was created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The RFC 2822 date and time in GMT that the resource was last
     * updated.
     * 
     * @return The RFC 2822 date and time in GMT that the resource was last updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
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
     * Returns The The ISO country code of the address.
     * 
     * @return The ISO country code of the address
     */
    public final String getIsoCountry() {
        return this.isoCountry;
    }

    /**
     * Returns The The postal code of the address.
     * 
     * @return The postal code of the address
     */
    public final String getPostalCode() {
        return this.postalCode;
    }

    /**
     * Returns The The state or region of the address.
     * 
     * @return The state or region of the address
     */
    public final String getRegion() {
        return this.region;
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
     * Returns The The number and street address of the address.
     * 
     * @return The number and street address of the address
     */
    public final String getStreet() {
        return this.street;
    }

    /**
     * Returns The The URI of the resource, relative to `https://api.twilio.com`.
     * 
     * @return The URI of the resource, relative to `https://api.twilio.com`
     */
    public final String getUri() {
        return this.uri;
    }

    /**
     * Returns The Whether emergency calling has been enabled on this number.
     * 
     * @return Whether emergency calling has been enabled on this number
     */
    public final Boolean getEmergencyEnabled() {
        return this.emergencyEnabled;
    }

    /**
     * Returns The Whether the address has been validated to comply with local
     * regulation.
     * 
     * @return Whether the address has been validated to comply with local
     *         regulation
     */
    public final Boolean getValidated() {
        return this.validated;
    }

    /**
     * Returns The Whether the address has been verified to comply with regulation.
     * 
     * @return Whether the address has been verified to comply with regulation
     */
    public final Boolean getVerified() {
        return this.verified;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Address other = (Address) o;

        return Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(city, other.city) && 
               Objects.equals(customerName, other.customerName) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateUpdated, other.dateUpdated) && 
               Objects.equals(friendlyName, other.friendlyName) && 
               Objects.equals(isoCountry, other.isoCountry) && 
               Objects.equals(postalCode, other.postalCode) && 
               Objects.equals(region, other.region) && 
               Objects.equals(sid, other.sid) && 
               Objects.equals(street, other.street) && 
               Objects.equals(uri, other.uri) && 
               Objects.equals(emergencyEnabled, other.emergencyEnabled) && 
               Objects.equals(validated, other.validated) && 
               Objects.equals(verified, other.verified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            city,
                            customerName,
                            dateCreated,
                            dateUpdated,
                            friendlyName,
                            isoCountry,
                            postalCode,
                            region,
                            sid,
                            street,
                            uri,
                            emergencyEnabled,
                            validated,
                            verified);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("city", city)
                          .add("customerName", customerName)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("friendlyName", friendlyName)
                          .add("isoCountry", isoCountry)
                          .add("postalCode", postalCode)
                          .add("region", region)
                          .add("sid", sid)
                          .add("street", street)
                          .add("uri", uri)
                          .add("emergencyEnabled", emergencyEnabled)
                          .add("validated", validated)
                          .add("verified", verified)
                          .toString();
    }
}