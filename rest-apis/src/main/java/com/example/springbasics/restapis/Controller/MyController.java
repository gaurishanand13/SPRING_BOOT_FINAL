package com.example.springbasics.restapis.Controller;
import com.example.springbasics.restapis.Model.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * This annotation tells spring to make an object of this classs.
 */
@RestController // creating an object of this class + acting as collection of APIs
public class MyController {

    /**
     * GET - get some information from server ====>  GETMAPPING
     * POST - insert / post something on server ===> POSTMAPPING
     * PUT - updating something on server ===> PUTMAPPING
     * DELETE - deleting something from server ====> DELETEMAPPING
     */
    private HashMap<Integer, Person> users = new HashMap<>();

    @GetMapping("/getUsers")
    public Map<Integer,Person> getUsers(){
        return users;
    }

    @GetMapping("/getParticularUsers")
    public Person getParticularPerson(@RequestParam(value = "PersonId") Integer id){
        if(id==null){
            return null;
        }else{
            return users.get(id);
        }
    }


    @GetMapping("/getUsersAdvanced")
    public List<Person> getUser(@RequestParam(value = "PersonId",required = false) Integer id){
        if(id == null){
            if(users.values().size()>0){
                return (users.values().stream().collect(Collectors.toList()));
            }else{
                return new ArrayList<Person>();
            }
        }else{
            if(users.get(id)!=null){
                return Collections.singletonList(users.get(id));
            }else{
                return new ArrayList<Person>();
            }
        }
    }

    // if required is not mentioned, then by default it is true.
    // Inserting a user can be done in 2 ways - either using a custom object
    @PostMapping("/insertUser")
    public void insertUser(@RequestParam(value = "id") int id,
                           @RequestParam(value = "age", required = false, defaultValue = "20") int age,
                           @RequestParam(value = "name", required = false, defaultValue = "ABC") String name,
                           @RequestParam(value = "country", required = false, defaultValue = "India") String country){

        Person person = new Person(id, age, name, country);
        users.put(id,person);
    }

    @RequestMapping(value = "/insertUserTwo",method = RequestMethod.POST ,consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public void insertUserTwo(Person person){
        users.put(person.getId(),person);
    }


    @RequestMapping(value = "/modify_user", method = RequestMethod.PUT)
    public void modifyUser(@RequestBody Person user) throws Exception {
        if(user == null){
            throw new Exception("User object is empty");
        }
        users.put(user.getId(), user);
    }


    /**
     * Deleting a user can be done in 2 ways -
     */
    @DeleteMapping("/delete_user/{id}")
    public void deleteUser(@PathVariable("id") int id){
        users.remove(id);
    }


    @DeleteMapping("/delete_user")
    public void deleteUser2(@RequestParam("id") int id){
        users.remove(id);
    }
}

