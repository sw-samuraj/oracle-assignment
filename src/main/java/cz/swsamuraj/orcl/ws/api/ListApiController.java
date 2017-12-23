package cz.swsamuraj.orcl.ws.api;

import cz.swsamuraj.orcl.logic.ListDao;
import cz.swsamuraj.orcl.ws.model.Element;
import cz.swsamuraj.orcl.ws.model.InsertAfter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Controller
public class ListApiController implements ListApi {

    private static final Logger logger = LogManager.getLogger(ListApiController.class);

    private ListDao list;

    @Override
    public ResponseEntity<Void> insertAfter(@RequestBody InsertAfter insertAfter) {
        try {
            list.insertAfter(insertAfter.getElement().getValue(), insertAfter.getAfter().getValue());

            logger.debug("insertAfter:\n{}", insertAfter);
        } catch (UnsupportedOperationException e) {
            logger.warn("insertAfter called on the empty list:\n{}", insertAfter);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Element> pop() {
        Element element = new Element();
        Optional<String> optional = list.pop();

        if (optional.isPresent()) {
            element.setValue(optional.get());
        }

        logger.debug("pop:\n {}", element);

        return new ResponseEntity<>(element, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> push(@RequestBody Element element) {
        list.push(element.getValue());

        logger.debug("push:\n {}", element);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Autowired
    public void setList(ListDao list) {
        this.list = list;
    }

}
