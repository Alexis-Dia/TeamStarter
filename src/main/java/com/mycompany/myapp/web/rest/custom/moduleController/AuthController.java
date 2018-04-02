package com.mycompany.myapp.web.rest.custom.moduleController;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.mycompany.myapp.web.rest.custom.modulePojo.*;
import com.mycompany.myapp.web.rest.custom.moduleService.JsonJavaConverter;
import com.mycompany.myapp.web.rest.custom.moduleService.UserService;
import com.mycompany.myapp.web.rest.custom.security.jwt.impl.MyTokenProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Controller to authenticate users.
 */
@ComponentScan
@RestController
public class AuthController {

    @Autowired
    UserService userService;

    @Autowired
    JsonJavaConverter jsonJavaConverter;

    @Autowired
    MyTokenProviderImpl tokenProvider;

    @CrossOrigin(allowedHeaders = "*", allowCredentials = "false")
    @RequestMapping(value = "/auth", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> loginUser(@RequestBody ActionPojo action) throws IOException {
        System.out.println("/auth");
        String identifier = action.getData().getUser().getUsername();
        String password = action.getData().getUser().getPassword();

        Collection<FullUserPojo> existingUsersByParam = (Collection<FullUserPojo>) userService.getUserByParams(identifier, password);

        boolean userIsExist = existingUsersByParam.iterator().hasNext();

        String jsonObject = jsonJavaConverter.convertToJson(action);

        if (!userIsExist) {
            return new ResponseEntity<String>(jsonObject, HttpStatus.UNAUTHORIZED);
        }

        action.getData().setUser(existingUsersByParam.iterator().next());

        String id = action.getData().getUser().getId().toString();

        TokenPojo tokenPojo = tokenProvider.createToken(id, identifier);
        jsonObject = jsonJavaConverter.convertToJson(tokenPojo);
        return new ResponseEntity<String>(jsonObject, HttpStatus.OK);

    }

    @CrossOrigin(allowedHeaders = "*", allowCredentials = "false")
    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveNewUser(@Valid @RequestBody FullUserPojo user, BindingResult br) throws IOException {
        System.out.println("/save");
        ObjectMapper objectMapper = new ObjectMapper();
        String userName = user.getUsername();
        String email = user.getEmail();

        ArrayList errList = new ArrayList<SignUpFieldPojo>();

        if (!br.hasErrors()) {
            userService.saveUser(user);
            String jsonObject = jsonJavaConverter.convertToJson(errList);
            return new ResponseEntity<String>(jsonObject, HttpStatus.BAD_REQUEST);
        }

        for (ObjectError err : br.getAllErrors()) {
            if (((FieldError) err).getField().equals("username")) {
                SignUpFieldPojo error = new SignUpFieldPojo("username","userNameErr", err.getDefaultMessage());
                errList.add(error);
            }

            if (((FieldError) err).getField().equals("email")) {
                SignUpFieldPojo error = new SignUpFieldPojo("email", "emailErr", err.getDefaultMessage());
                errList.add(error);
            }

            if (((FieldError) err).getField().equals("password")) {
                SignUpFieldPojo error = new SignUpFieldPojo("password", "passwordErr", err.getDefaultMessage());
                errList.add(error);
            }

            if (((FieldError) err).getField().equals("passwordConfirmation")) {
                SignUpFieldPojo error = new SignUpFieldPojo("passwordConfirmation","passwordConfirmationErr", err.getDefaultMessage());
                errList.add(error);
            }

            if (((FieldError) err).getField().equals("timezone")) {
                SignUpFieldPojo error = new SignUpFieldPojo("timezone","timezoneErr", err.getDefaultMessage());
                errList.add(error);
            }
        }

        String jsonObject = jsonJavaConverter.convertToJson(errList);
        return new ResponseEntity<String>(jsonObject, HttpStatus.BAD_REQUEST);
    }

    @CrossOrigin(allowedHeaders = "*", allowCredentials = "false")
    @RequestMapping(value = "/checkIfUserExist", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> checkIfUserExist(@RequestBody SignUpFieldPojo signUpFieldPojo) throws IOException {
        System.out.println("/checkIfUserExist");
        ObjectMapper objectMapper = new ObjectMapper();

        ArrayList errList = new ArrayList<SignUpFieldPojo>();

        if (userService.userIsExistsByParam("username", signUpFieldPojo.getFieldValue())) {
            SignUpFieldPojo error = new SignUpFieldPojo("username", "userNameErr", "Exist user with the same name.", "");
            errList.add(error);
        }

        if (userService.userIsExistsByParam("email", signUpFieldPojo.getFieldValue())) {
            SignUpFieldPojo error = new SignUpFieldPojo("email","emailErr", "Exist user with the same email.");
            errList.add(error);
        }

        String jsonObject = jsonJavaConverter.convertToJson(errList);

        if (errList.size() > 0) {
            return new ResponseEntity<String>(jsonObject, HttpStatus.BAD_REQUEST);
        }

        signUpFieldPojo.setErrorDescription("");
        errList.add(signUpFieldPojo);
        jsonObject = jsonJavaConverter.convertToJson(errList);
        return new ResponseEntity<String>(jsonObject, HttpStatus.OK);
    }

    @CrossOrigin(allowedHeaders = "*", allowCredentials = "false")
    @RequestMapping(value = "/testJWTtoken", method = RequestMethod.GET)
    public String testJWTtoken() throws IOException {
        System.out.println("jwtTokenIsOk");
        return "jwtTokenIsOk";
    }

}
