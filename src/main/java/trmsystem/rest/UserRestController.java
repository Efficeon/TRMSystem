package trmsystem.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import trmsystem.model.User;
import trmsystem.service.UserService;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Collection;

/**
 * Created by lion on 11.05.17.
 */

@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")
@RequestMapping("api/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("userId") int userId){
        System.out.println("TEST");
        System.out.println("TEST");
        System.out.println("TEST");
        User user = this.userService.findUserById(userId);
        if(user == null){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping("/greeting")
    public User greeting(@RequestParam(value="name", required=false, defaultValue="World") String name) {
        System.out.println("TEST");
        System.out.println("TEST");
        System.out.println("TEST");
        return new User();
    }

    @RequestMapping(value = "/index")
    @ResponseBody
    public String listContacts() {

        String line = "TEST";
        return line;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<User>> getUsers(){
        Collection<User> users = this.userService.findAllUsers();
        if(users.isEmpty()){
            return new ResponseEntity<Collection<User>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Collection<User>>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> addUser(@RequestBody @Valid User user, BindingResult bindingResult, UriComponentsBuilder ucBuilder){
        System.out.println("TEST");
        System.out.println("TEST");
        System.out.println("TEST");
        BindingErrorsResponse errors = new BindingErrorsResponse();
        HttpHeaders headers = new HttpHeaders();
        if(bindingResult.hasErrors() || (user == null)){
            errors.addAllErrors(bindingResult);
            headers.add("errors", errors.toJSON());
            return new ResponseEntity<User>(headers, HttpStatus.BAD_REQUEST);
        }
        this.userService.saveUser(user);
        headers.setLocation(ucBuilder.path("/api/users/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<User>(user, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public ResponseEntity<Void> deleteUser(@PathVariable("userId") int userId){
        User user = this.userService.findUserById(userId);
        if(user == null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        this.userService.deleteUser(user);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
