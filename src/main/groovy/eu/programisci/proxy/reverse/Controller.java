package eu.programisci.proxy.reverse;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(method = RequestMethod.GET)
public class Controller {

    @RequestMapping(path = "/ok")
    public ResponseEntity ok(){
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(path = "/unauthorized")
    public ResponseEntity unauthorized(){
        return new ResponseEntity(HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping(path = "/forbidden")
    public ResponseEntity forbidden(){
        return new ResponseEntity(HttpStatus.FORBIDDEN);
    }

    @RequestMapping(path = "/code/{value}")
    public ResponseEntity code(@PathVariable() int value){
        Optional<HttpStatus> pStatus = Stream.of(HttpStatus.values()).filter(s->s.value() == value).findFirst();

        return pStatus.map(s->new ResponseEntity(s)).orElseThrow( () ->new IllegalArgumentException());
    }




}
