package net.Soumik.Paul.controller;

import net.Soumik.Paul.entity.PaulEntry;
import net.Soumik.Paul.entity.User;
import net.Soumik.Paul.service.PaulEntryService;
import net.Soumik.Paul.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController


@RequestMapping("/Paul")
public class PaulEntryController {

    @Autowired
    private PaulEntryService paulEntryService;

    @Autowired
    private UserService userService;



    @GetMapping
    public ResponseEntity<?> getAllPaulEntriesOfUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();

        User user = userService.findByUserName(userName);
        List<PaulEntry> all = user.getPaulEntries();

        if (all != null && !all.isEmpty()) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<String>("No entries found for this user.",HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<PaulEntry> createEntry(@RequestBody PaulEntry myEntry) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String userName = authentication.getName();
            paulEntryService.saveEntry(myEntry, userName);
            return new ResponseEntity<>(myEntry,HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("id/{myId}")
    public ResponseEntity<PaulEntry> getPaulEntryById(@PathVariable ObjectId myId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userService.findByUserName(userName);
        List<PaulEntry> collect = user.getPaulEntries().stream().filter(x -> x.getId().equals(myId)).collect(Collectors.toList());

        if(!collect.isEmpty()) {
            Optional<PaulEntry> paulEntry = paulEntryService.findById(myId);

            if (paulEntry.isPresent()) {
            return new ResponseEntity<>(paulEntry.get(), HttpStatus.OK);
        }
    }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


    @DeleteMapping("id/{myId}")
    public ResponseEntity<?> deletePaulEntryById(@PathVariable ObjectId myId){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        boolean removed = paulEntryService.deleteById(myId,userName);
        if(removed){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }else{
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    @PutMapping("id/{myId}")
    public ResponseEntity<?> updatePaulEntryById(@PathVariable ObjectId myId,
                                                 @RequestBody PaulEntry newEntry){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userService.findByUserName(userName);
        List<PaulEntry> collect = user.getPaulEntries().stream().filter(x -> x.getId().equals(myId)).collect(Collectors.toList());

        if(!collect.isEmpty()) {
            Optional<PaulEntry> paulEntry = paulEntryService.findById(myId);
            if (paulEntry.isPresent()) {
                PaulEntry old = paulEntry.get();
                old.setTitle(newEntry.getTitle()!= null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
                old.setContent(newEntry.getContent()!=null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());
                paulEntryService.saveEntry(old);
                return new ResponseEntity<>(old,HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}

