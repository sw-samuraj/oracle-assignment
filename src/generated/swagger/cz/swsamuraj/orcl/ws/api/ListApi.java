package cz.swsamuraj.orcl.ws.api;

import cz.swsamuraj.orcl.ws.model.InsertAfter;
import cz.swsamuraj.orcl.ws.model.Element;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-08-09T22:40:21.869+02:00")

@Api(value = "list", description = "the list API")
public interface ListApi {

    @ApiOperation(value = "insert a new element after given element", notes = "", response = Void.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "No Content; element added", response = Void.class),
        @ApiResponse(code = 400, message = "Bad Request; Invalid input data", response = Void.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Void.class) })
    @RequestMapping(value = "/list/insertAfter",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> insertAfter(

@ApiParam(value = ""  ) @RequestBody InsertAfter insertAfter

);


    @ApiOperation(value = "pop the last element from the list", notes = "", response = Element.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK; element popped", response = Element.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Element.class) })
    @RequestMapping(value = "/list/pop",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Element> pop();


    @ApiOperation(value = "push a new element to the list", notes = "", response = Void.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 204, message = "No Content; element added", response = Void.class),
        @ApiResponse(code = 400, message = "Bad Request; Invalid input data", response = Void.class),
        @ApiResponse(code = 500, message = "Internal Server Error", response = Void.class) })
    @RequestMapping(value = "/list/push",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> push(

@ApiParam(value = ""  ) @RequestBody Element element

);

}
