package com.finantix.mock.hsbc.ann.rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.finantix.mock.hsbc.ann.UrlConstants.AnnConstants;
import com.finantix.mock.hsbc.ann.UrlConstants.RestConstants;
import com.finantix.mock.hsbc.ann.model.AnNDTO;
import com.finantix.mock.hsbc.ann.model.ErrorDTO;
import com.finantix.mock.hsbc.ann.model.ErrorJWTDTO;
import com.finantix.mock.hsbc.ann.model.ErrorMsgDTO;
import com.finantix.mock.hsbc.ann.model.InputTokenDTO;
import com.finantix.mock.hsbc.ann.model.TokenDTO;

/**
 * The Class AnnModelController.
 */
@ConfigurationProperties
@RestController
public class AnnModelController {

    /** The Constant LOG. */
    private static final Logger LOG = LoggerFactory.getLogger(AnnModelController.class.getName());

    /** The Constant APPLICATION_PROPERTIES. */
    private static final String APPLICATION_PROPERTIES = "application.properties";

    /** The xhsbcchnlcountrycode key. */
    @Value("${xhsbcchnlcountrycodeKey}")
    private String xhsbcchnlcountrycodeKey;

    /** The xhsbce 2 etrusttoken key. */
    @Value("${xhsbce2etrusttokenKey}")
    private String xhsbce2etrusttokenKey;

    /** The delay. */
    @Value("${delay}")
    private int delay;

    /** The is fail execution. */
    @Value("${isFailureExecution}")
    private boolean isFailExecution;

    /** The token JWT. */
    @Value("${tokenJWT}")
    private String tokenJWT;

    @Value("${usernameJWT}")
    private String username;

    @Value("${passwordJWT}")
    private String password;

    /**
     * Do post.
     *
     * @param headers
     *            the headers
     * @param dto
     *            the dto
     * @param response
     *            the response
     * @param request
     *            the request
     * @return the response entity
     */
    @ResponseBody
    @PostMapping(RestConstants.BASE_ANN_URL)
    public ResponseEntity<?> doPost(@RequestHeader @NotNull Map<String, String> headers, @RequestBody AnNDTO dto, HttpServletResponse response,
            HttpServletRequest request) {
        // create a cookie
        LOG.info("Url: " + RestConstants.BASE_ANN_URL);
        LOG.info("Request: {}", dto);

        request.getAttribute("businessId");

        ResponseEntity<?> validationHeader = validationHeader(headers);
        if (validationHeader != null) {
            return validationHeader;
        }
        ResponseEntity<?> validationBody = validationBody(dto);
        if (validationBody != null) {
            return validationBody;
        }

        String result = "Success Delivery Ann Notification!";
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * Generate token.
     *
     * @param headers
     *            the headers
     * @param response
     *            the response
     * @return the token DTO
     * @throws InterruptedException
     *             the interrupted exception
     */
    @ResponseBody
    @PostMapping(RestConstants.BASE_ANN_AUTH_TOKEN)
    public ResponseEntity<?> generateToken(@NotNull @RequestBody InputTokenDTO dto, HttpServletResponse response) throws InterruptedException {
        LOG.info("Url: " + RestConstants.BASE_ANN_AUTH_TOKEN);

        // Load property files
        loadProperties();

        ResponseEntity<?> authValidator = authValidator(dto);
        if (authValidator != null) {
            return authValidator;
        }

        // Delay for the response in order to simulate failure scenarios
        waitForMeCase();

        return new ResponseEntity<>(new TokenDTO(tokenJWT), HttpStatus.OK);
    }

    private ResponseEntity<?> authValidator(InputTokenDTO dto) {
        if (dto.getInput_token_state() == null) {
            LOG.error("Paylod Null ");
            return new ResponseEntity<>(
                    new ErrorJWTDTO(HttpStatus.UNAUTHORIZED.value(), AnnConstants.UNAUTHORIZED, AnnConstants.ERROR_IN_CREDENTIALS_VALIDATION),
                    HttpStatus.BAD_REQUEST);
        }

        if (dto.getInput_token_state().getUsername() == null) {
            LOG.error("Missing Username null");
            return new ResponseEntity<>(
                    new ErrorJWTDTO(HttpStatus.UNAUTHORIZED.value(), AnnConstants.UNAUTHORIZED, AnnConstants.ERROR_IN_CREDENTIALS_VALIDATION),
                    HttpStatus.BAD_REQUEST);
        }

        if (dto.getInput_token_state().getPassword() == null) {
            LOG.error("Missing password null");
            return new ResponseEntity<>(
                    new ErrorJWTDTO(HttpStatus.UNAUTHORIZED.value(), AnnConstants.UNAUTHORIZED, AnnConstants.ERROR_IN_CREDENTIALS_VALIDATION),
                    HttpStatus.UNAUTHORIZED);
        }

        if (!dto.getInput_token_state().getUsername().equals(username) || !dto.getInput_token_state().getPassword().equals(password)) {
            LOG.error("Wrong Credentials! username:{} password:{}", dto.getInput_token_state().getUsername(), dto.getInput_token_state().getPassword());
            LOG.error("Expected username:{} password:{}", username, password);
            return new ResponseEntity<>(
                    new ErrorJWTDTO(HttpStatus.UNAUTHORIZED.value(), AnnConstants.UNAUTHORIZED, AnnConstants.ERROR_IN_CREDENTIALS_VALIDATION),
                    HttpStatus.BAD_REQUEST);

        }

        if (!dto.getInput_token_state().getToken_type().equals("CREDENTIAL")) {
            LOG.error("Invalid Token type :{}", dto.getInput_token_state().getToken_type());
            return new ResponseEntity<>(new ErrorJWTDTO(HttpStatus.BAD_REQUEST.value(), AnnConstants.BAD_REQUEST, AnnConstants.ERROR_INPUT_STRUCTURE),
                    HttpStatus.BAD_REQUEST);

        }

        if (dto.getOutput_token_state() == null) {
            LOG.error("Invalid Output token state: {}", dto.getOutput_token_state());
            return new ResponseEntity<>(new ErrorJWTDTO(HttpStatus.BAD_REQUEST.value(), AnnConstants.BAD_REQUEST, AnnConstants.ERROR_INPUT_STRUCTURE),
                    HttpStatus.BAD_REQUEST);

        }

        if (!dto.getOutput_token_state().getToken_type().equals("JWT")) {
            LOG.error("Invalid Output token type :{}", dto.getOutput_token_state().getToken_type());
            return new ResponseEntity<>(new ErrorJWTDTO(HttpStatus.BAD_REQUEST.value(), AnnConstants.BAD_REQUEST, AnnConstants.ERROR_INPUT_STRUCTURE),
                    HttpStatus.BAD_REQUEST);

        }

        return null;

    }

    /**
     * Validation header.
     *
     * @param headers
     *            the headers
     * @return the response entity
     */
    private ResponseEntity<?> validationHeader(Map<String, String> headers) {

        String countryCode = headers.get(xhsbcchnlcountrycodeKey);
        if (countryCode == null) {
            return new ResponseEntity<>(new ErrorDTO(AnnConstants.ERROR_NO_E2E_TRUST_TOKEN_HEADER_FOUND), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        String tokenJWTFromHeader = headers.get(xhsbce2etrusttokenKey);
        if (tokenJWTFromHeader == null) {
            return new ResponseEntity<>(new ErrorDTO(AnnConstants.ERROR_NO_E2E_TRUST_TOKEN_HEADER_FOUND), HttpStatus.FORBIDDEN);
        } else if (!tokenJWTFromHeader.equals(tokenJWT)) {
            return new ResponseEntity<>(new ErrorDTO(AnnConstants.ERROR_INVALID_TOKEN_STRUCTURE), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return null;
    }

    /**
     * Validation body.
     *
     * @param dto
     *            the dto
     * @return the response entity
     */
    private ResponseEntity<?> validationBody(@NotNull AnNDTO dto) {
        // Mandatory fields
        if (dto.getBusinessId() == null) {
            return new ResponseEntity<>(new ErrorMsgDTO(HttpStatus.BAD_REQUEST.value(), AnnConstants.ERROR_BUSINESSID_REQUIRED), HttpStatus.BAD_REQUEST);
        }

        if (dto.getRequestId() == null) {
            return new ResponseEntity<>(new ErrorMsgDTO(HttpStatus.BAD_REQUEST.value(), AnnConstants.ERROR_REQUESTID_REQUIRED), HttpStatus.BAD_REQUEST);
        }
        return null;

    }

    /**
     * Write all headers to log.
     *
     * @param request
     *            the HTTPRequest
     */
    private void logHeader(HttpServletRequest request) {
        Enumeration<String> headers = request.getHeaderNames();
        LOG.info("Headers:");
        while (headers.hasMoreElements()) {
            String header = headers.nextElement();
            LOG.info("--- {} : {}", header, request.getHeader(header));
        }
    }

    /**
     * Load properties.
     */
    private void loadProperties() {
        String appPath = System.getProperty("user.dir") + File.separatorChar + APPLICATION_PROPERTIES;
        LOG.debug("Path for configuration : {}", appPath);
        try (InputStream input = new FileInputStream(appPath)) {
            Properties prop = new Properties();
            prop.load(input);
            if (prop.getProperty("delay") != null) {
                delay = Integer.valueOf(prop.getProperty("delay"));
            }
            if (prop.getProperty("isFailureExecution") != null) {
                isFailExecution = Boolean.valueOf(prop.getProperty("isFailureExecution"));
            }
        } catch (IOException e) {
            LOG.error("Error retrieving properties from {} {}", APPLICATION_PROPERTIES, e);
        }
    }

    /**
     * Force exception case.
     *
     * @throws Exception
     *             the exception
     */
    private void forceExceptionCase() throws Exception {
        if (isFailExecution) {
            LOG.info("Force Exception");
            throw new Exception("Failure PDF Embedded scenario");
        }
    }

    /**
     * Wait for me case.
     *
     * @throws InterruptedException
     *             the interrupted exception
     */
    private void waitForMeCase() throws InterruptedException {
        try {
            LOG.info("Sleep {} milliseconds", delay);
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new InterruptedException("Error ");
        }
    }

}